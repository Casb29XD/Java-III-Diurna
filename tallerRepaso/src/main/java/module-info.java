module co.edu.uniquindio.taller1.tallerrepaso {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens co.edu.uniquindio.taller1.tallerrepaso to javafx.fxml;
    exports co.edu.uniquindio.taller1.tallerrepaso;
}