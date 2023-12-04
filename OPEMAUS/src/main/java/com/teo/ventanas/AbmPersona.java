package com.teo.ventanas;

import com.teo.modelos.Persona;
import com.teo.util.UtilArchivos;
import com.teo.util.UtilControlVentanas;
import com.teo.util.UtilFechas;
import com.teo.util.UtilGraficoVentanas;
import java.io.File;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 * @author Teo
 */
public class AbmPersona extends javax.swing.JFrame {
    
    UtilGraficoVentanas monitor; //No puedo instanciarla aca porque requiere un "this", que no puede usarse hasta construir esta clase per se
    UtilControlVentanas control = new UtilControlVentanas();
    public AbmPersona() {
        initComponents();
        inicializar();
        generarControlVentana();
    }
    
    private void inicializar(){
        monitor = new UtilGraficoVentanas(this, jPanel1, 0, 0);
        monitor.redimensionarReposicionarVentana();
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtxtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtxtApellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtxtFormattedFechaNacimiento = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jrbSexoHombre = new javax.swing.JRadioButton();
        jrbSexoOtro = new javax.swing.JRadioButton();
        jrbSexoMujer = new javax.swing.JRadioButton();
        jbCancelar = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jcbFechaNoRecordar = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jcbFechaDesconocida = new javax.swing.JCheckBox();
        jbLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Log In");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Bernard MT Condensed", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nueva Persona");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 10, 370, 15);
        jPanel1.add(jtxtNombre);
        jtxtNombre.setBounds(130, 50, 230, 22);

        jLabel2.setText("Nombre:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 50, 110, 16);
        jPanel1.add(jtxtApellido);
        jtxtApellido.setBounds(130, 80, 230, 22);

        jLabel3.setText("Sexo:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 110, 100, 16);

        jtxtFormattedFechaNacimiento.setFormatterFactory(UtilFechas.FORMATTER_FACTORY);
        jtxtFormattedFechaNacimiento.setActionCommand("<Not Set>");
        jPanel1.add(jtxtFormattedFechaNacimiento);
        jtxtFormattedFechaNacimiento.setBounds(130, 140, 90, 22);

        jLabel4.setText("Apellido:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 80, 110, 16);

        jbgGenero.add(jrbSexoHombre);
        jrbSexoHombre.setText("Hombre");
        jPanel1.add(jrbSexoHombre);
        jrbSexoHombre.setBounds(130, 110, 90, 21);

        jbgGenero.add(jrbSexoOtro);
        jrbSexoOtro.setText("Otro");
        jPanel1.add(jrbSexoOtro);
        jrbSexoOtro.setBounds(300, 110, 70, 21);

        jbgGenero.add(jrbSexoMujer);
        jrbSexoMujer.setText("Mujer");
        jPanel1.add(jrbSexoMujer);
        jrbSexoMujer.setBounds(220, 110, 80, 21);

        jbCancelar.setText("Cancelar");
        jPanel1.add(jbCancelar);
        jbCancelar.setBounds(10, 220, 90, 23);

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(jbGuardar);
        jbGuardar.setBounds(290, 220, 72, 23);

        jcbFechaNoRecordar.setText("No recordarme este cumpleaños");
        jcbFechaNoRecordar.setToolTipText("");
        jcbFechaNoRecordar.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jPanel1.add(jcbFechaNoRecordar);
        jcbFechaNoRecordar.setBounds(130, 160, 210, 30);

        jLabel5.setText("Fecha Nacimiento:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 140, 110, 16);

        jcbFechaDesconocida.setText("No lo sé");
        jPanel1.add(jcbFechaDesconocida);
        jcbFechaDesconocida.setBounds(220, 140, 100, 20);

        jbLimpiar.setText("Limpiar");
        jbLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(jbLimpiar);
        jbLimpiar.setBounds(110, 220, 72, 23);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 380, 260);

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

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(AbmPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AbmPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AbmPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AbmPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AbmPersona().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbLimpiar;
    private javax.swing.ButtonGroup jbgGenero;
    private javax.swing.JCheckBox jcbFechaDesconocida;
    private javax.swing.JCheckBox jcbFechaNoRecordar;
    private javax.swing.JRadioButton jrbSexoHombre;
    private javax.swing.JRadioButton jrbSexoMujer;
    private javax.swing.JRadioButton jrbSexoOtro;
    private javax.swing.JTextField jtxtApellido;
    private javax.swing.JFormattedTextField jtxtFormattedFechaNacimiento;
    private javax.swing.JTextField jtxtNombre;
    // End of variables declaration//GEN-END:variables
}
