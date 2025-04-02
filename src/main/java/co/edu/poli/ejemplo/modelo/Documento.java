package co.edu.poli.ejemplo.modelo;

/**
 * 
 */
public class Documento extends Mercancia {
    
    private int numPaginas;
    
    public Documento(Envio envio, int numPaginas) {
        super(envio);
        this.numPaginas = numPaginas;
    }
    
    @Override
    public double calcularCostoTotal() {
        // El costo base del envío más un costo adicional por página
        return envio.calcularCosto() + (numPaginas * 0.05);
    }
    
    @Override
    public String obtenerDescripcion() {
        return "Documento de " + numPaginas + " páginas";
    }

}