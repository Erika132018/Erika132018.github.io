/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author 59398
 */
public class Encuentro {

    private Equipo local;
    private Equipo visitante;
    private Date fecha;
    private String lugar;
    private EstadoEncuentro estadoEncuentro;
    private ArrayList<SancionFutbol> sancionFutbol;
    private ArrayList<MarcadorFutbol> marcadorFutbolLista;

    public Encuentro() {
    }

    public Encuentro(Equipo local, Equipo visitante, Date fecha, String lugar, EstadoEncuentro estadoEncuentro) {
        this.local = local;
        this.visitante = visitante;
        this.fecha = fecha;
        this.lugar = lugar;
        this.estadoEncuentro = estadoEncuentro;
        this.marcadorFutbolLista = new ArrayList<>();
        this.sancionFutbol = new ArrayList<>();
        this.local.agregarEncuentroList(this);
        this.visitante.agregarEncuentroList(this);
    }

    public Equipo getLocal() {
        return local;
    }

    public void setLocal(Equipo local) {
        this.local = local;
    }

    public Equipo getVisitante() {
        return visitante;
    }

    public void setVisitante(Equipo visitante) {
        this.visitante = visitante;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public EstadoEncuentro getEstadoEncuentro() {
        return estadoEncuentro;
    }

    public void setEstadoEncuentro(EstadoEncuentro estadoEncuentro) {
        this.estadoEncuentro = estadoEncuentro;
    }

    

    public ArrayList<SancionFutbol> getSancionFutbol() {
        return sancionFutbol;
    }

    public void setSancionFutbol(ArrayList<SancionFutbol> sancionFutbol) {
        this.sancionFutbol = sancionFutbol;
    }


    public ArrayList<MarcadorFutbol> getMarcadorFutbol() {
        return marcadorFutbolLista;
    }

    public void setMarcadorFutbol(ArrayList<MarcadorFutbol> marcadorFutbol) {
        this.marcadorFutbolLista = marcadorFutbol;
    }


    public void agregarMarcadorFutbol(MarcadorFutbol marcadorFutbol) {
        marcadorFutbolLista.add(marcadorFutbol);
    }

    public void agregarSancionFutbol(SancionFutbol sancion) {
        sancionFutbol.add(sancion);
    }

}
