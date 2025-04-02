package co.edu.poli.ejemplo.modelo;

/**
 * 
 */
public class Empleado implements Component {

    public Empleado(String name, String position) {
        this.name = name;
        this.position = position;        
    }
    private String name;
    private String position;

    @Override
    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }
}