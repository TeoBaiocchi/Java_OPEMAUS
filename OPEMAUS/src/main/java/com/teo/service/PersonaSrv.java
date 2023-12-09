package com.teo.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.teo.modelos.Persona;
import com.teo.util.LocalDateAdapter;
import com.teo.util.UtilArchivos;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Teo
 */
public class PersonaSrv {
    
    public static int GENERO_HOMBRE = 1;
    public static int GENERO_MUJER = 0;
    public static int GENERO_OTRO = -1;
    public static HashMap<String, Integer> GENERO_CODIGO = generarMapaSexo();
    public static HashMap<String, Integer> generarMapaSexo(){
        HashMap<String, Integer> mapa = new HashMap<>();
        mapa.put("Hombre", GENERO_HOMBRE);
        mapa.put("Mujer", GENERO_MUJER);
        mapa.put("Otro", GENERO_OTRO);
        return mapa;
    }
          
    public static void guardar(Persona persona){
        UtilArchivos.crearEscribirArchivo(UtilArchivos.DIRECTORIO_PERSONAS + File.separator + persona.getId() + ".txt", convertirEnGson(persona));
    }
    
    public static void eliminar(int id){
        UtilArchivos.eliminarArchivo(UtilArchivos.DIRECTORIO_PERSONAS + File.separator + id + ".txt");
    }
    
    private static Gson obtenerGson(){
        return new GsonBuilder()
        .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
        .create();
    }
    
    public static String convertirEnGson(Persona persona){ 
       return obtenerGson().toJson(persona);
    }
    
    public static Persona convertirDesdeJsonString(String jsonString){
        Gson gson = obtenerGson();
        Persona retorno = new Persona();     
        try{
            retorno = gson.fromJson(jsonString, Persona.class);
        } catch(Exception e){}
        return retorno;
    }
    
    public static int obtenerMaxID(){
        //TODO: Esto puede unificarse en un solo metodo que reciba el directorio. 
        int idMax = 0;
        for(String idParse : UtilArchivos.obtenerArchivosEnDirectorioString(UtilArchivos.DIRECTORIO_PERSONAS, true)){
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
     * Dada una id, intenta ubicar y parsear el archivo correspondiente en una Persona.
     * En caso de no encontrarla, devuelve null.
     * @param id
     * @return Persona o Null si no existe.
     */
    public static Persona obtenerById(int id) {
        String path = UtilArchivos.DIRECTORIO_RAIZ + File.separator + UtilArchivos.DIRECTORIO_PERSONAS + File.separator + id + ".txt";
        File archivo = new File(path);
        if(!archivo.isFile()){
            return null;
        }
        Persona ret = new Persona();
        ret = convertirDesdeJsonString(UtilArchivos.leerContenidoArchivo(archivo));
        return ret;
    }

    public static List<Persona> obtenerTodos() {
        List<Persona> ret = new ArrayList<>();
        for(File archivo : UtilArchivos.obtenerArchivosEnDirectorio(UtilArchivos.DIRECTORIO_PERSONAS)){
            try{
                ret.add(PersonaSrv.convertirDesdeJsonString(UtilArchivos.leerContenidoArchivo(archivo)));
            } catch(Exception e){
                //Nada. Si algo sale mal no lo agregamos.
                //TODO: Mensaje error
            }
        }
        return ret;
    }
    
}
