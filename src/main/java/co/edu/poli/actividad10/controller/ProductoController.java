package co.edu.poli.actividad10.controller;

import java.net.URL;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import co.edu.poli.actividad10.model.CatalogoProductos;
import co.edu.poli.actividad10.model.HistorialPrecios;
import co.edu.poli.actividad10.model.Producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProductoController implements Initializable{

    @FXML
    private Button BtnRestartPrice;

    @FXML
    private Button btnChangePrice;

    @FXML
    private TextField txtPercent;

    @FXML
    private TableColumn<String, Producto> codeProducts;

    @FXML
    private TableColumn<String, Producto> descProducts;

    @FXML
    private TableColumn<String, Producto> nameProducts;

    @FXML
    private TableColumn<String, Producto> priceProducts;

    @FXML
    private TableView<Producto> tblProducts;

    @FXML
    private TextField txtCodeProduct;

    @FXML
    private TextField txtProdCode;

    @FXML
    private TextArea txtProdDesc;

    @FXML
    private TextField txtProdName;

    @FXML
    private TextField txtProdPrice;

    private CatalogoProductos productos = new CatalogoProductos();
    private Map<String, Double> preciosOriginales = new HashMap<>();
    private Set<String> productosModificados = new HashSet<>(); 
    Date fecha = new Date();
    
    private Producto producto = new Producto();
    Alert error = new Alert(AlertType.ERROR);



    @FXML
    void cambiarPrecio(ActionEvent event) {
     String porcentajeStr = txtPercent.getText();
        int porcentaje = Integer.parseInt(porcentajeStr);
        

          preciosOriginales.clear();
            productosModificados.clear();

            
        Collection<Producto> prAll = productos.obtenerTodosProductos();

        
   

        for (Producto producto : prAll) {
          if (!preciosOriginales.containsKey(producto.getCodigo())) {
                    preciosOriginales.put(producto.getCodigo(), producto.getPrecio());
                }

                double nuevoPrecio = producto.getPrecio() * (1 + porcentaje / 100.0);
                producto.setPrecio(nuevoPrecio); // Modificar precio

                productosModificados.add(producto.getCodigo()); 
                
       
                  HistorialPrecios historial = productos.obtenerHistorial(producto.getCodigo());
                if (historial != null) {
                    historial.registrarCambioPrecio();
                }
        }    
                    // Actualizar tabla
            tblProducts.refresh();                
    }

    @FXML
    void restaurarPrecio(ActionEvent event) {
  try {
        for (String codigo : productosModificados) {
                if (preciosOriginales.containsKey(codigo)) {
                    Producto producto = productos.obtenerProducto(codigo);
                    if (producto != null) {
                        producto.setPrecio(preciosOriginales.get(codigo));
                     
                        HistorialPrecios historial = productos.obtenerHistorial(codigo);
                        if (historial != null) {
                            historial.registrarCambioPrecio();
                        }
                    }
                }
            }
            
            // Limpiar los registros
            preciosOriginales.clear();
            productosModificados.clear();
                       tblProducts.refresh();  
            
    } catch (Exception e) {
        error.setContentText("Ocurrió un error al restaurar los precios.");
        error.show();
    }
    }

    @FXML
    void gestionProducto(ActionEvent event) {
        
        if(txtProdName.getText().length() > 0 && txtProdPrice.getText().length() > 0 && txtProdCode.getText().length() > 0){
            String idProducto;
            try {
                idProducto = (txtProdCode.getText() != null) ? txtProdCode.getText() : String.valueOf(productos.obtenerTodosProductos().size() + 1);
                
                Producto nuevoProducto = new Producto(
                    txtProdName.getText(), 
                    idProducto, 
                    Double.parseDouble(txtProdPrice.getText()), 
                    txtProdDesc.getText(), 
                    fecha,                
                    null,
                    null
                );
                productos.agregarProducto(nuevoProducto);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            txtProdName.setText("");
            txtProdDesc.setText("");
            txtProdPrice.setText("");
            txtProdCode.setText("");
            tblProducts.setItems(initialData());
        } else {
            error.setContentText("Uno o mas campos están vacios, por favor diligencie el formulario");
            error.show();
        }
    }

    @FXML
    void productDetails(ActionEvent event) {

        String codigo = txtCodeProduct.getText();
        try {
            producto = productos.obtenerProducto(codigo);
            if (producto.getCodigo() != null || producto.getCodigo() != codigo) {
                txtProdCode.setText(producto.getCodigo());
                txtProdName.setText(producto.getNombre());
                txtProdDesc.setText(producto.getDescripcion());
                txtProdPrice.setText(String.valueOf(producto.getPrecio()));
            } else {
                error.setContentText("El producto no existe");
            }
            
        } catch (Exception e) {
            error.setContentText("Algo anda mal con el producto");
        }
    }

    ObservableList<Producto> initialData(){
    
        Collection p;
        try {
            p = productos.obtenerTodosProductos();
            ObservableList<Producto> productList = FXCollections.observableArrayList(p);
            return productList;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        codeProducts.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        nameProducts.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        descProducts.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        priceProducts.setCellValueFactory(new PropertyValueFactory<>("precio"));
        tblProducts.setItems(initialData()); 
    }

}
