package co.edu.poli.ejemplo.modelo;


/**
 * 
 */
public abstract class Producto {

    /**
     * Default constructor
     */
    public Producto(String id, String descripcion, double precio) {
    	this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String descripcion;

    /**
     * 
     */
    private double precio;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public Prototype clone() {
        
        Producto producto = new ProductoElectronico ("1","Producto Electronico", 1000, 110);
        return (Prototype) producto;
    }
}