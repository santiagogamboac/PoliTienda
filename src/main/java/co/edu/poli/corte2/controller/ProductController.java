package co.edu.poli.corte2.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import co.edu.poli.corte2.model.Product;
import co.edu.poli.corte2.model.ProductAccess;
import co.edu.poli.corte2.model.ProductAccessProxy;
import co.edu.poli.corte2.model.SessionManager;
import co.edu.poli.corte2.repositories.implementations.ProductRepository;
import co.edu.poli.corte2.repositories.implementations.UserRepository;
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
    private UserRepository ur = new UserRepository();
    private ProductRepository pr = new ProductRepository();
    private UserRepository userRepository;
    private SessionManager sessionManager;
    private ProductAccess productAccess;
    

    @FXML
    private TableColumn<Product, Integer> idProducts;

    @FXML
    private TableColumn<Product, String> nameProducts;

    @FXML
    private TableView<Product> tblProducts;

    @FXML
    private TextField txtIdProduct;

    @FXML
    void productDetails(ActionEvent event) throws Exception {
        int idProducto;
        idProducto = Integer.parseInt(txtIdProduct.getText());
        producto = pr.getProduct(idProducto);
        String prodDetail = productAccess.viewProductDetail(producto);
        if (prodDetail.contains("ID")) {
            mensaje.setContentText(prodDetail);
            mensaje.show();  
        }else {
            error.setContentText(prodDetail);
            error.show();  
        }
        
    }

    ObservableList<Product> initialData(){
    
        List<Product> p;
        try {
            p = pr.getAllProducts();
            ObservableList<Product> productList = FXCollections.<Product> observableArrayList(p);
            return productList;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        sessionManager = SessionManager.getInstance();
        System.out.println("Usuario actual: " + sessionManager.getCurrentUser());
        productAccess = new ProductAccessProxy(sessionManager.getCurrentUser());

        idProducts.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameProducts.setCellValueFactory(new PropertyValueFactory<>("name"));
        tblProducts.setItems(initialData());  
    } 

    public ProductController() {
        userRepository = ur.getInstance();
    }
}
