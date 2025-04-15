package co.edu.poli.corte2.view;

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
        AnchorPane ap = (AnchorPane) FXMLLoader.load(getClass().getResource("/co/edu/poli/corte2/view/MainView.fxml"));
        scene = new Scene(ap);
        stage.setScene(scene);
        stage.setTitle("Portal negocio");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}