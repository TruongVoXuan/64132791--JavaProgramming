module com.example.caroapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.caroapp to javafx.fxml;
    exports com.example.caroapp;
}