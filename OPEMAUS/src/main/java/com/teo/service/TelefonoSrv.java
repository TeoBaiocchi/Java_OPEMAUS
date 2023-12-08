package com.teo.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.teo.modelos.Telefono;
import com.teo.util.UtilArchivos;
import java.io.File;

/**
 * @author Teo
 */
public class TelefonoSrv {
    
    public static void guardar(Telefono telefono){
        UtilArchivos.crearEscribirArchivo(UtilArchivos.DIRECTORIO_TELEFONOS + File.separator + telefono.getId() + ".txt", convertirEnGson(telefono));
    }
    
    public static void eliminar(int id){
        UtilArchivos.eliminarArchivo(UtilArchivos.DIRECTORIO_TELEFONOS + File.separator + id + ".txt");
    }
    
    private static Gson obtenerGson(){
        return new GsonBuilder().create();
    }
    
    public static String convertirEnGson(Telefono telefono){ 
       return obtenerGson().toJson(telefono);
    }
    
    public static Telefono convertirDesdeGsonString(String jsonString){
        Gson gson = obtenerGson();
        Telefono retorno = new Telefono();     
        try{
            retorno = gson.fromJson(jsonString, Telefono.class);
        } catch(Exception e){}
        return retorno;
    }
    
    public static int obtenerMaxID(){
        int idMax = 0;
        for(String idParse : UtilArchivos.obtenerArchivosEnDirectorio(UtilArchivos.DIRECTORIO_TELEFONOS, true)){
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
     * Dada una id, intenta ubicar y parsear el archivo correspondiente en un telefono.
     * En caso de no encontrarla, devuelve null.
     * @param id
     * @return Telefono o Null si no existe.
     */
    public static Telefono obtenerById(int id) {
        String path = UtilArchivos.DIRECTORIO_RAIZ + File.separator + UtilArchivos.DIRECTORIO_TELEFONOS + File.separator + id + ".txt";
        File archivo = new File(path);
        if(!archivo.isFile()){
            return null;
        }
        Telefono ret = new Telefono();
        ret = convertirDesdeGsonString(UtilArchivos.leerContenidoArchivo(archivo));
        return ret;
    }
    
}
