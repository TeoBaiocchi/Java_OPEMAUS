package com.teo.aus.lecturaescriturasimultaneaarchivos;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Teo
 */
public class OrganizadorHilos {
    
    int CANTIDAD_HILOS = 10;
    int TIMEOUT = 3; //Tiempo que dormira entre iteraciones (en segundos)
    
    public void realizarTarea(){
        
        
        //Cuando alguno de los hilos detecte que se llego al final del bulk, cambiará esta variable para detener la lectura.
        while(!ManejadorArchivos.bulkLeidoCompleto){
            
            
            List<Thread> hilos = generarHilos();
            for(Thread hilo : hilos){
                    hilo.start();
            }
           
            //Generamos la pausa hasta la proxima iteración...
            try {
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
