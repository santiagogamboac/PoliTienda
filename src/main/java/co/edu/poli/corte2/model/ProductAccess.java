package co.edu.poli.corte2.model;

import java.io.*;
import java.util.*;

/**
 * 
 */
public interface ProductAccess {

    /**
     * Método que valida el perfil para permitir o no mostrar el detalle del producto
     * @param product 
     * @return
     */
    public String viewProductDetail(Product product);

}