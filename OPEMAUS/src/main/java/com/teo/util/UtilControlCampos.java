/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.teo.util;

import com.teo.ventanas.JDialogAvisoGenerico;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Teo
 */
public class UtilControlCampos {
    public HashMap<String, JTextField> CAMPOS_INPUT_ESTANDAR = new HashMap<>();
    public HashMap<String, JTextArea> CAMPOS_INPUT_TEXTAREA = new HashMap<>();
    public List<JCheckBox> CAMPOS_INPUT_CHECKBOX = new ArrayList<>();
    public HashMap<String, JFormattedTextField> CAMPOS_INPUT_FORMATTED = new HashMap<>();
    
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
        for(JCheckBox jcb : CAMPOS_INPUT_CHECKBOX){
            jcb.setSelected(false);
        }
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
            JDialogAvisoGenerico dialog = new JDialogAvisoGenerico(padre, true, "Por favor complete el campo '" + llave + "'");
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
                JDialogAvisoGenerico dialog = new JDialogAvisoGenerico(padre, true, "Por favor complete el campo '" + llave + "'");
                return false;
            }
        }    
     
        return true;
    }
    
}
