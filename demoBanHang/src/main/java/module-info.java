module truongvx.demobanhang {
  requires javafx.controls;
  requires javafx.fxml;
  requires java.sql;


  opens truongvx.demobanhang to javafx.fxml;
  exports truongvx.demobanhang;
}