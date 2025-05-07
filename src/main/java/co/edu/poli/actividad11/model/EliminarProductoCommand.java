package co.edu.poli.actividad11.model;

import java.util.List;

/**
 * 
 */
public class EliminarProductoCommand implements ProductoCommand {

    /**
     * Default constructor
     */
    public EliminarProductoCommand() {
    }

    /**
     * 
     */
    private Producto prod;


    /**
     * @param productos 
     * @param nombreProducto
     */
    public EliminarProductoCommand(List<Producto> productos, String nombreProducto) {
        // TODO implement here
    }

    /**
     * @return
     */
    public void execute() {
        // TODO implement ProductoCommand.execute() here

    }

    /**
     * @return
     */
    public void undo() {
        // TODO implement ProductoCommand.undo() here

    }

}