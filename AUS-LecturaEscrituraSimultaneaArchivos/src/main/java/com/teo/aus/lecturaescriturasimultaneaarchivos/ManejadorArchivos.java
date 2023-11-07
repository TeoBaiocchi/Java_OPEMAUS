package com.teo.aus.lecturaescriturasimultaneaarchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Teo
 */
public class ManejadorArchivos {
    
    public static BufferedReader generarBufferReaderBulk(){
        BufferedReader reader = null;
        try { 
             reader = new BufferedReader(new FileReader(System.getProperty("user.home") + File.separator + "bulk.txt"));
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR: Archivo BULK no encontrado");
            Logger.getLogger(AUSLecturaEscrituraSimultaneaArchivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reader;
    }
    
    public static void crearArchivo(File archivo){
        try {
            if (archivo.createNewFile()) {
              System.out.println("Archivo creado correctamente: " + archivo.getName());
            } else {
              System.out.println("No se pudo crear el archivo.");
            }
          } catch (IOException e) {
            System.out.println("Algo salio mal creando el archivo.");
          }
    }

    public static void borrarArchivo(File archivo){
        try {
            if (archivo.delete()) {
              System.out.println("Archivo eliminado correctamente");
            } else {
              System.out.println("No se pudo eliminar el archivo.");
            }
          } catch (Exception e) {
            System.out.println("Algo salio mal eliminado el archivo.");
          }
    }    
    
}
