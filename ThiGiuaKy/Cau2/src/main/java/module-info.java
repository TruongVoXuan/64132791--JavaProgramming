module truongvx.cau2 {
    requires javafx.controls;
    requires javafx.fxml;
  requires java.sql;


  opens truongvx.cau2 to javafx.fxml;
    exports truongvx.cau2;
}