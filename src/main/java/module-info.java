module co.edu.poli {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    requires com.fasterxml.jackson.databind;

    opens co.edu.poli.actividad10.controller to javafx.fxml;
    opens co.edu.poli.actividad10.view to javafx.fxml;
    opens co.edu.poli.actividad10.model to javafx.fxml;
    
    exports co.edu.poli.actividad10.view;
    exports co.edu.poli.actividad10.controller;
    exports co.edu.poli.actividad10.model;
}
