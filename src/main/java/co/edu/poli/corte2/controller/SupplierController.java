package co.edu.poli.corte2.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import co.edu.poli.corte2.model.Product;
import co.edu.poli.corte2.model.Supplier;
import co.edu.poli.corte2.model.SupplierFactory;
import co.edu.poli.corte2.model.productViewDTO;
import co.edu.poli.corte2.repositories.implementations.ProductRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class SupplierController implements javafx.fxml.Initializable {

    @FXML
    private Button btnGuardar;
    @FXML
    private TableView<productViewDTO> tblProducts;
    @FXML
    private ComboBox<String> cmbProveedores;

    @FXML
    private TableColumn<productViewDTO, Integer> idProducts;

    @FXML
    private TableColumn<productViewDTO, String> nameProducts;

    @FXML
    private ComboBox<?> slcSupplier;

    @FXML
    private TableColumn<productViewDTO, String> supplierProducts;

    @FXML
    private TextField txtNombreProducto;

    @FXML
    private TextField txtPrecioProducto;
    @FXML
    private TextArea txtDescripcionProducto;

    @FXML
    void productDetails(ActionEvent event) {

    }

    @Override
    public void initialize(java.net.URL location, java.util.ResourceBundle resources) {

        nameProducts.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getName()));
        supplierProducts.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getSupplierName()));

        // Limpia el ComboBox y agrega la opción para nuevo proveedor
        cmbProveedores.getItems().clear();
        cmbProveedores.getItems().add("-- Nuevo Proveedor --");
        SupplierFactory supplierFactory = new SupplierFactory();
        List<Supplier> proveedores = supplierFactory.getAllSuppliers();

        // Agrega todos los proveedores registrados al ComboBox
        for (Supplier proveedor : proveedores) {
            cmbProveedores.getItems().add(proveedor.getName());
        }

        // Selecciona por defecto "-- Nuevo Proveedor --"
        cmbProveedores.setValue("-- Nuevo Proveedor --");
        cargarProductosEnTabla();
    }

    @FXML
    void btnGuardar_Click(ActionEvent event) {
        try {

            String nombre = txtNombreProducto.getText();
            double precio = Double.parseDouble(txtPrecioProducto.getText());
            String descripcion = txtDescripcionProducto.getText();
            // Obtener el valor seleccionado del ComboBox
            String nombreProveedor = cmbProveedores.getValue();

            if (nombreProveedor == null) {
                mostrarError("Debe seleccionar un proveedor");
                return;
            }

            // Si es "Nuevo Proveedor", mostrar diálogo para crear uno
            if (nombreProveedor.equals("-- Nuevo Proveedor --")) {
                // Mostrar diálogo para crear proveedor
                // Si el proveedor se crea con éxito, obtener su instancia
                Supplier nuevoProveedor = mostrarDialogoNuevoProveedor();

                if (nuevoProveedor == null) {
                    // El usuario canceló la creación del proveedor
                    return;
                }
                SupplierFactory sp = new SupplierFactory();

                int id = sp.getUltimoIdProveedor();
                Product producto = new Product(id, nombre, descripcion, precio, nuevoProveedor.getId());
                guardarProducto(producto);
            } else {
                // Obtener la instancia existente del proveedor usando el Factory
                Supplier proveedorExistente = SupplierFactory.getSupplierByName(nombreProveedor);

                // Aquí está la clave del patrón Flyweight: 
                // Reutilizas la instancia existente del proveedor
                int id = SupplierFactory.getUltimoIdProveedor();
                Product producto = new Product(id, nombre, descripcion, precio, proveedorExistente.getId());
                guardarProducto(producto);
            }

            limpiarFormulario();

        } catch (NumberFormatException e) {
            mostrarError("El precio debe ser un número válido");
        } catch (Exception e) {
            mostrarError("Error al guardar el producto: " + e.getMessage());
        }
    }
    private ProductRepository pr = new ProductRepository();
    List<Product> p;

    private void cargarProductosEnTabla() {
        List<Product> productos;
        try {
            productos = pr.getAllProducts();

            SupplierFactory supplierFactory = new SupplierFactory();
            List<productViewDTO> dtos = new ArrayList<>();

            for (Product p : productos) {
                Supplier proveedor = supplierFactory.getSupplierById(p.getSupplierId());
                dtos.add(new productViewDTO(p, proveedor));
            }

            tblProducts.setItems(javafx.collections.FXCollections.observableArrayList(dtos));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private Supplier mostrarDialogoNuevoProveedor() {
        Dialog<Supplier> dialog = new Dialog<>();
        dialog.setTitle("Nuevo Proveedor");
        dialog.setHeaderText("Ingrese los datos del nuevo proveedor");

        // Configurar botones
        ButtonType btnGuardarType = new ButtonType("Guardar", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(btnGuardarType, ButtonType.CANCEL);

        // Crear el layout del diálogo
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField txtNombre = new TextField();
        TextField txtEmail = new TextField();

        grid.add(new Label("Nombre:"), 0, 0);
        grid.add(txtNombre, 1, 0);
        grid.add(new Label("Email:"), 0, 1);
        grid.add(txtEmail, 1, 1);

        dialog.getDialogPane().setContent(grid);

        // Convertir el resultado
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == btnGuardarType) {
                String nombre = txtNombre.getText();
                String email = txtEmail.getText();

                if (nombre.isEmpty() || email.isEmpty()) {
                    return null;
                }
                // Usar la factory para crear/obtener el proveedor
                // Esto es clave para el patrón Flyweight:
                // Si ya existe un proveedor con ese nombre, devolverá la instancia existente
                // Si no existe, creará una nueva instancia y la almacenará en caché
                return SupplierFactory.getSupplier(nombre, email);
            }
            return null;
        });

        // Mostrar diálogo y obtener resultado
        Optional<Supplier> resultado = dialog.showAndWait();
        return resultado.orElse(null);
    }

    private void guardarProducto(Product producto) {
        // Aquí iría tu lógica para guardar el producto en la base de datos o donde sea necesario
        // System.out.println("Guardando producto: " + producto.getNombre());
        // System.out.println("Con proveedor: " + producto.getProveedor().getNombre());
    }

    private void guardarProveedor(Supplier producto) {
        // Aquí iría tu lógica para guardar el producto en la base de datos o donde sea necesario
        // System.out.println("Guardando producto: " + producto.getNombre());
        // System.out.println("Con proveedor: " + producto.getProveedor().getNombre());
    }

    private void limpiarFormulario() {

        txtNombreProducto.clear();
        txtPrecioProducto.clear();
        cmbProveedores.setValue(null);
    }

    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
