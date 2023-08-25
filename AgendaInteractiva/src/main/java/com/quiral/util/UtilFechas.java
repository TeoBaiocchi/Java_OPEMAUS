package com.quiral.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ciggy
 */
public class UtilFechas {
    
    public static LocalDate obtenerFechaHoy(){
       return LocalDate.now();
    }
    
    
    public static List<LocalDate> obtenerRangoDesdeHoy(int cantidadDias){
        List lista = new ArrayList<LocalDate>();
        lista.add(obtenerFechaHoy());
        if(cantidadDias <= 0){
            return lista;
        }
        return lista;
    }
}
