package co.edu.poli.ejemplo.servicio;


import java.util.*;

import co.edu.poli.ejemplo.modelo.Producto;

/**
 * 
 */
public interface ProductoRepository extends ICrudDAO<Producto> {
  
    public List<Producto> findByPriceRange(double min, double max);

}