package co.edu.poli.ejemplo.modelo;



/**
 * 
 */
public class Cliente {

    /**
     * Default constructor
     */

	 public Cliente(String id, String nombre) {
			super();
			this.id = id;
			this.nombre = nombre;
		}

    private String id ;
    private String nombre;
	
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}