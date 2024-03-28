/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.teo.ventanas;

import com.teo.modelos.Actividad;
import com.teo.modelos.Comida;
import com.teo.service.ActividadSrv;
import com.teo.service.ComidaSrv;
import com.teo.service.UnidadSrv;
import com.teo.util.UtilGraficoVentanas;
import java.util.HashMap;
import javax.swing.JFrame;

/**
 * @author Teo
 */
public class AbmModalGenerico extends javax.swing.JDialog {

    
    enum GUARDAR{
        ACTIVIDAD,
        COMIDA
    }
    private GUARDAR guardar;
    /**
     * Creates new form AbmModalActividad
     */
    public AbmModalGenerico(java.awt.Frame parent, boolean modal, GUARDAR guardar) {
        super(parent, modal);
        initComponents();
        this.guardar = guardar;
        UtilGraficoVentanas.resizearDialog(this, parent, jPanel1);
        llenarUnidad();
        if(guardar == GUARDAR.ACTIVIDAD){
            jtxtID.setText(""+ActividadSrv.obtenerMaxID()+1);
        }
        if(guardar == GUARDAR.COMIDA){
            jtxtID.setText(""+ComidaSrv.obtenerMaxID()+1);
        }
        
    }
    
    private int idUnidades[];
    private void llenarUnidad(){
        HashMap<Integer, String> mapa = UnidadSrv.getUNIDADES();
        idUnidades = new int[mapa.size()];
        
        mapa.forEach((key, value) -> {
            int i = 0;
            idUnidades[i] = key;
            i++;
            jcomboUnidad.addItem(value);
        });
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jtxtDescripcion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jtxtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jcomboUnidad = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jButton1.setText("Ok");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(140, 140, 72, 23);
        jPanel1.add(jtxtDescripcion);
        jtxtDescripcion.setBounds(10, 90, 200, 22);

        jLabel1.setText("Descripcion");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 70, 200, 16);
        jPanel1.add(jtxtID);
        jtxtID.setBounds(10, 40, 30, 22);

        jLabel2.setText("ID");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 20, 30, 16);
        jPanel1.add(jcomboUnidad);
        jcomboUnidad.setBounds(82, 40, 130, 22);

        jLabel3.setText("Unidad");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(80, 20, 120, 16);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 220, 170);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(guardar == GUARDAR.ACTIVIDAD){
            Actividad entidad = new Actividad();
            entidad.setId(Integer.parseInt(jtxtID.getText().trim()));
            entidad.setDescripcion(jtxtDescripcion.getText().trim());
            entidad.setIdUnidad(idUnidades[jcomboUnidad.getSelectedIndex()]);
            ActividadSrv.guardarOActualizar(entidad);
            
            }
        if(guardar == GUARDAR.COMIDA){
            Comida entidad = new Comida();
            entidad.setId(Integer.parseInt(jtxtID.getText().trim()));
            entidad.setDescripcion(jtxtDescripcion.getText().trim());
            entidad.setIdUnidad(idUnidades[jcomboUnidad.getSelectedIndex()]);
            ComidaSrv.guardarOActualizar(entidad);
            }
            
        
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(JFrame padre, GUARDAR guardar) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AbmModalGenerico dialog = new AbmModalGenerico(padre, true, guardar);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> jcomboUnidad;
    private javax.swing.JTextField jtxtDescripcion;
    private javax.swing.JTextField jtxtID;
    // End of variables declaration//GEN-END:variables
}