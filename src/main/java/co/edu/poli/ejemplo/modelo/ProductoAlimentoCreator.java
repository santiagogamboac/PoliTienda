package co.edu.poli.ejemplo.modelo;

/**
 * 
 */
public class ProductoAlimentoCreator implements ProductoFactory {

    /**
     * Default constructor
     */
    public ProductoAlimentoCreator() {
    }

    @Override
    public ProductoAlimento createProduct() {
        return new ProductoAlimento("","", 0,0);
    
    }

}