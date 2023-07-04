package modelo;

import java.util.Date;

public class SancionBasket {

    private String nombre;
    private Date fecha;
    private int minutos;
    private Jugador jugador;
    private Encuentro encuentro;

    private TipoSancionBasket tipoSancionBasket;


    public SancionBasket() {
    }

    public SancionBasket(String nombre, Date fecha, TipoSancionBasket tipoSancionBasket, int minutos, Jugador jugador, Encuentro encuentro) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.minutos = minutos;
        this.jugador = jugador;
        this.encuentro = encuentro;
        this.tipoSancionBasket = tipoSancionBasket;
    }


}
