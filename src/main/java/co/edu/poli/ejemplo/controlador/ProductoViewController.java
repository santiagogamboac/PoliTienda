package co.edu.poli.ejemplo.controlador;

import co.edu.poli.ejemplo.modelo.ProductoAlimento;
import co.edu.poli.ejemplo.modelo.ProductoAlimentoCreator;
import co.edu.poli.ejemplo.modelo.ProductoElectronico;
import co.edu.poli.ejemplo.modelo.ProductoElectronicoCreator;
import co.edu.poli.ejemplo.modelo.ProductoFactory;

public class ProductoViewController {
    
    // public static void main(String[] args) {
    //         ProductoFactory productoFactory = new ProductoElectronicoCreator();
    //         ProductoElectronico productoElectronico = (ProductoElectronico) productoFactory.createProduct();
    //         productoElectronico.setId("12");
    //         productoElectronico.setDescripcion("Producto electronico");
    //         productoElectronico.setPrecio(1000);
    //         productoElectronico.setVoltajeEntrada(12);

    //      System.out.println(productoElectronico.getId());
    //         System.out.println(productoElectronico.getDescripcion());   
    //         System.out.println(productoElectronico.getPrecio());
    //         System.out.println(productoElectronico.getVoltajeEntrada());

    //         ProductoFactory productoFactory2 = new ProductoAlimentoCreator();
    //         ProductoAlimento productoAlimento = (ProductoAlimento) productoFactory2.createProduct();
    //         productoAlimento.setId("12");
    //         productoAlimento.setDescripcion("Producto alimenticio");
    //         productoAlimento.setPrecio(1000);
    //         productoAlimento.setCalorias(12);
    //         System.out.println(productoAlimento.getId());
    //         System.out.println(productoAlimento.getDescripcion());
    //         System.out.println(productoAlimento.getPrecio());
    //         System.out.println(productoAlimento.getCalorias());
    // }
}
