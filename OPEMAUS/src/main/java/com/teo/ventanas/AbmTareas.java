package com.teo.ventanas;

import com.teo.modelos.Tarea;
import com.teo.service.TareaSrv;
import com.teo.util.FlujoVentanas;
import com.teo.util.UtilControlCampos;
import com.teo.util.UtilFechas;
import com.teo.util.UtilGraficoVentanas;
import java.awt.Color;
import java.time.LocalDate;

/**
 * @author Teo
 */
public class AbmTareas extends javax.swing.JFrame {

    UtilControlCampos control = new UtilControlCampos();
    
    public static int ID = 0;
    
    public AbmTareas(int id) {
        initComponents();
        ID = id;
        inicializar();
    }
    
    private void inicializar(){
        UtilGraficoVentanas.reshapeadorVentanas(this, jPanel1, 0, 0);
        generarControlVentana();
        llenarCamposEdicion();
        this.setVisible(true);
    }

    private void llenarCamposEdicion(){
        
        if(ID == 0){
            return;
        }
        
        Tarea tarea = TareaSrv.obtenerById(ID);
        jtxtAsunto.setText(tarea.getAsunto());
        jtextareaDetalle.setText(tarea.getDetalle());
        jtxtFormattedFecha.setText(tarea.getFecha().format(UtilFechas.FORMATO_DATETIME));
        jcbFechaLimite.setSelected(tarea.isFechaLimite());
        jcbSinFecha.setSelected(tarea.isSinFecha());
        
        switch(tarea.getPrioridad()){
            case TareaSrv.PRIORIDAD_0:
                jrb0.setSelected(true);
                break;
            case TareaSrv.PRIORIDAD_1:
                jrb1.setSelected(true);
                break;
            case TareaSrv.PRIORIDAD_2:
                jrb2.setSelected(true);
                break;
            case TareaSrv.PRIORIDAD_3:
                jrb3.setSelected(true);
                break;
            case TareaSrv.PRIORIDAD_4:
                jrb4.setSelected(true);
                break;
            case TareaSrv.PRIORIDAD_5:
                jrb5.setSelected(true);
                break;
        }
        
    }
    
        private void generarControlVentana(){
        control.CAMPOS_INPUT_ESTANDAR.put("Asunto", jtxtAsunto);
    
        control.CAMPOS_CHECKBOX.put("RecordarCumpleanios", jcbFechaLimite);
        control.CAMPOS_CHECKBOX.put("SinFecha", jcbSinFecha);
        
        control.CAMPOS_INPUT_TEXTAREA.put("Detalle", jtextareaDetalle);
        
        control.CAMPOS_INPUT_FORMATTED.put("Fecha", jtxtFormattedFecha);
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jbVolver = new javax.swing.JButton();
        jbAceptar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtextareaDetalle = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtxtAsunto = new javax.swing.JTextField();
        jtxtFormattedFecha = new javax.swing.JFormattedTextField();
        jcbFechaLimite = new javax.swing.JCheckBox();
        jcbSinFecha = new javax.swing.JCheckBox();
        jrb0 = new javax.swing.JRadioButton();
        jrb1 = new javax.swing.JRadioButton();
        jrb2 = new javax.swing.JRadioButton();
        jrb3 = new javax.swing.JRadioButton();
        jrb4 = new javax.swing.JRadioButton();
        jrb5 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jbVolver.setText("Cancelar");
        jbVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVolverActionPerformed(evt);
            }
        });
        jPanel1.add(jbVolver);
        jbVolver.setBounds(10, 280, 90, 30);

        jbAceptar.setText("Aceptar");
        jbAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(jbAceptar);
        jbAceptar.setBounds(252, 280, 90, 30);

        jtextareaDetalle.setColumns(20);
        jtextareaDetalle.setRows(5);
        jScrollPane1.setViewportView(jtextareaDetalle);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 160, 340, 100);

        jLabel1.setText("Prioridad : ");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 90, 80, 16);

        jLabel2.setText("Fecha :");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 40, 70, 16);

        jLabel3.setText("Asunto : ");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 10, 90, 16);
        jPanel1.add(jtxtAsunto);
        jtxtAsunto.setBounds(70, 10, 280, 22);

        jtxtFormattedFecha.setFormatterFactory(UtilFechas.FORMATTER_FACTORY);
        jtxtFormattedFecha.setText("dia/mes/año");
        jtxtFormattedFecha.setActionCommand("<Not Set>");
        jtxtFormattedFecha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtFormattedFechaFocusGained(evt);
            }
        });
        jPanel1.add(jtxtFormattedFecha);
        jtxtFormattedFecha.setBounds(70, 40, 90, 20);

        jcbFechaLimite.setText("Fecha limite");
        jPanel1.add(jcbFechaLimite);
        jcbFechaLimite.setBounds(170, 60, 110, 20);

        jcbSinFecha.setText("Sin Fecha");
        jcbSinFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbSinFechaActionPerformed(evt);
            }
        });
        jPanel1.add(jcbSinFecha);
        jcbSinFecha.setBounds(170, 40, 73, 20);

        buttonGroup1.add(jrb0);
        jrb0.setText("Min.");
        jPanel1.add(jrb0);
        jrb0.setBounds(10, 110, 50, 21);

        buttonGroup1.add(jrb1);
        jrb1.setSelected(true);
        jrb1.setText("1");
        jPanel1.add(jrb1);
        jrb1.setBounds(70, 110, 50, 21);

        buttonGroup1.add(jrb2);
        jrb2.setText("2");
        jPanel1.add(jrb2);
        jrb2.setBounds(130, 110, 50, 21);

        buttonGroup1.add(jrb3);
        jrb3.setText("3");
        jPanel1.add(jrb3);
        jrb3.setBounds(190, 110, 50, 21);

        buttonGroup1.add(jrb4);
        jrb4.setText("4");
        jPanel1.add(jrb4);
        jrb4.setBounds(250, 110, 50, 21);

        buttonGroup1.add(jrb5);
        jrb5.setText("5");
        jPanel1.add(jrb5);
        jrb5.setBounds(310, 110, 50, 21);

        jLabel4.setText("Detalle : ");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 140, 80, 16);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 360, 320);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private String MENSAJE_FECHA = "dia/mes/año";
    private void jtxtFormattedFechaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtFormattedFechaFocusGained
    if(jtxtFormattedFecha.getText().trim().equals(MENSAJE_FECHA)){
            jtxtFormattedFecha.setValue(null);
        }
    }//GEN-LAST:event_jtxtFormattedFechaFocusGained

    private void jbAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAceptarActionPerformed
        if(!control.revisarInputValidoCampos(this)){
            return;
        }
        
        Tarea tarea = new Tarea();
        tarea.setId(ID);
        tarea.setAsunto(jtxtAsunto.getText().trim());
        tarea.setDetalle(jtextareaDetalle.getText().trim());
        tarea.setFechaLimite(jcbFechaLimite.isSelected());
        
        if(jcbSinFecha.isSelected() || jtxtFormattedFecha.getText().trim().equals("") || jtxtFormattedFecha.getText().trim().equals(MENSAJE_FECHA)){
            tarea.setFechaLimite(false);
            tarea.setSinFecha(true);
            tarea.setFecha(null);
        } else {
            tarea.setSinFecha(false);
            tarea.setFecha(LocalDate.parse(jtxtFormattedFecha.getText(), UtilFechas.FORMATO_DATETIME));
        }
        
        if(jrb0.isSelected()){
            tarea.setPrioridad(TareaSrv.PRIORIDAD_0);
        } else if(jrb1.isSelected()){
            tarea.setPrioridad(TareaSrv.PRIORIDAD_1);
        } else if(jrb2.isSelected()){
            tarea.setPrioridad(TareaSrv.PRIORIDAD_2);
        } else if(jrb3.isSelected()){
            tarea.setPrioridad(TareaSrv.PRIORIDAD_3);
        } else if(jrb4.isSelected()){
            tarea.setPrioridad(TareaSrv.PRIORIDAD_4);
        } else if(jrb5.isSelected()){
            tarea.setPrioridad(TareaSrv.PRIORIDAD_5);
        }
        
        TareaSrv.guardarOActualizar(tarea);
        JDialogAvisoGenerico avisoGenerico = new JDialogAvisoGenerico(this, true, "Guardado!", FlujoVentanas.COLOR_VERDECLARO);
        FlujoVentanas.volver(this);
    }//GEN-LAST:event_jbAceptarActionPerformed

    private void jcbSinFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbSinFechaActionPerformed
        if(jcbSinFecha.isSelected()){
            jtxtFormattedFecha.setEnabled(false);
        } else {
            jtxtFormattedFecha.setEnabled(true);
        }
    }//GEN-LAST:event_jcbSinFechaActionPerformed

    private void jbVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVolverActionPerformed
        FlujoVentanas.volver(this);
    }//GEN-LAST:event_jbVolverActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAceptar;
    private javax.swing.JButton jbVolver;
    private javax.swing.JCheckBox jcbFechaLimite;
    private javax.swing.JCheckBox jcbSinFecha;
    private javax.swing.JRadioButton jrb0;
    private javax.swing.JRadioButton jrb1;
    private javax.swing.JRadioButton jrb2;
    private javax.swing.JRadioButton jrb3;
    private javax.swing.JRadioButton jrb4;
    private javax.swing.JRadioButton jrb5;
    private javax.swing.JTextArea jtextareaDetalle;
    private javax.swing.JTextField jtxtAsunto;
    private javax.swing.JFormattedTextField jtxtFormattedFecha;
    // End of variables declaration//GEN-END:variables
}
