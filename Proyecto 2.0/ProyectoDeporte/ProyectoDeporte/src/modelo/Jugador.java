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
public class Jugador extends Persona {

    private int numCamiseta;
    private boolean titular;
    private ArrayList<MarcadorBasket> marcadorList;
    private ArrayList<Goles> golesList;
    private ArrayList<SancionFutbol> sancionFutbol;
    
   

    public Jugador(int numCamiseta, boolean titular, String nombre, String apellido, String dni, String telefono, Date fechaNacimiento,TipoPersona tipoPersona) {
        super(nombre, apellido, dni, telefono, fechaNacimiento, tipoPersona);
        this.numCamiseta = numCamiseta;
        this.titular = titular;
        this.marcadorList = new ArrayList<>();
        this.golesList = new ArrayList<>();
        this.sancionFutbol=new ArrayList<>();
    }

    public int getNumCamiseta() {
        return numCamiseta;
    }

    public void setNumCamiseta(int numCamiseta) {
        this.numCamiseta = numCamiseta;
    }

    public boolean isTitular() {
        return titular;
    }

    public void setTitular(boolean titular) {
        this.titular = titular;
    }

    public ArrayList<MarcadorBasket> getMarcadorList() {
        return marcadorList;
    }

    public void setMarcadorList(ArrayList<MarcadorBasket> marcadorList) {
        this.marcadorList = marcadorList;
    }

    public ArrayList<Goles> getGolesList() {
        return golesList;
    }

    public void setGolesList(ArrayList<Goles> golesList) {
        this.golesList = golesList;
    }

    public ArrayList<SancionFutbol> getSancionFutbol() {
        return sancionFutbol;
    }

    public void setSancionFutbol(ArrayList<SancionFutbol> sancionFutbol) {
        this.sancionFutbol = sancionFutbol;
    }



    public void agregarmarcadorBasket(MarcadorBasket mb) {
        marcadorList.add(mb);
    }
    public void agregarGolesList(Goles gol) {
        golesList.add(gol);
    }
   
    
    public void agregarSancion(SancionFutbol sancion) {
        sancionFutbol.add(sancion);
    }

}
