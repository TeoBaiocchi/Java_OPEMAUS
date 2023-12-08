package com.teo.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.teo.modelos.Correo;
import com.teo.util.UtilArchivos;
import java.io.File;

/**
 * @author Teo
 */
public class CorreoSrv {
    
    public static void guardar(Correo correo){
        UtilArchivos.crearEscribirArchivo(UtilArchivos.DIRECTORIO_CORREOS + File.separator + correo.getId() + ".txt", convertirEnGson(correo));
    }
    
    public static void eliminar(int id){
        UtilArchivos.eliminarArchivo(UtilArchivos.DIRECTORIO_CORREOS + File.separator + id + ".txt");
    }
    
    private static Gson obtenerGson(){
        return new GsonBuilder().create();
    }
    
    public static String convertirEnGson(Correo correo){ 
       return obtenerGson().toJson(correo);
    }
    
    public static Correo convertirDesdeGsonString(String jsonString){
        Gson gson = obtenerGson();
        Correo retorno = new Correo();     
        try{
            retorno = gson.fromJson(jsonString, Correo.class);
        } catch(Exception e){}
        return retorno;
    }
    
    public static int obtenerMaxID(){
        //TODO: Esto puede unificarse en un solo metodo que reciba el directorio. 
        int idMax = 0;
        for(String idParse : UtilArchivos.obtenerArchivosEnDirectorio(UtilArchivos.DIRECTORIO_CORREOS, true)){
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
     * Dada una id, intenta ubicar y parsear el archivo correspondiente en un Correo.
     * En caso de no encontrarla, devuelve null.
     * @param id
     * @return Correo o Null si no existe.
     */
    public static Correo obtenerById(int id) {
        String path = UtilArchivos.DIRECTORIO_RAIZ + File.separator + UtilArchivos.DIRECTORIO_CORREOS + File.separator + id + ".txt";
        File archivo = new File(path);
        if(!archivo.isFile()){
            return null;
        }
        Correo ret = new Correo();
        ret = convertirDesdeGsonString(UtilArchivos.leerContenidoArchivo(archivo));
        return ret;
    }
    
}
