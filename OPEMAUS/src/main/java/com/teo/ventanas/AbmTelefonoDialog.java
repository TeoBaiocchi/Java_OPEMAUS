/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.teo.ventanas;

import com.teo.modelos.Telefono;
import com.teo.service.TelefonoSrv;
import com.teo.util.UtilControlCampos;
import com.teo.util.UtilGraficoVentanas;
import java.awt.Frame;
import javax.swing.JFrame;

/**
 *
 * @author Teo
 */
public class AbmTelefonoDialog extends javax.swing.JDialog {
    
    private UtilGraficoVentanas monitor = new UtilGraficoVentanas(); //No puedo instanciarla aca porque requiere un "this", que no puede usarse hasta construir esta clase per se
    private UtilControlCampos control = new UtilControlCampos();
    private Frame padre;
    public Telefono telefono = null;
    private int ID = 0;
   
    /*
    Mandar id = 0 para nuevo, id real para edicion
    */
    public AbmTelefonoDialog(java.awt.Frame parent, boolean modal, int id){
        super(parent, modal);
        initComponents();
        padre = parent;
        ID = id;
        inicializar();
    }
    
    private void llenarCamposParaEdicion(){
        this.telefono = TelefonoSrv.obtenerById(ID);
        control.CAMPOS_INPUT_ESTANDAR.get("Nro").setText(telefono.getNro());
        control.CAMPOS_CHECKBOX.get("Personal").setSelected(telefono.isPersonal());
        control.CAMPOS_COMBOBOX.get("Tipo").setSelectedItem(telefono.getTipo());
        control.CAMPOS_INPUT_TEXTAREA.get("Observaciones").setText(telefono.getObservaciones());
    }
    
    private void inicializar(){
        control.CAMPOS_INPUT_ESTANDAR.put("Nro", jtxtNro);
        control.CAMPOS_INPUT_TEXTAREA.put("Observaciones", jtxtObservaciones);
        control.CAMPOS_COMBOBOX.put("Tipo", jComboTipo);
        control.CAMPOS_CHECKBOX.put("Personal", jcbPersonal);
       
        
        UtilControlCampos.setearItemsCombo( control.CAMPOS_COMBOBOX.get("Tipo"), new String[]{"Celular", "Fijo", "Oficina", "Negocio", "Fax"});
        
        if(ID == 0){
            jLabelTitulo.setText("Nuevo Telefono");
        } else {
            llenarCamposParaEdicion();
            jLabelTitulo.setText("Editando Telefono N°" + ID);
        }
        
    }
    
    public Telefono mostrarDialogEsperarResultado(){
        monitor.resizearDialog(this, padre, jPanel1);
        this.setVisible(true);
        return telefono;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jbCancelar = new javax.swing.JButton();
        jbAceptar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jtxtNro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtxtObservaciones = new javax.swing.JTextArea();
        jComboTipo = new javax.swing.JComboBox<>();
        jcbPersonal = new javax.swing.JCheckBox();
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
        jbCancelar.setBounds(10, 240, 90, 23);

        jbAceptar.setText("Aceptar");
        jbAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(jbAceptar);
        jbAceptar.setBounds(120, 240, 90, 23);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Nro : ");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(0, 40, 50, 20);
        jPanel1.add(jtxtNro);
        jtxtNro.setBounds(50, 40, 150, 22);

        jLabel5.setText("Observaciones :");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 130, 90, 20);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Tipo : ");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(0, 70, 50, 20);

        jtxtObservaciones.setColumns(20);
        jtxtObservaciones.setRows(5);
        jtxtObservaciones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jtxtObservaciones);
        jtxtObservaciones.setBounds(20, 160, 180, 60);
        jPanel1.add(jComboTipo);
        jComboTipo.setBounds(50, 70, 150, 22);

        jcbPersonal.setText("Telefono Personal");
        jPanel1.add(jcbPersonal);
        jcbPersonal.setBounds(50, 100, 150, 20);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 220, 270);

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

    private void jbAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAceptarActionPerformed
        if(!control.revisarInputValidoCampos((JFrame)padre)){
            return;
        }
        Telefono telefono = new Telefono();
        if(ID == 0){
            telefono.setId(TelefonoSrv.obtenerMaxID()+1);
        } else {
            telefono.setId(ID);
            TelefonoSrv.eliminar(ID); //"Editar" es efectivamente eliminar el registro anterior, 
            //y reemplazarlo por el guardado del nuevo.
        }

        telefono.setNro(control.CAMPOS_INPUT_ESTANDAR.get("Nro").getText());
        telefono.setPersonal(control.CAMPOS_CHECKBOX.get("Personal").isSelected());
        telefono.setTipo(control.CAMPOS_COMBOBOX.get("Tipo").getSelectedItem().toString());
        telefono.setObservaciones(control.CAMPOS_INPUT_TEXTAREA.get("Observaciones").getText());
        TelefonoSrv.guardar(telefono);
        this.telefono = telefono;
       
        this.dispose();
    }//GEN-LAST:event_jbAceptarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        this.telefono = null;
        this.dispose();
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
    }//GEN-LAST:event_jbEliminarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboTipo;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbAceptar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JCheckBox jcbPersonal;
    private javax.swing.JTextField jtxtNro;
    private javax.swing.JTextArea jtxtObservaciones;
    // End of variables declaration//GEN-END:variables
}
