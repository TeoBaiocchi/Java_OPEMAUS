package com.teo.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;

/**
 * @author Teo
 */
public class UtilFechas {
    
    //Te juro que los uso todos. Es importante que sean coherentes entre si
    public static final String FORMATO_STRING = "dd/MM/yyyy";
    public static final DateTimeFormatter FORMATO_DATETIME = DateTimeFormatter.ofPattern(FORMATO_STRING);
    public static final String FORMATO_MASK = "##/##/####";
    public static final DateFormat FORMATO_DATE = new SimpleDateFormat(FORMATO_STRING);
    public static final DateFormatter FORMATTER_DATE = new DateFormatter(FORMATO_DATE);
    public static final DefaultFormatterFactory FORMATTER_FACTORY = new DefaultFormatterFactory(FORMATTER_DATE, FORMATTER_DATE, FORMATTER_DATE);
    

    public static String MENSAJE_FECHA = "dia/mes/año";
    
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
