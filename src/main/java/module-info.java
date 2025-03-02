module co.edu.poli.ejemplo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.security.jgss;
    requires java.xml;
    requires org.controlsfx.controls;


    opens co.edu.poli.ejemplo to javafx.fxml;
    opens co.edu.poli.ejemplo.controlador to javafx.fxml;
    opens co.edu.poli.ejemplo.modelo to javafx.base;
    exports co.edu.poli.ejemplo.controlador;
    exports co.edu.poli.ejemplo;
}
