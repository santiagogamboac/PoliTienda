package co.edu.poli.actividad11.model;

/**
 * 
 */
public class DescuentoTemporada implements DescuentoStrategy {

    /**
     * Default constructor
     */
    public DescuentoTemporada() {
    }

    /**
     * @param total 
     * @return
     */
    public double aplicarDescuento(double total) {
        // TODO implement DescuentoStrategy.aplicarDescuento() here
        return total * 0.80;
    }

}