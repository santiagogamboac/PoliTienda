package co.edu.poli.ejemplo.modelo;

public class Certificacion {
    private String nombre;
    private String entidad;
    private String fechaObtencion;

    public Certificacion(String nombre, String entidad, String fechaObtencion) {
        this.nombre = nombre;
        this.entidad = entidad;
        this.fechaObtencion = fechaObtencion;
    }

    public String getNombre() { return nombre; }
    public String getEntidad() { return entidad; }
    public String getFechaObtencion() { return fechaObtencion; }

	public Object getCalificacion() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getComentarios() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public void setFechaObtencion(String fechaObtencion) {
		this.fechaObtencion = fechaObtencion;
	}
	
}
