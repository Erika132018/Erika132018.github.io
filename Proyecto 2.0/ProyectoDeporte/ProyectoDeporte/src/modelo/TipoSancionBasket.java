package modelo;

import java.util.ArrayList;

public class TipoSancionBasket {

    private String nombre;
    private String penalizacion;

    private ArrayList<SancionBasket> sancionBasket;

    public TipoSancionBasket() {
    }

    public TipoSancionBasket(String nombre, String penalizacion) {
        this.nombre = nombre;
        this.penalizacion = penalizacion;
        this.sancionBasket=new ArrayList<>();
    }

    public ArrayList<SancionBasket> getSancionBasket() {
        return sancionBasket;
    }

    public void setSancionBasket(ArrayList<SancionBasket> sancionBasket) {
        this.sancionBasket = sancionBasket;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPenalizacion() {
        return penalizacion;
    }

    public void setPenalizacion(String penalizacion) {
        this.penalizacion = penalizacion;
    }


}
