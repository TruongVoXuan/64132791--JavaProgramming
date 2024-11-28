package truongvx.demobanhang.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Utils {
  public static Connection connectDB() {
    Connection connect = null;
    try {
      // Đăng ký driver
      Class.forName("com.mysql.cj.jdbc.Driver");

      // Thiết lập kết nối
      connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/banhang3layout", "root", ""); // Thay thế bằng mật khẩu của bạn nếu có
    } catch (ClassNotFoundException e) {
      System.out.println("Không tìm thấy driver JDBC.");
      e.printStackTrace();
    } catch (SQLException e) {
      System.out.println("Không thể kết nối đến cơ sở dữ liệu.");
      e.printStackTrace();
    }
    return connect;
  }
}