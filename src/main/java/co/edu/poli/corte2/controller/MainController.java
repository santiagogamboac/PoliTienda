package co.edu.poli.corte2.controller;

import java.io.IOException;

import co.edu.poli.corte2.model.User;
import co.edu.poli.corte2.model.UserRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;


public class MainController{

    Alert mensaje = new Alert(AlertType.INFORMATION);
    Alert error = new Alert(AlertType.ERROR);

    @FXML
    private Button btnCustomer;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnProduct;

    @FXML
    private Button btnVendor;
    
    @FXML
    private ImageView imgLogin;

    @FXML
    private PasswordField txtPass;

    @FXML
    private TextField txtUser;

    @FXML
    private VBox vboxPrincipal;

    @FXML
    void ValidateUser(ActionEvent event) {
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
        try {
            // Cargar ProductoView.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/poli/corte2/view/CustomerView.fxml"));
            VBox productoVBox = loader.load();

            // Reemplazar el VBox principal
            vboxPrincipal.getChildren().clear(); // Vaciar el contenido actual
            vboxPrincipal.getChildren().add(productoVBox); // Agregar el nuevo VBox
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void productInterface(ActionEvent event) throws IOException {
       
        try {
            // Cargar ProductoView.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/poli/corte2/view/ProductView.fxml"));
            VBox productoVBox = loader.load();

            // Reemplazar el VBox principal
            vboxPrincipal.getChildren().clear(); // Vaciar el contenido actual
            vboxPrincipal.getChildren().add(productoVBox); // Agregar el nuevo VBox
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void vendorInterface(ActionEvent event) {
        mensaje.setContentText("Proximamente");
        mensaje.show();
    }
}
