
package com.castores.modelos;

import java.sql.Date;
import java.sql.Time;
import java.util.List;


public class publicacion {
    private int idnotapublicada;
    private String notapublicada;
    private Date fecha;
    private Time hora;
    private int idpersona;

    public int getIdnotapublicada() {
        return idnotapublicada;
    }

    public void setIdnotapublicada(int idnotapublicada) {
        this.idnotapublicada = idnotapublicada;
    }

    public String getNotapublicada() {
        return notapublicada;
    }

    public void setNotapublicada(String notapublicada) {
        this.notapublicada = notapublicada;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }
   
    
    
    
}
