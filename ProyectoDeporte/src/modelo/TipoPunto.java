/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author 59398
 */
public class TipoPunto {
    private int cantidadPuntos;
    private String nombre;

    public TipoPunto() {
    }

    public TipoPunto(int cantidadPuntos, String nombre) {
        this.cantidadPuntos = cantidadPuntos;
        this.nombre = nombre;
    }

    public int getCantidadPuntos() {
        return cantidadPuntos;
    }

    public void setCantidadPuntos(int cantidadPuntos) {
        this.cantidadPuntos = cantidadPuntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
