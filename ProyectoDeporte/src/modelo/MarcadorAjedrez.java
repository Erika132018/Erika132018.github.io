/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author A S U S
 */
public class MarcadorAjedrez {
    private EncuentroAjedrez encuentro;
    private Jugador jugadorBlancas;
    private Jugador jugadorNegras;
    private ResultadoAjedrez resultado;

    public MarcadorAjedrez(EncuentroAjedrez encuentro, Jugador jugadorBlancas, Jugador jugadorNegras, ResultadoAjedrez resultado) {
        this.encuentro = encuentro;
        this.jugadorBlancas = jugadorBlancas;
        this.jugadorNegras = jugadorNegras;
        this.resultado = resultado;
    }

    public EncuentroAjedrez getEncuentro() {
        return encuentro;
    }

    public void setEncuentro(EncuentroAjedrez encuentro) {
        this.encuentro = encuentro;
    }

    public Jugador getJugadorBlancas() {
        return jugadorBlancas;
    }

    public void setJugadorBlancas(Jugador jugadorBlancas) {
        this.jugadorBlancas = jugadorBlancas;
    }

    public Jugador getJugadorNegras() {
        return jugadorNegras;
    }

    public void setJugadorNegras(Jugador jugadorNegras) {
        this.jugadorNegras = jugadorNegras;
    }

    public ResultadoAjedrez getResultado() {
        return resultado;
    }

    public void setResultado(ResultadoAjedrez resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "MarcadorAjedrez{" +
                "encuentro=" + encuentro +
                ", jugadorBlancas=" + jugadorBlancas +
                ", jugadorNegras=" + jugadorNegras +
                ", resultado=" + resultado +
                '}';
    }


    public void presentarMarcadorAjedrez() {
    System.out.println("Marcador Ajedrez:");
    System.out.println("=================");
    System.out.println("Encuentro: " + encuentro.getJugadorBlancas().getNombre() + " vs " + encuentro.getJugadorNegras().getNombre());
    System.out.println("Resultado: " + resultado);
    System.out.println("Fecha del encuentro: " + encuentro.getFecha());
}
}
