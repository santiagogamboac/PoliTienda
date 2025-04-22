package co.edu.poli.corte2.model;

public class productViewDTO {

    private int id;
    private String name;
    private String supplierName;
    private double price;

    public productViewDTO(Product p, Supplier supplier) {
        this.name = p.getName();
        this.price = p.getPrice();
        this.supplierName = supplier != null ? supplier.getName() : "Desconocido";
    }

    public String getName() {
        return name;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public double getPrice() {
        return price;
    }
}
