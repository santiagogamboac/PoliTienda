package co.edu.poli.ejemplo.modelo;

/**
 * 
 */
public class CargaFragil extends Mercancia {

    private double peso;
    private double factorFragilidad;
    
    public CargaFragil(Envio envio, double peso, double factorFragilidad) {
        super(envio);
        this.peso = peso;
        this.factorFragilidad = factorFragilidad;
    }
    
    @Override
    public double calcularCostoTotal() {
        // El costo base del envío más un costo adicional por peso y factor de fragilidad
        return envio.calcularCosto() + (peso * 2) + (factorFragilidad * 100);
    }
    
    @Override
    public String obtenerDescripcion() {
        return "Carga frágil de " + peso + " kg con factor de fragilidad " + factorFragilidad;
    }

}