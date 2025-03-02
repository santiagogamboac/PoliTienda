package co.edu.poli.ejemplo.controlador;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.poli.ejemplo.modelo.Cliente;
import co.edu.poli.ejemplo.servicio.ClienteDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
public class ClienteViewController implements  Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            ClienteDAO clienteDAO = new ClienteDAO();
            columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
            columnNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

            ObservableList<Cliente> lista = FXCollections.observableArrayList(clienteDAO.readAll());
            tblregistrocliente.setItems(lista);
        } catch (Exception e) {
            org.controlsfx.control.Notifications.create().title("Error").text("Error al cargar clientes").showError();
        }
    }
    @FXML
    private Button btneliminar;

    @FXML
    private Button btnguardar;

    @FXML
    private TableColumn<Cliente, String> columnId;

    @FXML
    private TableColumn<Cliente, String> columnNombre;

    @FXML
    private TableView<Cliente> tblregistrocliente;

    @FXML
    private TextField txtid;

    @FXML
    private TextField txtnombre;

    @FXML
    void EliminarCliente(ActionEvent event) {

    }

    @FXML
    void GuardarCliente(ActionEvent event) {
        if (txtid.getText().isEmpty() || txtnombre.getText().isEmpty()) {
            org.controlsfx.control.Notifications.create().title("Advertencia").text("Ingrese todos los datos para poder registrar un cliente").showWarning();
            System.out.println("Por favor ingrese los datos del cliente");
        } else {
            Cliente cliente = new Cliente(txtid.getText(), txtnombre.getText());
            
            try {
                ClienteDAO clienteDAO = new ClienteDAO();
                
                String msj = clienteDAO.create(cliente);
                org.controlsfx.control.Notifications.create().title("Error").text(msj).show();
            } catch (Exception e) {
                org.controlsfx.control.Notifications.create().title("Error").text("Error al guardar cliente").showError();
            }
            
            System.out.println(cliente);
        }
    }
}
