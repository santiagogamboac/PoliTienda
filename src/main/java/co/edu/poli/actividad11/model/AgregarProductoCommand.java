package co.edu.poli.actividad11.model;

import java.util.List;

/**
 * 
 */
public class AgregarProductoCommand implements ProductoCommand {

    /**
     * Default constructor
     */
    public AgregarProductoCommand() {
    }

    /**
     * 
     */
    private List<Producto> productos;

    /**
     * 
     */
    private Producto prod;

    /**
     * @param productos 
     * @param nombreProducto
     */
    public AgregarProductoCommand(List<Producto> productos, String nombreProducto) {
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