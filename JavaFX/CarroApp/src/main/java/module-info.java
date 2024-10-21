module com.example.carroapp {
  requires javafx.controls;
  requires javafx.fxml;

  requires org.controlsfx.controls;
  requires org.kordamp.bootstrapfx.core;

  opens com.example.carroapp to javafx.fxml;
  exports com.example.carroapp;
}