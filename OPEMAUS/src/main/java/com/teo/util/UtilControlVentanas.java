/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.teo.util;

import com.teo.ventanas.AbmPersona;
import com.teo.ventanas.ListadoPersonas;
import com.teo.ventanas.Menu;
import javax.swing.JFrame;

/**
 * @author Teo
 */
public class UtilControlVentanas {
    
    private static String frameVolver = "";
    public static String VOLVER_MENU = "Menu";
    public static String VOLVER_LISTADOPERSONAS = "ListadoPersonas";
    public static String VOLVER_ABMPERSONAS = "AbmPersonas";
    public static String VOLVER_CERRARPROGRAMA = "Salir";
    
    private static AbmPersona abmPersona = null;
    private static ListadoPersonas listadoPersonas = null;
    private static Menu menu = null;

    
    public static void volver(JFrame frame){
        if(frameVolver.equals(VOLVER_MENU)){
            abrirMenu(frame);
        }
        if(frameVolver.equals(VOLVER_LISTADOPERSONAS)){
            abrirListado(frame);
        }
        if(frameVolver.equals(VOLVER_ABMPERSONAS)){
            abrirAbmPersonas(frame);
        }
        if(frameVolver.equals(VOLVER_CERRARPROGRAMA)){
            System.exit(0);
        }
    }
    
    public static void abrirMenu(JFrame frame){
        frame.dispose();
        menu = new Menu();
    }
    
    public static void abrirAbmPersonas(JFrame frame){
        frame.dispose();
        abrirAbmPersonas(frame, 0);
    }
    public static void abrirAbmPersonas(JFrame frame, int id){
        frame.dispose();
        abmPersona = new AbmPersona(id, "");
    }
            
    public static void abrirListado(JFrame frame){
        frame.dispose();
        listadoPersonas = new ListadoPersonas();
    }
    
    public static void setearFrameParaVolver(String nombre){
        frameVolver = nombre;
    }
    
}
   
