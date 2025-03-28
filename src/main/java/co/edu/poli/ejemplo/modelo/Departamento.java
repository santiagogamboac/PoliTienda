package co.edu.poli.ejemplo.modelo;
import java.util.*;

public class Departamento implements Component, CompositeOperations {

    private String name;
    private List<Component> components = new ArrayList<Component>();

    public Departamento(String name) {
        this.name = name;
    }

    @Override
    public String getName() {        
        return name;
    }

    public void add(Component component) {
        components.add(component);      
    }
  
    public void remove(Component component) {
        components.remove(component);    
    }

     public Component getChild(int index) {
        if (index >= 0 && index < components.size()) {
            return components.get(index);
        }
        return null;
    }

    /**
     * @return
     */
    public List<Component> getComponents() {
        return new ArrayList<>(components);
  
    }

}