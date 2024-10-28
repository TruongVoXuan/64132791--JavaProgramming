module truongvx.appmaytinh {
    requires javafx.controls;
    requires javafx.fxml;


    opens truongvx.appmaytinh to javafx.fxml;
    exports truongvx.appmaytinh;
}