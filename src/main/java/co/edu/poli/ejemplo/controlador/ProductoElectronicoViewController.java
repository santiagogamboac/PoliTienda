package co.edu.poli.ejemplo.controlador;

import co.edu.poli.ejemplo.modelo.ProductoElectronico;
import co.edu.poli.ejemplo.servicio.ProductoDAO;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ProductoElectronicoViewController {

    @FXML
    private TableView<ProductoElectronico> productoTable;
    @FXML
    private TableColumn<ProductoElectronico, String> idColumn;
    @FXML
    private TableColumn<ProductoElectronico, String> descripcionColumn;
    @FXML
    private TableColumn<ProductoElectronico, Double> precioColumn;
    @FXML
    private TableColumn<ProductoElectronico, Integer> garantiaColumn;
    @FXML
    private TextField idField;
    @FXML
    private TextField descripcionField;
    @FXML
    private TextField precioField;
    @FXML
    private TextField garantiaField;

    private ProductoDAO productoDAO;

    public ProductoElectronicoViewController() throws Exception {
        productoDAO = new ProductoDAO();
    }

    @FXML
    private void initialize() {
        // idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        // descripcionColumn.setCellValueFactory(cellData -> cellData.getValue().descripcionProperty());
        // precioColumn.setCellValueFactory(cellData -> cellData.getValue().precioProperty().asObject());
        // garantiaColumn.setCellValueFactory(cellData -> cellData.getValue().garantiaProperty().asObject());

        // productoTable.setItems(productoDAO.readAllElectronicos());
    }

    @FXML
    private void handleAddProducto() {
        ProductoElectronico producto = new ProductoElectronico(
            idField.getText(),
            descripcionField.getText(),
            Double.parseDouble(precioField.getText()),
            Integer.parseInt(garantiaField.getText())
        );
        productoDAO.create(producto);
        // productoTable.setItems(productoDAO.readAllElectronicos());
    }

    @FXML
    private void handleUpdateProducto() {
        ProductoElectronico producto = new ProductoElectronico(
            idField.getText(),
            descripcionField.getText(),
            Double.parseDouble(precioField.getText()),
            Integer.parseInt(garantiaField.getText())
        );
        productoDAO.update(producto.getId(), producto);
        // productoTable.setItems(productoDAO.readAllElectronicos());
    }

    @FXML
    private void handleDeleteProducto() {
        productoDAO.delete(idField.getText());
        // productoTable.setItems(productoDAO.readAllElectronicos());
    }
}
