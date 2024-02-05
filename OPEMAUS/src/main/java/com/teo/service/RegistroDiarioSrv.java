package com.teo.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.teo.modelos.RegistroDiario;
import com.teo.util.UtilArchivos;
import java.io.File;

/**
 * @author Teo
 */
public class RegistroDiarioSrv {
    
    public static void guardarOActualizar(RegistroDiario entidad){
        if(obtenerById(entidad.getId()) != null){
            //En caso de que ya exista, se elimina para "pisar" con la nueva version.
            eliminar(entidad.getId());
        } else {
            entidad.setId(obtenerMaxID() + 1);
        }
        guardar(entidad);
    }
    
    public static void guardar(RegistroDiario entidad){
        UtilArchivos.crearEscribirArchivo(UtilArchivos.DIRECTORIO_REGISTRO_DIARIO + File.separator + entidad.getId() + ".txt", convertirEnGson(entidad));
    }
    
    public static void eliminar(int id){
        UtilArchivos.eliminarArchivo(UtilArchivos.DIRECTORIO_REGISTRO_DIARIO + File.separator + id + ".txt");
    }
    
    private static Gson obtenerGson(){
        return new GsonBuilder().create();
    }
    
    public static String convertirEnGson(RegistroDiario entidad){ 
       return obtenerGson().toJson(entidad);
    }
    
    public static RegistroDiario convertirDesdeGsonString(String jsonString){
        Gson gson = obtenerGson();
        RegistroDiario retorno = new RegistroDiario();     
        try{
            retorno = gson.fromJson(jsonString, RegistroDiario.class);
        } catch(Exception e){}
        return retorno;
    }
    
    public static int obtenerMaxID(){
        //TODO: Esto puede unificarse en un solo metodo que reciba el directorio. 
        int idMax = 0;
        for(String idParse : UtilArchivos.obtenerArchivosEnDirectorioString(UtilArchivos.DIRECTORIO_REGISTRO_DIARIO, true)){
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
     * Dada una id, intenta ubicar y parsear el archivo correspondiente en un ActividadFisica.
     * En caso de no encontrarla, devuelve null.
     * @param id
     * @return ActividadFisica o Null si no existe.
     */
    public static RegistroDiario obtenerById(int id) {
        String path = UtilArchivos.DIRECTORIO_RAIZ + File.separator + UtilArchivos.DIRECTORIO_REGISTRO_DIARIO + File.separator + id + ".txt";
        File archivo = new File(path);
        if(!archivo.isFile()){
            return null;
        }
        RegistroDiario ret = new RegistroDiario();
        ret = convertirDesdeGsonString(UtilArchivos.leerContenidoArchivo(archivo));
        return ret;
    }
    
}
