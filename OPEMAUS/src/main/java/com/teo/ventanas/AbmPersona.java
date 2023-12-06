package com.teo.ventanas;

import com.teo.modelos.Direccion;
import com.teo.modelos.Persona;
import com.teo.service.DireccionSrv;
import com.teo.util.UtilArchivos;
import com.teo.util.UtilControlTablas;
import com.teo.util.UtilControlVentanas;
import com.teo.util.UtilFechas;
import com.teo.util.UtilGraficoVentanas;
import java.io.File;
import javax.swing.table.DefaultTableModel;

/**
 * @author Teo
 */
public class AbmPersona extends javax.swing.JFrame {
    
    UtilGraficoVentanas monitor; //No puedo instanciarla aca porque requiere un "this", que no puede usarse hasta construir esta clase per se
    UtilControlVentanas control = new UtilControlVentanas();
    
    public AbmPersona() {
        initComponents();
        inicializar();
    }
    
    private void inicializar(){
        monitor = new UtilGraficoVentanas(this, jPanel1, 0, 0);
        monitor.redimensionarReposicionarVentana();
        generarControlVentana();
        generarTablas();
    }
    
    private int TABLA_DIRECCIONES_ID = 0;
    private int TABLA_DIRECCIONES_CALLE = 1;
    private int TABLA_DIRECCIONES_NRO = 2;
    private int TABLA_DIRECCIONES_PISO = 3;
    private void generarTablas(){
        jtDirecciones.setModel(UtilControlTablas.createDefaultTableModelGeneric(new String[]{"ID", "Calle", "Nro", "Piso"}));
    }
    
    private void generarControlVentana(){
        control.CAMPOS_INPUT_ESTANDAR.put(jtxtApellido, "Apellido");
        control.CAMPOS_INPUT_ESTANDAR.put(jtxtNombre, "Nombre");
        control.CAMPOS_INPUT_CHECKBOX.add(jcbFechaNoRecordar);
        control.CAMPOS_INPUT_CHECKBOX.add(jcbFechaDesconocida);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbgGenero = new javax.swing.ButtonGroup();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jtxtNombre = new javax.swing.JTextField();
        jLabelTitulo = new javax.swing.JLabel();
        jtxtApellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtxtFormattedFechaNacimiento = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jrbSexoHombre = new javax.swing.JRadioButton();
        jrbSexoOtro = new javax.swing.JRadioButton();
        jrbSexoMujer = new javax.swing.JRadioButton();
        jbCancelar = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelDireccion = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jspDirecciones = new javax.swing.JScrollPane();
        jtDirecciones = new javax.swing.JTable();
        jbDireccionEliminar = new javax.swing.JButton();
        jbDireccionNueva = new javax.swing.JButton();
        jbDireccionEditar = new javax.swing.JButton();
        jPanelTelefono = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jbTelefonoEliminar = new javax.swing.JButton();
        jbTelefonoNuevo = new javax.swing.JButton();
        jbTelefonoEditar = new javax.swing.JButton();
        jPanelOtros = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jbOtrosEliminar = new javax.swing.JButton();
        jbOtrosNueva = new javax.swing.JButton();
        jbOtrosEditar = new javax.swing.JButton();
        jcbFechaNoRecordar = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jcbFechaDesconocida = new javax.swing.JCheckBox();
        jbLimpiar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Log In");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);
        jPanel1.add(jtxtNombre);
        jtxtNombre.setBounds(80, 50, 190, 22);

        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("placeholder");
        jPanel1.add(jLabelTitulo);
        jLabelTitulo.setBounds(10, 10, 530, 16);
        jPanel1.add(jtxtApellido);
        jtxtApellido.setBounds(80, 80, 190, 22);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Sexo");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(290, 40, 210, 20);

        jtxtFormattedFechaNacimiento.setFormatterFactory(UtilFechas.FORMATTER_FACTORY);
        jtxtFormattedFechaNacimiento.setActionCommand("<Not Set>");
        jPanel1.add(jtxtFormattedFechaNacimiento);
        jtxtFormattedFechaNacimiento.setBounds(130, 120, 90, 22);

        jLabel4.setText("Apellido:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 80, 70, 16);

        jbgGenero.add(jrbSexoHombre);
        jrbSexoHombre.setText("Hombre");
        jPanel1.add(jrbSexoHombre);
        jrbSexoHombre.setBounds(290, 70, 90, 21);

        jbgGenero.add(jrbSexoOtro);
        jrbSexoOtro.setSelected(true);
        jrbSexoOtro.setText("Otro");
        jPanel1.add(jrbSexoOtro);
        jrbSexoOtro.setBounds(460, 70, 70, 21);

        jbgGenero.add(jrbSexoMujer);
        jrbSexoMujer.setText("Mujer");
        jPanel1.add(jrbSexoMujer);
        jrbSexoMujer.setBounds(380, 70, 80, 21);

        jbCancelar.setText("Cancelar");
        jPanel1.add(jbCancelar);
        jbCancelar.setBounds(10, 300, 90, 23);

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(jbGuardar);
        jbGuardar.setBounds(430, 300, 100, 23);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 204));

        jPanelDireccion.setBackground(new java.awt.Color(255, 255, 204));
        jPanelDireccion.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setLayout(null);

        jspDirecciones.setViewportView(jtDirecciones);

        jPanel2.add(jspDirecciones);
        jspDirecciones.setBounds(10, 10, 410, 90);

        jbDireccionEliminar.setText("Eliminar");
        jbDireccionEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDireccionEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(jbDireccionEliminar);
        jbDireccionEliminar.setBounds(430, 80, 80, 23);

        jbDireccionNueva.setText("Nueva");
        jbDireccionNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDireccionNuevaActionPerformed(evt);
            }
        });
        jPanel2.add(jbDireccionNueva);
        jbDireccionNueva.setBounds(430, 10, 80, 23);

        jbDireccionEditar.setText("Editar");
        jbDireccionEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDireccionEditarActionPerformed(evt);
            }
        });
        jPanel2.add(jbDireccionEditar);
        jbDireccionEditar.setBounds(430, 45, 80, 23);

        jPanelDireccion.add(jPanel2);
        jPanel2.setBounds(0, 0, 520, 110);

        jTabbedPane1.addTab("Direcciones", jPanelDireccion);

        jPanelTelefono.setBackground(new java.awt.Color(255, 255, 204));
        jPanelTelefono.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel3.setLayout(null);

        jScrollPane2.setViewportView(jTable2);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(10, 10, 410, 90);

        jbTelefonoEliminar.setText("Eliminar");
        jPanel3.add(jbTelefonoEliminar);
        jbTelefonoEliminar.setBounds(430, 80, 80, 23);

        jbTelefonoNuevo.setText("Nuevo");
        jPanel3.add(jbTelefonoNuevo);
        jbTelefonoNuevo.setBounds(430, 10, 80, 23);

        jbTelefonoEditar.setText("Editar");
        jPanel3.add(jbTelefonoEditar);
        jbTelefonoEditar.setBounds(430, 45, 80, 23);

        jPanelTelefono.add(jPanel3);
        jPanel3.setBounds(0, 0, 520, 110);

        jTabbedPane1.addTab("Telefonos", jPanelTelefono);

        jPanelOtros.setBackground(new java.awt.Color(255, 255, 204));
        jPanelOtros.setLayout(null);

        jPanel4.setBackground(new java.awt.Color(255, 255, 204));
        jPanel4.setLayout(null);

        jScrollPane3.setViewportView(jTable3);

        jPanel4.add(jScrollPane3);
        jScrollPane3.setBounds(10, 10, 410, 90);

        jbOtrosEliminar.setText("Eliminar");
        jPanel4.add(jbOtrosEliminar);
        jbOtrosEliminar.setBounds(430, 80, 80, 23);

        jbOtrosNueva.setText("Nueva");
        jbOtrosNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbOtrosNuevaActionPerformed(evt);
            }
        });
        jPanel4.add(jbOtrosNueva);
        jbOtrosNueva.setBounds(430, 10, 80, 23);

        jbOtrosEditar.setText("Editar");
        jPanel4.add(jbOtrosEditar);
        jbOtrosEditar.setBounds(430, 45, 80, 23);

        jPanelOtros.add(jPanel4);
        jPanel4.setBounds(0, 0, 520, 110);

        jTabbedPane1.addTab("Otros/Observaciones", jPanelOtros);

        jPanel1.add(jTabbedPane1);
        jTabbedPane1.setBounds(10, 150, 520, 140);

        jcbFechaNoRecordar.setText("No recordarme este cumpleaños");
        jcbFechaNoRecordar.setToolTipText("");
        jcbFechaNoRecordar.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jPanel1.add(jcbFechaNoRecordar);
        jcbFechaNoRecordar.setBounds(320, 120, 200, 20);

        jLabel5.setText("Fecha Nacimiento:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 120, 110, 20);

        jcbFechaDesconocida.setText("No lo sé");
        jPanel1.add(jcbFechaDesconocida);
        jcbFechaDesconocida.setBounds(230, 120, 100, 20);

        jbLimpiar.setText("Limpiar");
        jbLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(jbLimpiar);
        jbLimpiar.setBounds(110, 300, 72, 23);

        jLabel6.setText("Nombre:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 50, 70, 16);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 540, 330);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        
        if(!control.revisarInputValidoCampos(this)){
            return;
        }
        
        Persona persona = new Persona();
        persona.setNombre(jtxtNombre.getText());
        persona.setApellido(jtxtApellido.getText());
        persona.setFechaNacimiento(UtilFechas.obtenerFechaHoy());
        String path = UtilArchivos.DIRECTORIO_PERSONAS + File.separator + String.valueOf(persona.getId()) + ".txt";
        UtilArchivos.crearArchivo(path);
        UtilArchivos.escribirArchivo(path, UtilArchivos.convertirPersonaEnGson(persona));
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarActionPerformed
        control.vaciarCampos();
    }//GEN-LAST:event_jbLimpiarActionPerformed

    private void jbOtrosNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbOtrosNuevaActionPerformed
        
    }//GEN-LAST:event_jbOtrosNuevaActionPerformed

    private void jbDireccionNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDireccionNuevaActionPerformed
        ventanaNuevaDireccion();
    }//GEN-LAST:event_jbDireccionNuevaActionPerformed

    private void jbDireccionEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDireccionEditarActionPerformed
        int idDireccion = UtilControlTablas.obtenerValorNumericoDeTabla(jtDirecciones, TABLA_DIRECCIONES_ID);
        if(idDireccion != -1){
            AbmDireccionDialog ventana = new AbmDireccionDialog(this, true, idDireccion);
            Direccion direccion = ventana.mostrarDialogEsperarResultado();
            if(direccion != null){
                //Solo elimino la fila en caso de que la direccion se haya editado en efecto.
                //TODO revisar editar el campo en lugar de resetearlo
                UtilControlTablas.eliminarFilaSeleccionada(jtDirecciones);
                agregarDireccionTabla(direccion);
            }
        }
    }//GEN-LAST:event_jbDireccionEditarActionPerformed
    
    
    
    private void jbDireccionEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDireccionEliminarActionPerformed
        int idDireccion = UtilControlTablas.obtenerValorNumericoDeTabla(jtDirecciones, TABLA_DIRECCIONES_ID); 
        DireccionSrv.eliminar(idDireccion);
        UtilControlTablas.eliminarFilaSeleccionada(jtDirecciones);
    }//GEN-LAST:event_jbDireccionEliminarActionPerformed
    private void ventanaNuevaDireccion(){
        AbmDireccionDialog ventana = new AbmDireccionDialog(this, true, 0);
        Direccion direccion = ventana.mostrarDialogEsperarResultado();
        if(direccion != null){
            agregarDireccionTabla(direccion);
        }
    }
    
    public void agregarDireccionTabla(Direccion direccion){
        DefaultTableModel modelo = (DefaultTableModel) jtDirecciones.getModel();
        Object[] fila = new Object[4];
        fila[TABLA_DIRECCIONES_ID] = direccion.getId();
        fila[TABLA_DIRECCIONES_CALLE] = direccion.getCalle();
        fila[TABLA_DIRECCIONES_NRO] = direccion.getNro();
        fila[TABLA_DIRECCIONES_PISO] = direccion.getPiso();
        modelo.addRow(fila);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AbmPersona().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelDireccion;
    private javax.swing.JPanel jPanelOtros;
    private javax.swing.JPanel jPanelTelefono;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbDireccionEditar;
    private javax.swing.JButton jbDireccionEliminar;
    private javax.swing.JButton jbDireccionNueva;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbLimpiar;
    private javax.swing.JButton jbOtrosEditar;
    private javax.swing.JButton jbOtrosEliminar;
    private javax.swing.JButton jbOtrosNueva;
    private javax.swing.JButton jbTelefonoEditar;
    private javax.swing.JButton jbTelefonoEliminar;
    private javax.swing.JButton jbTelefonoNuevo;
    private javax.swing.ButtonGroup jbgGenero;
    private javax.swing.JCheckBox jcbFechaDesconocida;
    private javax.swing.JCheckBox jcbFechaNoRecordar;
    private javax.swing.JRadioButton jrbSexoHombre;
    private javax.swing.JRadioButton jrbSexoMujer;
    private javax.swing.JRadioButton jrbSexoOtro;
    private javax.swing.JScrollPane jspDirecciones;
    private javax.swing.JTable jtDirecciones;
    private javax.swing.JTextField jtxtApellido;
    private javax.swing.JFormattedTextField jtxtFormattedFechaNacimiento;
    private javax.swing.JTextField jtxtNombre;
    // End of variables declaration//GEN-END:variables
}
