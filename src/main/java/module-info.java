module co.edu.poli {
    requires javafx.controls;
    requires javafx.fxml;

    
    opens co.edu.poli.corte2.controller to javafx.fxml;
    opens co.edu.poli.corte2.view to javafx.fxml;
    opens co.edu.poli.corte2.model to javafx.fxml;
    
    exports co.edu.poli.corte2.view;
    exports co.edu.poli.corte2.controller;
    exports co.edu.poli.corte2.model;
}
