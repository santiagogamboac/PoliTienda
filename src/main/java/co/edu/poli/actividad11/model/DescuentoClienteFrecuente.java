package co.edu.poli.actividad11.model;

/**
 *
 */
public class DescuentoClienteFrecuente implements DescuentoStrategy {

    /**
     * Default constructor
     */
    public DescuentoClienteFrecuente() {
    }

    /**
     * @param total
     * @return
     */
    @Override
    public double aplicarDescuento(double total) {

        return total * 0.90;
    }

}
