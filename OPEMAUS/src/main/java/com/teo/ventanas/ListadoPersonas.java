/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.teo.ventanas;

import com.teo.modelos.Persona;
import com.teo.service.PersonaSrv;
import com.teo.util.UtilControlCampos;
import com.teo.util.UtilControlTablas;
import com.teo.util.UtilGraficoVentanas;
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
    }

    private final int TABLA_LISTADO_ID = 0;
    private final int TABLA_LISTADO_NOMBREAPELLIDO = 1;
    private final int TABLA_LISTADO_SEXO = 2;
    private void generarTablas(){
        jtListado.setModel(UtilControlTablas.createDefaultTableModelGeneric(new String[]{"ID", "Nombre y Apellido", "Sexo"}));
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
        jbBuscar2 = new javax.swing.JButton();
        jlabelResultados1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jspListado.setViewportView(jtListado);

        jPanel1.add(jspListado);
        jspListado.setBounds(10, 150, 470, 260);

        jlabelResultados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabelResultados.setText("Listado Personas");
        jPanel1.add(jlabelResultados);
        jlabelResultados.setBounds(10, 10, 470, 16);
        jPanel1.add(jtxtApellido);
        jtxtApellido.setBounds(90, 60, 160, 22);
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
        jbBuscar.setBounds(350, 60, 120, 23);

        jbVolver.setText("Volver");
        jPanel1.add(jbVolver);
        jbVolver.setBounds(400, 420, 75, 23);

        jbLimpiar.setText("Limpiar");
        jbLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(jbLimpiar);
        jbLimpiar.setBounds(350, 30, 120, 23);

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

        jbBuscar2.setText("Ver detalle");
        jbBuscar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscar2ActionPerformed(evt);
            }
        });
        jPanel1.add(jbBuscar2);
        jbBuscar2.setBounds(350, 90, 120, 23);

        jlabelResultados1.setText("placeholder");
        jPanel1.add(jlabelResultados1);
        jlabelResultados1.setBounds(10, 130, 470, 16);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 490, 460);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarActionPerformed
        control.vaciarCampos();
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
    private void jbBuscar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbBuscar2ActionPerformed

    private void jbBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscar1ActionPerformed
        buscar();
        llenarListadoPersonas(PersonaSrv.obtenerTodos());
    }//GEN-LAST:event_jbBuscar1ActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        int fila = jtListado.getSelectedRow();
        if(fila == -1){
            return;
        }
        AbmPersona ventana = new AbmPersona(Integer.parseInt(((DefaultTableModel)jtListado.getModel()).getValueAt(fila, TABLA_LISTADO_ID).toString()));
    }//GEN-LAST:event_jbBuscarActionPerformed


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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListadoPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListadoPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListadoPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListadoPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListadoPersonas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbBuscar1;
    private javax.swing.JButton jbBuscar2;
    private javax.swing.JButton jbLimpiar;
    private javax.swing.JButton jbVolver;
    private javax.swing.JLabel jlabelResultados;
    private javax.swing.JLabel jlabelResultados1;
    private javax.swing.JScrollPane jspListado;
    private javax.swing.JTable jtListado;
    private javax.swing.JTextField jtxtApellido;
    private javax.swing.JTextField jtxtNombre;
    // End of variables declaration//GEN-END:variables
}
