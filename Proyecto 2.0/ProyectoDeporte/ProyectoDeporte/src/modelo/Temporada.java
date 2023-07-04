/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author 59398
 */
public class Temporada {
    private Date fechaInicio;
    private Date fechaFin;
    private String nombreTemporada;

    public Temporada() {
    }

    public Temporada(Date fechaInicio, Date fechaFin, String nombreTemporada) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.nombreTemporada = nombreTemporada;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getNombreTemporada() {
        return nombreTemporada;
    }

    public void setNombreTemporada(String nombreTemporada) {
        this.nombreTemporada = nombreTemporada;
    }



}
