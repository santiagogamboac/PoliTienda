package co.edu.poli.ejemplo.controlador;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.poli.ejemplo.modelo.Component;
import co.edu.poli.ejemplo.modelo.Departamento;
import co.edu.poli.ejemplo.modelo.Empleado;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.layout.AnchorPane;

public class TreeTableViewController implements Initializable {
        @FXML
    private TreeTableColumn<Component, String> colNombre;

    @FXML
    private TreeTableColumn<Component, String> colTipo;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private TreeTableView<Component> treeTableVw;

@FXML
private TextField txtNombre;

@FXML
private TextField txtTipo;

@FXML
private TextField txtPosicion;

    @Override
public void initialize(URL location, ResourceBundle resources) {
    // Configurar las columnas
    colNombre.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getName()));
    colTipo.setCellValueFactory(param -> new SimpleStringProperty(
            param.getValue().getValue() instanceof Departamento ? "Departamento" : "Empleado"));

    // Crear la jerarquía de ejemplo
    Departamento rootDepartment = createSampleStructure();

    // Convertir la jerarquía en TreeItems
    TreeItem<Component> rootItem = createTreeItem(rootDepartment);

    // Configurar el TreeTableView
    treeTableVw.setRoot(rootItem);
    treeTableVw.setShowRoot(true);

    treeTableVw.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
        if (newValue != null) {
            Component selectedComponent = newValue.getValue();
            txtNombre.setText(selectedComponent.getName());
            txtTipo.setText(selectedComponent instanceof Departamento ? "Departamento" : "Empleado");

            if (selectedComponent instanceof Empleado) {
                Empleado empleado = (Empleado) selectedComponent;
                txtPosicion.setText(empleado.getPosition());
            } else {
                txtPosicion.setText(""); // Vacío para departamentos
            }
        }
    });
}
    private TreeItem<Component> createTreeItem(Departamento department) {
        TreeItem<Component> treeItem = new TreeItem<>(department);

        for (Component component : department.getComponents()) {
            if (component instanceof Departamento) {
                treeItem.getChildren().add(createTreeItem((Departamento) component));
            } else if (component instanceof Empleado) {
                treeItem.getChildren().add(new TreeItem<>(component));
            }
        }
        return treeItem;
    }


private Departamento createSampleStructure() {
    Departamento company = new Departamento("Mi Empresa S.A.");
    Departamento engineering = new Departamento("Ingeniería");
    Departamento sales = new Departamento("Ventas");
    Departamento marketing = new Departamento("Marketing");
    Departamento software = new Departamento("Desarrollo de Software");
    Departamento hardware = new Departamento("Hardware");

    Empleado dev1 = new Empleado("Juan Pérez", "Desarrollador Senior");
    Empleado dev2 = new Empleado("Ana García", "Desarrollador Junior");
    Empleado dev3 = new Empleado("Carlos López", "Arquitecto");
    Empleado hw1 = new Empleado("María Rodríguez", "Ingeniero de Hardware");
    Empleado hw2 = new Empleado("Pedro Sánchez", "Técnico");
    Empleado sales1 = new Empleado("Laura Martínez", "Gerente de Ventas");
    Empleado sales2 = new Empleado("Roberto Fernández", "Representante de Ventas");
    Empleado mkt1 = new Empleado("Sofía Díaz", "Director de Marketing");
    Empleado mkt2 = new Empleado("Miguel Torres", "Especialista en Redes Sociales");

    software.add(dev1);
    software.add(dev2);
    software.add(dev3);
    hardware.add(hw1);
    hardware.add(hw2);
    engineering.add(software);
    engineering.add(hardware);
    sales.add(sales1);
    sales.add(sales2);
    marketing.add(mkt1);
    marketing.add(mkt2);
    company.add(engineering);
    company.add(sales);
    company.add(marketing);

    return company;
}
}
