package co.edu.poli.actividad11.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import co.edu.poli.actividad11.model.AgregarProductoCommand;
import co.edu.poli.actividad11.model.DescuentoClienteFrecuente;
import co.edu.poli.actividad11.model.DescuentoTemporada;
import co.edu.poli.actividad11.model.EliminarProductoCommand;
import co.edu.poli.actividad11.model.Invoker;
import co.edu.poli.actividad11.model.Pedido;
import co.edu.poli.actividad11.model.Producto;
import co.edu.poli.actividad11.model.SinDescuento;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PedidoController implements Initializable {

    @FXML
    private CheckBox chBunuelo;

    @FXML
    private CheckBox chDurazno;

    @FXML
    private CheckBox chGalleta;

    @FXML
    private CheckBox chMani;

    @FXML
    private CheckBox chNatilla;

    @FXML
    private CheckBox chVino;

    @FXML
    private ComboBox<String> comboDescuento;

    @FXML
    private Label lblDescProductos;

    @FXML
    private Label lblDescuento;

    @FXML
    private Label lblSubTotal;

    @FXML
    private Label lblTotal;

    @FXML
    private TextField txtCant;

    @FXML
    private TextField txtCliente;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtTelefono;

    private List<Producto> listadoProductos = new ArrayList<>();
    private Invoker invoker = new Invoker();
    private StringBuilder sb = new StringBuilder("Descripción del pedido: \n");
    private double subtotal;
    private double totalConDescuento;

    Producto vino = new Producto("01", "Vino", "vino tinto 350 ml", 20000);
    Producto galletas = new Producto("02", "Galletas", "Galletas navideñas * 30 unidades", 8000);
    Producto mani = new Producto("03", "Maní", "Maní la Especial * 100 gramos", 17000);
    Producto durazno = new Producto("04", "Duraznos", "Duraznos en almibar en lata", 9500);
    Producto natilla = new Producto("05", "Natilla", "Caja de Natilla De la Abuela", 6500);
    Producto bunuelos = new Producto("06", "Buñuelos", "Caja de Mescla para buñuelos", 6500);

    @FXML
    void ActualizaVino(ActionEvent event) {

        if (chVino.isSelected()) {
            listadoProductos = invoker.ejecutarComando(new AgregarProductoCommand(listadoProductos, vino));
        } else {
            listadoProductos = invoker.ejecutarComando(new EliminarProductoCommand(listadoProductos, vino));
        }
        StringBuilder sb = new StringBuilder("Descripción del pedido: \n");
        listadoProductos.forEach(p -> sb.append(p.getDescripcion()).append(":\t $").append(p.getPrecio()).append("\n"));
        subtotal = 0;
        for (Producto p : listadoProductos) {
            subtotal += p.getPrecio();
        }
        lblDescProductos.setText(sb.toString());
        lblSubTotal.setText(String.valueOf(subtotal));
        //lblDescuento.setText(String.valueOf(subtotal - totalConDescuento));
        this.generarPedido(event);

    }

    @FXML
    void ActualizaGalleta(ActionEvent event) {

        if (chGalleta.isSelected()) {
            listadoProductos = invoker.ejecutarComando(new AgregarProductoCommand(listadoProductos, galletas));
        } else {
            listadoProductos = invoker.ejecutarComando(new EliminarProductoCommand(listadoProductos, galletas));
        }
        StringBuilder sb = new StringBuilder("Descripción del pedido: \n");
        listadoProductos.forEach(p -> sb.append(p.getDescripcion()).append(":\t $").append(p.getPrecio()).append("\n"));
        subtotal = 0;
        for (Producto p : listadoProductos) {
            subtotal += p.getPrecio();
        }
        lblDescProductos.setText(sb.toString());
        lblSubTotal.setText(String.valueOf(subtotal));
        //lblDescuento.setText(String.valueOf(subtotal - totalConDescuento));
        this.generarPedido(event);
    }

    @FXML
    void ActualizaMani(ActionEvent event) {

        if (chMani.isSelected()) {
            listadoProductos = invoker.ejecutarComando(new AgregarProductoCommand(listadoProductos, mani));
        } else {
            listadoProductos = invoker.ejecutarComando(new EliminarProductoCommand(listadoProductos, mani));
        }
        StringBuilder sb = new StringBuilder("Descripción del pedido: \n");
        listadoProductos.forEach(p -> sb.append(p.getDescripcion()).append(":\t $").append(p.getPrecio()).append("\n"));
        subtotal = 0;
        for (Producto p : listadoProductos) {
            subtotal += p.getPrecio();
        }
        lblDescProductos.setText(sb.toString());
        lblSubTotal.setText(String.valueOf(subtotal));
        //lblDescuento.setText(String.valueOf(subtotal - totalConDescuento));
        this.generarPedido(event);
    }

    @FXML
    void ActualizaDurazno(ActionEvent event) {

        if (chDurazno.isSelected()) {
            listadoProductos = invoker.ejecutarComando(new AgregarProductoCommand(listadoProductos, durazno));
        } else {
            listadoProductos = invoker.ejecutarComando(new EliminarProductoCommand(listadoProductos, durazno));
        }
        StringBuilder sb = new StringBuilder("Descripción del pedido: \n");
        listadoProductos.forEach(p -> sb.append(p.getDescripcion()).append(":\t $").append(p.getPrecio()).append("\n"));
        subtotal = 0;
        for (Producto p : listadoProductos) {
            subtotal += p.getPrecio();
        }
        lblDescProductos.setText(sb.toString());
        lblSubTotal.setText(String.valueOf(subtotal));
        //lblDescuento.setText(String.valueOf(subtotal - totalConDescuento));
        this.generarPedido(event);
    }

    @FXML
    void ActualizaNatilla(ActionEvent event) {

        if (chNatilla.isSelected()) {
            listadoProductos = invoker.ejecutarComando(new AgregarProductoCommand(listadoProductos, natilla));
        } else {
            listadoProductos = invoker.ejecutarComando(new EliminarProductoCommand(listadoProductos, natilla));
        }
        StringBuilder sb = new StringBuilder("Descripción del pedido: \n");
        listadoProductos.forEach(p -> sb.append(p.getDescripcion()).append(":\t $").append(p.getPrecio()).append("\n"));
        subtotal = 0;
        for (Producto p : listadoProductos) {
            subtotal += p.getPrecio();
        }
        lblDescProductos.setText(sb.toString());
        lblSubTotal.setText(String.valueOf(subtotal));
        //lblDescuento.setText(String.valueOf(subtotal - totalConDescuento));
        this.generarPedido(event);
    }

    @FXML
    void ActualizaBunuelo(ActionEvent event) {

        if (chBunuelo.isSelected()) {
            listadoProductos = invoker.ejecutarComando(new AgregarProductoCommand(listadoProductos, bunuelos));
        } else {
            listadoProductos = invoker.ejecutarComando(new EliminarProductoCommand(listadoProductos, bunuelos));
        }
        StringBuilder sb = new StringBuilder("Descripción del pedido: \n");
        listadoProductos.forEach(p -> sb.append(p.getDescripcion()).append(":\t $").append(p.getPrecio()).append("\n"));
        subtotal = 0;
        for (Producto p : listadoProductos) {
            subtotal += p.getPrecio();
        }
        lblDescProductos.setText(sb.toString());
        lblSubTotal.setText(String.valueOf(subtotal));
        // lblDescuento.setText(String.valueOf(subtotal - totalConDescuento));
        this.generarPedido(event);
    }

    @FXML
    void PagarPedido(ActionEvent event) {
        boolean algunCheckboxSeleccionado = chVino.isSelected()
                || chGalleta.isSelected()
                || chMani.isSelected()
                || chDurazno.isSelected()
                || chNatilla.isSelected()
                || chBunuelo.isSelected();

        if (!algunCheckboxSeleccionado) {
            // Mostrar alerta si no hay productos seleccionados
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText("No hay productos seleccionados");
            alert.setContentText("Por favor seleccione al menos un producto.");
            alert.showAndWait();
            return;
        }

        Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
        successAlert.setTitle("Pedido generado");
        successAlert.setHeaderText("Pedido generado correctamente");
        successAlert.setContentText("El pedido ha sido registrado exitosamente.\n"
                + "Total a pagar: " + lblTotal.getText());
        successAlert.showAndWait();
    }

    @FXML
    void generarPedido(ActionEvent event) {

        double subtotal = Double.parseDouble(lblSubTotal.getText().replace("$", ""));
        Pedido pedido = new Pedido(subtotal);

        String seleccion = comboDescuento.getValue();
        switch (seleccion) {
            case "Cliente Frecuente -50%":
                pedido.setDescuentoStrategy(new DescuentoClienteFrecuente());
                break;
            case "Temporada -20%":
                pedido.setDescuentoStrategy(new DescuentoTemporada());
                break;
            default:
                pedido.setDescuentoStrategy(new SinDescuento());
        }

        totalConDescuento = pedido.calcularTotalConDescuento();

        // Mostrar el total con descuento
        lblTotal.setText("$" + totalConDescuento);

        // Calcular y mostrar el descuento aplicado
        double descuento = subtotal - totalConDescuento;
        lblDescuento.setText("$" + descuento);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboDescuento.getItems().addAll("Sin descuento", "Cliente Frecuente -50%", "Temporada -20%");
        comboDescuento.getSelectionModel().selectFirst();
    }

}
