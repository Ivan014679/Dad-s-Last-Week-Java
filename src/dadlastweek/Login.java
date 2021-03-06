/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dadlastweek;

import interfacethings.DLWOptionPane;
import interfacethings.ImageFond;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Daniel Arteaga
 */
public class Login extends javax.swing.JFrame {
    DLWOptionPane dialog;
    private Cursor cursor;
    /**
     * Creates new form Ventana
     */
    public Login() {
        initComponents();        
        anotherInitComponents();    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageFond image = new ImageFond();
        image.setImage("/images/Fondo.jpg");
        setContentPane(image);
        fondo = new javax.swing.JPanel();
        img = new javax.swing.JLabel();
        contenido = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        loginbutton = new javax.swing.JButton();
        registerbutton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        labelusername = new javax.swing.JLabel();
        nombreusuario = new javax.swing.JTextField();
        labelpassword = new javax.swing.JLabel();
        contrasena = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Iniciar sesión");
        setMaximumSize(new java.awt.Dimension(250, 400));
        setMinimumSize(new java.awt.Dimension(250, 400));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        fondo.setOpaque(false);
        fondo.setLayout(new java.awt.BorderLayout());

        img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fondo.add(img, java.awt.BorderLayout.CENTER);

        contenido.setOpaque(false);
        contenido.setLayout(new java.awt.BorderLayout());

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        loginbutton.setBorderPainted(false);
        loginbutton.setContentAreaFilled(false);
        loginbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbuttonActionPerformed(evt);
            }
        });
        jPanel2.add(loginbutton);

        registerbutton.setBorderPainted(false);
        registerbutton.setContentAreaFilled(false);
        registerbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerbuttonActionPerformed(evt);
            }
        });
        jPanel2.add(registerbutton);

        contenido.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setText("          ");
        jPanel3.add(jLabel1);

        jPanel5.setOpaque(false);
        jPanel5.setLayout(new java.awt.GridLayout(4, 0));

        labelusername.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        labelusername.setText("Nombre de Usuario:");
        jPanel5.add(labelusername);

        nombreusuario.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        nombreusuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 0, 0, 32), new java.awt.Color(0, 0, 0, 32), new java.awt.Color(0, 0, 0, 96), new java.awt.Color(0, 0, 0, 96)));
        nombreusuario.setOpaque(false);
        nombreusuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreusuarioKeyTyped(evt);
            }
        });
        jPanel5.add(nombreusuario);

        labelpassword.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        labelpassword.setText("Contraseña:");
        jPanel5.add(labelpassword);

        contrasena.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        contrasena.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 0, 0, 32), new java.awt.Color(0, 0, 0, 32), new java.awt.Color(0, 0, 0, 96), new java.awt.Color(0, 0, 0, 96)));
        contrasena.setOpaque(false);
        contrasena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                contrasenaKeyTyped(evt);
            }
        });
        jPanel5.add(contrasena);

        jPanel3.add(jPanel5);

        jLabel2.setText("          ");
        jPanel3.add(jLabel2);

        contenido.add(jPanel3, java.awt.BorderLayout.CENTER);

        fondo.add(contenido, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(fondo);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void anotherInitComponents(){
        
        Image ico = new ImageIcon(getClass().getResource("/images/calendar_5-512.png")).getImage().getScaledInstance(2000, 1900, Image.SCALE_AREA_AVERAGING);
        this.setIconImage(ico);
        Image mini = new ImageIcon(getClass().getResource("/images/Titulo.png")).getImage().getScaledInstance(200, 95, Image.SCALE_AREA_AVERAGING);
        img.setIcon(new ImageIcon(mini));        
        this.setSize(250,400);
        
        //CURSOR
        ImageIcon imagencursor = new ImageIcon(getClass().getResource("/images/cursor.png"));
        Toolkit TK = Toolkit.getDefaultToolkit(); 
        this.cursor = TK.createCustomCursor(imagencursor.getImage(), new Point(2,2),"Cursor 01"); 
        this.setCursor(cursor);
        
        nombreusuario.setBackground(new Color(0, 0, 0, 64));
        contrasena.setBackground(new Color(0, 0, 0, 64));
        
        Image logueoboton = new ImageIcon(getClass().getResource("/images/loginbutton.png")).getImage().getScaledInstance(110, 50, Image.SCALE_AREA_AVERAGING);
        Image registroboton = new ImageIcon(getClass().getResource("/images/registerbutton.png")).getImage().getScaledInstance(110, 50, Image.SCALE_AREA_AVERAGING);
        Image logueobotonenfocado = new ImageIcon(getClass().getResource("/images/loginbuttonfocused.png")).getImage().getScaledInstance(110, 50, Image.SCALE_AREA_AVERAGING);
        Image registrobotonenfocado = new ImageIcon(getClass().getResource("/images/registerbuttonfocused.png")).getImage().getScaledInstance(110, 50, Image.SCALE_AREA_AVERAGING);
        Image logueobotonpresionado = new ImageIcon(getClass().getResource("/images/loginbuttonpressed.png")).getImage().getScaledInstance(110, 50, Image.SCALE_AREA_AVERAGING);
        Image registrobotonpresionado = new ImageIcon(getClass().getResource("/images/registerbuttonpressed.png")).getImage().getScaledInstance(110, 50, Image.SCALE_AREA_AVERAGING);
        loginbutton.setIcon(new ImageIcon(logueoboton));
        registerbutton.setIcon(new ImageIcon(registroboton));
        loginbutton.setRolloverIcon(new ImageIcon(logueobotonenfocado));
        registerbutton.setRolloverIcon(new ImageIcon(registrobotonenfocado));
        loginbutton.setPressedIcon(new ImageIcon(logueobotonpresionado));
        registerbutton.setPressedIcon(new ImageIcon(registrobotonpresionado));
    }
    
    private void nombreusuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreusuarioKeyTyped
        if (nombreusuario.getText().length() >= 30) {
            evt.consume();
        }
    }//GEN-LAST:event_nombreusuarioKeyTyped

    private void contrasenaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contrasenaKeyTyped
        if (new String(contrasena.getPassword()).length() >= 10) {
            evt.consume();
        }
    }//GEN-LAST:event_contrasenaKeyTyped

    private void registerbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerbuttonActionPerformed
        new Registro(this).setVisible(true);
    }//GEN-LAST:event_registerbuttonActionPerformed

    private void loginbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbuttonActionPerformed
        if(nombreusuario.getText() == null || "".equals(nombreusuario.getText()) || "".equals(new String(contrasena.getPassword()))){
            dialog = new DLWOptionPane(this, "Rellene todos los campos.", "Campos faltantes","warning",250,150,false);
            dialog.setVisible(true);
        }else if(new Database().buscaUsuario(nombreusuario.getText(), new String(contrasena.getPassword())) != null && !"".equals(new Database().buscaUsuario(nombreusuario.getText(), new String(contrasena.getPassword())))){
            String iduser = new Database().buscaUsuario(nombreusuario.getText(), new String(contrasena.getPassword()));
            String[] pjinfo = new Database().buscaPersonaje(iduser);
            ArrayList<ArrayList<String>> objs = new Database().buscaObjetos(iduser);
            String decision = new Database().obtenerDiaODecision(iduser, "decision_iddecision");
            String dia = new Database().obtenerDiaODecision(iduser, "dia_coddia");
            new DadsLastWeek().setIdusuario(iduser);
            new DadsLastWeek().setNompersonaje(pjinfo[0]);
            new DadsLastWeek().setApellpersonaje(pjinfo[1]);
            new DadsLastWeek().setSalud(Integer.parseInt(pjinfo[2]));
            new DadsLastWeek().setEstadosalud(pjinfo[3]);
            new DadsLastWeek().setListaobjetos(objs);
            new DadsLastWeek().setDecision_iddecision(decision);
            new DadsLastWeek().setDia_coddia(dia);
            new Menu().setVisible(true);
            this.dispose();
            dialog = new DLWOptionPane(this, "Inicio de sesión exitoso.", "Autenticación exitosa","info",250,150,false);
            dialog.setVisible(true);
//            JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso.", "Autenticación exitosa", JOptionPane.INFORMATION_MESSAGE);
        }else{
            dialog = new DLWOptionPane(this, "Nombre de usuario o contraseña incorrectos.<br>Asegúrese que los campos esten digitados correctamente.", "Autenticación no exitosa","warning",370,150,false);
            dialog.setVisible(true);
//            JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos.\nAsegúrese que los campos esten digitados correctamente.", "Autenticación no exitosa", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_loginbuttonActionPerformed
    
//    private void centrarVentana() {
//        //este metodo devuelve el tamaño de la pantalla
//        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
//        //obtenemos el tamaño de la ventana
//        Dimension ventana = this.getSize();
//        //para centrar la ventana lo hacemos con el siguiente calculo
//        this.setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);
//    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contenido;
    private javax.swing.JPasswordField contrasena;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel img;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel labelpassword;
    private javax.swing.JLabel labelusername;
    private javax.swing.JButton loginbutton;
    private javax.swing.JTextField nombreusuario;
    private javax.swing.JButton registerbutton;
    // End of variables declaration//GEN-END:variables

    
}
