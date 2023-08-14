package modelo;

import java.util.ArrayList;

public class MarcadorFutbol {

    private Encuentro encuentro;
    private Equipo equipo;
    private int estado; // Empató: 0, Perdió 1, Ganó: 2,
    private ArrayList<Goles> golesList;

    public MarcadorFutbol() {
    }

    public MarcadorFutbol(Encuentro encuentro, Equipo equipo, int estado) {
        this.encuentro = encuentro;
        this.equipo = equipo;
        this.estado=estado;
        this.golesList = new ArrayList<>();
        this.encuentro.agregarMarcadorFutbol(this);
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public ArrayList<Goles> getGolesList() {
        return golesList;
    }

    public void setGolesList(ArrayList<Goles> golesList) {
        this.golesList = golesList;
    }

    public void agregarGolesList(Goles goles) {
        golesList.add(goles);
    }
}
