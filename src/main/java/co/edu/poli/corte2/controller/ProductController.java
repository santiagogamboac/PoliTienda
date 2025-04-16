package co.edu.poli.corte2.controller;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import co.edu.poli.corte2.model.Product;
import co.edu.poli.corte2.model.ProductAccess;
import co.edu.poli.corte2.model.ProductAccessProxy;
import co.edu.poli.corte2.model.ProductRepository;
import co.edu.poli.corte2.model.SessionManager;
import co.edu.poli.corte2.model.UserRepository;
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
        producto = ProductRepository.getProduct(idProducto);
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
    
        ObservableList<Product> productList = FXCollections.<Product> observableArrayList();
        try {
            Map<Integer, Product> p = ProductRepository.getAllProducts();
            productList.addAll(p.values());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        productAccess = new ProductAccessProxy(sessionManager.getCurrentUser());
        idProducts.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id"));
        nameProducts.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        tblProducts.setItems(initialData());  
    } 

    public ProductController() {
        userRepository = UserRepository.getInstance();
        sessionManager = SessionManager.getInstance();
        productAccess = new ProductAccessProxy(sessionManager.getCurrentUser());
    }
}
