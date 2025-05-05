package co.edu.poli.actividad10.model;

import java.util.Date;

public class PrecioMemento {

    private final double precio;
    private final Date fecha;
    
    public PrecioMemento(double precio) {
        this.precio = precio;
        this.fecha = new Date();
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public Date getFecha() {
        return fecha;
    }

}
