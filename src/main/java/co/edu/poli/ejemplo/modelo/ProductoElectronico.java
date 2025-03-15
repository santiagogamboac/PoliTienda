package co.edu.poli.ejemplo.modelo;

/**
 *
 */
public class ProductoElectronico extends Producto implements Prototype {

    /**
     * Default constructor
     */
    public ProductoElectronico(String id, String descripcion, double precio, int voltajeEntrada) {
        super(id, descripcion, precio);
        this.voltajeEntrada = voltajeEntrada;
    }

    /**
     *
     */
    private int voltajeEntrada;

    public int getVoltajeEntrada() {
        return voltajeEntrada;
    }

    public void setVoltajeEntrada(int voltajeEntrada) {
        this.voltajeEntrada = voltajeEntrada;
    }

    @Override
    public String toString() {
        return "ID: " + this.getId()
                + "\nNombre: " + this.getDescripcion()
                + "\nPrecio: $" + this.getPrecio()
                + // ... otros atributos específicos de ProductoElectronico
                "\nMarca: " + this.getVoltajeEntrada();
    }

    @Override
    public Prototype clone() {

        return new ProductoElectronico(getId(), getDescripcion(), getPrecio(), getVoltajeEntrada());
    }
}
