package com.teo.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.teo.modelos.Persona;
import com.teo.modelos.Tarea;
import com.teo.util.LocalDateAdapter;
import com.teo.util.UtilArchivos;
import java.io.File;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Teo
 */
public class TareaSrv {
    
    public static final int PRIORIDAD_0 = 0;
    public static final int PRIORIDAD_1 = 1;
    public static final int PRIORIDAD_2 = 2;
    public static final int PRIORIDAD_3 = 3;
    public static final int PRIORIDAD_4 = 4;
    public static final int PRIORIDAD_5 = 5;
    
    public static void guardarOActualizar(Tarea tarea){
        if(obtenerById(tarea.getId()) != null){
            //En caso de que ya exista, se elimina para "pisar" con la nueva version.
            eliminar(tarea.getId());
        } else {
            tarea.setId(obtenerMaxID() + 1);
        }
        guardar(tarea);
    }
    
    public static void guardar(Tarea tarea){
        UtilArchivos.crearEscribirArchivo(UtilArchivos.DIRECTORIO_TAREAS + File.separator + tarea.getId() + ".txt", convertirEnGson(tarea));
    }
    
    public static void eliminar(int id){
        UtilArchivos.eliminarArchivo(UtilArchivos.DIRECTORIO_TAREAS + File.separator + id + ".txt");
    }
    
    private static Gson obtenerGson(){
        return new GsonBuilder()
        .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
        .create();
    }
    
    public static String convertirEnGson(Tarea tarea){ 
       return obtenerGson().toJson(tarea);
    }
    
    public static Tarea convertirDesdeGsonString(String jsonString){
        Gson gson = obtenerGson();
        Tarea retorno = new Tarea();     
        try{
            retorno = gson.fromJson(jsonString, Tarea.class);
        } catch(Exception e){}
        return retorno;
    }
    
    public static int obtenerMaxID(){
        //TODO: Esto puede unificarse en un solo metodo que reciba el directorio. 
        int idMax = 0;
        for(String idParse : UtilArchivos.obtenerArchivosEnDirectorioString(UtilArchivos.DIRECTORIO_TAREAS, true)){
            int idComparar = 0;
            try{
                idComparar = Integer.parseInt(idParse);
            } catch (NumberFormatException e) {}
            if(idComparar>idMax){
                idMax = idComparar;
            }
        }
        return idMax;
    }

    /**
     * Dada una id, intenta ubicar y parsear el archivo correspondiente en una Tarea.
     * En caso de no encontrarla, devuelve null.
     * @param id
     * @return Tarea o Null si no existe.
     */
    public static Tarea obtenerById(int id) {
        String path = UtilArchivos.DIRECTORIO_RAIZ + File.separator + UtilArchivos.DIRECTORIO_TAREAS + File.separator + id + ".txt";
        File archivo = new File(path);
        if(!archivo.isFile()){
            return null;
        }
        Tarea ret = new Tarea();
        ret = convertirDesdeGsonString(UtilArchivos.leerContenidoArchivo(archivo));
        return ret;
    }
    
    public static List<Tarea> obtenerTodasTareasSinFecha() {
        List<Tarea> ret = new ArrayList<>();
        for(File archivo : UtilArchivos.obtenerArchivosEnDirectorio(UtilArchivos.DIRECTORIO_TAREAS)){
            try{
                Tarea tarea = TareaSrv.convertirDesdeGsonString(UtilArchivos.leerContenidoArchivo(archivo));
                if(tarea.isSinFecha()){
                    ret.add(tarea);
                } 
            } catch(Exception e){
                //Nada. Si algo sale mal no lo agregamos.
                //TODO: Mensaje error
            }
        }
        return ret;
    }
    
    public static List<Tarea> obtenerTodasTareasFechadas() {
        List<Tarea> ret = new ArrayList<>();
        for(File archivo : UtilArchivos.obtenerArchivosEnDirectorio(UtilArchivos.DIRECTORIO_TAREAS)){
            try{
                Tarea tarea = TareaSrv.convertirDesdeGsonString(UtilArchivos.leerContenidoArchivo(archivo));
                if(!tarea.isSinFecha() && tarea.getFecha() != null){
                    ret.add(tarea);
                } 
            } catch(Exception e){
                //Nada. Si algo sale mal no lo agregamos.
                //TODO: Mensaje error
            }
        }
        
        for(Tarea tarea : obtenerCumpleaniosComoTareas()){
            ret.add(tarea);
        }
        
        return ordenarTareasPorProximidad(ret, LocalDate.now());
    }
    
    public static List<Tarea> ordenarTareasPorProximidad(List<Tarea> tareas, LocalDate fecha){
        List<Tarea> ret = new ArrayList<>();
        
            for(Tarea tareaRevisar : tareas){
                long diasHasta = tareaRevisar.getFecha().until(fecha, ChronoUnit.DAYS);
                if(diasHasta > 0){
                    continue;
                }
                
                Tarea resultadoComparacion = null;
                for(Tarea tareaAgregada : ret){
                    long diaHastaAgregado = tareaAgregada.getFecha().until(fecha, ChronoUnit.DAYS);
                    if(diasHasta > diaHastaAgregado){
                       resultadoComparacion = tareaAgregada;
                    }
                }
                
                if(resultadoComparacion == null){
                    ret.add(tareaRevisar);
                } else {
                    ret.add(ret.indexOf(resultadoComparacion), tareaRevisar);
                }
            }
        return ret;
    }
    
    public static List<Tarea> obtenerCumpleaniosComoTareas(){
        List<Persona> todosPersonas = PersonaSrv.obtenerTodos();
        List<Tarea> ret = new ArrayList<>();
        for(Persona persona : todosPersonas){
            if(!persona.isNoRecordarCumpleanios() && !persona.isNoSeCumpleanios() && persona.getFechaNacimiento() != null){
                Tarea tarea = new Tarea();
                tarea.setAsunto("Cumpleaños de " + persona.getNombre() + " " + persona.getApellido());
                tarea.setDetalle("Cumpleaños!");
                tarea.setFechaLimite(false);
                tarea.setSinFecha(false);
                tarea.setId(-1);
                tarea.setPrioridad(PRIORIDAD_0);
                
                LocalDate fecha = persona.getFechaNacimiento();
                LocalDate fechaCambiada = LocalDate.of(LocalDate.now().getYear(), fecha.getMonth(), fecha.getDayOfMonth());
                
                //En caso de que este año ya haya pasado, calculo cuanto falta para el proximo cumpleaños
                if(fechaCambiada.until(LocalDate.now(), ChronoUnit.DAYS) > 0){
                    fechaCambiada = LocalDate.of(LocalDate.now().plusYears(1).getYear(), fecha.getMonth(), fecha.getDayOfMonth());
                }
                tarea.setFecha(fechaCambiada);
                
                ret.add(tarea);
            }
        }
        return ret;
    }
    
    public static List<Tarea> ordenarTareasPorFechaMasReciente(List<Tarea> tareas){
        List<Tarea> ret = new ArrayList<>();
       
        ret.add(tareas.remove(tareas.size()-1));
        int indice = tareas.size() - 1;
        
        while(!tareas.isEmpty()){
            
            Tarea tarea = tareas.remove(indice);
            indice--;
            
            boolean agregadoLista = false;
            for(Tarea tareaAgregada: ret){
                if(tareaAgregada.getFecha().isBefore(tarea.getFecha())){
                    ret.add(ret.indexOf(tareaAgregada), tarea);
                    agregadoLista = true;
                    break;
                }
            }

            if(!agregadoLista){
                ret.add(tarea);
            }

        }
        return ret;    
    }

}
