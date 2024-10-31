package truongvx.cau2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        primaryStage.setScene(new Scene(loader.load()));
        primaryStage.setTitle("Đăng Nhập");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
