package co.edu.poli.ejemplo.controlador;

import co.edu.poli.ejemplo.modelo.Certificacion;
import co.edu.poli.ejemplo.modelo.Evaluacion;
import co.edu.poli.ejemplo.modelo.PoliticaEntrega;
import co.edu.poli.ejemplo.modelo.Proveedor;
import co.edu.poli.ejemplo.modelo.Proveedor.Builder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class BuilderViewController {

    @FXML
    private Button btn_builder;
    @FXML
    private Label labelProducto;

    @FXML
    void btn_builder_click(ActionEvent event) {
        // Usamos el Builder para crear un proveedor
        Proveedor proveedor = new Builder()
        		.setID("1234")
            .setNombre("Proveedor XYZ")
            .setCelular("3154569874")
            .setCertificacion(new Certificacion("ISO 9001", "Entidad de Certificación", "30/03/2025"))
            .setEvaluacion(new Evaluacion("95", "Buena"))
            .setPoliticaEntrega(new PoliticaEntrega("dos dias","Express"))
            .build();

     // Mostramos los datos en la etiqueta
        labelProducto.setText("Proveedor creado: " + proveedor.getID() + " " + proveedor.getNombre() + " " + proveedor.getCelular() + 
        	    "\nCertificación: " + (proveedor.getCertificacion() != null ? 
        	        proveedor.getCertificacion().getNombre() + " - " + proveedor.getCertificacion().getEntidad() + " (" + proveedor.getCertificacion().getFechaObtencion() + ")"
        	        : "No especificada") + 
        	    "\nEvaluación: " + (proveedor.getEvaluacion() != null ? 
        	        proveedor.getEvaluacion().getCalificacion() + " - " + proveedor.getEvaluacion().getComentarios()
        	        : "No especificada") + 
        	    "\nPolítica de Entrega: " + (proveedor.getPoliticaEntrega() != null ? 
        	        proveedor.getPoliticaEntrega().getTiempoEntrega() + " - " + proveedor.getPoliticaEntrega().getCondiciones()
        	        : "No especificada"));
    }
   
    
}