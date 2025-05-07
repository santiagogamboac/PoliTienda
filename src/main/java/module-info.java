module co.edu.poli {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;

    opens co.edu.poli.actividad11.controller to javafx.fxml;
    opens co.edu.poli.actividad11.view to javafx.fxml;
    opens co.edu.poli.actividad11.model to javafx.fxml;
    
    exports co.edu.poli.actividad11.view;
    exports co.edu.poli.actividad11.controller;
    exports co.edu.poli.actividad11.model;
}
