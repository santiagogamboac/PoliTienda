package co.edu.poli.actividad11.model;

import java.util.List;

/**
 * 
 */
public interface ProductoCommand {

    /**
     * 
     */
    List<Producto> execute();
    

    /**
     * 
     */
    List<Producto> undo();

}