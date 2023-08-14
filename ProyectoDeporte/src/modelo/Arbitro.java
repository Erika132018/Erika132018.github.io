/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author 59398
 */
public class Arbitro extends Persona {
    private String descripcion;
    private String especialidad;

    public Arbitro(String descripcion, String especialidad, String nombre, String apellido, String dni, String telefono, Date fechaNacimiento,TipoPersona tipoPersona) {
        super(nombre, apellido, dni, telefono, fechaNacimiento, tipoPersona);
        this.descripcion = descripcion;
        this.especialidad = especialidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

 




}
