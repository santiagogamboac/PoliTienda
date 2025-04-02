package co.edu.poli.ejemplo.modelo;

/**
 * 
 */
public class EnvioInternacional implements Envio {

    private double tarifaBase;
    private double impuestos;
    
    public EnvioInternacional(double tarifaBase, double impuestos) {
        this.tarifaBase = tarifaBase;
        this.impuestos = impuestos;
    }
    
    @Override
    public double calcularCosto() {
        return tarifaBase + (tarifaBase * impuestos);
    }
    
    @Override
    public int obtenerTiempoEntrega() {
        return 10; // 10 días para envíos internacionales
    }
    
    @Override
    public String procesarEnvio() {
        return "Envio Internacional generado por una tarifa de " + tarifaBase + " y con el impuesto de $" + impuestos;
    }

}