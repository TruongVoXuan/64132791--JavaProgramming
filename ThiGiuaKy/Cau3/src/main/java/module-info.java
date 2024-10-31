module truongvx.cau3 {
    requires javafx.controls;
    requires javafx.fxml;
  requires java.desktop;


  opens truongvx.cau3 to javafx.fxml;
    exports truongvx.cau3;
}