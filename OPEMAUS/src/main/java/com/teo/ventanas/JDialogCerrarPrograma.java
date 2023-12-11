package com.teo.ventanas;

import com.teo.util.FlujoVentanas;
import com.teo.util.UtilGraficoVentanas;
import java.awt.Color;
import javax.swing.JPanel;
import jdk.jshell.execution.Util;

/**
 * @author Teo
 */
public class JDialogCerrarPrograma extends javax.swing.JDialog {

    
    public JDialogCerrarPrograma(java.awt.Frame parent, boolean modal){
        super(parent, modal);
        initComponents();
        UtilGraficoVentanas.resizearDialog(this, parent, jPanel1);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlabelTexto = new javax.swing.JLabel();
        jbOK = new javax.swing.JButton();
        jbOK1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(null);

        jlabelTexto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabelTexto.setText("¿Cerrar el programa?");
        jlabelTexto.setToolTipText("");
        jPanel1.add(jlabelTexto);
        jlabelTexto.setBounds(10, 10, 380, 50);

        jbOK.setText("No, cambie de opinion");
        jbOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbOKActionPerformed(evt);
            }
        });
        jPanel1.add(jbOK);
        jbOK.setBounds(10, 70, 190, 23);

        jbOK1.setText("Si, cerrar.");
        jbOK1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbOK1ActionPerformed(evt);
            }
        });
        jPanel1.add(jbOK1);
        jbOK1.setBounds(230, 70, 160, 23);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 400, 100);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbOKActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbOKActionPerformed

    private void jbOK1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbOK1ActionPerformed
        FlujoVentanas.setearFrameParaVolver(FlujoVentanas.CERRAR_PROGRAMA);
        FlujoVentanas.volver(null);
    }//GEN-LAST:event_jbOK1ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
       //No, no vas a cerrarte.
    }//GEN-LAST:event_formWindowClosed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbOK;
    private javax.swing.JButton jbOK1;
    private javax.swing.JLabel jlabelTexto;
    // End of variables declaration//GEN-END:variables
}
