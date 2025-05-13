package co.edu.poli.actividad11.model;

public abstract class AbstractHandler implements IHandler {

    private IHandler next;

    @Override
    public IHandler setNext(IHandler handler) {
        this.next = handler;
        return handler;
    }

    @Override
    public void handle(Cliente cliente) {
        if (next != null) {
            next.handle(cliente);
        }
    }
}
