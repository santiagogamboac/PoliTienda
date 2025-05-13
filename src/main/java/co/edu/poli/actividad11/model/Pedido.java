package co.edu.poli.actividad11.model;

import java.util.ArrayList;

/**
 * 
 */
public class Pedido {

    /**
     * Default constructor
     */
    public Pedido(double total) {
        this.total = total;
    }

    private String numero;
    private String fecha;
    private Cliente cliente;
    private ArrayList<Producto> producto;
    private DescuentoStrategy descuentoStrategy;
    private double total;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Producto> getProducto() {
        return producto;
    }

    public void setProducto(ArrayList<Producto> producto) {
        this.producto = producto;
    }

    public DescuentoStrategy getDescuentoStrategy() {
        return descuentoStrategy;
    }

    public void setDescuentoStrategy(DescuentoStrategy descuentoStrategy) {
        this.descuentoStrategy = descuentoStrategy;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    
    public Pedido(String numero, String fecha, Cliente cliente, ArrayList<Producto> producto, 
            DescuentoStrategy descuentoStrategy, double total) {
        this.numero = numero;
        this.fecha = fecha;
        this.cliente = cliente;
        this.producto = producto;
        this.descuentoStrategy = descuentoStrategy;
        this.total = total;
    }
    
    /**
     * @param total 
     * @return
     */
    public double calcularTotalConDescuento() {
        // TODO implement here
        if (descuentoStrategy == null) return total;
        return descuentoStrategy.aplicarDescuento(total);

    }
}