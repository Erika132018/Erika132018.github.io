package modelo;

public class Partida {
    private Jugador fichasBlancas;
    private Jugador fichasNegras;
    private ResultadoPartida resultado;
    private String duracion;

    public Partida(Jugador fichasBlancas, Jugador fichasNegras, ResultadoPartida resultado, String duracion) {
        this.fichasBlancas = fichasBlancas;
        this.fichasNegras = fichasNegras;
        this.resultado = resultado;
        this.duracion = duracion;
    }
}

