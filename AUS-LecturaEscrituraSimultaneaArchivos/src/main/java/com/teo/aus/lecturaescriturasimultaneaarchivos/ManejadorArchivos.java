package com.teo.aus.lecturaescriturasimultaneaarchivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
    
    public static BufferedReader lectorBulk;
    public static BufferedWriter escritorLog;
    public static boolean bulkLeidoCompleto = false;
    
    public static void generarBufferReaderBulk(){
        BufferedReader reader = null;
        try { 
             reader = new BufferedReader(new FileReader(System.getProperty("user.home") + File.separator + "bulk.txt"));
        } catch (FileNotFoundException ex) {
            System.out.println("[ERROR - ARCHIVOS] Archivo BULK no encontrado");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        ManejadorArchivos.lectorBulk = reader;
    }
    
    public boolean verificarBulk(){
        if(ManejadorArchivos.lectorBulk == null){
            System.out.println("[ERROR - ARCHIVOS] Hubo un error leyendo 'bulk.txt'");
            return false;
        } else {
             System.out.println("[LOG - ARCHIVOS] Archivo 'bulk.txt' abierto correctamente");
             return true;
        }
    }
    
        public static void generarBufferWriterSalida(){
        BufferedReader reader = null;
        try { 
             reader = new BufferedReader(new FileReader(System.getProperty("user.home") + File.separator + "bulk.txt"));
        } catch (FileNotFoundException ex) {
            System.out.println("[ERROR - ARCHIVOS] Archivo BULK no encontrado");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        ManejadorArchivos.lectorBulk = reader;
    }
    
    
    public static void crearArchivo(File archivo){
        try {
            if (archivo.createNewFile()) {
              System.out.println("[LOG - ARCHIVOS] Archivo creado correctamente: " + archivo.getName());
            } else {
              System.out.println("[ERROR - ARCHIVOS] No se pudo crear el archivo '" + archivo.getName() + "'");
              escribirErrorCreacion();
            }
          } catch (IOException e) {
            System.out.println("[ERROR - ARCHIVOS] Algo salio mal creando el archivo '" + archivo.getName() +"'");
            escribirErrorCreacion();
          }
    }
    
    public static void escribirErrorCreacion(){
        
    }

    public static void borrarArchivo(File archivo){
        try {
            if (archivo.delete()) {
              System.out.println("[LOG - ARCHIVOS] Archivo eliminado correctamente");
            } else {
              System.out.println("[ERROR - ARCHIVOS] No se pudo eliminar el archivo.");
              escribirErrorBorrado();
            }
          } catch (Exception e) {
            System.out.println("[ERROR - ARCHIVOS] Algo salio mal eliminado el archivo.");
            escribirErrorBorrado();
          }
    }    
    
    public static void escribirErrorBorrado(){
        
    }
}
