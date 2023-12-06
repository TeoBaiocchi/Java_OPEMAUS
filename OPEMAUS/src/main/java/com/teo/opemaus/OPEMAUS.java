package com.teo.opemaus;
import com.teo.util.UtilArchivos;
import com.teo.ventanas.JDialogAvisoGenerico;
import com.teo.ventanas.Logueo;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Teo
 */
public class OPEMAUS {

    public static List<String> VERSION = new ArrayList<String>();
    public static List<String> VERSION_CHANGELOG = new ArrayList<String>(); 
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
        UtilArchivos.verificarDirectorioRaiz();

        OPEMAUS.cargarVersiones(); 
        Logueo.main(args);
    }
    
    public static String obtenerUltimaVersion(){
        return VERSION.get(VERSION.size()-1);
    }
    
    public static void cargarVersiones(){
        VERSION.add("0.0.1");
        VERSION_CHANGELOG.add("Pre-Alpha: Esqueleto basico para entender la idea."
                + "\nVentanas iniciales, logueo, control de versiones, agregado de librerias"
                + "\nesenciales que eventualmente crecerán y se corregiran en medida que sea necesario");
        
        VERSION.add("0.0.2");
        VERSION_CHANGELOG.add("Agregado de dependencias gson y se agrega la lectura y escritura de clases en el util de archivos.\nFormato de fecha agregado\nOtras mejoras menores");
        
        VERSION.add("0.0.3");
        VERSION_CHANGELOG.add("Util de ventanas mejorado. Maps agregados para manejar con facilidad campos vacios/invalidos");
        
        VERSION.add("0.0.4");
        VERSION_CHANGELOG.add("Soporte de carga y eliminacion de direcciones a traves del abm de persona. Multiples util y un srv agregado."
                + "\nCorrecciones generales mayores.");
    }
    
        
}
