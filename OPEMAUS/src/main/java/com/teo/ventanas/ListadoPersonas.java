/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.teo.ventanas;

import com.teo.modelos.Persona;
import com.teo.service.PersonaSrv;
import com.teo.util.UtilControlCampos;
import com.teo.util.UtilControlTablas;
import com.teo.util.FlujoVentanas;
import com.teo.util.UtilGraficoVentanas;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 * @author Teo
 */
public class ListadoPersonas extends javax.swing.JFrame {

    UtilGraficoVentanas monitor;
    UtilControlCampos control = new UtilControlCampos();
    
    public ListadoPersonas() {
        initComponents();
        inicializar();        
    }
    
    private void inicializar(){
        monitor = new UtilGraficoVentanas(this, jPanel1, 0, 0);
        monitor.redimensionarReposicionarVentana();
        generarControlCampos();
        UtilControlCampos.setearItemsCombo(control.CAMPOS_COMBOBOX.get("Sexo"), new String[]{"Cualquiera", "Hombre", "Mujer", "Otro"});
        generarTablas();
        llenarListadoPersonas(PersonaSrv.obtenerTodos());
        this.setVisible(true);
    }

    private final int TABLA_LISTADO_ID = 0;
    private final int TABLA_LISTADO_NOMBREAPELLIDO = 1;
    private final int TABLA_LISTADO_SEXO = 2;
    private void generarTablas(){
        int fraccion = jtListado.getWidth() / 100;
        jtListado.setModel(UtilControlTablas.createDefaultTableModelGeneric(new String[]{"ID", "Nombre y Apellido", "Sexo"}));
        UtilControlTablas.setTableWidth(jtListado, new int[]{0, fraccion * 100, 0});
    }
    
    private void generarControlCampos(){
        control.CAMPOS_INPUT_ESTANDAR.put("Apellido", jtxtApellido);
        control.CAMPOS_INPUT_ESTANDAR.put("Nombre", jtxtNombre);
        control.CAMPOS_COMBOBOX.put("Sexo", jComboSexo);
    }
    
    private void llenarListadoPersonas(List<Persona> lista){
        for(Persona persona: lista){
            Object[] fila = new Object[3];
            fila[TABLA_LISTADO_ID] = persona.getId();
            fila[TABLA_LISTADO_NOMBREAPELLIDO] = persona.getApellido()+ ", " + persona.getNombre();
            fila[TABLA_LISTADO_SEXO] = PersonaSrv.GENERO_CODIGO.get(persona.getGenero());
            ((DefaultTableModel)jtListado.getModel()).addRow(fila);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jspListado = new javax.swing.JScrollPane();
        jtListado = new javax.swing.JTable();
        jlabelResultados = new javax.swing.JLabel();
        jtxtApellido = new javax.swing.JTextField();
        jtxtNombre = new javax.swing.JTextField();
        jComboSexo = new javax.swing.JComboBox<>();
        jbBuscar = new javax.swing.JButton();
        jbVolver = new javax.swing.JButton();
        jbLimpiar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jbBuscar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Listado");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jspListado.setViewportView(jtListado);

        jPanel1.add(jspListado);
        jspListado.setBounds(10, 150, 470, 260);

        jlabelResultados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabelResultados.setText("Listado Personas");
        jPanel1.add(jlabelResultados);
        jlabelResultados.setBounds(10, 10, 470, 16);

        jtxtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtApellidoKeyReleased(evt);
            }
        });
        jPanel1.add(jtxtApellido);
        jtxtApellido.setBounds(90, 60, 160, 22);

        jtxtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtNombreKeyReleased(evt);
            }
        });
        jPanel1.add(jtxtNombre);
        jtxtNombre.setBounds(90, 30, 160, 22);
        jPanel1.add(jComboSexo);
        jComboSexo.setBounds(90, 90, 160, 22);

        jbBuscar.setText("Editar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(jbBuscar);
        jbBuscar.setBounds(350, 80, 120, 23);

        jbVolver.setText("Volver");
        jbVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVolverActionPerformed(evt);
            }
        });
        jPanel1.add(jbVolver);
        jbVolver.setBounds(10, 420, 75, 23);

        jbLimpiar.setText("Limpiar");
        jbLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(jbLimpiar);
        jbLimpiar.setBounds(350, 50, 120, 23);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("Sexo : ");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 90, 80, 16);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Nombre : ");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 30, 80, 16);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Apellido  : ");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 60, 80, 16);

        jbBuscar1.setText("Buscar");
        jbBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscar1ActionPerformed(evt);
            }
        });
        jPanel1.add(jbBuscar1);
        jbBuscar1.setBounds(260, 50, 75, 50);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 490, 460);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarActionPerformed
        control.vaciarCampos();
        UtilControlTablas.limpiarTabla(jtListado);
        llenarListadoPersonas(PersonaSrv.obtenerTodos());
    }//GEN-LAST:event_jbLimpiarActionPerformed

    private void buscar(){
        UtilControlTablas.limpiarTabla(jtListado);
        boolean cumpleTodo = true;
        List<Persona> todos = PersonaSrv.obtenerTodos();
        List<Persona> filtrados = new ArrayList<>();
        String nombre = jtxtNombre.getText().trim().toLowerCase();
        String apellido = jtxtApellido.getText().trim().toLowerCase();

        for(Persona persona : todos){
            cumpleTodo = true;
            if(!persona.getNombre().trim().toLowerCase().contains(nombre)){
                cumpleTodo = false;
            }
            if(!persona.getApellido().trim().toLowerCase().contains(apellido)){
                cumpleTodo = false;
            }
            if(!jComboSexo.getSelectedItem().equals("Cualquiera")){
               if(persona.getGenero() != PersonaSrv.GENERO_CODIGO.get(jComboSexo.getSelectedItem().toString())){
                   cumpleTodo = false;
               }
            }
            
            if(cumpleTodo){
                filtrados.add(persona);
            }
        }
        llenarListadoPersonas(filtrados);
 
    }
    private void jbBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscar1ActionPerformed
        buscar();
    }//GEN-LAST:event_jbBuscar1ActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        int fila = jtListado.getSelectedRow();
        if(fila == -1){
            return;
        }
        FlujoVentanas.setearFrameParaVolver(FlujoVentanas.FRAME_LISTADOPERSONAS);
        FlujoVentanas.abrirAbmPersonas(this, Integer.parseInt(((DefaultTableModel)jtListado.getModel()).getValueAt(fila, TABLA_LISTADO_ID).toString()));
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVolverActionPerformed
        cerrar();
    }//GEN-LAST:event_jbVolverActionPerformed

    private boolean banderaCerrar = false;
    private void cerrar(){
        if(!banderaCerrar){
            banderaCerrar = true;
            FlujoVentanas.volver(this);
        }
    } 
    
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void jtxtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtNombreKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            buscar();
        }
    }//GEN-LAST:event_jtxtNombreKeyReleased

    private void jtxtApellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtApellidoKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            buscar();
        }
    }//GEN-LAST:event_jtxtApellidoKeyReleased


    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbBuscar1;
    private javax.swing.JButton jbLimpiar;
    private javax.swing.JButton jbVolver;
    private javax.swing.JLabel jlabelResultados;
    private javax.swing.JScrollPane jspListado;
    private javax.swing.JTable jtListado;
    private javax.swing.JTextField jtxtApellido;
    private javax.swing.JTextField jtxtNombre;
    // End of variables declaration//GEN-END:variables
}
