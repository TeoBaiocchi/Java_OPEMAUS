package com.teo.modelos;

/**
 * @author Teo
 */
public class Correo {
    private int id;
    private String correo;
    private boolean personal;
    private String observaciones;
    
    public Correo(){
        id = 0;
        correo = "";
        observaciones = "";
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    public boolean isPersonal() {
        return personal;
    }

    public void setPersonal(boolean personal) {
        this.personal = personal;
    }
    
}
