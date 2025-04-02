package co.edu.poli.ejemplo.modelo;

public class Proveedor  {
    private String ID;
    private String nombre;
    private String celular;
    private Certificacion certificacion;
    private Evaluacion evaluacion;
    private PoliticaEntrega politicaEntrega;

    public Proveedor(Builder builder) {
        this.ID = builder.ID;
        this.nombre = builder.nombre;
        this.celular = builder.celular;
        this.certificacion = builder.certificacion;
        this.evaluacion = builder.evaluacion;
        this.politicaEntrega = builder.politicaEntrega;
    }

   // public Proveedor(String iD2, String nombre2, String celular2, Certificacion certificacion2, Evaluacion evaluacion2,
    //		PoliticaEntrega politicaEntrega2) {
		// TODO Auto-generated constructor stub   	
	//}

	public static class Builder {
        private String ID;
        private String nombre;
        private String celular;
        private Certificacion certificacion;
        private Evaluacion evaluacion;
        private PoliticaEntrega politicaEntrega;

        public Builder setID(String ID) {
            this.ID = ID;
            return this;
        }

        public Builder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder setCelular(String celular) {
            this.celular = celular;
            return this;
        }

        public Builder setCertificacion(Certificacion certificacion) {
            this.certificacion = certificacion;
            return this;
        }

        public Builder setEvaluacion(Evaluacion evaluacion) {
            this.evaluacion = evaluacion;
            return this;
        }

        public Builder setPoliticaEntrega(PoliticaEntrega politicaEntrega) {
            this.politicaEntrega = politicaEntrega;
            return this;
        }

        public Proveedor build() {
          
            if (certificacion == null || evaluacion == null || politicaEntrega == null) {
                throw new IllegalStateException("No se puede construir un Proveedor sin todos los campos requeridos");
            }

            return new Proveedor(this);
        }
       
    }

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Certificacion getCertificacion() {
		return certificacion;
	}

	public void setCertificacion(Certificacion certificacion) {
		this.certificacion = certificacion;
	}

	public Evaluacion getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(Evaluacion evaluacion) {
		this.evaluacion = evaluacion;
	}

	public PoliticaEntrega getPoliticaEntrega() {
		return politicaEntrega;
	}

	public void setPoliticaEntrega(PoliticaEntrega politicaEntrega) {
		this.politicaEntrega = politicaEntrega;
	}
	
}