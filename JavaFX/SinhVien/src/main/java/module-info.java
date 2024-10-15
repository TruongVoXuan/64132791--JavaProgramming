module com.example.sinhvien {
  requires javafx.controls;
  requires javafx.fxml;

  requires org.kordamp.bootstrapfx.core;
  requires jdk.jsobject;
  requires json.simple;

  opens com.example.sinhvien to javafx.fxml;
  exports com.example.sinhvien;
}