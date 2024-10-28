module truongvx.maytinh {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
  requires java.scripting;

  opens truongvx.maytinh to javafx.fxml;
    exports truongvx.maytinh;
}