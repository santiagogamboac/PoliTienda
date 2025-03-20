package co.edu.poli.ejemplo.modelo;
import java.util.List;

/**
 * 
 */
public class Departamento extends Unidad {

    /**
     * Default constructor
     */
    public Departamento() {
    }

    /**
     * 
     */
    private String nombre;

    /**
     * 
     */
    private List<Unidad> miembros;

    /**
     * @param m
     */
    public void agregarMiembro(Unidad m) {
     miembros.add(m);
    }

    /**
     * @param m
     */
    public void eliminarMiembro(Unidad m) {
       miembros.remove(m);
    }

    /**
     * @param indice 
     * @return
     */
    public Unidad getMiembro(int indice) {
        for (Object elem : miembros) {
            System.out.println(elem);
        }

        return null;
    }

    /**
     * @return
     */
    public Void mostrarDetalle() {
        // TODO implement Component.mostrarDetalle() here
        return null;
    }

    /**
     * @return
     */
    public String getNombre() {
   
        return "";
    }

}