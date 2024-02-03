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
public class Rol {

    private String nombre;
    private String descripcion;
    private ArrayList<Usuario> listaUsuarios;

    public Rol() {
    }

    public Rol(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        listaUsuarios = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public void agregarUsuario(Usuario u) {
        listaUsuarios.add(u);
    }

    public void presentarRoles() {
        ArrayList<Rol> lista = Listas.listaRoles;
        System.out.println("*****Lista de Roles*****");
        for (Rol r : lista) {
            System.out.println(r.nombre+ ""+ r.descripcion);
        }
    }
}
