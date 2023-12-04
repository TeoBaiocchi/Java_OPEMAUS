package com.teo.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;

/**
 * @author Teo
 */
public class UtilFechas {
    
    //Te juro que los uso todos. Es importante que sean coherentes entre si
    public static String FORMATO_DISPLAY_STRING = "dd/MM/yyyy";
    public static String FORMATO_DISPLAY_MASK = "##/##/####";
    public static DateFormat FORMATO_DISPLAY = new SimpleDateFormat(FORMATO_DISPLAY_STRING);
    public static DateFormatter FORMATTER_DISPLAY = new DateFormatter(FORMATO_DISPLAY);
    public static DefaultFormatterFactory FORMATTER_FACTORY = new DefaultFormatterFactory(FORMATTER_DISPLAY, FORMATTER_DISPLAY, FORMATTER_DISPLAY);
    

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
