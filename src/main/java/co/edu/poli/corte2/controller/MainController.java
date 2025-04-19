package co.edu.poli.corte2.controller;

import java.io.IOException;

import co.edu.poli.corte2.model.SessionManager;
import co.edu.poli.corte2.model.User;
import co.edu.poli.corte2.repositories.implementations.UserRepository;
import co.edu.poli.corte2.repositories.interfaces.IUserRepository;
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

public class MainController {

    Alert mensaje = new Alert(AlertType.INFORMATION);
    Alert error = new Alert(AlertType.ERROR);
    FXMLLoader loader;
    VBox opcionVBox;
    private IUserRepository userRepository;
    private SessionManager sessionManager;

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
    private ImageView imgPrincipal;

    @FXML
    private PasswordField txtPass;

    @FXML
    private TextField txtUser;

    @FXML
    private VBox vboxPrincipal;

    @FXML
    void ValidateUser(ActionEvent event) {
        User usuarioLogueado = null;
        if (txtPass.getText().isEmpty() || txtUser.getText().isEmpty()) {
            error.setHeaderText("Campos vacíos");
            error.setContentText("Por favor diligencie los campos");
            error.show();
        } else {
            String clave = txtPass.getText();
            String user = txtUser.getText();
            try {
                switch (btnLogin.getText()) {
                    case "Iniciar Sesión":
                    usuarioLogueado = userRepository.getUser(user, SessionManager.encrypt(clave));
                        if (usuarioLogueado != null) {
                            txtUser.setVisible(false);
                            txtPass.setVisible(false);
                            imgLogin.setVisible(true);
                            btnCustomer.setDisable(false);
                            btnProduct.setDisable(false);
                            btnVendor.setDisable(false);
                            btnLogin.setText("Cerrar Sesión");
                            sessionManager.setCurrentUser(usuarioLogueado);
                        } else {
                            txtUser.setText("");
                            txtPass.setText("");
                            error.setHeaderText("Error de Autenticación");
                            error.setContentText("Usuario o clave incorrecto");
                            error.show();
                        }
                        break;
                    case "Cerrar Sesión":
                        vboxPrincipal.getChildren().clear();
                        txtUser.setText("");
                        txtPass.setText("");
                        btnLogin.setText("Iniciar Sesión");
                        txtUser.setVisible(true);
                        txtPass.setVisible(true);
                        imgLogin.setVisible(false);
                        btnCustomer.setDisable(true);
                        btnProduct.setDisable(true);
                        btnVendor.setDisable(true);
                        sessionManager.logout();

                        break;
                    default:
                        throw new AssertionError();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void customerInterface(ActionEvent event) {
        try {
            // Cargar CustomerView.fxml
            loader = new FXMLLoader(getClass().getResource("/co/edu/poli/corte2/view/CustomerView.fxml"));

            opcionVBox = loader.load();
            // CustomerController controller = loader.getController();
            // controller.setShopAdminFacade(new ShopAdminFacade());
            // controller.loadCustomerData();
            vboxPrincipal.getChildren().clear(); // Vaciar el contenido actual
            vboxPrincipal.getChildren().add(opcionVBox); // Agregar el nuevo VBox
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void productInterface(ActionEvent event) throws IOException {

        try {
            // Cargar ProductoView.fxml
            loader = new FXMLLoader(getClass().getResource("/co/edu/poli/corte2/view/ProductView.fxml"));
            opcionVBox = loader.load();

            // Reemplazar el VBox principal
            vboxPrincipal.getChildren().clear(); // Vaciar el contenido actual
            vboxPrincipal.getChildren().add(opcionVBox); // Agregar el nuevo VBox
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void vendorInterface(ActionEvent event) {
        try {
            // Cargar ProductoView.fxml
            loader = new FXMLLoader(getClass().getResource("/co/edu/poli/corte2/view/SupplierView.fxml"));
            opcionVBox = loader.load();

            // Reemplazar el VBox principal
            vboxPrincipal.getChildren().clear(); // Vaciar el contenido actual
            vboxPrincipal.getChildren().add(opcionVBox); // Agregar el nuevo VBox
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MainController() {
        userRepository = UserRepository.getInstance();
        sessionManager = SessionManager.getInstance();
    }
}
