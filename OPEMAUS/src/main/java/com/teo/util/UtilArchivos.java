package com.teo.util;

import com.google.gson.Gson;
import com.teo.modelos.Persona;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author ciggy
 */
public class UtilArchivos {
    
    private static String pathRaiz = System.getProperty("user.home") + File.separator + "OPEMDATA";
    
    public static String DIRECTORIO_PERSONAS = "PERSONAS";
    
    //Verifica que si o si exista el directorio base para trabajar.
    //Si no existe, intenta crearlo, y si fallase por algun motivo devuelve
    //False para que el main maneje el cierre del programa.
    public static boolean verificarDirectorioRaiz(){
        try{
            crearDirectorioSiNoExiste(pathRaiz);
        } catch (Exception e){
            return false;
        }
        return true;
    }
    
    public static void crearDirectorioSiNoExiste(String path){
        File archivo = new File(pathRaiz + path);
        if (!archivo.exists()){
            archivo.mkdirs();
        }
    }
    
    public static void crearArchivo(String path, String nombreArchivo, String contenido){
        String pathArchivo = pathRaiz + File.separator + path + File.separator + nombreArchivo;
        try {
            File myObj = new File(pathArchivo);
            if (myObj.createNewFile()) {
              System.out.println("Archivo creado correctamente: " + myObj.getName());
            } else {
              System.out.println("Archivo ya existente.");
            }
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        
            try {
            FileWriter myWriter = new FileWriter(pathArchivo);
            myWriter.write(contenido);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
              System.out.println("An error occurred.");
              e.printStackTrace();
            }
    }
    
    public static String convertirPersonaEnGson(Persona persona){
        Gson gson = new Gson();
        return gson.toJson(persona);
    }
    
    public static Persona convertirGsonStringEnPersona(String jsonString){
        Gson gson = new Gson();
        Persona retorno = new Persona();     
        try{
            retorno = gson.fromJson(jsonString, Persona.class);
        } catch(Exception e){}
        return retorno;
    }
}
