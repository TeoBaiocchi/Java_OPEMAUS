package com.quiral.util;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import static javax.swing.SwingConstants.TRAILING;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Teo
 */
public class UtilControlTablas {
    
    
     /**
     * De la misma forma que la version no-generic de esta funcion, recibe un array de titulos y
     * devuelve un modelo correspondiente. Pero no es necesario definir class o canEdit porque
     * asigna valores por defecto "object" y "false" del tama�o del array de titulos
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
}
