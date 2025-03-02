package co.edu.poli.ejemplo.controlador;

import co.edu.poli.ejemplo.modelo.ProductoAlimento;
import co.edu.poli.ejemplo.servicio.ProductoDAO;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProductoAlimentoViewController {

    @FXML
    private TableView<ProductoAlimento> productoTable;
    @FXML
    private TableColumn<ProductoAlimento, String> idColumn;
    @FXML
    private TableColumn<ProductoAlimento, String> descripcionColumn;
    @FXML
    private TableColumn<ProductoAlimento, Double> precioColumn;
    @FXML
    private TableColumn<ProductoAlimento, Integer> caloriasColumn;
    @FXML
    private TextField idField;
    @FXML
    private TextField descripcionField;
    @FXML
    private TextField precioField;
    @FXML
    private TextField caloriasField;

    private ProductoDAO productoDAO;

    public ProductoAlimentoViewController() throws Exception {
        productoDAO = new ProductoDAO();
    }

    @FXML
    private void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        descripcionColumn.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        precioColumn.setCellValueFactory(new PropertyValueFactory<>("precio"));
        caloriasColumn.setCellValueFactory(new PropertyValueFactory<>("calorias"));

        //productoTable.setItems(productoDAO.readAllAlimentos());
    }

    @FXML
    private void handleAddProducto() {
        // ProductoAlimento producto = new ProductoAlimento(
        //     idField.getText(),
        //     descripcionField.getText(),
        //     Double.parseDouble(precioField.getText()),
        //     Integer.parseInt(caloriasField.getText())
        // );
        // productoDAO.create(producto);
        // productoTable.setItems(productoDAO.readAllAlimentos());
    }

    @FXML
    private void handleUpdateProducto() {
        // ProductoAlimento producto = new ProductoAlimento(
        //     idField.getText(),
        //     descripcionField.getText(),
        //     Double.parseDouble(precioField.getText()),
        //     Integer.parseInt(caloriasField.getText())
        // );
        // productoDAO.update(producto.getId(), producto);
        // productoTable.setItems(productoDAO.readAllAlimentos());
    }

    @FXML
    private void handleDeleteProducto() {
        // productoDAO.delete(idField.getText());
        // productoTable.setItems(productoDAO.readAllAlimentos());
    }
}
