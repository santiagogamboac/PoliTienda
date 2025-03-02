package co.edu.poli.ejemplo.modelo;

/**
 * 
 */
public class ProductoElectronicoCreator implements ProductoFactory {

    /**
     * Default constructor
     */
    public ProductoElectronicoCreator() {
    }

    @Override
    public ProductoElectronico createProduct() {
        return new ProductoElectronico("","", 0,0);
    
    }

}