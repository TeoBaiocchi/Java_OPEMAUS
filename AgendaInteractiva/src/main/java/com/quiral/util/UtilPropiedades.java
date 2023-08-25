
package com.quiral.util;

import javax.swing.JLabel;

/**
 * @author Teo
 */
public class UtilPropiedades {
    String version = "0.0.1";
    String JDKVersion = "(Open) Oracle 17.0.2";

    
    public void mensajeVersion(JLabel label){
        label.setText("Version: " + version + " / JDK: " + JDKVersion);
    }
    
    public String getVersion() {
        return version;
    }
    
    public String getJDKVersion() {
        return JDKVersion;
    }
}
