module truongvx.shape {
    requires javafx.controls;
    requires javafx.fxml;
  requires java.desktop;


  opens truongvx.shape to javafx.fxml;
    exports truongvx.shape;
}