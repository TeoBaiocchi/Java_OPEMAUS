package com.teo.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.teo.modelos.Persona;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ciggy
 */
public class UtilArchivos {
    
    private static String pathRaiz = System.getProperty("user.home") + File.separator + "OPEMDATA";
    
    public static String DIRECTORIO_PERSONAS = "PERSONAS";
    public static String DIRECTORIO_DIRECCIONES = "DIRECCIONES";
    
    //Verifica que si o si exista el directorio base para trabajar.
    //Si no existe, intenta crearlo, y si fallase por algun motivo devuelve
    //False para que el main maneje el cierre del programa.
    public static boolean verificarDirectorioRaiz(){
        boolean ret = false;
        System.out.println("[LOG - INICIO] Verificando integridad del directorio ");
        ret = crearDirectorio("");
        ret = crearDirectorio(File.separator + DIRECTORIO_PERSONAS);
        ret = crearDirectorio(File.separator + DIRECTORIO_DIRECCIONES);
        System.out.println("[LOG - INICIO] Verificacion completa!");
        return ret;
    }
    
    public static boolean crearDirectorio(String path){
        File archivo = new File(pathRaiz + path);
        if (!archivo.exists()){
            return archivo.mkdirs();
        } else {
            return false;
        }
    }
    
    public static boolean eliminarArchivo(String path){
        File archivo = new File(path);
        return eliminarArchivo(archivo);
    }
    public static boolean eliminarArchivo(File archivo){
        return archivo.delete();
    }
    
    public static void crearArchivo(String path){
        crearArchivo(new File(pathRaiz + File.separator + path));
    }
    public static void crearArchivo(File archivo){
        try {
            if (archivo.createNewFile()) {
              System.out.println("[LOG - ARCHIVOS] Archivo creado correctamente: " + archivo.getPath());
            } else {
              System.out.println("[WARNING - ARCHIVOS] No se pudo crear el archivo '" + archivo.getPath() + "' porque ya existia.");
            }
          } catch (IOException e) {
            System.out.println("[ERROR - ARCHIVOS] Algo salio mal creando el archivo '" + archivo.getPath() +"' ("+e+")");
          }
    }
    
    public static void crearEscribirArchivo(String path, String contenido){
        crearArchivo(path);
        escribirArchivo(path, contenido);
    }
    
    public static void escribirArchivo(String path, String contenido){
        escribirArchivo(new File(pathRaiz + File.separator + path), contenido);
    }
    public static void escribirArchivo(File archivo, String contenido){
        contenido = contenido.trim();
        if(!contenido.equals("")){
            BufferedWriter salida;          
            try {
                salida = new BufferedWriter(new FileWriter(archivo));
                salida.write(contenido);
                salida.flush();
            } catch (IOException ex) {
                System.out.println("[ERROR - ARCHIVOS] Algo salio mal escribiendo en el archivo '" + archivo.getPath() +"' ("+ex+")");
            }        
        }
    }
    
    private static Gson obtenerGsonPersonas(){
        return new GsonBuilder()
        .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
        .create();
    }
    
    public static String convertirPersonaEnGson(Persona persona){ 
       return obtenerGsonPersonas().toJson(persona);
    }
    
    public static Persona convertirGsonStringEnPersona(String jsonString){
        Gson gson = obtenerGsonPersonas();
        Persona retorno = new Persona();     
        try{
            retorno = gson.fromJson(jsonString, Persona.class);
        } catch(Exception e){}
        return retorno;
    }

    public static List<String> obtenerArchivosEnDirectorio(String path, boolean recortarExtension){
        File dir = new File(pathRaiz + File.separator + path);
        List<String> ret = new ArrayList<String>();
        for(File archivo : dir.listFiles()){
            if(recortarExtension){
                ret.add(archivo.getName().substring(0, archivo.getName().lastIndexOf('.')));
            } else {
                ret.add(archivo.getName());
            }
        }
        return ret;
    }
}
