/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.teo.util;

import com.teo.ventanas.AbmPersona;
import com.teo.ventanas.AbmTareas;
import com.teo.ventanas.JDialogCerrarPrograma;
import com.teo.ventanas.ListadoPersonas;
import com.teo.ventanas.Menu;
import java.awt.Color;
import static java.awt.Color.RGBtoHSB;
import javax.swing.JFrame;

/**
 * @author Teo
 */
public class FlujoVentanas {

    public static Color COLOR_VERDECLARO = Color.getHSBColor(RGBtoHSB(153, 255, 153, null)[0], RGBtoHSB(153, 255, 153, null)[1], RGBtoHSB(153, 255, 153, null)[2]);
   
    private static String FRAME_AL_QUE_VOLVER = "";
    public static String FRAME_MENU = "Menu";
    public static String FRAME_LISTADOPERSONAS = "ListadoPersonas";
    public static String FRAME_ABMPERSONAS = "AbmPersonas";
    public static String FRAME_ABMTAREAS = "AbmTareas";
    public static String CERRAR_PROGRAMA = "Salir";
    
    private static AbmPersona abmPersona = null;
    private static AbmTareas abmTareas = null;
    private static ListadoPersonas listadoPersonas = null;
    private static Menu menu = null;

    
    public static void volver(JFrame frame){
        if(FRAME_AL_QUE_VOLVER.equals(FRAME_MENU)){
            abrirMenu(frame);
            FRAME_AL_QUE_VOLVER = CERRAR_PROGRAMA;
            return;
        }
        if(FRAME_AL_QUE_VOLVER.equals(FRAME_LISTADOPERSONAS)){
            abrirListado(frame);
            FRAME_AL_QUE_VOLVER = FRAME_MENU;
            return;
        }
        if(FRAME_AL_QUE_VOLVER.equals(FRAME_ABMPERSONAS)){
            abrirAbmPersonas(frame);
            FRAME_AL_QUE_VOLVER = FRAME_MENU;
            return;
        }
        if(FRAME_AL_QUE_VOLVER.equals(FRAME_ABMTAREAS)){
            abrirAbmTareas(frame);
            FRAME_AL_QUE_VOLVER = FRAME_MENU;
            return;
        }
        if(FRAME_AL_QUE_VOLVER.equals(CERRAR_PROGRAMA)){
            System.exit(0);
        }
    }
    
    public static void abrirMenu(JFrame frameLlamado){
        frameLlamado.dispose();
        menu = new Menu();
    }
    
    public static void abrirAbmPersonas(JFrame frameLlamado){
        frameLlamado.dispose();
        abrirAbmPersonas(frameLlamado, 0);
    }
    public static void abrirAbmPersonas(JFrame frameLlamado, int id){
        frameLlamado.dispose();
        abmPersona = new AbmPersona(id);
    }
    
    public static void abrirAbmTareas(JFrame frameLlamado){
        frameLlamado.dispose();
        abrirAbmTareas(frameLlamado, 0);
    }
    public static void abrirAbmTareas(JFrame frameLlamado, int id){
        frameLlamado.dispose();
        abmTareas = new AbmTareas(id);
    }
    
            
    public static void abrirListado(JFrame frameLlamado){
        frameLlamado.dispose();
        listadoPersonas = new ListadoPersonas();
    }
    
    public static void setearFrameParaVolver(String nombre){
        FRAME_AL_QUE_VOLVER = nombre;
    }
    
    public static int confirmarCerrarPrograma(JFrame frameLlamado){
        JDialogCerrarPrograma dialog = new JDialogCerrarPrograma(frameLlamado, true);
        return 0;
    }
    
}
   
