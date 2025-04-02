package co.edu.poli.ejemplo.modelo;

public class PoliticaEntrega {
    private String tiempoEntrega;
    private String condiciones;

    public PoliticaEntrega(String tiempoEntrega, String condiciones) {
        this.tiempoEntrega = tiempoEntrega;
        this.condiciones = condiciones;
    }

    public String getTiempoEntrega() { return tiempoEntrega; }
    public String getCondiciones() { return condiciones; }

	public void setTiempoEntrega(String tiempoEntrega) {
		this.tiempoEntrega = tiempoEntrega;
	}

	public void setCondiciones(String condiciones) {
		this.condiciones = condiciones;
	}

    
}