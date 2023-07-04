/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author 59398
 */
public class Equipo {
    private Date fechaCreacion;
    private String logo;
    private String nombreEquipo;
    private TipoCompetencia tipoCompetencia;
    private ArrayList<CuerpoTecnico> CuerpoTecnicos;
    private ArrayList<Fichaje> fichajelist;
    private ArrayList<Encuentro> encuentrosList;


    public Equipo() {
    }

    public Equipo(Date fechaCreacion, String logo, String nombreEquipo,TipoCompetencia tipoCompetencia) {
        this.fechaCreacion = fechaCreacion;
        this.logo = logo;
        this.tipoCompetencia=tipoCompetencia;
        this.nombreEquipo = nombreEquipo;
        this.CuerpoTecnicos= new ArrayList<>();
        this.fichajelist= new ArrayList<>();
        this.encuentrosList= new ArrayList<>();
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public ArrayList<CuerpoTecnico> getCuerpoTecnicos() {
        return CuerpoTecnicos;
    }

    public void setCuerpoTecnicos(ArrayList<CuerpoTecnico> CuerpoTecnicos) {
        this.CuerpoTecnicos = CuerpoTecnicos;
    }

    public ArrayList<Fichaje> getFichajes() {
        return fichajelist;
    }

    public void setFichajes(ArrayList<Fichaje> fichajes) {
        this.fichajelist = fichajes;
    }

    public ArrayList<Fichaje> getFichajelist() {
        return fichajelist;
    }

    public void setFichajelist(ArrayList<Fichaje> fichajelist) {
        this.fichajelist = fichajelist;
    }

    public ArrayList<Encuentro> getEncuentrosList() {
        return encuentrosList;
    }

    public void setEncuentrosList(ArrayList<Encuentro> encuentrosList) {
        this.encuentrosList = encuentrosList;
    }

    public TipoCompetencia getTipoCompetencia() {
        return tipoCompetencia;
    }

    public void setTipoCompetencia(TipoCompetencia tipoCompetencia) {
        this.tipoCompetencia = tipoCompetencia;
    }

   public void agregarCuerpoTecnico(CuerpoTecnico ct) {
        CuerpoTecnicos.add(ct);
    }
   public void agregarCuerpoEquipo(Fichaje eq) {
        fichajelist.add(eq);
    }
   public void agregarEncuentroList(Encuentro enc) {
        encuentrosList.add(enc);
    }

  public void presentarEquiposFutbol() {
        ArrayList<Equipo> lista = Listas.listaEquipos;
        System.out.println("*****Lista de Equipos de Futbol*****");
        for (Equipo eq : lista) {
            if (eq.getTipoCompetencia() == TipoCompetencia.FUTBOL) {
                System.out.println(eq.getNombreEquipo());
            }
        }
    }
  public void presentarEquiposBasket() {
        ArrayList<Equipo> lista = Listas.listaEquipos;
        System.out.println("*****Lista de Equipos de Basket*****");
        for (Equipo eq : lista) {
            if (eq.getTipoCompetencia() == TipoCompetencia.BASKETBALL) {
                System.out.println(eq.getNombreEquipo());
            }
        }
    }
}
