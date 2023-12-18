package com.teo.util;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.SwingConstants.TRAILING;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Teo
 */
public class UtilControlTablas {
    
        private static final int MIN_VALOR_TABLE_WIDTH = 15;
        private static final int MAX_VALOR_TABLE_WIDTH = 2147483647;

        public static void setTableWidth(javax.swing.JTable table, int[] valores) {
        int a = 0;
        int min = table.getModel().getColumnCount();
        if (valores.length < min) {
            min = valores.length;
        }
        for (a = 0; a < min; a++) {
            if (valores[a] == 0) { //Con esto oculta la columna totalmente
                table.getColumnModel().getColumn(a).setMinWidth(0);
                table.getColumnModel().getColumn(a).setMaxWidth(0);
                table.getColumnModel().getColumn(a).setPreferredWidth(0);
            } else {
                table.getColumnModel().getColumn(a).setMinWidth(MIN_VALOR_TABLE_WIDTH);
                table.getColumnModel().getColumn(a).setMaxWidth(MAX_VALOR_TABLE_WIDTH);
                table.getColumnModel().getColumn(a).setPreferredWidth(valores[a]);
            }
        }
    }

    
     /**
     * De la misma forma que la version no-generic de esta funcion, recibe un array de titulos y
     * devuelve un modelo correspondiente. Pero no es necesario definir class o canEdit porque
     * asigna valores por defecto "object" y "false" del tamanio del array de titulos
     * 
     * @param stringArray
     * @return defaultTableModel
     */
    public static DefaultTableModel createDefaultTableModelGeneric(final String[] stringArray) {
        Class[] classArray = new Class[stringArray.length];
        for(int i = 0; i < stringArray.length; i++){
            classArray[i] = java.lang.Object.class;
        }
        
        boolean[] booleanArray = new boolean[stringArray.length];
        for(int i = 0; i < stringArray.length; i++){
            booleanArray[i] = false;
        }
        return createDefaultTableModel(stringArray, classArray, booleanArray);
    }


    /**
     * Se pasan los titulos, clases y si se puede editar, y devuelve el modelo
     * hecho.
     *
     * @param stringArray deben ser los titulos.
     * @param classArray deben ser las clases correspondientes con los titulos.
     * @param booleanArray indica respectivamente si se puede editar.
     * @return default table model
     */
    private static DefaultTableModel createDefaultTableModel(final String[] stringArray, final Class[] classArray, final boolean[] booleanArray) {
        DefaultTableModel m;
        m = (new javax.swing.table.DefaultTableModel(
                new Object[][]{}, stringArray) {
            @Override
            public Class getColumnClass(int i) {
                return classArray[i];
            }

            @Override
            public boolean isCellEditable(int i, int i1) {
                return booleanArray[i1];
            }
        });
        return m;
    }

    public static void eliminarFilaSeleccionada(JTable tabla) {
        int fila = tabla.getSelectedRow();
        if(fila != -1){
            ((DefaultTableModel)tabla.getModel()).removeRow(fila);
        }
    }

    public static void limpiarTabla(JTable tabla) {
        ((DefaultTableModel)tabla.getModel()).setRowCount(0);
    }
    
    public void posicionarJSPDebajoDeTXT(JScrollPane jsp, JTextField jtxt, int altura) {
        jsp.setBounds(jtxt.getX(), jtxt.getY() + jtxt.getHeight(), jtxt.getWidth(), altura);
    }

    public void posicionarJSPEncimaDeTXT(JScrollPane jsp, JTextField jtxt, int altura) {
        jsp.setBounds(jtxt.getX(), jtxt.getY() - altura, jtxt.getWidth(), altura);
    }

    public void posicionarJSPEncimaDeTXT_MenosAnchoDeLabel(JScrollPane jsp, JTextField jtxt, JLabel label, int altura, boolean derecha) {
        if (derecha) {
            jsp.setBounds(jtxt.getX() + label.getWidth(), jtxt.getY() - altura, jtxt.getWidth() - label.getWidth(), altura);
        } else {
            jsp.setBounds(jtxt.getX(), jtxt.getY() - altura, jtxt.getWidth() - label.getWidth(), altura);
        }
    }

    public void posicionarResultadosSobreJSP(JScrollPane jsp, JLabel label, int desfase) {
        label.setBounds(jsp.getX(), jsp.getY() - desfase, jsp.getWidth() - 2, label.getHeight());
        label.setHorizontalAlignment(TRAILING);
    }
    
    public static int obtenerValorNumericoDeTabla(JTable tabla, int columna){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int fila = tabla.getSelectedRow();
        if(tabla.getSelectedRow() == -1){
            return -1;
        }
        return Integer.parseInt(modelo.getValueAt(fila, columna).toString());
    }
}
