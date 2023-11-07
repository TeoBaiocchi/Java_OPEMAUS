package com.teo.aus.lecturaescriturasimultaneaarchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Teo
 */
public class HiloArchivos implements Runnable {
    
    int nroHilo;
    BufferedReader lector;
    
    public HiloArchivos(int i, BufferedReader lector){
        nroHilo = i;
        this.lector = lector;
    }
    
    @Override
    public void run(){
        String linea = "";
        
        try {
            linea = lector.readLine();
        } catch (IOException ex) {
            Logger.getLogger(HiloArchivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(linea == null){
            System.out.println("No se logro leer una linea del bulk. Cerrando hilo nro " + nroHilo);
            //TODO: Revisar que no tenga que hacer algo adicional para cerrar el hilo
            return;
        }
        
        System.out.println("La linea leida por hilo nro: " + nroHilo + " es: '" + linea + "'");
        
        File archivo = new File(linea);
        if(archivo.isFile()){
            ManejadorArchivos.borrarArchivo(archivo);
        } else {
            ManejadorArchivos.crearArchivo(archivo);
        }
    }
}
