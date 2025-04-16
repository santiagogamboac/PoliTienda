package co.edu.poli.corte2.model;

public class ProductAccessImpl implements ProductAccess {

    @Override
    public String viewProductDetail(Product product) {
            
        if (product == null) {
            return "Producto no encontrado";
        }
        
        StringBuilder details = new StringBuilder();
        details.append("ID: ").append(product.getId()).append("\n");
        details.append("Nombre: ").append(product.getName()).append("\n");
        details.append("Descripción: ").append(product.getDescription()).append("\n");
        details.append("Precio: $").append(String.format("%.2f", product.getPrice()));
        
        return details.toString();
    }

}
