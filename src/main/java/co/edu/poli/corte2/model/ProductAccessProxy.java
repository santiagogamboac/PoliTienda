package co.edu.poli.corte2.model;

/**
 * 
 */
public class ProductAccessProxy implements ProductAccess {
    /**
     * 
     */
    private User user;
    private ProductAccess realAccess = new ProductAccessImpl();

    /**
     * Método que valida el perfil para permitir o no mostrar el detalle del producto
     * @param product 
     * @return
     */
    public String viewProductDetail(Product product) {
        System.out.println("Producto: " + product.getId());
        //user = UserRepository.getUser(username, password)
        if("ADMIN".equalsIgnoreCase(user.getRole())){
            return realAccess.viewProductDetail(product);
        } else {
            // TODO: handle exception
            return "Este usuario co tiene permisos suficientes";
        }
    }

}