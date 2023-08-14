/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.Date;


public class Persona {

    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private Date fechaNacimiento;
    private TipoPersona tipoPersona;
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<CuerpoTecnico> CuerpoTecnicos;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String dni, String telefono, Date fechaNacimiento, TipoPersona tipoPersona) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.tipoPersona = tipoPersona;
        this.fechaNacimiento = fechaNacimiento;
        this.listaUsuarios = new ArrayList<>();
        this.CuerpoTecnicos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> ListaUsuarios) {
        this.listaUsuarios = ListaUsuarios;
    }

    public void agregarUsuario(Usuario u) {
        listaUsuarios.add(u);
    }

    public void agregarCuerpoTecnico(CuerpoTecnico ct) {
        CuerpoTecnicos.add(ct);
    }

    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public ArrayList<CuerpoTecnico> getCuerpoTecnicos() {
        return CuerpoTecnicos;
    }

    public void setCuerpoTecnicos(ArrayList<CuerpoTecnico> CuerpoTecnicos) {
        this.CuerpoTecnicos = CuerpoTecnicos;
    }

    public void presentarPersonas() {
        ArrayList<Persona> lista = Listas.listaPersonas;
        System.out.println("*****Lista de Personas*****");
        for (Persona p : lista) {
            if (p.getTipoPersona() == TipoPersona.NATURAL) {
                System.out.println(p.getNombre() + " " + p.getApellido() + " " + p.getDni());
            }
        }
    }

    public void presentarJugadoresFutbol() {
        ArrayList<Persona> lista = Listas.listaPersonas;
        System.out.println("*****Lista de Jugadores*****");
        System.out.println("Nombre\t" + "Apellido " + " DNI\t\t" + "Sanciones\t");
        for (Persona p : lista) {
            if (p.getTipoPersona() == TipoPersona.JUGADOR_FUTBOL) {
                Jugador j = (Jugador) p;
                //j.getSancionFutbol()
                System.out.println(j.getNombre() + "\t " + j.getApellido() + "\t " + j.getDni() + "\t " +obtenerSanciones(j.getSancionFutbol()) );
            }
        }
    }

    public int obtenerSanciones(ArrayList<SancionFutbol> list) {
        int cont = 0;
        for (SancionFutbol sancionFutbol : list) {
            if (sancionFutbol.getEstadoSancion().equals(EstadoSancion.PENDIENTE)) {
                cont = cont + 1;
            }
        }
        return cont;
    }


    public void presentarArbitros() {
    }

    public void presentarPersona() {
    System.out.println(nombre + " " + apellido + " " + dni);
}


   
}
