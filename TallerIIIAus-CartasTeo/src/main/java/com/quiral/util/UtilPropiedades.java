
package com.quiral.util;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JLabel;

/**
 * @author Teo
 */
public class UtilPropiedades {
    static String version = "0.0.1";
    static String JDKVersion = "(Open) Oracle 17.0.2";

    
    static public void mensajeVersion(JLabel label){
        label.setText("Version: " + version + " / JDK: " + JDKVersion);
    }
    
    static public String getVersion() {
        return version;
    }
    
    static public String getJDKVersion() {
        return JDKVersion;
    }
    

    static public String getChangeLogUltimaVersion(){
        String retorno = "";
        Map versiones = new HashMap();
        versiones.put("0.0.1", ""
                + "Version inicial\n"
                + "Inicializacion de esqueletos de lo que serán posteriormente clases utilitarias "
                + "y ventanas a modo de placeholder.\n"
                + "Utilizo OpenJDK Oracle 17.0.2");
        
        versiones.put(3, 6);
        retorno = versiones.get(3).toString();
        
        retorno = versiones.get(version).toString();
        return retorno;
    }
}
