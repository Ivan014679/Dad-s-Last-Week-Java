/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dadlastweek;

import java.util.ArrayList;

/**
 *
 * @author Ivan
 */
public class DadsLastWeek {
    private static String idusuario;
    private static String nompersonaje, apellpersonaje, dia_coddia, decision_iddecision, estadosalud;
    private static boolean isPlaying = false;
    private static boolean isPjWindowOpened = false;
    private static int salud;
    private static ArrayList<ArrayList<String>> listaobjetos;
    
    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        DadsLastWeek.idusuario = idusuario;
    }

    public String getDia_coddia() {
        return dia_coddia;
    }

    public void setDia_coddia(String dia_coddia) {
        DadsLastWeek.dia_coddia = dia_coddia;
    }

    public String getDecision_iddecision() {
        return decision_iddecision;
    }

    public void setDecision_iddecision(String decision_iddecision) {
        DadsLastWeek.decision_iddecision = decision_iddecision;
    }

    public boolean isIsPlaying() {
        return isPlaying;
    }

    public void setIsPlaying(boolean isPlaying) {
        DadsLastWeek.isPlaying = isPlaying;
    }

    public boolean isIsPjWindowOpened() {
        return isPjWindowOpened;
    }

    public void setIsPjWindowOpened(boolean isPjWindowOpened) {
        DadsLastWeek.isPjWindowOpened = isPjWindowOpened;
    }

    public String getNompersonaje() {
        return nompersonaje;
    }

    public void setNompersonaje(String nompersonaje) {
        DadsLastWeek.nompersonaje = nompersonaje;
    }

    public String getApellpersonaje() {
        return apellpersonaje;
    }

    public void setApellpersonaje(String apellpersonaje) {
        DadsLastWeek.apellpersonaje = apellpersonaje;
    }

    public String getEstadosalud() {
        return estadosalud;
    }

    public void setEstadosalud(String estadosalud) {
        DadsLastWeek.estadosalud = estadosalud;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        DadsLastWeek.salud = salud;
    }

    public ArrayList<ArrayList<String>> getListaobjetos() {
        return listaobjetos;
    }

    public void setListaobjetos(ArrayList<ArrayList<String>> listaobjetos) {
        DadsLastWeek.listaobjetos = listaobjetos;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        new Login().setVisible(true);
    }
}
