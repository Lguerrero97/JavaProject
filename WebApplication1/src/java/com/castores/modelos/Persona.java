
package com.castores.modelos;

import java.sql.Date;


public class Persona {
    private int idpersona;
    private String appaterno;
    private String apmaterno;
    private String nombre;
    private String direccion;
    private String fechaingreso;
    private boolean esexterno;
    private String contrasenia;

    public Persona() {
    }

    public Persona(int idpersona, String appaterno, String apmaterno, String nombre, String direccion, String fechaingreso, boolean esexterno, String contrasenia) {
        this.idpersona = idpersona;
        this.appaterno = appaterno;
        this.apmaterno = apmaterno;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaingreso = fechaingreso;
        this.esexterno = esexterno;
        this.contrasenia = contrasenia;
    }

   

    

    
    
    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public String getAppaterno() {
        return appaterno;
    }

    public void setAppaterno(String appaterno) {
        this.appaterno = appaterno;
    }

    public String getApmaterno() {
        return apmaterno;
    }

    public void setApmaterno(String apmaterno) {
        this.apmaterno = apmaterno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(String fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public boolean isEsexterno() {
        return esexterno;
    }

    public void setEsexterno(boolean esexterno) {
        this.esexterno = esexterno;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    
}
