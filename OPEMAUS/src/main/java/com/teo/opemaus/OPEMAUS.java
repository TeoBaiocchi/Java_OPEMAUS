package com.teo.opemaus;
import com.teo.ventanas.Logueo;
import java.util.List;

/**
 * @author Teo
 */
public class OPEMAUS {

    public static List<String> VERSION;
    public static List<String> VERSION_CHANGELOG;
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
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
    }
}
