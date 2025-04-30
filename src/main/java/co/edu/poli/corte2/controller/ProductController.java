package co.edu.poli.corte2.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import co.edu.poli.corte2.model.Product;
import co.edu.poli.corte2.model.ProductAccess;
import co.edu.poli.corte2.model.ProductAccessProxy;
import co.edu.poli.corte2.model.SessionManager;
import co.edu.poli.corte2.model.Supplier;
import co.edu.poli.corte2.repositories.implementations.ProductRepository;
import co.edu.poli.corte2.repositories.implementations.SupplierRepository;
import co.edu.poli.corte2.repositories.implementations.UserRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProductController  implements Initializable{

    Alert error = new Alert(AlertType.ERROR);
    Product producto;
    Supplier proveedor;
    private List<co.edu.poli.corte2.model.Supplier> listaProveedores = new ArrayList<>();
    private SupplierRepository sp = new SupplierRepository();
    private UserRepository ur = new UserRepository();
    private ProductRepository pr = new ProductRepository();
    private SessionManager sessionManager;
    private ProductAccess productAccess;

    @FXML
    private TableColumn<Product, Integer> idProducts;

    @FXML
    private TableColumn<Product, String> nameProducts;

    @FXML
    private TableView<Product> tblProducts;
    
    @FXML
    private Label lblId;

    @FXML
    private ComboBox<String> slcSupplier;

    @FXML
    private TextField txtIdProduct;

    @FXML
    private TextArea txtProdDesc;

    @FXML
    private TextField txtProdName;

    @FXML
    private TextField txtProdPrice;

    @FXML
    void productDetails(ActionEvent event) throws Exception {
        int idProducto;
        Product prodDetail = null;
        idProducto = Integer.parseInt(txtIdProduct.getText());
        producto = pr.getProduct(idProducto);
        prodDetail = productAccess.viewProductDetail(producto);
        if (prodDetail != null) {
            lblId.setText("ID: " + prodDetail.getId());
            lblId.setId(String.valueOf(prodDetail.getId()));
            txtProdName.setText(prodDetail.getName());
            txtProdPrice.setText(String.valueOf(prodDetail.getPrice()));
            txtProdDesc.setText(prodDetail.getDescription());
            for (Object elem : listaProveedores) {
                proveedor = (Supplier) elem;
                if(proveedor.getId() == prodDetail.getSupplierId()) {
                    slcSupplier.setValue(proveedor.getName());
                }
            }
        }else {
            error.setContentText("Usuario no autorizado para realizar esta acción");
            error.show();  
        }
        
    }

    @FXML
    void gestionProducto(ActionEvent event) {
        if(txtProdName.getText().length() > 0 && txtProdPrice.getText().length() > 0 && slcSupplier.getValue() != null){
            int nombreProveedor = 0;
            int idProducto =0;
            try {
                idProducto = (Integer.parseInt(lblId.getId()) > 0) ? Integer.parseInt(lblId.getId()) : pr.getAllProducts().size() + 1;
                for (Object elem : listaProveedores) {
                    proveedor = (Supplier) elem;
                    if(proveedor.getName() == slcSupplier.getValue()) {
                        nombreProveedor = proveedor.getId();
                    }
                }
                Product nuevoProducto = new Product(
                    idProducto,
                    txtProdName.getText(),
                    txtProdDesc.getText(),
                    Double.parseDouble(txtProdPrice.getText()),
                    nombreProveedor
                );
                pr.addProduct(nuevoProducto);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            txtProdName.setText("");
            txtProdDesc.setText("");
            txtProdPrice.setText("");
            slcSupplier.setValue("");
            lblId.setId("0");
            tblProducts.setItems(initialData());
        } else {
            error.setContentText("Uno o mas campos están vacios, por favor diligencie el formulario");
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
        productAccess = new ProductAccessProxy(sessionManager.getCurrentUser());

        idProducts.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameProducts.setCellValueFactory(new PropertyValueFactory<>("name"));
        tblProducts.setItems(initialData()); 
        for (Supplier elem : listaProveedores) {
            slcSupplier.getItems().add(elem.getName());
        }
    } 

    public ProductController() {
        UserRepository userRepository = ur.getInstance();
        listaProveedores = sp.cargarProveedores();
    }
}
