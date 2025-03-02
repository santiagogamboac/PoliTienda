package co.edu.poli.ejemplo.modelo;

/**
 *
 */
public class ProductoAlimento extends Producto {

    /**
     * Default constructor
     */
    public ProductoAlimento(String id, String descripcion, double precio, int calorias) {
        super(id, descripcion, precio);
        this.calorias = calorias;
    }

    /**
     *
     */
    private int calorias;

    public int getCalorias() {
        return calorias;
    }
    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }
}
