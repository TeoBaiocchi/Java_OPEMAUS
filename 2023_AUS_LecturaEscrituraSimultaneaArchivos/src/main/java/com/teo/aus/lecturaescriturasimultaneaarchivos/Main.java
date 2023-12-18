package com.teo.aus.lecturaescriturasimultaneaarchivos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {

    int CANTIDAD_HILOS = 10;
    int TIMEOUT = 60; //Tiempo que dormira entre iteraciones (en segundos)
    
    public static void main(String[] args) {
        System.out.println("[START: Empieza la ejecucion]");
        
        //Aprovechando el hecho de que el archivo a leer es unico y fijo, utilizo de manera estatica
        //un bufferedReader en la clase pertinente para centralizar y controlar más sencillamente los accesos al archivo bulk.
        ManejadorArchivos.generarBufferReaderBulk();
        
        //Misma idea, pero para escribir el log de errores.
        ManejadorArchivos.generarBufferWriterSalida();
        
        //Una pequeña verificacion para finalizar directamente si el reader/writer fueran null
        ManejadorArchivos manejador = new ManejadorArchivos();
        if(manejador.verificarBulk() && manejador.verificarSalida()){
            Main main = new Main();
            main.buclePrincipal();
        } 
       
        
        //Finalizacion de programa, cierro los reader/writer
        System.out.println("");
        try { 
            ManejadorArchivos.escritorLog.close();
            ManejadorArchivos.lectorBulk.close();
        } catch (IOException ex) {
            System.out.println("[WARNING - ARCHIVOS] Algo salio mal cerrando los archivos bulk o log"); 
        }
        
        System.out.println("[END: Finalizando programa]"); 
    }
    
   
    public void buclePrincipal(){
         
        int i = 1;
        //Cuando alguno de los hilos detecte que se llego al final del bulk, cambiará esta variable para detener la lectura.
        while(!ManejadorArchivos.bulkLeidoCompleto){
            System.out.println("\n[LOG: Iteracion N°"+ i++ +"]");
            
            //Por cada iteración, genero y comienzo la cantidad especificada de hilos.
            //Nota: Entiendo que sería ineficiente generar tantos hilos en un programa real, pero la reutilización directa
            //parece no ser posible y la alternativa era instanciar un thread pool lo cual me parecio excesivo
            List<Thread> hilos = generarHilos();
            for(Thread hilo : hilos){
                    hilo.start();
            }
           
            try { //Una vez generados, duermo el loop por 60 segundos.
                TimeUnit.SECONDS.sleep(TIMEOUT);
            } catch (InterruptedException ex) {
                System.out.println("[ERROR: Problema durmiendo el hilo principal.]");
            }
        }
        
    }
    
    public List<Thread> generarHilos(){
        List<Thread> ret = new ArrayList<Thread>();
        for(int nroHilo = 0; nroHilo < CANTIDAD_HILOS; nroHilo++) {
                HiloArchivos hiloArchivo = new HiloArchivos(nroHilo);
                Thread hilo = new Thread(hiloArchivo);
                ret.add(hilo);
            }
        return ret;
    }
          
}
