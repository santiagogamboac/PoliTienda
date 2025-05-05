package co.edu.poli.actividad10.model;

import java.util.ArrayList;
import java.util.Date;
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
    private double precio;
    private String descripcion;
    private Date fechaModificacion;
    private List<ObservadorProducto> observadores = new ArrayList<>();
    private HistorialPrecios historial;

public Producto(String nombre, String codigo, double precio, 
                   String descripcion, Date fechaCreacion, Date fechaModificacion) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.descripcion = descripcion;        
        this.fechaModificacion = fechaModificacion != null ? fechaModificacion : new Date();
        this.historial = new HistorialPrecios(this);
    }

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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public void agregarObservador(ObservadorProducto observador) {
        observadores.add(observador);
    }

    public void eliminarObservador(ObservadorProducto observador) {
        observadores.remove(observador);
    }

    

    // public ProductoMemento crearMemento() {
    //     return new ProductoMemento(precioActual);
    // }


public Producto(String nombre, String codigo, double precio, String descripcion, Date fechaModificacion,
            List<ObservadorProducto> observadores, HistorialPrecios historial) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.descripcion = descripcion;
        this.fechaModificacion = fechaModificacion;
        this.observadores = observadores;
        this.historial = historial;
    }

public void modificarPrecioPorPorcentage(double percentage) {
        double oldPrice = this.precio;
        this.precio *= (1 + percentage/100);
        notificarObservadores(oldPrice, this.precio);
    }

    // public String restaurarMemento(ProductoMemento memento) {
    //     if (memento != null) {
    //         this.precioActual = memento.getPrecio();
    //         return "Estado restaurado correctamente";
    //     }
    //     return "No hay estado previo disponible";
    // }

    // public String setPrecio(double nuevoPrecio) {
    //     historial.registrarCambioPrecio();
    //     this.precioActual = nuevoPrecio;
    //     notificarObservadores();
    //     return "Precio actualizado correctamente";
    // }

    private void notificarObservadores(double precioAnterior, double precioActual) {
        Map<String, Object> datos = Map.of("codigo", codigo, "nuevoPrecio", precioActual);
        for (ObservadorProducto obs : observadores) {
            obs.actualizar(datos);
        }
    }

    



}