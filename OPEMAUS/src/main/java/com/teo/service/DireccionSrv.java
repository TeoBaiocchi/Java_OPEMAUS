package com.teo.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.teo.modelos.Direccion;
import com.teo.util.UtilArchivos;
import java.io.File;

/**
 * @author Teo
 */
public class DireccionSrv {
    
    public static void guardar(Direccion direccion){
        UtilArchivos.crearEscribirArchivo(UtilArchivos.DIRECTORIO_DIRECCIONES + File.separator + direccion.getId() + ".txt", convertirEnGson(direccion));
    }
    
    public static void eliminar(int id){
        UtilArchivos.eliminarArchivo(UtilArchivos.DIRECTORIO_DIRECCIONES + File.separator + id + ".txt");
    }
    
    private static Gson obtenerGson(){
        return new GsonBuilder().create();
    }
    
    public static String convertirEnGson(Direccion direccion){ 
       return obtenerGson().toJson(direccion);
    }
    
    public static Direccion convertirDesdeGsonString(String jsonString){
        Gson gson = obtenerGson();
        Direccion retorno = new Direccion();     
        try{
            retorno = gson.fromJson(jsonString, Direccion.class);
        } catch(Exception e){}
        return retorno;
    }
    
    public static int obtenerMaxID(){
        int idMax = 0;
        for(String idParse : UtilArchivos.obtenerArchivosEnDirectorio(UtilArchivos.DIRECTORIO_DIRECCIONES, true)){
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
     * Dada una id, intenta ubicar y parsear el archivo correspondiente en una direccion.
     * En caso de no encontrarla, devuelve null.
     * @param id
     * @return Direccion o Null si no existe.
     */
    public static Direccion obtenerById(int id) {
        String path = UtilArchivos.DIRECTORIO_RAIZ + File.separator + UtilArchivos.DIRECTORIO_DIRECCIONES + File.separator + id + ".txt";
        File archivo = new File(path);
        if(!archivo.isFile()){
            return null;
        }
        Direccion ret = new Direccion();
        ret = convertirDesdeGsonString(UtilArchivos.leerContenidoArchivo(archivo));
        return ret;
    }
    
}
