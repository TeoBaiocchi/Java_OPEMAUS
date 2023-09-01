/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.clasediamand.cartas;

/**
 *
 * @author ciggy
 */
public enum EnumPalosEspaniola {
    
    ESPADA("Espada"),
    BASTO("Basto"),
    COPA("Copa"),
    ORO("Oro");
    
    private String nombre;
    
    private EnumPalosEspaniola(String nombre){
        this.nombre = nombre;
    }
    
    @Override
    public String toString(){
        return this.nombre;
    }
}
