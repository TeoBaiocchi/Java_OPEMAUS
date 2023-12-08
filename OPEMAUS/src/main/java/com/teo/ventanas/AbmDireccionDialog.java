/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.teo.ventanas;

import com.teo.modelos.Direccion;
import com.teo.service.DireccionSrv;
import com.teo.util.UtilControlCampos;
import com.teo.util.UtilGraficoVentanas;
import java.awt.Frame;
import javax.swing.JFrame;

/**
 *
 * @author Teo
 */
public class AbmDireccionDialog extends javax.swing.JDialog {
    
    private UtilGraficoVentanas monitor = new UtilGraficoVentanas(); //No puedo instanciarla aca porque requiere un "this", que no puede usarse hasta construir esta clase per se
    private UtilControlCampos control = new UtilControlCampos();
    private Frame padre;
    public Direccion direccion = null;
    private int ID = 0;
   
    /*
    Mandar id = 0 para nuevo, id real para edicion
    */
    public AbmDireccionDialog(java.awt.Frame parent, boolean modal, int id){
        super(parent, modal);
        initComponents();
        padre = parent;
        ID = id;
        inicializar();
    }
    
    private void llenarCamposParaEdicion(){
        this.direccion = DireccionSrv.obtenerDireccionById(ID);
        control.CAMPOS_INPUT_ESTANDAR.get("Calle").setText(direccion.getCalle());
        control.CAMPOS_INPUT_ESTANDAR.get("Nro").setText(direccion.getNro());
        control.CAMPOS_INPUT_ESTANDAR.get("Piso").setText(direccion.getPiso());
        control.CAMPOS_INPUT_TEXTAREA.get("Observaciones").setText(direccion.getObservaciones());
    }
    
    private void inicializar(){
        control.CAMPOS_INPUT_ESTANDAR.put("Calle", jtxtCalle);
        control.CAMPOS_INPUT_ESTANDAR.put("Nro", jtxtNro);
        control.CAMPOS_INPUT_ESTANDAR.put("Piso", jtxtPiso);
        control.CAMPOS_INPUT_TEXTAREA.put("Observaciones", jtxtObservaciones);
        if(ID == 0){
            jLabelTitulo.setText("Nueva Direccion");
        } else {
            llenarCamposParaEdicion();
            jLabelTitulo.setText("Editando Direccion N°" + ID);
        }
    }
    
    public Direccion mostrarDialogEsperarResultado(){
        monitor.resizearDialog(this, padre, jPanel1);
        this.setVisible(true);
        return direccion;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jbCancelar = new javax.swing.JButton();
        jbAceptar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jtxtCalle = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtxtNro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtxtPiso = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtxtObservaciones = new javax.swing.JTextArea();
        jbEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("placeholder");
        jPanel1.add(jLabelTitulo);
        jLabelTitulo.setBounds(10, 10, 220, 16);

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(jbCancelar);
        jbCancelar.setBounds(10, 220, 90, 23);

        jbAceptar.setText("Aceptar");
        jbAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(jbAceptar);
        jbAceptar.setBounds(160, 220, 90, 23);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Calle : ");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(0, 40, 50, 20);
        jPanel1.add(jtxtCalle);
        jtxtCalle.setBounds(50, 40, 190, 22);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("N°: ");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(0, 70, 50, 20);
        jPanel1.add(jtxtNro);
        jtxtNro.setBounds(50, 70, 50, 22);

        jLabel5.setText("Observaciones :");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 100, 210, 20);
        jPanel1.add(jtxtPiso);
        jtxtPiso.setBounds(190, 70, 50, 22);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Piso/Timbre :");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(100, 70, 80, 20);

        jtxtObservaciones.setColumns(20);
        jtxtObservaciones.setRows(5);
        jtxtObservaciones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jtxtObservaciones);
        jtxtObservaciones.setBounds(20, 130, 220, 70);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 260, 250);

        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(jbEliminar);
        jbEliminar.setBounds(10, 290, 75, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAceptarActionPerformed
        if(!control.revisarInputValidoCampos((JFrame)padre)){
            return;
        }
        Direccion direccion = new Direccion();
        if(ID == 0){
            direccion.setId(DireccionSrv.obtenerMaxID()+1);
        } else {
            direccion.setId(ID);
            DireccionSrv.eliminar(ID); //"Editar" es efectivamente eliminar el registro anterior, 
            //y reemplazarlo por el guardado del nuevo.
        }
        direccion.setCalle(control.CAMPOS_INPUT_ESTANDAR.get("Calle").getText());
        direccion.setPiso(control.CAMPOS_INPUT_ESTANDAR.get("Piso").getText());
        direccion.setNro(control.CAMPOS_INPUT_ESTANDAR.get("Nro").getText());
        direccion.setObservaciones(control.CAMPOS_INPUT_TEXTAREA.get("Observaciones").getText());
        DireccionSrv.guardar(direccion);
        this.direccion = direccion;
       
        this.dispose();
    }//GEN-LAST:event_jbAceptarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        DireccionSrv.eliminar(ID);
    }//GEN-LAST:event_jbEliminarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbAceptar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JTextField jtxtCalle;
    private javax.swing.JTextField jtxtNro;
    private javax.swing.JTextArea jtxtObservaciones;
    private javax.swing.JTextField jtxtPiso;
    // End of variables declaration//GEN-END:variables
}
