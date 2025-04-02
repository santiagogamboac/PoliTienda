package co.edu.poli.ejemplo.modelo;

/**
 * 
 */
public class CargaPesada extends Mercancia {

    private double peso;
    private boolean requiereEquipoEspecial;
    
    public CargaPesada(Envio envio, double peso, boolean requiereEquipoEspecial) {
        super(envio);
        this.peso = peso;
        this.requiereEquipoEspecial = requiereEquipoEspecial;
    }
    
    @Override
    public double calcularCostoTotal() {
        // El costo base del envío más un costo adicional por peso
        double costoTotal = envio.calcularCosto() + (peso * 1.5);
        
        // Si requiere equipo especial, se añade un costo adicional
        if (requiereEquipoEspecial) {
            costoTotal += 200;
        }
        
        return costoTotal;
    }
    
    @Override
    public String obtenerDescripcion() {
        String descripcion = "Carga pesada de " + peso + " kg";
        if (requiereEquipoEspecial) {
            descripcion += " (requiere equipo especial)";
        }
        return descripcion;
    }

}