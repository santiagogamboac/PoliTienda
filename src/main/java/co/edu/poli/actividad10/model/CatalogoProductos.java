package co.edu.poli.actividad10.model;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class CatalogoProductos {

    /**
     * Default constructor
     */
    public CatalogoProductos() {
    }

    /**
     * 
     */
    private Map <String, Object> historiales;

    /**
     * 
     */
    private Map <String, Object> productos;

    private final Map<String, Producto> productos = new HashMap<>();
    private final Map<String, HistorialPrecios> historiales = new HashMap<>();

    public String agregarProducto(Producto producto) {
        productos.put(producto.getCodigo(), producto);
        historiales.put(producto.getCodigo(), new HistorialPrecios(producto));
        return "Producto agregado con éxito";
    }

    public Producto obtenerProducto(String codigo) {
        return productos.get(codigo);
    }

    public Collection<Producto> obtenerTodosProductos() {
        return productos.values();
    }

    public HistorialPrecios obtenerHistorial(String codigo) {
        return historiales.get(codigo);
    }

    public String generarJSON() {
        // Simulación de generación de JSON (puedes usar una biblioteca como Gson en un proyecto real)
        return "{ \"productos\": " + productos.toString() + " }";
    }

    public Map<String, Object> obtenerMapaProductos() {
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("productos", productos);
        mapa.put("historiales", historiales);
        return mapa;
    }

    public Map<String, Object> getProductos() {
        return productos;
    }


}