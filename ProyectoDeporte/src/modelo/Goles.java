/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author 59398
 */
public class Goles {

    private Jugador jugador;
    private MarcadorFutbol marcadorFutbol;
    private int goles;

    public Goles() {
    }

    public Goles(Jugador jugador, MarcadorFutbol marcador, int goles) {
        this.jugador = jugador;
        this.marcadorFutbol = marcador;
        this.goles = goles;
        this.jugador.agregarGolesList(this);
        this.marcadorFutbol.agregarGolesList(this);
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public MarcadorFutbol getMarcadorFutbol() {
        return marcadorFutbol;
    }

    public void setMarcadorFutbol(MarcadorFutbol marcadorFutbol) {
        this.marcadorFutbol = marcadorFutbol;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

}
