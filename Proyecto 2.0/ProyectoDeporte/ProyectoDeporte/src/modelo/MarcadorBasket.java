/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author 59398
 */
public class MarcadorBasket {

    private Encuentro encuentro;
    private Equipo equipo;
    private TipoPunto tipoPunto;

    public MarcadorBasket() {
    }

    public MarcadorBasket(Encuentro encuentro, Equipo equipo, TipoPunto tipoPunto) {

        this.encuentro = encuentro;
        this.equipo = equipo;
        this.tipoPunto = tipoPunto;
        this.encuentro.agregarMarcadorBasket(this);

    }

    public Encuentro getEncuentro() {
        return encuentro;
    }

    public void setEncuentro(Encuentro encuentro) {
        this.encuentro = encuentro;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public TipoPunto getTipoPunto() {
        return tipoPunto;
    }

    public void setTipoPunto(TipoPunto tipoPunto) {
        this.tipoPunto = tipoPunto;
    }

}
