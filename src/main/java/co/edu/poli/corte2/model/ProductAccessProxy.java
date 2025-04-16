package co.edu.poli.corte2.model;

/**
 * 
 */
public class ProductAccessProxy implements ProductAccess {
    /**
     * 
     */
    private User user;
    private ProductAccessImpl realAccess;

    public ProductAccessProxy(User user) {
        this.user = user;
        this.realAccess = new ProductAccessImpl();
    }

    /**
     * Método que valida el perfil para permitir o no mostrar el detalle del producto
     * @param product 
     * @return
     */
    public String viewProductDetail(Product product) {

        if(user != null && "ADMIN".equalsIgnoreCase(user.getRole())){
            return realAccess.viewProductDetail(product);
        } else {
            // TODO: handle exception
            return "Este usuario no tiene permisos suficientes";
        }
    }

}