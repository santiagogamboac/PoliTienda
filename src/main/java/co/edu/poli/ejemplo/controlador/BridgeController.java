package co.edu.poli.ejemplo.controlador;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.poli.ejemplo.modelo.CargaFragil;
import co.edu.poli.ejemplo.modelo.CargaPesada;
import co.edu.poli.ejemplo.modelo.Documento;
import co.edu.poli.ejemplo.modelo.Envio;
import co.edu.poli.ejemplo.modelo.EnvioInternacional;
import co.edu.poli.ejemplo.modelo.EnvioNacional;
import co.edu.poli.ejemplo.modelo.Mercancia;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class BridgeController implements Initializable{
    
    
    @FXML
    private Label mensaje;
    
    @FXML
    private Button btnEnvio;
    
    @FXML
    private ChoiceBox<String> selectEnvio;
    
    @FXML
    private ChoiceBox<String> selectMerch;
    
    private String[] opcionEnvio = {"Nacional", "Internacional"};
    private String[] opcionMercancia = {"Carga Pesada", "Carga Frágil", "Documentos"};

    Envio tipoEnvio;
    Mercancia tipoMercancia;
    String mensajeMercancia;
    Alert error = new Alert(AlertType.ERROR);
    
    @FXML
    void generarOrdenEnvio(ActionEvent event) {
        if (selectEnvio.getValue() == null) {
            error.setContentText("Debe seleccionar el Tipo de envío para continuar");
            error.show();
        }else if (selectMerch.getValue() == null) {
            error.setContentText("Debe seleccionar el Tipo de Mercancia para continuar");
            error.show();
        }else {
            // Realizar envíos
            switch (selectEnvio.getValue()) {
                case "Nacional" :
                    tipoEnvio = new EnvioNacional(100); 
                break;
                case "Internacional" :
                    tipoEnvio = new EnvioInternacional(300, 0.2);
                break;
            }

            switch (selectMerch.getValue()) {
                case "Carga Pesada" :
                    tipoMercancia = new CargaPesada(tipoEnvio, 120, true);
                    mensajeMercancia = tipoMercancia.realizarEnvio();
                break;
                case "Carga Frágil" :
                    tipoMercancia = new CargaFragil(tipoEnvio, 5, 0.8);
                    mensajeMercancia = tipoMercancia.realizarEnvio();
                break;

                case "Documentos" :
                    tipoMercancia = new Documento(tipoEnvio, 50);
                    mensajeMercancia = tipoMercancia.realizarEnvio();
                break;
            }
            mensaje.setText("Enviando: " + tipoMercancia.obtenerDescripcion() + "\n" + mensajeMercancia);
        }
        
       
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        selectEnvio.getItems().addAll(opcionEnvio);
        selectMerch.getItems().addAll(opcionMercancia);
    }

}
