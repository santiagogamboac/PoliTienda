package co.edu.poli.corte2.model;

/**
 *
 */
public class Product {

    /**
     * ID del producto
     */
    private int id;

    /**
     * Nombre del producto
     */
    private String name;

    /**
     * Descripción del producto
     */
    private String description;

    /**
     * Precio del producto
     */
    private double price;
    private int supplierId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    /**
     * Constructor por defecto
     */
    public Product() {
    }

    public Product(int id, String name, String description, double price, int supplierId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.supplierId = supplierId;
    }
}
