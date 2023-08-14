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
public class TablaDePosicionesFutbol {

    private int pts;
    private int pj;
    private int pg;
    private int pe;
    private int pp;
    private int gF;
    private int gC;
    private int dg;
    private Equipo equipo;

    public TablaDePosicionesFutbol() {
    }

    public TablaDePosicionesFutbol(int pts, int pj, int pg, int pe, int pp, int gF, int gC, int dg, Equipo equipo) {
        this.pts = pts;
        this.pj = pj;
        this.pg = pg;
        this.pe = pe;
        this.pp = pp;
        this.gF = gF;
        this.gC = gC;
        this.dg = dg;
        this.equipo = equipo;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public int getPj() {
        return pj;
    }

    public void setPj(int pj) {
        this.pj = pj;
    }

    public int getPg() {
        return pg;
    }

    public void setPg(int pg) {
        this.pg = pg;
    }

    public int getPe() {
        return pe;
    }

    public void setPe(int pe) {
        this.pe = pe;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

    public int getgF() {
        return gF;
    }

    public void setgF(int gF) {
        this.gF = gF;
    }

    public int getgC() {
        return gC;
    }

    public void setgC(int gC) {
        this.gC = gC;
    }

    public int getDg() {
        return dg;
    }

    public void setDg(int dg) {
        this.dg = dg;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public void calcularTablaPosiciones(ArrayList<Equipo> listEquipos, ArrayList<MarcadorFutbol> lisM) {
        for (Equipo equipoFutbol : listEquipos) {
            int pts = puntosAfavor(lisM, equipoFutbol);
            int pj = partidosJugados(equipoFutbol);
            int pg = partidosGanados(lisM, equipoFutbol);
            int pe = partidosEmpatados(lisM, equipoFutbol);
            int pp = partidosPerdidos(lisM, equipoFutbol);
            int gf = golesFavor(lisM, equipoFutbol);
            int gc = golesContra(lisM, equipoFutbol);
            int dg = gf-gc;
            Listas.agregarTablaDePosiciones(new TablaDePosicionesFutbol(pts, pj, pg, pe, pp, gf, gc, dg, equipoFutbol));
        }
    }

    public int partidosGanados(ArrayList<MarcadorFutbol> lisM, Equipo equipo) {
        int ganados = 0;
        for (MarcadorFutbol marcador : lisM) {
            if (marcador.getEquipo().getNombreEquipo().equals(equipo.getNombreEquipo())) {
                if (marcador.getEstado() == 2) {
                    ganados = ganados + 1;
                }
            }
        }
        return ganados;
    }

    public int partidosEmpatados(ArrayList<MarcadorFutbol> lisM, Equipo equipo) {
        int empatados = 0;
        for (MarcadorFutbol marcador : lisM) {
            if (marcador.getEquipo().getNombreEquipo().equals(equipo.getNombreEquipo())) {
                if (marcador.getEstado() == 0) {
                    empatados = empatados + 1;
                }
            }
        }
        return empatados;
    }

    public int puntosAfavor(ArrayList<MarcadorFutbol> lisM, Equipo equipo) {
        int puntos = 0;
        for (MarcadorFutbol marcador : lisM) {
            if (marcador.getEquipo().getNombreEquipo().equals(equipo.getNombreEquipo())) {
                if (marcador.getEstado() == 0) {
                    puntos = puntos + 1;
                } else if (marcador.getEstado() == 2) {
                    puntos = puntos + 3;
                }
            }
        }
        return puntos;
    }

    public int partidosPerdidos(ArrayList<MarcadorFutbol> lisM, Equipo equipo) {
        int perdido = 0;
        for (MarcadorFutbol marcador : lisM) {
            if (marcador.getEquipo().getNombreEquipo().equals(equipo.getNombreEquipo())) {
                if (marcador.getEstado() == 1) {
                    perdido = perdido + 1;
                }
            }
        }
        return perdido;
    }

    public int partidosJugados(Equipo equipo) {
        int jugados = 0;
        for (Encuentro encuentro :equipo.getEncuentrosList() ) {
            if (encuentro.getEstadoEncuentro() == EstadoEncuentro.FINALIZADO) {
                jugados = jugados + 1;
            }
        }
        return jugados;
    }

    public int golesFavor(ArrayList<MarcadorFutbol> lisM, Equipo equipo) {
        int golesFavor = 0;
        for (MarcadorFutbol marcador : lisM) {
            if (marcador.getEquipo().getNombreEquipo().equals(equipo.getNombreEquipo())) {
                golesFavor = +contarGolesEquipo(marcador.getGolesList());

            }
        }
        return golesFavor;
    }

    public int contarGolesEquipo(ArrayList<Goles> lista_goles) {
        int cont_goles = 0;
        for (Goles gol : lista_goles) {
            cont_goles = +gol.getGoles();
        }
        return cont_goles;

    }

    public int golesContra(ArrayList<MarcadorFutbol> lisM, Equipo equipo) {
        int golesContra = 0;
        for (Encuentro encuentro : equipo.getEncuentrosList()) {
            ArrayList<MarcadorFutbol> list = encuentro.getMarcadorFutbol();
            for (MarcadorFutbol marcadorFutbol : list) {
                if (!marcadorFutbol.getEquipo().getNombreEquipo().equals(equipo.getNombreEquipo())) {
                    golesContra = golesContra + contarGolesEquipo(marcadorFutbol.getGolesList());
                }
            }
        }
        return golesContra;
    }

    public void presentarTablaPosiciones() {
        ArrayList<TablaDePosicionesFutbol> lista = Listas.listaTablaDePosiciones; // Obtenemos los registros guardados
        System.out.println("Equipos\t\t" + "PTS\t" + "PJ\t" + "PG\t" + "PE\t" + "PP\t" + "DG\t");
        for (TablaDePosicionesFutbol tabla : lista) {
            System.out.print(tabla.equipo.getNombreEquipo() + "\t" + tabla.pts + "\t" + tabla.pj + "\t" + tabla.pg + "\t" + tabla.pe + "\t" + tabla.pp + "\t" + tabla.dg + "\n");
        }
    }



}
