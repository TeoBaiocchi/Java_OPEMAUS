package com.teo.aus.lecturaescriturasimultaneaarchivos;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Teo
 */
public class HiloArchivos implements Runnable {
    
    int nroHilo;
    
    public HiloArchivos(int i){
        nroHilo = i;
    }
    
    @Override
    public void run(){
        String linea = "";
        
        try {
            //BufferedReader es thread-safe, por lo que no necesito verificar que los hilos accediendo
            //la variable dedicada a leer el bulk no se pisen entre sí.
            linea = ManejadorArchivos.lectorBulk.readLine();
        } catch (IOException ex) {
            System.out.println("[ERROR - HILO N°" + nroHilo + "] Algo salio mal leyendo la linea.");
            }
       
            if(linea == null){
                System.out.println("[WARNING - HILO N°" + nroHilo +"]: No se logro leer una linea del bulk. Finalizando Hilo");
                ManejadorArchivos.bulkLeidoCompleto = true;
                return;
            }
        
            System.out.println("[LOG - HILO N°" + nroHilo + "] Linea leida: '" + linea + "'");
        
            File archivo = new File(linea);
            if(archivo.isFile()){
                ManejadorArchivos.borrarArchivo(archivo);
            } else {
                ManejadorArchivos.crearArchivo(archivo);
            }
        }
    
}
