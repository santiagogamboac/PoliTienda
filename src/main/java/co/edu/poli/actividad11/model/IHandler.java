package co.edu.poli.actividad11.model;

public interface IHandler {

    public IHandler setNext(IHandler handler);

    public void handle(Cliente cliente);
}
