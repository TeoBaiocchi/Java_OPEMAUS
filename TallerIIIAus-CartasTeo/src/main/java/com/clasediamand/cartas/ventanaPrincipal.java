package com.clasediamand.cartas;

import com.quiral.util.UtilControlTablas;
import com.quiral.util.UtilFechas;
import com.quiral.util.UtilGraficoVentanas;
import com.quiral.util.UtilPropiedades;
import java.time.LocalDate;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 * @author Teo
 */
public class ventanaPrincipal extends javax.swing.JFrame {
    
    UtilGraficoVentanas monitor; //No puedo instanciarla aca porque requiere un "this", que no puede usarse hasta construir esta clase per se
    
    BarajaEspaniola mazo = new BarajaEspaniola();
    
    public ventanaPrincipal() {
        initComponents();
        inicializar();
        inicializarTablas();
        llenarTablaConMazo();
    }
    
    private void inicializar(){
        monitor = new UtilGraficoVentanas(this, jPanel1, 0, 0);
        
        int altoEfectivoFrame = monitor.obtenerAltoUtilizableMaximoEnMonitorDinamico() - 50;
        jPanel1.setBounds(0, 0, jPanel1.getWidth(), altoEfectivoFrame);
        monitor.redimensionarReposicionarVentana();
        int nuevoAltoTabla = altoEfectivoFrame - jspCartero.getY() - 5;
        jspCartero.setBounds(jspCartero.getX(), jspCartero.getY(), jspCartero.getWidth(), nuevoAltoTabla);
        this.setVisible(true);
    }

    private void llenarTablaConMazo(){
        DefaultTableModel modelo = (DefaultTableModel) jtCartero.getModel();
        modelo.setRowCount(0);
        Object[] aux = new Object[1];
        for(Carta carta : mazo.getMazo()){
            if(carta.enMazo){
                aux[0] = carta.leerCarta();
                modelo.addRow(aux);
            }
        }
    }
    
    private void inicializarTablas(){
        String[] columnas = {"Tu Mazo"};
        jtCartero.setModel(UtilControlTablas.createDefaultTableModelGeneric(columnas));
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
        jLabel1 = new javax.swing.JLabel();
        jspCartero = new javax.swing.JScrollPane();
        jtCartero = new javax.swing.JTable();
        jbSacarCarta = new javax.swing.JButton();
        jbMezclar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hola");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("'Cartero' : A Teo Program 2023 (Hecho muy ineficientemente en 2 horas)");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 10, 540, 16);

        jspCartero.setViewportView(jtCartero);

        jPanel1.add(jspCartero);
        jspCartero.setBounds(10, 110, 520, 50);

        jbSacarCarta.setText("Sacar Carta");
        jbSacarCarta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSacarCartaActionPerformed(evt);
            }
        });
        jPanel1.add(jbSacarCarta);
        jbSacarCarta.setBounds(100, 70, 100, 23);

        jbMezclar.setText("Mezclar");
        jbMezclar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMezclarActionPerformed(evt);
            }
        });
        jPanel1.add(jbMezclar);
        jbMezclar.setBounds(10, 70, 72, 23);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 540, 360);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSacarCartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSacarCartaActionPerformed
        if(!mazo.estaVacio()){
        mazo.sacarCarta();
        llenarTablaConMazo();
        }
    }//GEN-LAST:event_jbSacarCartaActionPerformed

    private void jbMezclarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMezclarActionPerformed
        if(!mazo.estaVacio()){
        mazo.mezclar();
        llenarTablaConMazo();}
    }//GEN-LAST:event_jbMezclarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main() {
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
            java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ventanaPrincipal();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbMezclar;
    private javax.swing.JButton jbSacarCarta;
    private javax.swing.JScrollPane jspCartero;
    private javax.swing.JTable jtCartero;
    // End of variables declaration//GEN-END:variables
}