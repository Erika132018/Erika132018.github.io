/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author 59398
 */
public class CuerpoTecnico {
    private Persona persona;
    private Equipo equipo;
    private TipoCuerpoTecnico tipoCuerpoTec;

    public CuerpoTecnico() {
    }

    public CuerpoTecnico(Persona persona, Equipo equipo, TipoCuerpoTecnico tipoCuerpoTec) {
        this.persona = persona;
        this.equipo = equipo;
        this.tipoCuerpoTec = tipoCuerpoTec;
        persona.agregarCuerpoTecnico(this);
        equipo.agregarCuerpoTecnico(this);
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public TipoCuerpoTecnico getTipoCuerpoTec() {
        return tipoCuerpoTec;
    }

    public void setTipoCuerpoTec(TipoCuerpoTecnico tipoCuerpoTec) {
        this.tipoCuerpoTec = tipoCuerpoTec;
    }
    
  

}
