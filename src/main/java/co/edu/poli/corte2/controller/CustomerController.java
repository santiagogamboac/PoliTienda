package co.edu.poli.corte2.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CustomerController {

    @FXML
    private TableColumn<?, ?> idProducts;

    @FXML
    private TableColumn<?, ?> nameProducts;

    @FXML
    private TableView<?> tblProducts;

    @FXML
    private TextField txtIdProduct;

    @FXML
    void productDetails(ActionEvent event) {

    }

}
