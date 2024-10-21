module com.example.weatherapp {
  requires javafx.controls;
  requires javafx.fxml;

  requires org.controlsfx.controls;
  requires org.kordamp.bootstrapfx.core;
  requires com.google.gson;
  requires java.net.http;
  opens com.example.weatherapp to javafx.fxml;
  exports com.example.weatherapp;
}