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
public class Usuario {

    private String usuario;
    private String paswword;
    private Rol rol;
    private Persona persona;

    public Usuario() {
    }

    public Usuario(String usuario, String paswword, Rol rol, Persona persona) {
        this.usuario = usuario;
        this.paswword = paswword;
        this.rol = rol;
        this.persona = persona;
        this.persona.agregarUsuario(this);// Asignarle el usuario a la persona
        this.rol.agregarUsuario(this); // Asignarle el usuario al rol
    }



    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPaswword() {
        return paswword;
    }

    public void setPaswword(String paswword) {
        this.paswword = paswword;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

   public void presentarUsuario() {
        ArrayList<Usuario> lista = Listas.listaUsuarios;
        System.out.println("*****Lista de Usuarios*****");
        for (Usuario u : lista) {
            System.out.println(u.getUsuario()+ "" +u.getPaswword());
        }
    }

}
