package com.teo.modelos;

/**
 * @author Teo
 */
public class Direccion {
    private int id;
    private String calle;
    private String nro;
    private String piso;
    private String observaciones;
    
    public Direccion(){
        id = 0;
        calle = "";
        nro = "";
        piso = "";
        observaciones = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
}
