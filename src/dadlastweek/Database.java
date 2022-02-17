/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dadlastweek;

import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ivan
 */
public class Database {
    int localhost = 5433;
    String usernamepostgresql = "postgres";
    String passwordpostgresql = "iucesmag";
    
    public Connection conn = null;
    
    public Database() {
        realizaConexion();
    }

    private void realizaConexion() {
        datosConexion();
        String urlDatabase = "jdbc:postgresql://localhost:"+localhost+"/dads_last_week";
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(urlDatabase, usernamepostgresql, passwordpostgresql);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Ocurrio un error : " + e.getMessage());
        }
    }
    
    private void datosConexion(){
        File fichero = new File("servidor.txt");
//            System.out.println(archivos.getSelectedFile());

            try (FileReader leer = new FileReader(fichero)) {
                String cadena;                
                    try (BufferedReader read = new BufferedReader(leer)) {
                        while((cadena = read.readLine()) != null){                            
                            String[] datos = cadena.split(",");
                            localhost = Integer.parseInt(datos[0]);
                            usernamepostgresql = datos[1];
                            passwordpostgresql = datos[2];
                        }
                        read.close();
                    }                    

                leer.close();
            } catch (IOException e1) {
            }
    }
    
    private String getIDMore1(String primarykey, String nombretabla) {
        Statement stmt;
        String newid;
        String stringid = "";
        String idexist = "";
        if (null != nombretabla) {
            switch (nombretabla) {
                case "usuarios":
                    idexist = "U0000";
                    break;
                case "dias":
                    idexist = "D001";
                    break;
                case "decisiones":
                    idexist = "A000";
                    break;
                case "objetos":
                    idexist = "O01";
                    break;
                case "estadisticas":
                    idexist = "E00000";
                    break;
                default:
                    break;
            }
        }
        try {
            stmt = conn.createStatement();
            try (ResultSet rs = stmt.executeQuery("select " + primarykey + " from " + nombretabla + " order by " + primarykey + " desc;")) {
                while (rs.next()) {
                    if(rs.isFirst()){
                        stringid = rs.getString(1);
                        break;
                    }
                    System.out.println(rs.getString(1));
                }
            }
            stmt.close();
//            conn.close();
            if (stringid == null || "".equals(stringid)) {
                newid = idexist;
            } else {
                String tempid = stringid.replace(String.valueOf(idexist.charAt(0)), "");
                
                int numericid = Integer.parseInt(tempid) + 1;
                int size = stringid.length() - String.valueOf(numericid).length() - 1;
                String idzeros = "";
                for (int k = 0; k < size; k++) {
                    idzeros = idzeros + "0";
                }
                newid = idexist.charAt(0) + idzeros + String.valueOf(numericid);
            }
            return newid;
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return null;
    }
    
    public boolean guardaUsuario(String nombreusuario, String contrasena) {
        String id = "";
        Statement stmt;
        try {
            stmt = conn.createStatement();
            try (ResultSet rs = stmt.executeQuery("select nomusuario,contrausuario from usuarios where nomusuario like '"+nombreusuario+"';")) {
                while (rs.next()) {
                    id = rs.getString(1);
                }
            }
            if(id == null ? nombreusuario == null : id.equals(nombreusuario)){
                return false;
            }
            String sql = "insert into usuarios values('"+getIDMore1("idusuario","usuarios")+"','"+nombreusuario+"','"+contrasena+"',null,'nuevopersonaje','nuevopersonaje',100,'Normal','D000','A000');";
            stmt.executeUpdate(sql);           

            stmt.close();
//            conn.commit();
            conn.close();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return false;
    }
    
    public String buscaUsuario(String nombreusuario, String contrasena) {
        Statement stmt;
        String id = "";
        try {
            stmt = conn.createStatement();
            try (ResultSet rs = stmt.executeQuery("select idusuario,nomusuario,contrausuario from usuarios where nomusuario like '"+nombreusuario+"' and contrausuario like '"+contrasena+"';")) {
                while (rs.next()) {
                    id = rs.getString(1);
                }
            }
            stmt.close();
            conn.close();
            return id;
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
//            return null;
        }
        return null;
    }
    
    public String obtenerDiaODecision(String idusuario, String diaodecision) {
        Statement stmt;
        String decision = "";
        try {
            stmt = conn.createStatement();
            try (ResultSet rs = stmt.executeQuery("select "+diaodecision+" from usuarios where idusuario like '"+idusuario+"';")) {
                while (rs.next()) {
                    decision = rs.getString(1);
                }
            }
            stmt.close();
            conn.close();
            return decision;
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
//            return null;
        }
        return null;
    }
    
    public void actualizarDiaYDecision(String idusuario, String dia, String decision) {
        Statement stmt;
        try {
            stmt = conn.createStatement();
            String sql = "update usuarios set dia_coddia = '"+dia+"' where idusuario like '"+idusuario+"';";
            stmt.executeUpdate(sql);
            sql = "update usuarios set decision_iddecision = '"+decision+"' where idusuario like '"+idusuario+"';";
            stmt.executeUpdate(sql);
//            conn.commit();
           
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    
    public String[] buscaPersonaje(String iduser) {
        Statement stmt;
        String nompersonaje = "";
        String apellpersonaje = "";
        String porcentajevida = "";
        String estadojugador = "";
        try {
            stmt = conn.createStatement();
            try (ResultSet rs = stmt.executeQuery("select nompersonaje,apellpersonaje,porcentajevida,estadojugador from usuarios where idusuario like '"+iduser+"';")) {
                while (rs.next()) {
                    nompersonaje = rs.getString(1);
                    apellpersonaje = rs.getString(2);
                    porcentajevida = rs.getString(3);
                    estadojugador = rs.getString(4);
                }
            }
            String[] datospersonaje = {nompersonaje,apellpersonaje,porcentajevida,estadojugador};
            stmt.close();
            conn.close();
            return datospersonaje;
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
//            return null;
        }
        return null;
    }
    
    public void actualizarPersonaje(String iduser, String nompersonaje, String apellpersonaje, int salud, String estadosalud) {
        Statement stmt;
        try {
            stmt = conn.createStatement();
            String sql = "update usuarios set nompersonaje = '"+nompersonaje+"' where idusuario like '"+iduser+"';";
            stmt.executeUpdate(sql);
            sql = "update usuarios set apellpersonaje = '"+apellpersonaje+"' where idusuario like '"+iduser+"';";
            stmt.executeUpdate(sql);
            sql = "update usuarios set porcentajevida = "+salud+" where idusuario like '"+iduser+"';";
            stmt.executeUpdate(sql);
            sql = "update usuarios set estadojugador = '"+estadosalud+"' where idusuario like '"+iduser+"';";
            stmt.executeUpdate(sql);
//            conn.commit();
           
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    
    public void subirImagen(FileInputStream fis, int longitudBytes, String iduser){
        try{
            String sql="update usuarios set imagen = ? where idusuario like '"+iduser+"';";

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setBinaryStream(1,fis,longitudBytes);
                ps.execute();
            }

        }catch(SQLException | NumberFormatException | HeadlessException e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    
    public ImageIcon consultarImagen(String iduser){
        Statement stmt;
        String sql="select imagen from usuarios where idusuario like '"+iduser+"';";
        ImageIcon img;
        InputStream is;
        try{
            stmt = conn.createStatement();
            try (ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    is = rs.getBinaryStream(1);

                    BufferedImage bi = ImageIO.read(is);
                    img = new ImageIcon(bi);

                    return img;
                }
            }
        }catch(SQLException | IOException e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }catch(java.lang.IllegalArgumentException x){
            return new ImageIcon(getClass().getResource("/images/withoutphoto.png"));
        }
        return null;
    }
    
    public void insertarOBorrarObjetos(String idusuario, String codobjeto, boolean isinsertar){
        Statement stmt;
        String sql;
        try {
            stmt = conn.createStatement();
            if(isinsertar){
                sql = "insert into usuarios_has_objetos values('" + idusuario + "','" + codobjeto + "');";
            }else{
                sql = "delete from usuarios_has_objetos where usuario_idusuario like '"+idusuario+"' and objeto_codobjeto like '"+codobjeto+"';";
            }
            
            stmt.executeUpdate(sql);
            stmt.close();
//            conn.commit();
            conn.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
    public void borrarTodosLosObjetos(String idusuario){
        Statement stmt;
        String sql;
        try {
            stmt = conn.createStatement();
            sql = "delete from usuarios_has_objetos where usuario_idusuario like '"+idusuario+"';";
            
            stmt.executeUpdate(sql);
            stmt.close();
//            conn.commit();
            conn.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    
    public ArrayList<ArrayList<String>> buscaObjetos(String iduser) {
        Statement stmt;
        ArrayList<String> objetos = new ArrayList<>();
        ArrayList<String> nomobjetos = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            try (ResultSet rs = stmt.executeQuery("select objeto_codobjeto,nomobjeto from usuarios_has_objetos join objetos on objeto_codobjeto=codobjeto where usuario_idusuario like '"+iduser+"';")) {
                while (rs.next()) {
                    if(rs.getString(1) != null && !"".equals(rs.getString(1)) && rs.getString(2) != null && !"".equals(rs.getString(1))){
                        objetos.add(rs.getString(1));
                        nomobjetos.add(rs.getString(2));
                    }                    
                }
            }
            ArrayList<ArrayList<String>> objwithname = new ArrayList<>();
            if(!objetos.isEmpty() || !nomobjetos.isEmpty()){
                objwithname.add(objetos);
                objwithname.add(nomobjetos);
            }
            stmt.close();
            conn.close();
            return objwithname;
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
//            return null;
        }
        return null;
    }

    public String buscaNomObjeto(String codobjeto) {
        Statement stmt;
        String nombreobjeto = null;
        try {
            stmt = conn.createStatement();
            try (ResultSet rs = stmt.executeQuery("select nomobjeto from objetos where codobjeto like '"+codobjeto+"';")) {
                while (rs.next()) {
                    nombreobjeto = rs.getString(1);
                }
            }
            stmt.close();
            conn.close();
            return nombreobjeto;
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
//            return null;
        }
        return null;
    }
    
    public void insertarEstadistica(String idusuario, String nompersonaje, String apellpersonaje, int porcentajevida, String estadojugador, String finaldecision){
        Statement stmt;
        String sql;
        try {
            stmt = conn.createStatement();

            sql = "insert into estadisticas values('" + getIDMore1("idestadistica","estadisticas") + "','" + idusuario + "','" + nompersonaje + "','" + apellpersonaje + "'," + porcentajevida + ",'" + estadojugador + "','" + finaldecision + "');";
            
            stmt.executeUpdate(sql);
            stmt.close();
//            conn.commit();
            conn.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    
    public DefaultTableModel estadisticas(JTable stats) {
        DefaultTableModel estad = (DefaultTableModel) stats.getModel();
        Statement stmt;
        try {
            stmt = conn.createStatement();
            try (ResultSet rs = stmt.executeQuery("select nomusuario,estadisticas.nompersonaje,estadisticas.apellpersonaje,estadisticas.porcentajevida,estadisticas.estadojugador," +
                    "eventofinal from estadisticas join usuarios on usuario_idusuario=idusuario join decisiones on finaldecision=iddecision;")) {
                while (rs.next()) {
                    Object[] tupla = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)};
                    estad.addRow(tupla);
                }
            }
            stmt.close();
            conn.close();
            return estad;
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
//            return null;
        }
        return null;
    }
    
    public int conteoEstadisticas(String eventofinal) {
        int count = 0;
        Statement stmt;
        try {
            stmt = conn.createStatement();
            try (ResultSet rs = stmt.executeQuery("select t1.iddecision,t1.eventofinal,t2.iddecision,t2.eventofinal from (estadisticas join decisiones on finaldecision=iddecision) as t1 join " +
                    "(estadisticas join decisiones on finaldecision=iddecision) as t2 on t1.eventofinal=t2.eventofinal where t1.eventofinal like '" + eventofinal + "';")) {
                while (rs.next()) {                    
                    count++;
                }
            }
            stmt.close();
            conn.close();
            return count;
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
//            return null;
        }
        return 0;
    }
    
    public String miEstadistica(String idusuario){
        String exist = null;
        Statement stmt;
        try {
            stmt = conn.createStatement();
            try (ResultSet rs = stmt.executeQuery("select usuario_idusuario,finaldecision,eventofinal from estadisticas join decisiones on finaldecision=iddecision where usuario_idusuario like '" + idusuario + "';")) {
                while (rs.next()) {                    
                    if(rs.isLast()){
                        exist = rs.getString(3);
                    }
                }
            }
            stmt.close();
            conn.close();
            return exist;
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
//            return null;
        }
        return exist;
    }
}
