package co.edu.poli.corte2.model;

/**
 * 
 */
public interface ProductAccess {

    /**
     * Método que valida el perfil para permitir o no mostrar el detalle del producto
     * @param product 
     * @return
     */
    public Product viewProductDetail(Product product);

}