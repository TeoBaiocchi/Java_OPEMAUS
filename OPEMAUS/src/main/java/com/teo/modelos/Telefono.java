package com.teo.modelos;

/**
 * @author Teo
 */
public class Telefono {
    private int id;
    private String nro;
    private String tipo;
    private String observaciones;
    
    public Telefono(){
        id = 0;
        nro = "";
        observaciones = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
   
}
