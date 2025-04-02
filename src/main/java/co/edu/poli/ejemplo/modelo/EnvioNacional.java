package co.edu.poli.ejemplo.modelo;

/**
 * 
 */
public class EnvioNacional implements Envio {

    private double tarifaBase;
    
    public EnvioNacional(double tarifaBase) {
        this.tarifaBase = tarifaBase;
    }
    
    @Override
    public double calcularCosto() {
        return tarifaBase;
    }
    
    @Override
    public int obtenerTiempoEntrega() {
        return 2; // 2 días para envíos nacionales
    }
    
    @Override
    public String procesarEnvio() {
        return "Envío nacional generado por una tarifa de " + tarifaBase;
    }

}