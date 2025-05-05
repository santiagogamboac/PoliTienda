package co.edu.poli.actividad10.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 
 */
public class Producto {

    /**
     * Default constructor
     */
    public Producto() {
    }

    private String nombre;
    private String codigo;
    private double precioActual;
    private String descripcion;
    private List<ObservadorProducto> observadores = new ArrayList<>();
    private HistorialPrecios historial;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecioActual() {
        return precioActual;
    }

    public void setPrecioActual(double precioActual) {
        this.precioActual = precioActual;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



    public Producto(String nombre, String codigo, double precioActual, String descripcion,
            List<ObservadorProducto> observadores, HistorialPrecios historial) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precioActual = precioActual;
        this.descripcion = descripcion;
        this.observadores = observadores;
        this.historial = historial;
    }

    public void agregarObservador(ObservadorProducto observador) {
        observadores.add(observador);
    }

    public void eliminarObservador(ObservadorProducto observador) {
        observadores.remove(observador);
    }

    public ProductoMemento crearMemento() {
        return new ProductoMemento(precioActual);
    }

    public String restaurarMemento(ProductoMemento memento) {
        if (memento != null) {
            this.precioActual = memento.getPrecio();
            return "Estado restaurado correctamente";
        }
        return "No hay estado previo disponible";
    }

    public String setPrecio(double nuevoPrecio) {
        historial.registrarCambioPrecio();
        this.precioActual = nuevoPrecio;
        notificarObservadores();
        return "Precio actualizado correctamente";
    }

    private void notificarObservadores() {
        Map<String, Object> datos = Map.of("codigo", codigo, "nuevoPrecio", precioActual);
        for (ObservadorProducto obs : observadores) {
            obs.actualizar(datos);
        }
    }


}