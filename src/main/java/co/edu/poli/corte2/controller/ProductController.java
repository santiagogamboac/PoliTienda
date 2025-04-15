package co.edu.poli.corte2.controller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.poli.corte2.model.Product;
import co.edu.poli.corte2.model.ProductAccessProxy;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProductController  implements Initializable{

    Alert mensaje = new Alert(AlertType.INFORMATION);
    Alert error = new Alert(AlertType.ERROR);
    Product producto;
    ProductAccessProxy pap = new ProductAccessProxy();

    @FXML
    private TableColumn<Product, Integer> idProducts;

    @FXML
    private TableColumn<Product, String> nameProducts;

    @FXML
    private TableView<Product> tblProducts;

    @FXML
    private TextField txtIdProduct;

    @FXML
    void productDetails(ActionEvent event) {
        int idProducto;
        idProducto = Integer.parseInt(txtIdProduct.getText());
        System.out.println("Producto: " + idProducto);
        producto.setId(idProducto);
        String prodDetail = pap.viewProductDetail(producto);
        mensaje.setContentText(prodDetail);
        mensaje.show();  
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
