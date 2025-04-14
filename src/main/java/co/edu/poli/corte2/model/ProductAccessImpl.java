package co.edu.poli.corte2.model;

public class ProductAccessImpl implements ProductAccess {

    @Override
    public String viewProductDetail(Product product) {
            
        return "ID: " + product.getId() +
        "Nombre: " + product.getName() +
                   "\nDescripción: " + product.getDescription() +
                   "\nPrecio: $" + product.getPrice();
    }

}
