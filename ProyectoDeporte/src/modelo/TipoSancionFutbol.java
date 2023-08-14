package modelo;

public class TipoSancionFutbol {

    public String nombreSancion;
    public double costoSancion;

    public TipoSancionFutbol(String nombreSancion, double costoSancion) {
        this.nombreSancion = nombreSancion;
        this.costoSancion = costoSancion;
    }

    public String getNombreSancion() {
        return nombreSancion;
    }

    public void setNombreSancion(String nombreSancion) {
        this.nombreSancion = nombreSancion;
    }

    public double getCostoSancion() {
        return costoSancion;
    }

    public void setCostoSancion(double costoSancion) {
        this.costoSancion = costoSancion;
    }


}
