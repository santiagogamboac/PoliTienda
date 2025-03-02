package co.edu.poli.ejemplo.modelo;

/**
 * 
 */
public class ProductoElectronico extends Producto {

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
}