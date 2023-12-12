package com.teo.ventanas;

import com.teo.modelos.Correo;
import com.teo.modelos.Direccion;
import com.teo.modelos.Persona;
import com.teo.modelos.Telefono;
import com.teo.service.CorreoSrv;
import com.teo.service.DireccionSrv;
import com.teo.service.PersonaSrv;
import com.teo.service.TelefonoSrv;
import com.teo.util.UtilControlTablas;
import com.teo.util.UtilControlCampos;
import com.teo.util.FlujoVentanas;
import com.teo.util.UtilFechas;
import com.teo.util.UtilGraficoVentanas;
import java.awt.Color;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 * @author Teo
 */
public class AbmPersona extends javax.swing.JFrame {
    
    UtilGraficoVentanas monitor; //No puedo instanciarla aca porque requiere un "this", que no puede usarse hasta construir esta clase per se
    UtilControlCampos control = new UtilControlCampos();
    private int ID = 0;
    
    public AbmPersona(int id) {
        initComponents();
        ID = id;
        inicializar();
    }
    
    private void inicializar(){
        monitor = new UtilGraficoVentanas(this, jPanel1, 0, 0);
        monitor.redimensionarReposicionarVentana();
        generarControlVentana();
        generarTablas();
        jLabelTitulo.setText("Nueva Persona");
        llenarCamposEdicion();
        this.setVisible(true);
    }
    
    private void llenarCamposEdicion(){
        if(ID == 0){
            return;
        }
        Persona persona = PersonaSrv.obtenerById(ID);
        jtxtApellido.setText(persona.getApellido());
        jtxtNombre.setText(persona.getNombre());
        jcbFechaNoRecordar.setSelected(persona.isNoRecordarCumpleanios());
        jcbFechaDesconocida.setSelected(persona.isNoSeCumpleanios());
        
        int genero = persona.getGenero();
        if(genero == PersonaSrv.GENERO_HOMBRE){
            jrbSexoHombre.setSelected(true);
        } else if(genero == PersonaSrv.GENERO_MUJER){
            jrbSexoMujer.setSelected(true);
        } else if(genero == PersonaSrv.GENERO_OTRO){
            jrbSexoOtro.setSelected(true);
        } 
        
       jtxtFormattedFechaNacimiento.setText(persona.getFechaNacimiento().toString());
        
        for(String id : persona.getIdsCorreos()){
            Object[] fila = new Object[3];
            Correo correo = CorreoSrv.obtenerById(Integer.parseInt(id));
            fila[TABLA_CORREO_ID] = correo.getId();
            fila[TABLA_CORREO_CORREO] = correo.getCorreo();
            fila[TABLA_CORREO_OBS] = correo.getObservaciones();
            ((DefaultTableModel)jtCorreos.getModel()).addRow(fila);
        }
        for(String id : persona.getIdsDirecciones()){
            Direccion direccion = DireccionSrv.obtenerById(Integer.parseInt(id));
            Object[] fila = new Object[5];
            fila[TABLA_DIRECCIONES_ID] = direccion.getId();
            fila[TABLA_DIRECCIONES_CALLE] = direccion.getCalle();
            fila[TABLA_DIRECCIONES_NRO] = direccion.getNro();
            fila[TABLA_DIRECCIONES_PISO] = direccion.getPiso();
            fila[TABLA_DIRECCIONES_OBS] = direccion.getObservaciones();
            ((DefaultTableModel)jtDirecciones.getModel()).addRow(fila);
        }
        for(String id : persona.getIdsTelefonos()){
            Telefono telefono = TelefonoSrv.obtenerById(Integer.parseInt(id));
            Object[] fila = new Object[4];
            fila[TABLA_TELEFONO_ID] = telefono.getId();
            fila[TABLA_TELEFONO_NRO] = telefono.getNro();
            fila[TABLA_TELEFONO_TIPO] = telefono.getTipo();
            fila[TABLA_TELEFONO_OBS] = telefono.getObservaciones();
            ((DefaultTableModel)jtTelefonos.getModel()).addRow(fila);
        }
        for(String nota : persona.getNotas()){
            Object[] fila = new Object[1];
            fila[TABLA_OTROS_CUERPO] = nota;
            ((DefaultTableModel)jtOtros.getModel()).addRow(fila);
        }
        
        jLabelTitulo.setText("Editando Persona Nro: " + ID);
    }
    
    private final int TABLA_DIRECCIONES_ID = 0;
    private final int TABLA_DIRECCIONES_CALLE = 1;
    private final int TABLA_DIRECCIONES_NRO = 2;
    private final int TABLA_DIRECCIONES_PISO = 3;
    private final int TABLA_DIRECCIONES_OBS = 4;
    private final int TABLA_TELEFONO_ID = 0;
    private final int TABLA_TELEFONO_NRO = 1;
    private final int TABLA_TELEFONO_TIPO = 2;
    private final int TABLA_TELEFONO_OBS = 3;
    private final int TABLA_CORREO_ID = 0;
    private final int TABLA_CORREO_CORREO = 1;
    private final int TABLA_CORREO_OBS = 2;
    private final int TABLA_OTROS_CUERPO = 0;
    private void generarTablas(){
        jtDirecciones.setModel(UtilControlTablas.createDefaultTableModelGeneric(new String[]{"ID", "Calle", "Nro", "Piso", "Obs."}));
        jtTelefonos.setModel(UtilControlTablas.createDefaultTableModelGeneric(new String[]{"ID", "Nro", "Tipo", "Obs."}));
        jtCorreos.setModel(UtilControlTablas.createDefaultTableModelGeneric(new String[]{"ID", "Correo", "Obs."}));
        jtOtros.setModel(UtilControlTablas.createDefaultTableModelGeneric(new String[]{"Notas"}));
    
        int fraccion = jtDirecciones.getWidth() / 100;
        UtilControlTablas.setTableWidth(jtDirecciones, new int[]{0, fraccion * 30, fraccion * 15, fraccion * 15, fraccion * 40});
    
        fraccion = jtTelefonos.getWidth() / 100;
        UtilControlTablas.setTableWidth(jtTelefonos, new int[]{0, fraccion * 50, fraccion * 20, fraccion * 30});
        
        fraccion = jtCorreos.getWidth() / 100;
        UtilControlTablas.setTableWidth(jtCorreos, new int[]{0, fraccion * 40, fraccion * 60});
        
    }
    
    private void generarControlVentana(){
        control.CAMPOS_INPUT_ESTANDAR.put("Apellido", jtxtApellido);
        control.CAMPOS_INPUT_ESTANDAR.put("Nombre", jtxtNombre);
        
        control.CAMPOS_CHECKBOX.put("RecordarCumpleanios", jcbFechaNoRecordar);
        control.CAMPOS_CHECKBOX.put("NoSeCumpleanios", jcbFechaDesconocida);
        
        control.CAMPOS_INPUT_FORMATTED.put("Fecha Nacimiento", jtxtFormattedFechaNacimiento);
        
        control.CAMPOS_TABLAS.put("Direcciones", jtDirecciones);
        control.CAMPOS_TABLAS.put("Correos", jtCorreos);
        control.CAMPOS_TABLAS.put("Otros", jtOtros);
        control.CAMPOS_TABLAS.put("Telefonos", jtTelefonos);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbgGenero = new javax.swing.ButtonGroup();
        jPasswordField1 = new javax.swing.JPasswordField();
        jDesktopPane1 = new javax.swing.JDesktopPane();
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
        jspTelefonos = new javax.swing.JScrollPane();
        jtTelefonos = new javax.swing.JTable();
        jbTelefonoEliminar = new javax.swing.JButton();
        jbTelefonoNuevo = new javax.swing.JButton();
        jbTelefonoEditar = new javax.swing.JButton();
        jPanelCorreo = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jspCorreos = new javax.swing.JScrollPane();
        jtCorreos = new javax.swing.JTable();
        jbCorreoEliminar = new javax.swing.JButton();
        jbCorreoNuevo = new javax.swing.JButton();
        jbCorreoEditar = new javax.swing.JButton();
        jPanelOtros = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jspOtros = new javax.swing.JScrollPane();
        jtOtros = new javax.swing.JTable();
        jbOtrosEliminar = new javax.swing.JButton();
        jbOtrosNueva = new javax.swing.JButton();
        jbOtrosEditar = new javax.swing.JButton();
        jcbFechaNoRecordar = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jcbFechaDesconocida = new javax.swing.JCheckBox();
        jbLimpiar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Agregar / Modificar Persona");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
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
        jtxtFormattedFechaNacimiento.setText("dia/mes/año");
        jtxtFormattedFechaNacimiento.setActionCommand("<Not Set>");
        jtxtFormattedFechaNacimiento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtFormattedFechaNacimientoFocusGained(evt);
            }
        });
        jPanel1.add(jtxtFormattedFechaNacimiento);
        jtxtFormattedFechaNacimiento.setBounds(120, 120, 90, 22);

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
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(jbCancelar);
        jbCancelar.setBounds(10, 300, 110, 23);

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(jbGuardar);
        jbGuardar.setBounds(410, 300, 120, 23);

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

        jspTelefonos.setViewportView(jtTelefonos);

        jPanel3.add(jspTelefonos);
        jspTelefonos.setBounds(10, 10, 410, 90);

        jbTelefonoEliminar.setText("Eliminar");
        jbTelefonoEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbTelefonoEliminarActionPerformed(evt);
            }
        });
        jPanel3.add(jbTelefonoEliminar);
        jbTelefonoEliminar.setBounds(430, 80, 80, 23);

        jbTelefonoNuevo.setText("Nuevo");
        jbTelefonoNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbTelefonoNuevoActionPerformed(evt);
            }
        });
        jPanel3.add(jbTelefonoNuevo);
        jbTelefonoNuevo.setBounds(430, 10, 80, 23);

        jbTelefonoEditar.setText("Editar");
        jbTelefonoEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbTelefonoEditarActionPerformed(evt);
            }
        });
        jPanel3.add(jbTelefonoEditar);
        jbTelefonoEditar.setBounds(430, 45, 80, 23);

        jPanelTelefono.add(jPanel3);
        jPanel3.setBounds(0, 0, 520, 110);

        jTabbedPane1.addTab("Telefonos", jPanelTelefono);

        jPanelCorreo.setBackground(new java.awt.Color(255, 255, 204));
        jPanelCorreo.setLayout(null);

        jPanel5.setBackground(new java.awt.Color(255, 255, 204));
        jPanel5.setLayout(null);

        jspCorreos.setViewportView(jtCorreos);

        jPanel5.add(jspCorreos);
        jspCorreos.setBounds(10, 10, 410, 90);

        jbCorreoEliminar.setText("Eliminar");
        jbCorreoEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCorreoEliminarActionPerformed(evt);
            }
        });
        jPanel5.add(jbCorreoEliminar);
        jbCorreoEliminar.setBounds(430, 80, 80, 23);

        jbCorreoNuevo.setText("Nuevo");
        jbCorreoNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCorreoNuevoActionPerformed(evt);
            }
        });
        jPanel5.add(jbCorreoNuevo);
        jbCorreoNuevo.setBounds(430, 10, 80, 23);

        jbCorreoEditar.setText("Editar");
        jbCorreoEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCorreoEditarActionPerformed(evt);
            }
        });
        jPanel5.add(jbCorreoEditar);
        jbCorreoEditar.setBounds(430, 45, 80, 23);

        jPanelCorreo.add(jPanel5);
        jPanel5.setBounds(0, 0, 520, 110);

        jTabbedPane1.addTab("Correos", jPanelCorreo);

        jPanelOtros.setBackground(new java.awt.Color(255, 255, 204));
        jPanelOtros.setLayout(null);

        jPanel4.setBackground(new java.awt.Color(255, 255, 204));
        jPanel4.setLayout(null);

        jspOtros.setViewportView(jtOtros);

        jPanel4.add(jspOtros);
        jspOtros.setBounds(10, 10, 410, 90);

        jbOtrosEliminar.setText("Eliminar");
        jbOtrosEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbOtrosEliminarActionPerformed(evt);
            }
        });
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
        jbOtrosEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbOtrosEditarActionPerformed(evt);
            }
        });
        jPanel4.add(jbOtrosEditar);
        jbOtrosEditar.setBounds(430, 45, 80, 23);

        jPanelOtros.add(jPanel4);
        jPanel4.setBounds(0, 0, 520, 110);

        jTabbedPane1.addTab("Otros/Observaciones", jPanelOtros);

        jPanel1.add(jTabbedPane1);
        jTabbedPane1.setBounds(10, 150, 520, 140);

        jcbFechaNoRecordar.setText("No recordarme este cumpleaños");
        jcbFechaNoRecordar.setToolTipText("");
        jPanel1.add(jcbFechaNoRecordar);
        jcbFechaNoRecordar.setBounds(310, 120, 220, 20);

        jLabel5.setText("Fecha Nacimiento :");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 120, 110, 20);

        jcbFechaDesconocida.setText("No lo sé");
        jPanel1.add(jcbFechaDesconocida);
        jcbFechaDesconocida.setBounds(220, 120, 90, 20);

        jbLimpiar.setText("Limpiar");
        jbLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(jbLimpiar);
        jbLimpiar.setBounds(130, 300, 110, 23);

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
        
        if(ID == 0){
            persona.setId(PersonaSrv.obtenerMaxID()+1);
        } else {
            persona.setId(ID);
            PersonaSrv.eliminar(ID); //"Editar" es efectivamente eliminar el registro anterior, 
            //y reemplazarlo por el guardado del nuevo.
        }
        
        persona.setFechaNacimiento(LocalDate.parse(jtxtFormattedFechaNacimiento.getText().trim(), UtilFechas.FORMATO_DATETIME));
        
        persona.setNombre(jtxtNombre.getText());
        persona.setApellido(jtxtApellido.getText());
        
        
        persona.setNoSeCumpleanios(jcbFechaDesconocida.isSelected());
        persona.setNoRecordarCumpleanios(jcbFechaNoRecordar.isSelected());
        
        if(jrbSexoHombre.isSelected()){
            persona.setGenero(PersonaSrv.GENERO_HOMBRE);
        } else 
        if(jrbSexoMujer.isSelected()){
            persona.setGenero(PersonaSrv.GENERO_MUJER);
        } else
        if(jrbSexoOtro.isSelected()){
            persona.setGenero(PersonaSrv.GENERO_OTRO);
        } 
        
        List<String> leidoTablas = new ArrayList<>();
        for(int fila = 0; fila < jtDirecciones.getRowCount(); fila++){
            leidoTablas.add(((DefaultTableModel)jtDirecciones.getModel()).getValueAt(fila, TABLA_DIRECCIONES_ID).toString());
        }
        persona.setIdsDirecciones(leidoTablas);
        
        leidoTablas = new ArrayList<>();
        for(int fila = 0; fila < jtTelefonos.getRowCount(); fila++){
            leidoTablas.add(((DefaultTableModel)jtTelefonos.getModel()).getValueAt(fila, TABLA_TELEFONO_ID).toString());
        }
        persona.setIdsTelefonos(leidoTablas);
        
        leidoTablas = new ArrayList<>();
        for(int fila = 0; fila < jtCorreos.getRowCount(); fila++){
            leidoTablas.add(((DefaultTableModel)jtCorreos.getModel()).getValueAt(fila, TABLA_CORREO_ID).toString());
        }
        persona.setIdsCorreos(leidoTablas);
        
        leidoTablas = new ArrayList<>();
        for(int fila = 0; fila < jtOtros.getRowCount(); fila++){
            leidoTablas.add(((DefaultTableModel)jtOtros.getModel()).getValueAt(fila, TABLA_OTROS_CUERPO).toString());
        }
        persona.setNotas(leidoTablas);
        
        PersonaSrv.guardar(persona);
        JDialogAvisoGenerico ventana = new JDialogAvisoGenerico(this, true, "Guardado con exito!", Color.GREEN);
        this.dispose();
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarActionPerformed
        control.vaciarCampos();
    }//GEN-LAST:event_jbLimpiarActionPerformed

    private void jbOtrosNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbOtrosNuevaActionPerformed
        TextoDialog ventana = new TextoDialog(this, true, "Ingrese una Nota", "");
        String resultado = ventana.mostrarDialogEsperarResultado();
        if(resultado != null){
            Object[] fila = new Object[1];
            fila[TABLA_OTROS_CUERPO] = resultado;
            ((DefaultTableModel)jtOtros.getModel()).addRow(fila);
        }
    }//GEN-LAST:event_jbOtrosNuevaActionPerformed

    private void jbDireccionNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDireccionNuevaActionPerformed
        ventanaNuevaDireccion();
    }//GEN-LAST:event_jbDireccionNuevaActionPerformed

    private void jbDireccionEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDireccionEditarActionPerformed
        ventanaEdicionDireccion();
    }//GEN-LAST:event_jbDireccionEditarActionPerformed
    
    private void jbDireccionEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDireccionEliminarActionPerformed
         UtilControlTablas.eliminarFilaSeleccionada(jtDirecciones);
    }//GEN-LAST:event_jbDireccionEliminarActionPerformed

    private void jbTelefonoNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbTelefonoNuevoActionPerformed
        ventanaNuevoTelefono();
    }//GEN-LAST:event_jbTelefonoNuevoActionPerformed

    private void jbTelefonoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbTelefonoEditarActionPerformed
        ventanaEdicionTelefono();
    }//GEN-LAST:event_jbTelefonoEditarActionPerformed

    private void jbCorreoNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCorreoNuevoActionPerformed
        ventanaNuevoCorreo();
    }//GEN-LAST:event_jbCorreoNuevoActionPerformed

    private void jbCorreoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCorreoEditarActionPerformed
        ventanaEdicionCorreo();
    }//GEN-LAST:event_jbCorreoEditarActionPerformed

    private void jbOtrosEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbOtrosEditarActionPerformed
        int fila = jtOtros.getSelectedRow();
        if(fila == -1){
            return;
        }
        TextoDialog ventana = new TextoDialog(this, true, "Ingrese una Nota", ((DefaultTableModel)jtOtros.getModel()).getValueAt(fila, TABLA_OTROS_CUERPO).toString());
        String resultado = ventana.mostrarDialogEsperarResultado();
        if(resultado != null){
            ((DefaultTableModel)jtOtros.getModel()).setValueAt(resultado, fila, TABLA_OTROS_CUERPO);
        }
    }//GEN-LAST:event_jbOtrosEditarActionPerformed

    private void jbOtrosEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbOtrosEliminarActionPerformed
        UtilControlTablas.eliminarFilaSeleccionada(jtOtros);
    }//GEN-LAST:event_jbOtrosEliminarActionPerformed

    private void jbCorreoEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCorreoEliminarActionPerformed
        UtilControlTablas.eliminarFilaSeleccionada(jtCorreos);
    }//GEN-LAST:event_jbCorreoEliminarActionPerformed

    private void jbTelefonoEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbTelefonoEliminarActionPerformed
        UtilControlTablas.eliminarFilaSeleccionada(jtTelefonos);
    }//GEN-LAST:event_jbTelefonoEliminarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        cerrar();
    }//GEN-LAST:event_jbCancelarActionPerformed

    private boolean banderaCerrar = false;
    private void cerrar(){
        if(!banderaCerrar){
            banderaCerrar = true;
            FlujoVentanas.volver(this);
        }
    } 
    
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        cerrar();
    }//GEN-LAST:event_formWindowClosed

     private String MENSAJE_FECHA = "dia/mes/año";
    
    private void jtxtFormattedFechaNacimientoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtFormattedFechaNacimientoFocusGained
        if(jtxtFormattedFechaNacimiento.getText().trim().equals(MENSAJE_FECHA)){
            jtxtFormattedFechaNacimiento.setValue(null);
        }
    }//GEN-LAST:event_jtxtFormattedFechaNacimientoFocusGained

    private void ventanaNuevaDireccion(){
        AbmDireccionDialog ventana = new AbmDireccionDialog(this, true, 0);
        Direccion direccion = ventana.mostrarDialogEsperarResultado();
        if(direccion != null){
            agregarDireccionTabla(direccion);
        }
    }
    private void ventanaEdicionDireccion(){
        int idDireccion = UtilControlTablas.obtenerValorNumericoDeTabla(jtDirecciones, TABLA_DIRECCIONES_ID);
        if(idDireccion != -1){
            AbmDireccionDialog ventana = new AbmDireccionDialog(this, true, idDireccion);
            Direccion direccion = ventana.mostrarDialogEsperarResultado();
            if(direccion != null){
                //Solo elimino la fila en caso de que la direccion se haya editado en efecto.
                agregarDireccionTabla(direccion, jtDirecciones.getSelectedRow());
            }
        }
    }
    
    private void ventanaNuevoTelefono(){
        AbmTelefonoDialog ventana = new AbmTelefonoDialog(this, true, 0);
        Telefono telefono = ventana.mostrarDialogEsperarResultado();
        if(telefono != null){
            agregarTelefonoTabla(telefono);
        }
    }
    private void ventanaEdicionTelefono(){
        int idTelefono = UtilControlTablas.obtenerValorNumericoDeTabla(jtTelefonos, TABLA_TELEFONO_ID);
        if(idTelefono != -1){
            AbmTelefonoDialog ventana = new AbmTelefonoDialog(this, true, idTelefono);
            Telefono telefono = ventana.mostrarDialogEsperarResultado();
            if(telefono != null){
                //Solo elimino la fila en caso de que se haya editado en efecto
                agregarTelefonoTabla(telefono, jtTelefonos.getSelectedRow());
            }
        }
    }
    
    private void ventanaNuevoCorreo(){
        AbmCorreoDialog ventana = new AbmCorreoDialog(this, true, 0);
        Correo correo = ventana.mostrarDialogEsperarResultado();
        if(correo != null){
            agregarCorreoTabla(correo);
        }
    }
    private void ventanaEdicionCorreo(){
        int idCorreo = UtilControlTablas.obtenerValorNumericoDeTabla(jtCorreos, TABLA_CORREO_ID);
        if(idCorreo != -1){
            AbmCorreoDialog ventana = new AbmCorreoDialog(this, true, idCorreo);
            Correo correo = ventana.mostrarDialogEsperarResultado();
            if(correo != null){
                //Solo elimino la fila en caso de que se haya editado en efecto
                agregarCorreoTabla(correo, jtCorreos.getSelectedRow());
            }
        }
    }
    
    public void agregarCorreoTabla(Correo correo){
        agregarCorreoTabla(correo, -1);
    }
    public void agregarCorreoTabla(Correo correo, int filaPisar){
        DefaultTableModel modelo = (DefaultTableModel) jtCorreos.getModel();
        Object[] filaAgregar = new Object[5];
        filaAgregar[TABLA_CORREO_ID] = correo.getId();
        filaAgregar[TABLA_CORREO_CORREO] = correo.getCorreo();
        filaAgregar[TABLA_CORREO_OBS] = correo.getObservaciones();
        if(filaPisar == -1){
            modelo.addRow(filaAgregar);
        } else {
            modelo.setValueAt(filaAgregar[TABLA_CORREO_CORREO], filaPisar, TABLA_CORREO_CORREO);
            modelo.setValueAt(filaAgregar[TABLA_CORREO_OBS], filaPisar, TABLA_CORREO_OBS);
        }
    }
    
    public void agregarDireccionTabla(Direccion direccion){
        agregarDireccionTabla(direccion, -1);
    }
    public void agregarDireccionTabla(Direccion direccion, int filaPisar){
        DefaultTableModel modelo = (DefaultTableModel) jtDirecciones.getModel();
        Object[] filaAgregar = new Object[5];
        filaAgregar[TABLA_DIRECCIONES_ID] = direccion.getId();
        filaAgregar[TABLA_DIRECCIONES_CALLE] = direccion.getCalle();
        filaAgregar[TABLA_DIRECCIONES_NRO] = direccion.getNro();
        filaAgregar[TABLA_DIRECCIONES_PISO] = direccion.getPiso();
        filaAgregar[TABLA_DIRECCIONES_OBS] = direccion.getObservaciones();
        if(filaPisar == -1){
            modelo.addRow(filaAgregar);
        } else {
            modelo.setValueAt(filaAgregar[TABLA_DIRECCIONES_CALLE], filaPisar, TABLA_DIRECCIONES_CALLE);
            modelo.setValueAt(filaAgregar[TABLA_DIRECCIONES_NRO], filaPisar, TABLA_DIRECCIONES_NRO);
            modelo.setValueAt(filaAgregar[TABLA_DIRECCIONES_OBS], filaPisar, TABLA_DIRECCIONES_OBS);
            modelo.setValueAt(filaAgregar[TABLA_DIRECCIONES_PISO], filaPisar, TABLA_DIRECCIONES_PISO);
        }
    }
    
    public void agregarTelefonoTabla(Telefono telefono){
        agregarTelefonoTabla(telefono, -1);
    }
    public void agregarTelefonoTabla(Telefono telefono, int filaPisar){
        DefaultTableModel modelo = (DefaultTableModel) jtTelefonos.getModel();
        Object[] filaAgregar = new Object[4];
        filaAgregar[TABLA_TELEFONO_ID] = telefono.getId();
        filaAgregar[TABLA_TELEFONO_NRO] = telefono.getNro();
        filaAgregar[TABLA_TELEFONO_TIPO] = telefono.getTipo();
        filaAgregar[TABLA_TELEFONO_OBS] = telefono.getObservaciones();
        if(filaPisar == -1){
            modelo.addRow(filaAgregar);
        } else {
            modelo.setValueAt(filaAgregar[TABLA_TELEFONO_NRO], filaPisar, TABLA_TELEFONO_NRO);
            modelo.setValueAt(filaAgregar[TABLA_TELEFONO_TIPO], filaPisar, TABLA_TELEFONO_TIPO);
            modelo.setValueAt(filaAgregar[TABLA_TELEFONO_OBS], filaPisar, TABLA_TELEFONO_OBS);
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelCorreo;
    private javax.swing.JPanel jPanelDireccion;
    private javax.swing.JPanel jPanelOtros;
    private javax.swing.JPanel jPanelTelefono;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbCorreoEditar;
    private javax.swing.JButton jbCorreoEliminar;
    private javax.swing.JButton jbCorreoNuevo;
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
    private javax.swing.JScrollPane jspCorreos;
    private javax.swing.JScrollPane jspDirecciones;
    private javax.swing.JScrollPane jspOtros;
    private javax.swing.JScrollPane jspTelefonos;
    private javax.swing.JTable jtCorreos;
    private javax.swing.JTable jtDirecciones;
    private javax.swing.JTable jtOtros;
    private javax.swing.JTable jtTelefonos;
    private javax.swing.JTextField jtxtApellido;
    private javax.swing.JFormattedTextField jtxtFormattedFechaNacimiento;
    private javax.swing.JTextField jtxtNombre;
    // End of variables declaration//GEN-END:variables
}
