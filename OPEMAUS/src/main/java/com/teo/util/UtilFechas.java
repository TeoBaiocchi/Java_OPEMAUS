package com.teo.util;

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
        LocalDate hoy = obtenerFechaHoy();
        lista.add(hoy);
        if(cantidadDias <= 0){
            cantidadDias = 0; //En caso de que el numero sea negativo reasigno este valor de forma que nunca se entre al for.
        }
        for(int i = 1; i < cantidadDias; i++){
            lista.add(hoy.plusDays(i));
        }
        return lista;
    }
}
