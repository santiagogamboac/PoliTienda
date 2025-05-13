package co.edu.poli.actividad11.model;

/**
 *
 */
public class ValidarEmailHandler extends AbstractHandler {

    /**
     * Default constructor
     */
    @Override
    public void handle(Cliente cliente) {
        if (cliente.getCorreo() == null || !cliente.getCorreo().contains("@")) {
            throw new RuntimeException("Email no válido");
        }
        super.handle(cliente);
    }

}
