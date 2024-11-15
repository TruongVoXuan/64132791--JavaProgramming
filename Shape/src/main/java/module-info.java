module truongvx.shape {
    requires javafx.controls;
    requires javafx.fxml;


    opens truongvx.shape to javafx.fxml;
    exports truongvx.shape;
}