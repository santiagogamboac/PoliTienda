package co.edu.poli.actividad11.model;

import java.util.List;

/**
 * 
 */
public class AgregarProductoCommand implements ProductoCommand {

    private List<Producto> listaProd;
    private Producto prod;

    /**
     * @param productos 
     * @param productoAgregado
     */
    public AgregarProductoCommand(List<Producto> productos, Producto productoAgregado) {
        this.listaProd = productos;
        this.prod = productoAgregado;
    }

    /**
     * 
     */
    @Override
    public List<Producto> execute() {
        listaProd.add(prod);
        return listaProd;
    }

    /**
     * 
     */
    @Override
    public List<Producto> undo() {
        listaProd.remove(prod);
        return listaProd;
    }

}