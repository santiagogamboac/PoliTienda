package co.edu.poli.corte2.controller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.poli.corte2.model.Product;
import co.edu.poli.corte2.model.User;
import co.edu.poli.corte2.model.UserRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

public class MainController implements Initializable{

    Alert mensaje = new Alert(AlertType.INFORMATION);
    Alert error = new Alert(AlertType.ERROR);
    
    @FXML
    private Button btnLogin;

    @FXML
    private ImageView imgLogin;

    @FXML
    private TableColumn<Product, Integer> idProducts;

    @FXML
    private TableColumn<Product, String> nameProducts;

    @FXML
    private TableView tblProducts;

    @FXML
    private Button slCustomer;

    @FXML
    private Button slProduct;

    @FXML
    private Button slVendor;

    @FXML
    private PasswordField txtPass;

    @FXML
    private TextField txtUser;


    @FXML
    void ValidateUser(ActionEvent event) throws Exception {
        
        UserRepository usuarios = new UserRepository();
        String clave = txtPass.getText();
        String user = txtUser.getText();
        try {
            User usuarioLogueado = usuarios.getUser(user, clave);
            if(usuarioLogueado.getRole() != null){
                txtUser.setVisible(false);
                txtPass.setVisible(false);
                btnLogin.setVisible(false);
                imgLogin.setVisible(true);
                System.out.println("Rol: " + usuarioLogueado.getRole());
            }
        } catch (Exception e) {
            txtUser.setText("");
            txtPass.setText("");
            error.setContentText("Usuario o clave incorrecto");
            error.show();
        }
    }

    @FXML
    void customerInterface(ActionEvent event) {
        mensaje.setContentText("Proximamente");
        mensaje.show();
    }

    @FXML
    void productInterface(ActionEvent event) {

    }

    @FXML
    void vendorInterface(ActionEvent event) {
        mensaje.setContentText("Proximamente");
        mensaje.show();
    }

    @FXML
    void productDetail(ActionEvent event) {
        System.out.println("se toco este campo");
    }

    ObservableList<Product> initialData(){
    
        Product p1 = new Product(1, "Tablet Lenovo", "Tableta con Android", 380000);
        Product p2 = new Product(2, "SmartPhone Samsung", "Celular gama alta", 4850000);
        return FXCollections.<Product> observableArrayList(p1, p2);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idProducts.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id"));
        nameProducts.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        tblProducts.setItems(initialData());  
    }

}
