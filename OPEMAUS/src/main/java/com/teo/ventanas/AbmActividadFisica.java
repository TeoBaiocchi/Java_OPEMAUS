package com.teo.ventanas;

import com.teo.modelos.RegistroFisico;
import com.teo.service.RegistroFisicoSrv;
import com.teo.util.UtilFechas;
import java.time.LocalDate;

/**
 *
 * @author Teo
 */
public class AbmActividadFisica extends javax.swing.JFrame {

    /**
     * Creates new form AbmActividadFisica
     */
    public AbmActividadFisica() {
        initComponents();
        llenarCombo();
    }

    private void llenarCombo(){
//todo
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtxtFecha = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtxtAreaObservaciones = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtxtAreaDetalle = new javax.swing.JTextArea();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jbCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtxtDistancia = new javax.swing.JTextField();
        jbGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabel1.setText("Agregar una nueva actividad Fisica");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(6, 6, 390, 16);

        jLabel2.setText("Fecha");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 40, 370, 16);

        jtxtFecha.setFormatterFactory(UtilFechas.FORMATTER_FACTORY);
        jtxtFecha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtFechaFocusGained(evt);
            }
        });
        jPanel1.add(jtxtFecha);
        jtxtFecha.setBounds(10, 60, 100, 22);

        jLabel3.setText("Detalle");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(160, 100, 36, 16);

        jtxtAreaObservaciones.setColumns(20);
        jtxtAreaObservaciones.setRows(5);
        jScrollPane1.setViewportView(jtxtAreaObservaciones);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 240, 380, 80);

        jtxtAreaDetalle.setColumns(20);
        jtxtAreaDetalle.setRows(5);
        jScrollPane2.setViewportView(jtxtAreaDetalle);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(150, 120, 240, 90);
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(10, 120, 130, 22);

        jLabel4.setText("Observaciones");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 220, 120, 16);

        jbCancelar.setText("Cancelar");
        jPanel1.add(jbCancelar);
        jbCancelar.setBounds(10, 330, 110, 23);

        jLabel5.setText("Actividad");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 100, 49, 16);

        jLabel6.setText("Distancia Aproximada");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 170, 130, 16);
        jPanel1.add(jtxtDistancia);
        jtxtDistancia.setBounds(10, 190, 110, 22);

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(jbGuardar);
        jbGuardar.setBounds(280, 330, 110, 23);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 410, 380);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        //if verificacion
        
        RegistroFisico entidad = new RegistroFisico();
        entidad.setDetalle(jtxtAreaDetalle.getText().trim());
        entidad.setCantidad(jtxtDistancia.getText().trim());
        entidad.setFecha(LocalDate.parse(jtxtFecha.getText(), UtilFechas.FORMATO_DATETIME));
        entidad.setIdActividad(Integer.parseInt(jComboBox1.getSelectedItem().toString().split("-")[0].trim()));
        entidad.setId(0);
        RegistroFisicoSrv.guardarOActualizar(entidad);
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jtxtFechaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtFechaFocusGained
        if(jtxtFecha.getText().trim().equals(UtilFechas.MENSAJE_FECHA)){
            jtxtFecha.setValue(null);
        }
    }//GEN-LAST:event_jtxtFechaFocusGained

    public static void main(){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AbmActividadFisica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JTextArea jtxtAreaDetalle;
    private javax.swing.JTextArea jtxtAreaObservaciones;
    private javax.swing.JTextField jtxtDistancia;
    private javax.swing.JFormattedTextField jtxtFecha;
    // End of variables declaration//GEN-END:variables
}
