package com.teo.ventanas;

import com.teo.util.UtilGraficoVentanas;
import java.awt.Frame;

/**
 *
 * @author Teo
 */
public class TextoDialog extends javax.swing.JDialog {
    
    private UtilGraficoVentanas monitor = new UtilGraficoVentanas(); //No puedo instanciarla aca porque requiere un "this", que no puede usarse hasta construir esta clase per se
    private Frame padre;
    private String texto = "";
   
    /*
    Mandar id = 0 para nuevo, id real para edicion
    */
    public TextoDialog(java.awt.Frame parent, boolean modal, String titulo, String texto){
        super(parent, modal);
        initComponents();
        padre = parent;
        jLabelTitulo.setText(titulo);
        this.texto = texto;
        jtxtObservaciones.setText(texto);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jbCancelar = new javax.swing.JButton();
        jbAceptar = new javax.swing.JButton();
        jtxtObservaciones = new javax.swing.JTextArea();
        jbEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("placeholder");
        jPanel1.add(jLabelTitulo);
        jLabelTitulo.setBounds(10, 10, 200, 20);

        jbCancelar.setFont(new java.awt.Font("Liberation Sans", 0, 11)); // NOI18N
        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(jbCancelar);
        jbCancelar.setBounds(10, 120, 90, 23);

        jbAceptar.setText("Aceptar");
        jbAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(jbAceptar);
        jbAceptar.setBounds(110, 120, 90, 23);

        jtxtObservaciones.setColumns(20);
        jtxtObservaciones.setRows(5);
        jtxtObservaciones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jtxtObservaciones);
        jtxtObservaciones.setBounds(20, 40, 180, 60);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 220, 160);

        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(jbEliminar);
        jbEliminar.setBounds(20, 360, 75, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public String mostrarDialogEsperarResultado(){
        monitor.resizearDialog(this, padre, jPanel1);
        this.setVisible(true);
        return texto;
    }
    private void jbAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAceptarActionPerformed
        String aux = jtxtObservaciones.getText().trim();
        if(aux.equals("")){
            return;
//            JDialogAvisoGenerico ventana = JDialogAvisoGenerico(padre, true, "No puede dejar el campo en blanco.");
        }
        texto = aux;
        this.dispose();
    }//GEN-LAST:event_jbAceptarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        this.texto = null;
        this.dispose();
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        
    }//GEN-LAST:event_jbEliminarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbAceptar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JTextArea jtxtObservaciones;
    // End of variables declaration//GEN-END:variables
}
