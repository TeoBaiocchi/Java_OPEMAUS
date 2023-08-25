package com.quiral.util;

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Teo
 */
public class UtilMonitor {
    
    JFrame frame;
    JPanel panelReferencia; 
    int posX; 
    int posY;
    
    public UtilMonitor(JFrame frame, JPanel panelReferencia, int posX, int posY){
        this.frame = frame;
        this.panelReferencia = panelReferencia;
        this.posX = posX;
        this.posY = posY;
    }
        
    public int obtenerScreenHeightDefault(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return screenSize.height;
    }
    
    public int obtenerScreenWidthDefault(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return screenSize.width;
    }
    
    
    /**
     * Dado un GraphicsDevice (monitor) obtiene su altura, en base al frame.
     * @param gd
     * @return 
     */
    public int obtenerScreenHeightMonitorDinamico(){
        GraphicsDevice gd = frame.getGraphicsConfiguration().getDevice();
        return gd.getDisplayMode().getHeight();
    }

    /**
     * Dado un GraphicsDevice (monitor) obtiene su ancho.
     * @param gd
     * @return 
     */
    public int obtenerScreenWidthMonitorDinamico(){
        GraphicsDevice gd = frame.getGraphicsConfiguration().getDevice();
        return gd.getDisplayMode().getWidth();
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
    
}
