/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.teo.util;

import com.teo.ventanas.JDialogAvisoGenerico;
import java.awt.Color;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Teo
 */
public class UtilControlCampos {
    public HashMap<String, JTextField> CAMPOS_INPUT_ESTANDAR = new HashMap<>();
    public HashMap<String, JTextArea> CAMPOS_INPUT_TEXTAREA = new HashMap<>();
    public HashMap<String, JComboBox> CAMPOS_COMBOBOX = new HashMap<>();
    public HashMap<String, JCheckBox> CAMPOS_CHECKBOX = new HashMap<>();
    public HashMap<String, JFormattedTextField> CAMPOS_INPUT_FORMATTED = new HashMap<>();
     public HashMap<String, JTable> CAMPOS_TABLAS = new HashMap<>();
    
    
    public void vaciarCampos(){
        CAMPOS_INPUT_ESTANDAR.forEach((key, value) -> {
            value.setText("");
        });
        CAMPOS_INPUT_TEXTAREA.forEach((key, value) -> {
            value.setText("");
        });
        CAMPOS_INPUT_FORMATTED.forEach((key, value) -> {
            value.setValue(null);
        });
        CAMPOS_CHECKBOX.forEach((key, value) -> {
            value.setSelected(false);
        });
        CAMPOS_COMBOBOX.forEach((key, value) -> {
            value.setSelectedIndex(0);
        });
        CAMPOS_TABLAS.forEach((key, value) -> {
            UtilControlTablas.limpiarTabla(value);
        });
    }
    
    public boolean revisarInputValidoCampos(JFrame padre){
        //La mas sencilla expresion lambda no me deja trabajar con variables externas.
        for(Map.Entry<String, JTextField> entry : CAMPOS_INPUT_ESTANDAR.entrySet()) {
        JTextField campo;
        String llave;
        try {
            campo = entry.getValue();
            llave = entry.getKey();
        } catch(IllegalStateException ise) {
            throw new ConcurrentModificationException(ise);
        }
        if(campo.getText().trim().equals("")){
            JDialogAvisoGenerico dialog = new JDialogAvisoGenerico(padre, true, "Por favor complete el campo '" + llave + "'", Color.RED);
            return false;
        }
    }
        for(Map.Entry<String, JTextArea> entry : CAMPOS_INPUT_TEXTAREA.entrySet()) {
            JTextArea campo;
            String llave;
            try {
                llave = entry.getKey();
                campo = entry.getValue();
            } catch(IllegalStateException ise) {
                throw new ConcurrentModificationException(ise);
            }
            if(campo.getText().trim().equals("")){
                JDialogAvisoGenerico dialog = new JDialogAvisoGenerico(padre, true, "Por favor complete el campo '" + llave + "'", Color.RED);
                return false;
            }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
        }    
        
        return true;
    }
    
    public static void setearItemsCombo(JComboBox combo, String[] items){
        for(String item : items){
            combo.addItem(item);
        }
    }
    
}
