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

    public void setDescription(String descripción) {
        this.description = descripción;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product(int id, String name, String descripción, double price) {
        this.id = id;
        this.name = name;
        this.description = descripción;
        this.price = price;
    }

}