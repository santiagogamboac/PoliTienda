package co.edu.poli.ejemplo.modelo;

/**
 * 
 */
public abstract class Mercancia {
    protected Envio envio; // Relación de agregación
    
    public Mercancia(Envio envio) {
        this.envio = envio;
    }
    
    public abstract double calcularCostoTotal();
    public abstract String obtenerDescripcion();
    
    public String realizarEnvio() {

        String tipoEnvio;
        tipoEnvio = envio.procesarEnvio();
        return tipoEnvio  + " \nTiempo estimado de entrega: " + envio.obtenerTiempoEntrega() + " días \nCosto total: $" + calcularCostoTotal();
    }

}