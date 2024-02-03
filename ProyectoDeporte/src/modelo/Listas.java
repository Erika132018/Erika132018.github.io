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
public class Listas {

    public static ArrayList<Persona> listaPersonas = new ArrayList<>();

    public static void agregarPersona(Persona p) {
        listaPersonas.add(p);
    }

    public static ArrayList<Rol> listaRoles = new ArrayList<>();

    public static void agregarRol(Rol r) {
        listaRoles.add(r);
    }
    public static ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    public static void agregarUsuario(Usuario u) {
        listaUsuarios.add(u);
    }
    public static ArrayList<TipoSancionFutbol> listaTipoSancionFutbol = new ArrayList<>();

    public static void agregarTipoSancionFutbol(TipoSancionFutbol ts) {
        listaTipoSancionFutbol.add(ts);
    }

    public static ArrayList<MarcadorFutbol> listaMarcadorFutbol = new ArrayList<>();

    public static void agregarMarcadorFutbol(MarcadorFutbol mf) {
        listaMarcadorFutbol.add(mf);
    }
    public static ArrayList<Equipo> listaEquipos = new ArrayList<>();

    public static void agregarEquipoFutbol(Equipo equipos) {
        listaEquipos.add(equipos);
    }
    public static ArrayList<TablaDePosicionesFutbol> listaTablaDePosiciones = new ArrayList<>();

    public static void agregarTablaDePosiciones(TablaDePosicionesFutbol elemento) {
        listaTablaDePosiciones.add(elemento);
    }
    public static ArrayList<SancionFutbol> listaSancionesFutbol = new ArrayList<>();

    public static void agregarSancionesFutbol(SancionFutbol elemento) {
        listaSancionesFutbol.add(elemento);
    }

    private static ArrayList<TipoSancionAjedrez> listaTipoSancionAjedrez = new ArrayList<>();

    public static void agregarTipoSancionAjedrez(TipoSancionAjedrez tipoSancion) {
        listaTipoSancionAjedrez.add(tipoSancion);
    }

    public static ArrayList<TipoSancionAjedrez> obtenerListaTipoSancionAjedrez() {
        return listaTipoSancionAjedrez;
    }
    
    private static ArrayList<Temporada> listaTemporadaAjedrez = new ArrayList<>();
    public static void agregarTemporadaAjedrez(Temporada temporada) {
        listaTemporadaAjedrez.add(temporada);
    }
    private static ArrayList<CompetenciaAjedrez> listaCompetenciaAjedrez = new ArrayList<>();
    public static void agregarCompetenciaAjedrez(CompetenciaAjedrez competencia) {
        listaCompetenciaAjedrez.add(competencia);
    }
    private static ArrayList<EncuentroAjedrez> listaEncuentroAjedrez = new ArrayList<>();
     public static void agregarEncuentroAjedrez(EncuentroAjedrez encuentro) {
        listaEncuentroAjedrez.add(encuentro);
    }
    static ArrayList<MarcadorAjedrez> listaMarcadorAjedrez = new ArrayList<>(); 
    public static void agregarMarcadorAjedrez(MarcadorAjedrez marcador) {
        listaMarcadorAjedrez.add(marcador);
    }

}
