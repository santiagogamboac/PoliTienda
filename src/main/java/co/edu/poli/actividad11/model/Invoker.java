package co.edu.poli.actividad11.model;

import java.util.List;
import java.util.Stack;

/**
 * 
 */
public class Invoker {

    /**
     * 
     */
    private Stack<ProductoCommand> historial = new Stack<>();

    /**
     * @param command 
     * @return
     */
    public List<Producto> ejecutarComando(ProductoCommand command) {
        historial.push(command);        
        return command.execute();
    }

    /**
     * @return
     */
    public List<Producto> deshacerUltimoComando() {
        if (!historial.isEmpty()) {
            return historial.pop().undo();
        } else {
            System.out.println("No hay comandos para deshacer.");
            return null;
        }
    }

}