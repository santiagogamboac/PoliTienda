package co.edu.poli.actividad10.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 */
public class CatalogoProductos {

    /**
     * Default constructor
     */
    public CatalogoProductos() {
        Producto p1 = new Producto("Aguapanela", "10001", 2000, "aguita para mi gente", null, null);
        Producto p2 = new Producto("Tinto", "10002", 1500, "pal frio", null, null);
        agregarProducto(p1);
        agregarProducto(p2);
    }

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

    public Map<String, Object> obtenerMapaProductos() {
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("productos", productos);
        mapa.put("historiales", historiales);
        return mapa;
    }

    public Map<String, Producto> getProductos() {
        return productos;
    }


}