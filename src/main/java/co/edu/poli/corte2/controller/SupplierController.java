package co.edu.poli.corte2.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class SupplierController implements Initializable{

    @FXML
    private TableColumn<?, ?> idProducts;

    @FXML
    private TableColumn<?, ?> nameProducts;

    @FXML
    private ComboBox<?> slcSupplier;

    @FXML
    private TableView<?> tblProducts;

    @FXML
    void productDetails(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
       System.out.println("Cargando proveedores");
    }

}
