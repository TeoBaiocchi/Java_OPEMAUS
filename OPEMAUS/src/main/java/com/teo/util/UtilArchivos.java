package com.teo.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 *
 * @author ciggy
 */
public class UtilArchivos {
    
    //public static String DIRECTORIO_RAIZ = System.getProperty("user.home") + File.separator + "OPEMDATA";
    public static String DIRECTORIO_RAIZ = "E:" + File.separator + "OPEMDATA";
    public static String DIRECTORIO_PERSONAS = "REGISTROS_AGENDA" + File.separator + "PERSONAS";
    public static String DIRECTORIO_DIRECCIONES = "REGISTROS_AGENDA" + File.separator + "DIRECCIONES";
    public static String DIRECTORIO_TELEFONOS = "REGISTROS_AGENDA" + File.separator + "TELEFONOS";
    public static String DIRECTORIO_CORREOS = "REGISTROS_AGENDA" + File.separator + "CORREOS";
    public static String DIRECTORIO_TAREAS = "REGISTROS_AGENDA" + File.separator + "TAREAS";
    public static String DIRECTORIO_COMIDA = "MODELOS" + File.separator + "COMIDA";
    public static String DIRECTORIO_ACTIVIDADES = "MODELOS" + File.separator + "ACTIVIDADES";
    public static String DIRECTORIO_REGISTRO_FISICO = "REGISTROS_INFORMACION_PERSONAL" + File.separator + "REGISTRO_FISICO";
    public static String DIRECTORIO_REGISTRO_DIETA = "REGISTROS_INFORMACION_PERSONAL" + File.separator + "REGISTRO_DIETA";
    public static String DIRECTORIO_REGISTRO_DIARIO = "REGISTROS_INFORMACION_PERSONAL" + File.separator + "REGISTRO_DIARIO";
    
    
    //Verifica que si o si exista el directorio base para trabajar.
    //Si no existe, intenta crearlo, y si fallase por algun motivo devuelve
    //False para que el main maneje el cierre del programa.
    public static boolean verificarDirectorioRaiz(){
        System.out.println("[LOG - INICIO] Verificando integridad del directorio ");
        
        boolean bandera = true;
        
        if(!crearDirectorio("")){
            bandera = false;
        }
        if(!crearDirectorio(File.separator + DIRECTORIO_PERSONAS)){
            bandera = false;
        }
        if(!crearDirectorio(File.separator + DIRECTORIO_DIRECCIONES)){
             bandera = false;
        }
        if(!crearDirectorio(File.separator + DIRECTORIO_TELEFONOS)){
             bandera = false;
        }
        if(!crearDirectorio(File.separator + DIRECTORIO_CORREOS)){
             bandera = false;
        }
        if(!crearDirectorio(File.separator + DIRECTORIO_TAREAS)){
             bandera = false;
        }
        if(!crearDirectorio(File.separator + DIRECTORIO_REGISTRO_FISICO)){
             bandera = false;
        }
        if(!crearDirectorio(File.separator + DIRECTORIO_REGISTRO_DIARIO)){
             bandera = false;
        }
        if(!crearDirectorio(File.separator + DIRECTORIO_REGISTRO_DIETA)){
             bandera = false;
        }
        if(!crearDirectorio(File.separator + DIRECTORIO_ACTIVIDADES)){
             bandera = false;
        }
        if(!crearDirectorio(File.separator + DIRECTORIO_COMIDA)){
             bandera = false;
        }
       
        System.out.println("[LOG - INICIO] Verificacion completa!");
        return true;
    }
    
    public static boolean crearDirectorio(String path){
        File archivo = new File(DIRECTORIO_RAIZ + path);
        if (!archivo.exists()){
            return archivo.mkdirs();
        } else {
            return false;
        }
    }
    
    public static boolean eliminarArchivo(String path){
        File archivo = new File(path);
        return eliminarArchivo(archivo);
    }
    public static boolean eliminarArchivo(File archivo){
        return archivo.delete();
    }
    
    public static void crearArchivo(String path){
        crearArchivo(new File(DIRECTORIO_RAIZ + File.separator + path));
    }
    public static void crearArchivo(File archivo){
        try {
            if (archivo.createNewFile()) {
              System.out.println("[LOG - ARCHIVOS] Archivo creado correctamente: " + archivo.getPath());
            } else {
              System.out.println("[WARNING - ARCHIVOS] No se pudo crear el archivo '" + archivo.getPath() + "' porque ya existia.");
            }
          } catch (IOException e) {
            System.out.println("[ERROR - ARCHIVOS] Algo salio mal creando el archivo '" + archivo.getPath() +"' ("+e+")");
          }
    }
    
    public static void crearEscribirArchivo(String path, String contenido){
        crearArchivo(path);
        escribirArchivo(path, contenido);
    }
    
    public static void escribirArchivo(String path, String contenido){
        escribirArchivo(new File(DIRECTORIO_RAIZ + File.separator + path), contenido);
    }
    public static void escribirArchivo(File archivo, String contenido){
        contenido = contenido.trim();
        if(!contenido.equals("")){
            BufferedWriter salida;          
            try {
                salida = new BufferedWriter(new FileWriter(archivo));
                salida.write(contenido);
                salida.flush();
            } catch (IOException ex) {
                System.out.println("[ERROR - ARCHIVOS] Algo salio mal escribiendo en el archivo '" + archivo.getPath() +"' ("+ex+")");
            }        
        }
    }
    
    
    public static List<String> obtenerArchivosEnDirectorioString(String path, boolean recortarExtension){
        return obtenerArchivosEnDirectorioString(path, recortarExtension, true);
    }
 
    public static List<String> obtenerArchivosEnDirectorioString(String path, boolean recortarExtension, boolean agregarDirectorioRaiz){
        List<String> ret = new ArrayList<>();
        for(File archivo : obtenerArchivosEnDirectorio(path, agregarDirectorioRaiz)){
            if(recortarExtension){
                ret.add(archivo.getName().substring(0, archivo.getName().lastIndexOf('.')));
            } else {
                ret.add(archivo.getName());
            }
        }
        return ret;
    }
    
    public static List<File> obtenerArchivosEnDirectorio(String path){
        return obtenerArchivosEnDirectorio(path, true);
    }
    public static List<File> obtenerArchivosEnDirectorio(String path, boolean incluirDirectorioRaiz){
        
        File dir;
        if(incluirDirectorioRaiz){
            dir = new File(DIRECTORIO_RAIZ + File.separator + path);    
        } else {
            dir = new File(path);
        }
                
        List<File> ret = new ArrayList<>();
        ret.addAll(Arrays.asList(dir.listFiles()));
        Collections.sort(ret);
        
        return ret;
    }

    /**
     * Toma un archivo y devuelve sus lineas en un string.
     * De haber algun problema, devuelve lo que se haya podido leer, o string vacio.
     * @param archivo
     * @return 
     */
    public static String leerContenidoArchivo(File archivo) {
        BufferedReader reader;
        String ret = "";
        
        try {
            reader = new BufferedReader(new FileReader(archivo));
        } catch (FileNotFoundException ex) {
            //TODO mensaje error
            return ret;
        }
        
        String linea;
        try {
            while ((linea = reader.readLine()) != null) {
                ret = ret + linea;
            }
        } catch (IOException ex) {
            //TODO mensaje error
            return ret;
        }
        return ret;
    }
    
    public static String seleccionarDirectorio(String pathBase, JFrame padre){
        JFileChooser chooser = new JFileChooser(); 
        chooser.setCurrentDirectory(new java.io.File(pathBase));
        chooser.setDialogTitle("Seleccionar Directorio");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(padre) == JFileChooser.APPROVE_OPTION) { 
            return chooser.getSelectedFile().toString();
        } else {
            return "";
        }
    }
}
