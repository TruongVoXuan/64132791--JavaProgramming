package truongvx.demobanhang;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import truongvx.demobanhang.BLL.NhanVienBLL;
import truongvx.demobanhang.Utils.DB_Utils;

import java.sql.Connection;
import java.util.Scanner;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) {
    // Kết nối đến cơ sở dữ liệu
    Connection connection = DB_Utils.connectDB();
    if (connection == null) {
      System.out.println("Không thể kết nối đến cơ sở dữ liệu.");
      return;
    }

    NhanVienBLL nhanVienBLL = new NhanVienBLL(connection);
    Scanner scanner = new Scanner(System.in);

    System.out.print("Tài khoản mới:");
    String tk = scanner.next();

    System.out.print("Mật khẩu mới:");
    String mk = scanner.next();

    if (nhanVienBLL.dangkiTK(tk, mk)) {
      System.out.println("Tạo tài khoản thành công.");

      // Kiểm tra đăng nhập với tài khoản vừa tạo
      System.out.print("Đăng nhập với tài khoản vừa tạo\nTài khoản:");
      String loginTk = scanner.next();

      System.out.print("Mật khẩu:");
      String loginMk = scanner.next();

      if (nhanVienBLL.checkLogin(loginTk, loginMk)) {
        System.out.println("Đăng nhập thành công.");
      } else {
        System.out.println("Đăng nhập thất bại.");
      }
    } else {
      System.out.println("Tạo tài khoản thất bại.");
    }

    // Đóng kết nối cơ sở dữ liệu
    try {
      if (connection != null) connection.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

    // Kết thúc ứng dụng JavaFX
    Platform.exit();
  }

  public static void main(String[] args) {
    // Khởi chạy ứng dụng JavaFX
    launch(args);
  }
}