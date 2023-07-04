/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


/**
 *
 * @author 59398
 */
public class Competencia {

    private String competencia;
    private int numJugadoresTitulares;
    private int numJugadoresTotales;
    private TipoCompetencia tipoCompetencia;

    public Competencia() {
    }

    public Competencia(String competencia, int numJugadoresTitulares, int numJugadoresTotales, TipoCompetencia tipoCompetencia) {
        this.competencia = competencia;
        this.numJugadoresTitulares = numJugadoresTitulares;
        this.numJugadoresTotales = numJugadoresTotales;
        this.tipoCompetencia = tipoCompetencia;

    }

    public String getCompetencia() {
        return competencia;
    }

    public void setCompetencia(String competencia) {
        this.competencia = competencia;
    }

    public int getNumJugadoresTitulares() {
        return numJugadoresTitulares;
    }

    public void setNumJugadoresTitulares(int numJugadoresTitulares) {
        this.numJugadoresTitulares = numJugadoresTitulares;
    }

    public int getNumJugadoresTotales() {
        return numJugadoresTotales;
    }

    public void setNumJugadoresTotales(int numJugadoresTotales) {
        this.numJugadoresTotales = numJugadoresTotales;
    }

    public TipoCompetencia getTipoCompetencia() {
        return tipoCompetencia;
    }

    public void setTipoCompetencia(TipoCompetencia tipoCompetencia) {
        this.tipoCompetencia = tipoCompetencia;
    }

}
