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
import javax.swing.JTextField;

/**
 *
 * @author Teo
 */
public class UtilControlVentanas {
    public HashMap<JTextField, String> CAMPOS_INPUT_ESTANDAR = new HashMap<JTextField, String>();
    public List<JCheckBox> CAMPOS_INPUT_CHECKBOX = new ArrayList<JCheckBox>();
    public HashMap<JFormattedTextField, String> CAMPOS_INPUT_FORMATTED = new HashMap<JFormattedTextField, String>();
    
    public void vaciarCampos(){
        CAMPOS_INPUT_ESTANDAR.forEach((campo, valor) -> {
            campo.setText("");
        });
        CAMPOS_INPUT_FORMATTED.forEach((campo, valor) -> {
            campo.setValue(null);
        });
        for(JCheckBox jcb : CAMPOS_INPUT_CHECKBOX){
            jcb.setSelected(false);
        }
    }
    
    public boolean revisarInputValidoCampos(JFrame padre){
        //La mas sencilla expresion lambda no me deja trabajar con variables externas.
        for(Map.Entry<JTextField, String> entry : CAMPOS_INPUT_ESTANDAR.entrySet()) {
        JTextField k;
        String v;
        try {
            k = entry.getKey();
            v = entry.getValue();
        } catch(IllegalStateException ise) {
            // this usually means the entry is no longer in the map.
            throw new ConcurrentModificationException(ise);
        }
        if(k.getText().trim().equals("")){
            JDialogAvisoGenerico dialog = new JDialogAvisoGenerico(padre, true, "Por favor ingrese un " + v);
            return false;
        }
    }
        return true;
    }
    
}
