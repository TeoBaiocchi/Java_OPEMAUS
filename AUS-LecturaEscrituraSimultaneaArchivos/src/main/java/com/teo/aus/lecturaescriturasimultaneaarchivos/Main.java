package com.teo.aus.lecturaescriturasimultaneaarchivos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Teo
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("[START: Empieza la ejecucion]");
        
        //Aprovechando el hecho de que el archivo a leer es unico y fijo, utilizo de manera 
        //estatica  un bufferedReader en la clase pertinente para centralizar y controlar más sencillamente
        //los accesos al archivo bulk.
        ManejadorArchivos.generarBufferReaderBulk();
        
        //Una pequeña verificacion para finalizar si no se pudiese leer el bulk.
        ManejadorArchivos manejador = new ManejadorArchivos();
        if(manejador.verificarBulk()){
            OrganizadorHilos programa = new OrganizadorHilos();
            programa.realizarTarea();
        } 
       
        System.out.println("[END: Finalizando programa]"); 
    }
          
}
