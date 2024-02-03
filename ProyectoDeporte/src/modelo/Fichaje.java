/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author 59398
 */
public class Fichaje {

    private Equipo equipo;
    private Jugador jugador;
    private Competencia competencia;
    private Temporada temporada;

    public Fichaje() {
    }

    public Fichaje(Equipo equipo, Jugador jugador, Competencia competencia, Temporada temporada) {
        this.equipo = equipo;
        this.jugador = jugador;
        this.competencia = competencia;
        this.temporada = temporada;
    }



    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Competencia getCompetencia() {
        return competencia;
    }

    public void setCompetencia(Competencia competencia) {
        this.competencia = competencia;
    }

    public Temporada getTemporada() {
        return temporada;
    }

    public void setTemporada(Temporada temporada) {
        this.temporada = temporada;
    }



}
