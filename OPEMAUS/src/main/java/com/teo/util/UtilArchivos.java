package com.teo.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author ciggy
 */
public class UtilArchivos {
    
    private String pathRaiz;
   
    public void crearDirectorio(String path){
        File archivo = new File(pathRaiz + path);
        if (!archivo.exists()){
            archivo.mkdirs();
        }
    }
    
    public void crearArchivo(String path, String nombreArchivo, String contenido){
        String pathArchivo = pathRaiz + path + nombreArchivo;
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
    
}
