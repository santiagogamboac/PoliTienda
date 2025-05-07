package co.edu.poli.actividad11.model;

import java.util.List;

/**
 * 
 */
public class EliminarProductoCommand implements ProductoCommand {

    private List<Producto> listaProd;
    private Producto prod;

    /**
     * @param productos 
     * @param productoElliminado
     */
    public EliminarProductoCommand(List<Producto> productos, Producto productoEliminado) {
        // TODO implement here
        this.listaProd = productos;
        this.prod = productoEliminado;

    }

    /**
     * 
     */
    @Override
    public List<Producto> execute() {
        listaProd.remove(prod);
        return listaProd;
    }

    /**
     * 
     */
    @Override
    public List<Producto> undo() {
        listaProd.add(prod);
        return listaProd;
    }

}