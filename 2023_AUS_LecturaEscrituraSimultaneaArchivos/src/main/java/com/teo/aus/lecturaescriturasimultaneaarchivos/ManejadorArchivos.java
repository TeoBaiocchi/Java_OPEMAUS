package com.teo.aus.lecturaescriturasimultaneaarchivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        //Si saida.txt no existe, lo creo. Si existe, elimino su contenido.
        String path = System.getProperty("user.home") + File.separator + "salida.log";
        File archivo = new File(path);
        if(archivo.isFile()){
            PrintWriter pw;
            try {
                pw = new PrintWriter(path);
                pw.close();
            } catch (FileNotFoundException ex) {
                System.out.println("[ERROR - ARCHIVOS] Hubo un error creando 'salida.log'");
            }
        } else {
            crearArchivo(archivo);
        }
        
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(path));
        } catch (IOException ex) {
            System.out.println("[ERROR - ARCHIVOS] Hubo un error creando 'salida.log'");
        }
        ManejadorArchivos.escritorLog = writer;
    }
        
    
    public boolean verificarSalida(){
        if(ManejadorArchivos.escritorLog == null){
            System.out.println("[ERROR - ARCHIVOS] Hubo un error leyendo 'salida.log'");
            return false;
        } else {
             System.out.println("[LOG - ARCHIVOS] Archivo 'salida.log' abierto correctamente");
             return true;
        }
    }
    
    
    public static void crearArchivo(File archivo){
        try {
            if (archivo.createNewFile()) {
              System.out.println("[LOG - ARCHIVOS] Archivo creado correctamente: " + archivo.getPath());
            } else {
              System.out.println("[ERROR - ARCHIVOS] No se pudo crear el archivo '" + archivo.getPath() + "'");
              escribirErrorCreacion(archivo);
            }
          } catch (IOException e) {
            System.out.println("[ERROR - ARCHIVOS] Algo salio mal creando el archivo '" + archivo.getPath() +"'");
            escribirErrorCreacion(archivo);
          }
    }
    
    
    public static void escribirErrorCreacion(File archivo){
        try {
            escritorLog.write("C - " + archivo.getPath() + "\n");
            escritorLog.flush();
        } catch (IOException ex) {
            System.out.println("[ERROR - SALIDA] Algo salio mal escribiendo el log de saida");
        }
    }

    
    public static void borrarArchivo(File archivo){
        try {
            if (archivo.delete()) {
              System.out.println("[LOG - ARCHIVOS] Archivo eliminado correctamente '" + archivo.getPath() + "'");
            } else {
              System.out.println("[ERROR - ARCHIVOS] No se pudo eliminar el archivo '" + archivo.getPath() + "'");
              escribirErrorBorrado(archivo);
            }
          } catch (Exception e) {
            System.out.println("[ERROR - ARCHIVOS] Algo salio mal eliminado el archivo '" + archivo.getPath() + "'");
            escribirErrorBorrado(archivo);
          }
    }    
    
    
    public static void escribirErrorBorrado(File archivo){
        try {
            escritorLog.write("B - " + archivo.getPath() + "\n");
            escritorLog.flush();
        } catch (IOException ex) {
            System.out.println("[ERROR - SALIDA] Algo salio mal escribiendo el log de saida");
        }
    }
    
    
    public static void crearSiExisteBorrarSiNoExiste(String path){
        File archivo = new File(path);
        if(archivo.isFile()){
            ManejadorArchivos.borrarArchivo(archivo);
        } else {
            ManejadorArchivos.crearArchivo(archivo);
        }
    }
}
