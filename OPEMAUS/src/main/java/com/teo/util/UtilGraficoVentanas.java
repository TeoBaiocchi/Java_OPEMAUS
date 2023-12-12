package com.teo.util;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Teo
 */
public class UtilGraficoVentanas {
    
    /**
     * Dado un frame, obtiene el graphics device (monitor) al que pertenezca, y obtiene la altura del mismo mediante otra funcion.
     * @param frame
     * @return 
     */
    private static int obtenerScreenHeightMonitorDinamicoFrame(JFrame frame){
       GraphicsDevice gd = frame.getGraphicsConfiguration().getDevice();
       return obtenerScreenHeightMonitorDinamico(gd);
    }
    public static int obtenerScreenHeightMonitorDinamicoFrame(JDialog frame){
       GraphicsDevice gd = frame.getGraphicsConfiguration().getDevice();
       return obtenerScreenHeightMonitorDinamico(gd);
    }
    
    private static int obtenerScreenHeightMonitorDinamico(GraphicsDevice gd){
       return gd.getDisplayMode().getHeight();
    }
    

     /**
     * Dado un frame, obtiene el graphics device (monitor) al que pertenezca, y obtiene el ancho del mismo mediante otra funcion.
     * @param frame
     * @return 
     */
    private static int obtenerScreenWidthMonitorDinamicoFrame(JFrame frame){
       GraphicsDevice gd = frame.getGraphicsConfiguration().getDevice();
       return obtenerScreenWidthMonitorDinamico(gd);
    }
    public static int obtenerScreenWidthMonitorDinamicoFrame(JDialog frame){
       GraphicsDevice gd = frame.getGraphicsConfiguration().getDevice();
       return obtenerScreenWidthMonitorDinamico(gd);
    }

    private static int obtenerScreenWidthMonitorDinamico(GraphicsDevice gd){
       return gd.getDisplayMode().getWidth();
    }

    public static void repaintearFrame(JFrame frame, int posX, int posY){
        //Es necesario pintar el frame en la posicion en la que va a estar (actualizar el x), para poder determinar el monitor al que pertenece.
        frame.setBounds(posX, posY, 0, 0);
        frame.setVisible(true);
        frame.setVisible(false);
        frame.repaint();
    }
 
    /**
     * Tomando un frame, y un panel general que contenga todo el contenido de la ventana, 
     * hace un reshape de la ventana ajustado a todas las variables relevantes.
     * IMPORTANTE: Si se enva posY o posX = 0, centra ese eje de la ventana en el monitor donde se dispong el frame.
     * @param frame
     * @param panelReferencia
     * @param posX 
     * @param posY
     */
    public static void reshapeadorVentanas(JFrame frame, JPanel panelReferencia, int posX, int posY){
        int screenHeight;
        int screenWidth;
        screenHeight = obtenerScreenHeightMonitorDinamicoFrame(frame);
        screenWidth = obtenerScreenWidthMonitorDinamicoFrame(frame);
        
        Insets pantallaBarraInsets = obtenerInsetsBarraTareas(frame);
        Insets frameInsets = frame.getInsets();

        int alto = panelReferencia.getHeight() + frameInsets.top + frameInsets.bottom;
        int ancho = panelReferencia.getWidth() + frameInsets.right + frameInsets.left;
        //En caso de que alguno de estos dos campos venga en "0", centramos sobre ese eje.
        if(posY == 0){
            posY = (screenHeight - alto - pantallaBarraInsets.bottom - pantallaBarraInsets.top)/2; 
        }
        
        if(posX == 0){
            posX = (screenWidth - ancho - pantallaBarraInsets.left - pantallaBarraInsets.right)/2;
        }
        
        
        int clipeoVertical = screenHeight - (posY + alto + pantallaBarraInsets.bottom + pantallaBarraInsets.top);
        if(clipeoVertical < 0){
            posY = posY + clipeoVertical;
            if(posY <= 0){
                posY = 2;
            }
        }
        
        frame.setBounds(posX, posY, ancho, alto);
    }
    public static void reshapeadorVentanas(JFrame frame, JPanel panelReferencia){
        reshapeadorVentanas(frame, panelReferencia, 0, 0);
    }
    
    
    public static void dimensionadorDialog(JDialog frame, JPanel panelReferencia, Frame padre){
        //En caso de un dialog no necesito reposicionarlo, porque va a tener un padre y un setlocation relative to.
        int posX = padre.getX();
        frame.setBounds(posX, 0, 0, 0);
        frame.repaint();
        //Es necesario pintar el frame en la posicion en la que va a estar (actualizar el x), para poder determinar el monitor al que pertenece.
        
        Insets pantallaBarraInsets = obtenerInsetsBarraTareas(frame);
        Insets frameInsets = frame.getInsets();

        int alto = panelReferencia.getHeight() + frameInsets.top + frameInsets.bottom;
        int ancho = panelReferencia.getWidth() + frameInsets.right + frameInsets.left;
        //En caso de que alguno de estos dos campos venga en "0", centramos sobre ese eje.

        frame.setBounds(0, 0, ancho, alto);
        frame.setLocationRelativeTo(padre);
    }
    
    public static Insets obtenerInsetsBarraTareas(JFrame frame){
        GraphicsConfiguration gc = frame.getGraphicsConfiguration();
        return Toolkit.getDefaultToolkit().getScreenInsets(gc);
    }
    public static Insets obtenerInsetsBarraTareas(JDialog frame){
        GraphicsConfiguration gc = frame.getGraphicsConfiguration();
        return Toolkit.getDefaultToolkit().getScreenInsets(gc);
    }
    
    public static int obtenerAltoUtilizableMaximoEnMonitorDinamico(JFrame frame){
        int calculo = 0;
        int altura = obtenerScreenHeightMonitorDinamicoFrame(frame);
        Insets barraTareas = obtenerInsetsBarraTareas(frame);
        Insets frameInsets = frame.getInsets();
        calculo = altura - barraTareas.bottom - barraTareas.top - frameInsets.top - frameInsets.bottom;
        return calculo;
    }


    public static void resizearDialog(JDialog dialog, Frame padre, JPanel panelReferencia) {
        dialog.setBounds(0, 0, panelReferencia.getWidth(), panelReferencia.getHeight() + padre.getInsets().top + padre.getInsets().bottom);
        dialog.setLocationRelativeTo(padre);
    }


   
}
