package com.teo.modelos;

import java.time.LocalDate;

/**
 * @author Teo
 */
public class Tarea {
    private int id;
    private String asunto;
    private String detalle;
    private int prioridad;
    private LocalDate fecha;
    private boolean sinFecha;
    private boolean fechaLimite;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public boolean isSinFecha() {
        return sinFecha;
    }

    public void setSinFecha(boolean sinFecha) {
        this.sinFecha = sinFecha;
    }

    public boolean isFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(boolean fechaLimite) {
        this.fechaLimite = fechaLimite;
    }
 
}
