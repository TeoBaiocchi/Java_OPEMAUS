package com.teo.ventanas;

import com.teo.util.UtilGraficoVentanas;
import javax.swing.JPanel;

/**
 * @author Teo
 */
public class JDialogAvisoGenerico extends javax.swing.JDialog {

    UtilGraficoVentanas monitor;
    
    public JDialogAvisoGenerico(java.awt.Frame parent, boolean modal, String texto) {
        super(parent, modal);
        initComponents();
        jlabelTexto.setText(texto);
        monitor.resizearDialog(this, parent, jPanel1);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlabelTexto = new javax.swing.JLabel();
        jbOK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(null);

        jlabelTexto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabelTexto.setText("placeholder");
        jlabelTexto.setToolTipText("");
        jPanel1.add(jlabelTexto);
        jlabelTexto.setBounds(10, 10, 380, 50);

        jbOK.setText("OK");
        jbOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbOKActionPerformed(evt);
            }
        });
        jPanel1.add(jbOK);
        jbOK.setBounds(160, 70, 72, 23);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 400, 100);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbOKActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbOKActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbOK;
    private javax.swing.JLabel jlabelTexto;
    // End of variables declaration//GEN-END:variables
}
