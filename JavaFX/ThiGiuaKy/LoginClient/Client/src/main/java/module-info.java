module truongvx.client {
  requires javafx.controls;
  requires javafx.fxml;
  requires java.sql;
  requires javafx.base;


  opens truongvx.client to javafx.fxml;
  exports truongvx.client;
}