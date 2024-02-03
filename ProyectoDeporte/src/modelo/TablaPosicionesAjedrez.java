/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.ArrayList;


/**
 *
 * @author A S U S
 */
public class TablaPosicionesAjedrez {
    private ArrayList<JugadorAjedrez> jugadores;

    public TablaPosicionesAjedrez() {
        jugadores = new ArrayList<>();
    }

    public void agregarJugador(JugadorAjedrez jugador) {
        jugadores.add(jugador);
    }

    public void registrarPartida(String jugador1, String jugador2, int resultado) {
        if (resultado == 1) {
            encontrarJugador(jugador1).sumarPuntos(1);
        } else if (resultado == -1) {
            encontrarJugador(jugador2).sumarPuntos(1);
        } else if (resultado == 0) {
            encontrarJugador(jugador1).sumarPuntos((int) 0.5);
            encontrarJugador(jugador2).sumarPuntos((int) 0.5);
        }
    }

    private JugadorAjedrez encontrarJugador(String nombre) {
        for (JugadorAjedrez jugador : jugadores) {
            if (jugador.getNombre().equals(nombre)) {
                return jugador;
            }
        }
        return null;
    }

    public void presentarTablaPosiciones() {
        System.out.println("Tabla de Posiciones Ajedrez:");
        System.out.println("===========================");
        for (int i = 0; i < jugadores.size(); i++) {
            JugadorAjedrez jugador = jugadores.get(i);
            System.out.println((i + 1) + ". " + jugador.getNombre() + " - Puntos: " + jugador.getPuntos());
        }
    }
}