package co.edu.poli.actividad10.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class HistorialPrecios {
    private Producto producto;
    private Stack<PrecioMemento> mementos = new Stack<>();
    private Stack<PrecioMemento> redoStack = new Stack<>();
    
    public HistorialPrecios(Producto producto) {
        this.producto = producto;
        guardarEstado();
    }
    
    public void guardarEstado() {
        mementos.push(new PrecioMemento(producto.getPrecio()));
        redoStack.clear();
    }
    
    public void registrarCambioPrecio() {
        guardarEstado();
    }
    
    public void undo() {
        if (!mementos.isEmpty()) {
            PrecioMemento mementoActual = mementos.pop();
            redoStack.push(new PrecioMemento(producto.getPrecio()));
            
            if (!mementos.isEmpty()) {
                PrecioMemento mementoAnterior = mementos.peek();
                producto.setPrecio(mementoAnterior.getPrecio());
            }
        }
    }
    
    public void redo() {
        if (!redoStack.isEmpty()) {
            PrecioMemento memento = redoStack.pop();
            guardarEstado();
            producto.setPrecio(memento.getPrecio());
        }
    }
    
    public List<PrecioMemento> obtenerHistorialCompleto() {
        return new ArrayList<>(mementos);
    }
}