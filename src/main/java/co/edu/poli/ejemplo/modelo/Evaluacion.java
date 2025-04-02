package co.edu.poli.ejemplo.modelo;


public class Evaluacion {
 private String calificacion;
 private String comentarios;

 public Evaluacion(String calificacion, String comentarios) {
     this.calificacion = calificacion;
     this.comentarios = comentarios;
 }

 public String getCalificacion() { return calificacion; }
 public String getComentarios() { return comentarios; }

public void setCalificacion(String calificacion) {
	this.calificacion = calificacion;
}

public void setComentarios(String comentarios) {
	this.comentarios = comentarios;
}

 
}
