package com.teo.modelos;

import java.time.LocalDate;

/**
 * @author Teo
 */

public class RegistroDiario {
    
    private int id;
    private LocalDate fecha;
    private String observaciones;
    private boolean incluirResumen;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public boolean isIncluirResumen() {
        return incluirResumen;
    }

    public void setIncluirResumen(boolean incluirResumen) {
        this.incluirResumen = incluirResumen;
    }
    
    
    
}
