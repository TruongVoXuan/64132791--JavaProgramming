module truongvx.demobanhang {
  requires javafx.controls;
  requires javafx.fxml;


  opens truongvx.demobanhang to javafx.fxml;
  exports truongvx.demobanhang;
}