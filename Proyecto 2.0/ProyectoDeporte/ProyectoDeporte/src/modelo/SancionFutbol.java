package modelo;

import java.util.Date;

public class SancionFutbol {

    private Date fecha;
    private TipoSancionFutbol tipoSancionFutbol;
    private Encuentro encuentro;
    private Jugador jugador;
    private EstadoSancion estadoSancion;

    public SancionFutbol(Date fecha, TipoSancionFutbol tipoSancionFutbol, Encuentro encuentro, Jugador jugador, EstadoSancion estadoSancion) {
        this.fecha = fecha;
        this.tipoSancionFutbol = tipoSancionFutbol;
        this.encuentro = encuentro;
        this.jugador = jugador;
        this.estadoSancion=estadoSancion;
        this.encuentro.agregarSancionFutbol(this);
        this.jugador.agregarSancion(this);
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public TipoSancionFutbol getTipoSancion() {
        return tipoSancionFutbol;
    }

    public void setTipoSancion(TipoSancionFutbol tipoSancionFutbol) {
        this.tipoSancionFutbol = tipoSancionFutbol;
    }

    public Encuentro getEncuentro() {
        return encuentro;
    }

    public void setEncuentro(Encuentro encuentro) {
        this.encuentro = encuentro;
    }

    public double calcularCostoSancion() {
        return tipoSancionFutbol.getCostoSancion();
    }

    public Jugador getJugador(){
        return jugador;
    }

    public void setJugador(Jugador jugador){
        this.jugador = jugador;
    }

    public TipoSancionFutbol getTipoSancionFutbol() {
        return tipoSancionFutbol;
    }

    public void setTipoSancionFutbol(TipoSancionFutbol tipoSancionFutbol) {
        this.tipoSancionFutbol = tipoSancionFutbol;
    }

    public EstadoSancion getEstadoSancion() {
        return estadoSancion;
    }

    public void setEstadoSancion(EstadoSancion estadoSancion) {
        this.estadoSancion = estadoSancion;
    }




}
