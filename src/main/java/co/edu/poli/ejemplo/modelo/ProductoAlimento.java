package co.edu.poli.ejemplo.modelo;

/**
 *
 */
public class ProductoAlimento extends Producto implements Prototype {

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

    @Override
    public Prototype clone() {
        
        return (ProductoAlimento) super.clone();
    }
    @Override
public String toString() {
    return "ProductoAlimento{" +
           "id='" + getId() + '\'' +
           ", nombre='" + getDescripcion() + '\'' +
           ", precio=" + getPrecio() +
           ", calorias=" + getCalorias() +
           '}';
}
}
