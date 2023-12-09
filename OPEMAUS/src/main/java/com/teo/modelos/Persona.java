package com.teo.modelos;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Teo
 */
public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private boolean recordarCumpleanios;
    private boolean noSeCumpleanios;
    private int genero;
    private List<String> idsDirecciones;
    private List<String> idsTelefonos;
    private List<String> idsCorreos;
    private List<String> notas;
    
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

    public boolean isRecordarCumpleanios() {
        return recordarCumpleanios;
    }

    public void setRecordarCumpleanios(boolean recordarCumpleanios) {
        this.recordarCumpleanios = recordarCumpleanios;
    }

    public boolean isNoSeCumpleanios() {
        return noSeCumpleanios;
    }

    public void setNoSeCumpleanios(boolean noSeCumpleanios) {
        this.noSeCumpleanios = noSeCumpleanios;
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

    public List<String> getIdsDirecciones() {
        return idsDirecciones;
    }

    public void setIdsDirecciones(List<String> idsDirecciones) {
        this.idsDirecciones = idsDirecciones;
    }

    public List<String> getIdsTelefonos() {
        return idsTelefonos;
    }

    public void setIdsTelefonos(List<String> idsTelefonos) {
        this.idsTelefonos = idsTelefonos;
    }

    public List<String> getIdsCorreos() {
        return idsCorreos;
    }

    public void setIdsCorreos(List<String> idsCorreos) {
        this.idsCorreos = idsCorreos;
    }

    public List<String> getNotas() {
        return notas;
    }

    public void setNotas(List<String> notas) {
        this.notas = notas;
    }
    
    
}
