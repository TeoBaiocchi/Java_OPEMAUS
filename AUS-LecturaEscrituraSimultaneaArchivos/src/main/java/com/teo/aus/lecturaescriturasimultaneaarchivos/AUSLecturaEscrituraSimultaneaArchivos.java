package com.teo.aus.lecturaescriturasimultaneaarchivos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Teo
 */
public class AUSLecturaEscrituraSimultaneaArchivos {

    public static void main(String[] args) {
        System.out.println("Programa corriendo");
        
        BufferedReader lector = ManejadorArchivos.generarBufferReaderBulk();
        if(lector == null){
            System.out.println("Hubo un error leyendo bulk.txt - Cerrando programa");
            return;
        }
        
        for(int i = 0; i < 12; i++){
            HiloArchivos hiloArchivo = new HiloArchivos(i, lector);
            Thread hilo = new Thread(hiloArchivo);
            hilo.start();
            
        }
    }
}
