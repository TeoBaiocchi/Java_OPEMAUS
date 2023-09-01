package com.clasediamand.cartas;

import java.util.Random;

/**
 *
 * @author ciggy
 */
public class BarajaEspaniola {
    
    Carta[] mazo; //No uso listas por consignas
    int cartasPorPalo = 12;
    int cartasTotales;
    int cartasRestantes;

    public Carta[] getMazo() {
        return mazo;
    }
    public int getCartasPorPalo() {
        return cartasPorPalo;
    }

    public int getCartasTotales() {
        return cartasTotales;
    }

    public int getCartasRestantes() {
        return cartasRestantes;
    }
    
    
    public BarajaEspaniola(){
        
        cartasTotales = EnumPalosEspaniola.values().length * cartasPorPalo;
        cartasRestantes = cartasTotales;
        mazo = new Carta[cartasTotales];
        llenarMazo();
    }
    
    private void llenarMazo(){
        Carta cartaAux;
        int indice = 0;
        for(EnumPalosEspaniola en : EnumPalosEspaniola.values()){
            
            for(int i = 0; i < cartasPorPalo; i++){
                cartaAux = new Carta(i+1, en.toString());
                mazo[indice] = cartaAux;
                indice++;
            }
            
        }
    }
    
    public void mezclar(){
        
        Carta[] nuevoMazo = new Carta[cartasTotales];
        
        int aleatorio;
        Random rand = new Random();
        boolean espacio;
        
        for(int i = 0; i < cartasTotales; i++){
            espacio = true;
            
            while(espacio) {
                aleatorio = rand.nextInt(cartasTotales);
                if(nuevoMazo[aleatorio] == null){
                    nuevoMazo[aleatorio] = mazo[i];
                    espacio = false;
                }
            }
        }
        mazo = nuevoMazo;
        System.out.println("Mazo mezclado");
    }
    
    public void imprimirMazo(){
        for(Carta carta : mazo){
            if(carta.enMazo){
                System.out.println(carta.leerCarta());
            }
        }
    }
    
    public Carta sacarCarta(){
        Carta ret = null;
        boolean bandera = true;
        Random rand = new Random();
        int aleatorio;
        while(bandera){
            aleatorio = rand.nextInt(cartasTotales);
            if(mazo[aleatorio].enMazo){
                mazo[aleatorio].enMazo = false;
                ret = mazo[aleatorio];
                bandera = false;
            }
        }
        return ret;
    }
    
    public boolean estaVacio(){
        for(Carta carta : mazo){
            if(carta.enMazo){
                return false;
            }
        }
        return true;
    }
}
