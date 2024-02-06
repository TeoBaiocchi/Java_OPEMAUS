package com.teo.service;

import java.util.HashMap;

/**
 * @author Teo
 */
public class UnidadSrv {
    
    private static HashMap<Integer, String> UNIDADES = new HashMap<>();
    
    private static HashMap<Integer, String> HORARIOS = new HashMap<>();
    
    static{
        UNIDADES.put(0, "Otro/Indefinido");
        UNIDADES.put(1, "m");
        UNIDADES.put(2, "km");
        UNIDADES.put(3, "g");
        UNIDADES.put(3, "kg");
        UNIDADES.put(4, "Porciones");
        
        HORARIOS.put(0, "Otro");
        HORARIOS.put(1, "Desayuno");
        HORARIOS.put(2, "Mañana");
        HORARIOS.put(2, "Almuerzo");
        HORARIOS.put(2, "Mediodia");
        HORARIOS.put(2, "Merienda");
        HORARIOS.put(2, "Tarde");
        HORARIOS.put(2, "Cena");
        HORARIOS.put(2, "Trasnoche");
    }
    
    public static String getUnidadByID(int id){
        String ret = UNIDADES.get(id);
        if(ret == null){
            ret = "Indefinido";
        }
        return ret;
    }
    
    public static String getHorarioByID(int id){
        String ret = HORARIOS.get(id);
        if(ret == null){
            ret = "Indefinido";
        }
        return ret;
    }

    public static HashMap<Integer, String> getUNIDADES() {
        return UNIDADES;
    }

    public static HashMap<Integer, String> getHORARIOS() {
        return HORARIOS;
    }
    
    
}
