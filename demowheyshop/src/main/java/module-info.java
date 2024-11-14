module truongvx.demowheyshop {
    requires javafx.controls;
    requires javafx.fxml;


    opens truongvx.demowheyshop to javafx.fxml;
    exports truongvx.demowheyshop;
}