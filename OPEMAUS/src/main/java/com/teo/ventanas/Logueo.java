package com.teo.ventanas;

import com.teo.opemaus.OPEMAUS;
import com.teo.util.UtilGraficoVentanas;

/**
 * @author Teo
 */
public class Logueo extends javax.swing.JFrame {
    
    UtilGraficoVentanas utilVentana; //No puedo instanciarla aca porque requiere un "this", que no puede usarse hasta construir esta clase per se

    public Logueo() {
        initComponents();
        inicializar();
    }
    
    private void setearVersion(){
        jLabel1.setText("Version: " + OPEMAUS.obtenerUltimaVersion());
    }   
    private void inicializar(){
        utilVentana = new UtilGraficoVentanas(this, jPanel1, 0, 0);
        utilVentana.redimensionarReposicionarVentana();
        setearVersion();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtxtContra = new javax.swing.JTextField();
        jbAceptar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Log In");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabel1.setText("a");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 100, 350, 16);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Contraseña :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 55, 100, 16);
        jPanel1.add(jtxtContra);
        jtxtContra.setBounds(120, 50, 140, 30);

        jbAceptar.setText("OK");
        jbAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(jbAceptar);
        jbAceptar.setBounds(270, 55, 70, 23);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("OPEM");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(11, 14, 350, 16);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 370, 120);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAceptarActionPerformed
        if(jtxtContra.getText().trim().equals("pass")){
            Menu.main();
            this.dispose();
        }
    }//GEN-LAST:event_jbAceptarActionPerformed


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Logueo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbAceptar;
    private javax.swing.JTextField jtxtContra;
    // End of variables declaration//GEN-END:variables
}
