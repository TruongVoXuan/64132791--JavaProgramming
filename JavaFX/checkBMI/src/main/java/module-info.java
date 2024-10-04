module com.example.checkbmi {
  requires javafx.controls;
  requires javafx.fxml;


  opens com.example.checkbmi to javafx.fxml;
  exports com.example.checkbmi;
}