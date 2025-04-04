package co.edu.poli.ejemplo.modelo;

/**
 * 
 */
public class EnvioExpress implements Envio {

    private double tarifaBase;
    
    public EnvioExpress(double tarifaBase) {
        this.tarifaBase = tarifaBase;
    }
    
    @Override
    public double calcularCosto() {
        return tarifaBase;
    }
    
    @Override
    public int obtenerTiempoEntrega() {
        return 1; // 2 días para envíos nacionales
    }
    
    @Override
    public String procesarEnvio() {
        return "Envío express generado por una tarifa de " + tarifaBase;
    }

}