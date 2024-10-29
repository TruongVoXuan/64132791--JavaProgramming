package truongvx.client;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginApp extends Application {

  @FXML
  private TextField usernameField;
  @FXML
  private PasswordField passwordField;
  @FXML
  private Button loginButton;

  static {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
    loader.setController(this);
    primaryStage.setScene(new Scene(loader.load()));
    primaryStage.setTitle("Đăng Nhập");
    primaryStage.show();
  }

  @FXML
  private void handleLogin() {
    String username = usernameField.getText();
    String password = passwordField.getText();

    if (authenticate(username, password)) {
      showAlert(Alert.AlertType.INFORMATION, "Đăng nhập thành công!");
      // Chuyển đến màn hình chính
      showMainScreen();
    } else {
      showAlert(Alert.AlertType.ERROR, "Tên đăng nhập hoặc mật khẩu không đúng!");
    }
  }

  private boolean authenticate(String username, String password) {
    String url = "jdbc:mysql://localhost:3306/client?useSSL=false&serverTimezone=UTC&autoReconnect=true";
    try (Connection connection = DriverManager.getConnection(url, "user1", "password1")) {
      String query = "SELECT * FROM users WHERE username = ? AND password = ?";
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setString(1, username);
      statement.setString(2, password);
      ResultSet resultSet = statement.executeQuery();
      return resultSet.next();
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }



  private void showAlert(Alert.AlertType alertType, String message) {
    Alert alert = new Alert(alertType);
    alert.setContentText(message);
    alert.showAndWait();
  }

  private void showMainScreen() {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
      Stage stage = new Stage();
      stage.setScene(new Scene(loader.load()));
      stage.setTitle("Màn Hình Chính");
      stage.show();
    } catch (Exception e) {
      e.printStackTrace();

    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}
