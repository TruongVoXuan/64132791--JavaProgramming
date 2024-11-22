package truongvx.demobanhang.DAL;

import javafx.scene.control.Alert;
import truongvx.demobanhang.Model_DTO.NhanVien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NhanVienDAL {

  private Connection connect; // Kết nối sẽ được quản lý bên ngoài
  private PreparedStatement prepare;
  private ResultSet result;
  private Alert alert;

  // Constructor để nhận kết nối từ bên ngoài
  public NhanVienDAL(Connection connection) {
    this.connect = connection;
  }


  public boolean Login(String username, String password) {
    // Kiểm tra nếu username hoặc password trống
    if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
      alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Thông báo lỗi");
      alert.setHeaderText(null);
      alert.setContentText("Tên đăng nhập và mật khẩu không được để trống.");
      alert.showAndWait();
      return false;
    }

    if (connect != null) {
      String selectData = "SELECT username, password FROM nhanvien WHERE username = ? AND password = ?";
      try {
        prepare = connect.prepareStatement(selectData);
        prepare.setString(1, username);
        prepare.setString(2, password);

        result = prepare.executeQuery();

        // Kiểm tra kết quả truy vấn
        if (result.next()) {
          alert = new Alert(Alert.AlertType.INFORMATION);
          alert.setTitle("Thông báo");
          alert.setHeaderText(null);
          alert.setContentText("Đăng nhập thành công.");
          alert.showAndWait();
          return true; // Đăng nhập thành công
        } else {
          alert = new Alert(Alert.AlertType.ERROR);
          alert.setTitle("Thông báo lỗi");
          alert.setHeaderText(null);
          alert.setContentText("Tên đăng nhập hoặc mật khẩu không chính xác.");
          alert.showAndWait();
        }
      } catch (SQLException e) {
        e.printStackTrace();
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Lỗi cơ sở dữ liệu");
        alert.setHeaderText(null);
        alert.setContentText("Đã xảy ra lỗi khi kết nối hoặc truy vấn cơ sở dữ liệu.");
        alert.showAndWait();
      } finally {
        // Đóng tài nguyên PreparedStatement và ResultSet
        try {
          if (result != null) result.close();
          if (prepare != null) prepare.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    } else {
      alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Lỗi kết nối");
      alert.setHeaderText(null);
      alert.setContentText("Không thể kết nối đến cơ sở dữ liệu.");
      alert.showAndWait();
    }
    return false; // Đăng nhập thất bại
  }

  public boolean AddNew(NhanVien nv) {
    return true;
  }
}
