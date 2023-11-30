package com.teo.ventanas;

import com.teo.modelos.Persona;
import com.teo.util.UtilArchivos;
import com.teo.util.UtilFechas;
import com.teo.util.UtilGraficoVentanas;
import javax.swing.text.DefaultFormatterFactory;

/**
 * @author Teo
 */
public class AbmPersona extends javax.swing.JFrame {
    
    UtilGraficoVentanas monitor; //No puedo instanciarla aca porque requiere un "this", que no puede usarse hasta construir esta clase per se

    public AbmPersona() {
        initComponents();
        inicializar();
    }
    
    private void inicializar(){
        monitor = new UtilGraficoVentanas(this, jPanel1, 0, 0);
        monitor.redimensionarReposicionarVentana();
        
        DefaultFormatterFactory factory = new DefaultFormatterFactory(UtilFechas.FORMATTER_DISPLAY, UtilFechas.FORMATTER_DISPLAY, UtilFechas.FORMATTER_EDIT);
        jtxtFechaNacimiento.setFormatterFactory(factory);
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
        jtxtFechaNacimiento = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

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

        jtxtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtNombreActionPerformed(evt);
            }
        });
        jPanel1.add(jtxtNombre);
        jtxtNombre.setBounds(130, 50, 230, 22);

        jLabel2.setText("Nombre");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 50, 100, 16);

        jtxtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtApellidoActionPerformed(evt);
            }
        });
        jPanel1.add(jtxtApellido);
        jtxtApellido.setBounds(130, 80, 230, 22);

        jLabel3.setText("Fecha Nacimiento");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 110, 100, 16);

        jtxtFechaNacimiento.setActionCommand("<Not Set>");
        jtxtFechaNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtFechaNacimientoActionPerformed(evt);
            }
        });
        jPanel1.add(jtxtFechaNacimiento);
        jtxtFechaNacimiento.setBounds(130, 110, 90, 22);

        jLabel4.setText("Apellido");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 80, 100, 16);

        jbgGenero.add(jRadioButton1);
        jRadioButton1.setText("Hombre");
        jPanel1.add(jRadioButton1);
        jRadioButton1.setBounds(110, 150, 67, 21);

        jbgGenero.add(jRadioButton2);
        jRadioButton2.setText("Otro");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton2);
        jRadioButton2.setBounds(280, 150, 98, 21);

        jbgGenero.add(jRadioButton3);
        jRadioButton3.setText("Mujer");
        jPanel1.add(jRadioButton3);
        jRadioButton3.setBounds(200, 150, 54, 21);

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(10, 190, 75, 23);

        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(280, 190, 72, 23);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 380, 220);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtNombreActionPerformed

    private void jtxtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtApellidoActionPerformed

    private void jtxtFechaNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtFechaNacimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtFechaNacimientoActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Persona persona = new Persona();
        persona.setNombre(jtxtNombre.getText());
        persona.setApellido(jtxtApellido.getText());
        persona.setFechaNacimiento(UtilFechas.obtenerFechaHoy());
        UtilArchivos.crearArchivo(UtilArchivos.DIRECTORIO_PERSONAS, String.valueOf(persona.getId()), UtilArchivos.convertirPersonaEnGson(persona));
    }//GEN-LAST:event_jButton2ActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.ButtonGroup jbgGenero;
    private javax.swing.JTextField jtxtApellido;
    private javax.swing.JFormattedTextField jtxtFechaNacimiento;
    private javax.swing.JTextField jtxtNombre;
    // End of variables declaration//GEN-END:variables
}
