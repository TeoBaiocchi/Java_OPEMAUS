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
    
    private String llamadoDesde = "";
    private String nombreFrame = "";
    private JFrame frame = null;

    public UtilControlVentanas(JFrame frame, String nombreFrame, String llamadoDesde) {
        this.frame = frame;
        this.llamadoDesde = llamadoDesde;
        this.nombreFrame = nombreFrame;
    }
    
    public void volver(){
        frame.dispose();
        if(llamadoDesde.equals("Menu")){
            Menu.main();
        }
        if(llamadoDesde.equals("ListadoPersonas")){
            abrirListado();
        }
        if(llamadoDesde.equals("AbmPersonas")){
            abrirAbmPersonas();
        }
        if(llamadoDesde.equals("")){
            System.exit(0);
        }
    }
    
    public void abrirAbmPersonas(){
        abrirAbmPersonas(0);
    }
    public void abrirAbmPersonas(int id){
        frame.dispose();
        AbmPersona.main(new String[]{});
    }
            
    public void abrirListado(){
        frame.dispose();
        ListadoPersonas.main(llamadoDesde);
    }

}
   
