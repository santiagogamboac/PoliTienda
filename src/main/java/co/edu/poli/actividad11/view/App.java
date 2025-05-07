package co.edu.poli.actividad11.view;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        AnchorPane ap = (AnchorPane) FXMLLoader.load(getClass().getResource("/co/edu/poli/actividad11/view/PedidoView.fxml"));
        scene = new Scene(ap);
        stage.setScene(scene);
        stage.setTitle("Carrito de Compras");
        //stage.setMaximized(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
