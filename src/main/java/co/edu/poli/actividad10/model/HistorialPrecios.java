package co.edu.poli.actividad10.model;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class HistorialPrecios {

    /**
     * Default constructor
     */
    public HistorialPrecios() {
    }

    /**
     * 
     */
    private List<ProductoMemento> historial;

    /**
     * 
     */
    private Producto producto;

    /**
     * @param indice 
     * @return
     */
   public HistorialPrecios(Producto producto) {
        this.producto = producto;
    }

    public void guardarMemento(ProductoMemento memento) {
        historial.add(memento);
    }

    public ProductoMemento obtenerMemento(int indice) {
        return (indice >= 0 && indice < historial.size()) ? historial.get(indice) : null;
    }

    public List<ProductoMemento> obtenerHistorialCompleto() {
        return historial;
    }

    public void registrarCambioPrecio() {
        guardarMemento(new ProductoMemento(producto.getPrecioActual()));
    }


}