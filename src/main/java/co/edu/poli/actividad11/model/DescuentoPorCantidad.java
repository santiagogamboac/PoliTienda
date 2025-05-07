package co.edu.poli.actividad11.model;

/**
 * 
 */
public class DescuentoPorCantidad implements DescuentoStrategy {

    /**
     * Default constructor
     */
    public DescuentoPorCantidad() {
    }

    /**
     * @param total 
     * @return
     */
    public double aplicarDescuento(double total) {
        // TODO implement DescuentoStrategy.aplicarDescuento() here
        return total * 0.90;
    }

}