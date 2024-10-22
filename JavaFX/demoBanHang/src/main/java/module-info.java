module truongvx.demobanhang {
  requires javafx.controls;
  requires javafx.fxml;

  requires org.controlsfx.controls;
  requires org.kordamp.bootstrapfx.core;
  requires java.sql;

  opens truongvx.demobanhang to javafx.fxml;
  exports truongvx.demobanhang;
}