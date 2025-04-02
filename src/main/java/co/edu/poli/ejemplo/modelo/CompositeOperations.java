package co.edu.poli.ejemplo.modelo;

import java.util.List;

/**
 * 
 */
public interface CompositeOperations {

    /**
     * @param Component 
     * @return
     */
    public void add(Component component);

    /**
     * @param Component 
     * @return
     */
    public void remove(Component component);

    /**
     * @param int 
     * @return
     */
    public Component getChild(int index);

    /**
     * @return
     */
    public List<Component> getComponents();

}