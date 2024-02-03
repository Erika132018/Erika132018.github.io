/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author A S U S
 */
import java.util.Date;

public class EncuentroAjedrez {
    private Jugador jugadorBlancas;
    private Jugador jugadorNegras;
    private Date fecha;
    private String ubicacion;
    private EstadoEncuentro estado;

    public EncuentroAjedrez(Jugador jugadorBlancas, Jugador jugadorNegras, Date fecha, String ubicacion, EstadoEncuentro estado) {
        this.jugadorBlancas = jugadorBlancas;
        this.jugadorNegras = jugadorNegras;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.estado = estado;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public EstadoEncuentro getEstado() {
        return estado;
    }

    public void setEstado(EstadoEncuentro estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "EncuentroAjedrez{" +
                "jugadorBlancas=" + jugadorBlancas +
                ", jugadorNegras=" + jugadorNegras +
                ", fecha=" + fecha +
                ", ubicacion='" + ubicacion + '\'' +
                ", estado=" + estado +
                '}';
    }

    Object getEquipoBlancas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Object getEquipoNegras() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
