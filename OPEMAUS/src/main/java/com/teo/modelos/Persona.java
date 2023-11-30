package com.teo.modelos;

import java.time.LocalDate;

/**
 * @author Teo
 */
public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private int genero;
    
    public Persona(){
        id = 0;
        nombre = "";
        apellido = "";
        genero = -1;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }
}
