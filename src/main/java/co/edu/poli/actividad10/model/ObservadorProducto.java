package co.edu.poli.actividad10.model;

import java.util.Map;

/**
 * 
 */
public interface ObservadorProducto {

    String actualizar(Map<String, Object> datos);
    double getPrecioActual();
}

