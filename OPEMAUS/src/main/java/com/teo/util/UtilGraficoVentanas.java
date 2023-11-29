package com.teo.util;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Teo
 */
public class UtilGraficoVentanas {
    
    Frame frame;
    Dialog dialog;
    Frame padreDialog;
    JPanel panelReferencia; 
    int posX; 
    int posY;
    
    public void setPosX(int x){
        if(x < 0){
            posX = 0;
            //TODO: Entrada de log
        }
    }
    
    public void setPosY(int y){
        if(y < 0){
            posY = 0;
            //TODO: Entrada de log
        }
    }
    
    public UtilGraficoVentanas(Frame frame, JPanel panelReferencia, int posX, int posY){
        this.frame = frame;
        this.panelReferencia = panelReferencia;
        setPosX(posX);
        setPosY(posY);
    }
    public UtilGraficoVentanas(Dialog dialog, JPanel panelReferencia, Frame padre){
        this.dialog = dialog;
        this.padreDialog = padre;
        this.panelReferencia = panelReferencia;
        setPosX(0);
        setPosY(0);
    }
    
    /**
     * Obtiene el alto del monitor principal. No dependiente de como este instanciado el objeto
     * @return 
     */
    public static int obtenerScreenHeightDefault(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return screenSize.height;
    }
    
    /**
     * Obtiene el ancho del monitor principal. No dependiente de como este instanciado el objeto
     * @return 
     */
    public static int obtenerScreenWidthDefault(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return screenSize.width;
    }
    
    
    /**
     * Obtiene el GraphicsDevice del frame/dialog de la instancia, y devuelve su altura
     * (toma el monitor en el que se encuentra la esquina superior izquierda de la
     * ventana)
     */
    public int obtenerScreenHeightMonitorDinamico(){
        
        GraphicsDevice gd = null;
        
        if(frame != null){
            gd = frame.getGraphicsConfiguration().getDevice();
        } else if(dialog != null){
            gd = dialog.getGraphicsConfiguration().getDevice();
        }
        
        if(gd != null){
            return gd.getDisplayMode().getHeight();
        } else {
            return 0;
        }
        
    }

    /**
     * Obtiene el GraphicsDevice del frame de la instancia, y devuelve su ancho
     * (toma el monitor en el que se encuentra la esquina superior izquierda de la
     * ventana)
     */
    public int obtenerScreenWidthMonitorDinamico(){
        GraphicsDevice gd = frame.getGraphicsConfiguration().getDevice();
        return gd.getDisplayMode().getWidth();
    }

    
    /**
     * Redimensiona la ventana segun el panel de referencia y las posiciones del objeto.
     * Primero repinta un posX inicial para obtener el monitor correcto, luego calcula
     * las dimensiones de la pantalla y las esquinas a desestimar de la pantalla y frame
     * para poder centrarlo correctamente en los ejes.
     * Si el ejeX o el ejeY son 0, la ventana será centrada en ese eje.
     * WIP: En caso de que las posiciones XY esten indicadas, pero causen que la ventana
     * clipee en alguna direccion, reposicionar de forma que quede al borde pero sin clipear
     * IMPORTANTE: El aspecto de redimensión de ventana solo es util ante NULL LAYOUT
     */
    public void redimensionarReposicionarVentanaEscalonadamente(){
    }
    public void redimensionarReposicionarVentana(){    
        frame.setBounds(posX, 0, 0, 0);
        frame.repaint();
        //Es necesario pintar el frame en la posicion en la que va a estar, para poder determinar el monitor al que pertenece
        int screenHeight = obtenerScreenHeightMonitorDinamico(); 
        int screenWidth = obtenerScreenWidthMonitorDinamico();
        
        Insets pantallaBarraInsets = obtenerInsetsBarraTareas();
        Insets frameInsets = frame.getInsets();

        int alto = panelReferencia.getHeight() + frameInsets.top + frameInsets.bottom;
        int ancho = panelReferencia.getWidth() + frameInsets.right + frameInsets.left;
        if(posY == 0){
            posY = (screenHeight - alto - pantallaBarraInsets.bottom - pantallaBarraInsets.top)/2; 
        }
        if(posX == 0){
            posX = (screenWidth - ancho - pantallaBarraInsets.left - pantallaBarraInsets.right)/2;
        }
        
        frame.setBounds(posX, posY, ancho, alto);
    }
    
    public Insets obtenerInsetsBarraTareas(){
        GraphicsConfiguration gc = frame.getGraphicsConfiguration();
        return Toolkit.getDefaultToolkit().getScreenInsets(gc);
    }
    
    public int obtenerAltoUtilizableMaximoEnMonitorDinamico(){
        int calculo = 0;
        Insets barraTareas = obtenerInsetsBarraTareas();
        Insets frameInsets = frame.getInsets();
        calculo = obtenerScreenHeightMonitorDinamico() - barraTareas.bottom - barraTareas.top - frameInsets.top - frameInsets.bottom;
        return calculo;
    }
    
    public void centrarFrameSobreFrame(JFrame nuevoFrame){
        //Paso 1: Verificar y obtener "jpanel1" si es el primer hijo del nuevo frame.
        //Paso 2: Corroborar que el nuevo frame sea, en ambas dimensiones, menor al frame padre
        //Paso 2: instanciar un nuevo UtilGraficoVentanas para ese nuevo frame con todos los datos
    
    }
   
}
