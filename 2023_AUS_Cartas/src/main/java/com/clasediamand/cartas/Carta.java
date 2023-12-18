/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clasediamand.cartas;

/**
 *
 * @author ciggy
 */
public class Carta {
    
    int valor;
    String palo;
    boolean enMazo;
    
    public Carta(int valor, String palo){
        this.valor = valor;
        this.palo = palo;
        this.enMazo = true;
    }
    
    public String leerCarta(){
        String ret = valor + " de " + palo;
        return ret;
    }
    
    
}
