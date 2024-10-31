package truongvx.cau2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
public class MainController {

  @FXML
  private TableView<HangHoa> tableView;
  @FXML
  private TableColumn<HangHoa, Integer> idColumn;
  @FXML
  private TableColumn<HangHoa, String> tenHangColumn;
  @FXML
  private TableColumn<HangHoa, Integer> soLuongColumn;
  @FXML
  private TableColumn<HangHoa, Float> giaColumn;

  private ObservableList<HangHoa> hangHoaList = FXCollections.observableArrayList();

  @FXML
  public void initialize() {
    idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
    tenHangColumn.setCellValueFactory(new PropertyValueFactory<>("tenHang"));
    soLuongColumn.setCellValueFactory(new PropertyValueFactory<>("soLuong"));
    giaColumn.setCellValueFactory(new PropertyValueFactory<>("gia"));

    // Giả sử bạn đã xác thực người dùng trước khi gọi phương thức này
    loadHangHoa();
  }


  private boolean authenticateUser(String TenDangNhap, String MatKhau) {
    // Kết nối database, kiểm tra thông tin
    try {
      String strConn = "jdbc:mysql://localhost:3306/thigk";
      Connection conn = DriverManager.getConnection(strConn, "root", "");
      String query = "SELECT * FROM user WHERE TenDangNhap = ? AND MatKhau = ?";
      PreparedStatement stmt = conn.prepareStatement(query);
      stmt.setString(1, TenDangNhap);
      stmt.setString(2, MatKhau);
      ResultSet rs = stmt.executeQuery();

      return rs.next(); // Trả về true nếu tìm thấy người dùng
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  private void loadHangHoa() {
    hangHoaList.clear(); // Xóa danh sách trước khi tải dữ liệu mới
    String url = "jdbc:mysql://localhost:3306/thigk";
    try (Connection connection = DriverManager.getConnection(url, "root", "")) {
      String query = "SELECT * FROM HangHoa";
      PreparedStatement statement = connection.prepareStatement(query);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        HangHoa hangHoa = new HangHoa(
            resultSet.getInt("id"),
            resultSet.getString("tenHang"),
            resultSet.getInt("soLuong"),
            resultSet.getFloat("gia")
        );
        hangHoaList.add(hangHoa);
      }
      tableView.setItems(hangHoaList);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }



  private void showAlert(Alert.AlertType alertType, String message) {
    Alert alert = new Alert(alertType);
    alert.setContentText(message);
    alert.showAndWait();
  }

  @FXML
  private void handleAdd() {
    try {
      // Hiển thị hộp thoại để nhập thông tin hàng hóa mới
      TextInputDialog dialog = new TextInputDialog();
      dialog.setTitle("Thêm Hàng Hóa");
      dialog.setHeaderText("Nhập thông tin hàng hóa mới");

      // Nhập tên hàng
      dialog.setContentText("Tên hàng:");
      Optional<String> tenHang = dialog.showAndWait();
      if (!tenHang.isPresent()) return;

      // Nhập số lượng
      dialog.setContentText("Số lượng:");
      Optional<String> soLuong = dialog.showAndWait();
      if (!soLuong.isPresent()) return;

      // Nhập giá
      dialog.setContentText("Giá:");
      Optional<String> gia = dialog.showAndWait();
      if (!gia.isPresent()) return;

      // Kết nối cơ sở dữ liệu và thêm hàng hóa mới
      String url = "jdbc:mysql://localhost:3306/thigk";
      try (Connection connection = DriverManager.getConnection(url, "root", "")) {
        String query = "INSERT INTO HangHoa (tenHang, soLuong, gia) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, tenHang.get());
        statement.setInt(2, Integer.parseInt(soLuong.get()));
        statement.setFloat(3, Float.parseFloat(gia.get()));
        statement.executeUpdate();

        // Cập nhật danh sách hàng hóa
        loadHangHoa();
      }
    } catch (Exception e) {
      e.printStackTrace();
      showAlert(Alert.AlertType.ERROR, "Lỗi khi thêm hàng hóa!");
    }
  }

  @FXML
  private void handleDelete() {
    HangHoa selectedHangHoa = tableView.getSelectionModel().getSelectedItem();
    if (selectedHangHoa != null) {
      try {
        // Kết nối cơ sở dữ liệu và xóa hàng hóa
        String url = "jdbc:mysql://localhost:3306/thigk";
        try (Connection connection = DriverManager.getConnection(url, "root", "")) {
          String query = "DELETE FROM HangHoa WHERE id = ?";
          PreparedStatement statement = connection.prepareStatement(query);
          statement.setInt(1, selectedHangHoa.getId());
          statement.executeUpdate();

          // Cập nhật danh sách hàng hóa
          loadHangHoa();
        }
      } catch (Exception e) {
        e.printStackTrace();
        showAlert(Alert.AlertType.ERROR, "Lỗi khi xóa hàng hóa!");
      }
    } else {
      showAlert(Alert.AlertType.WARNING, "Vui lòng chọn hàng hóa để xóa!");
    }
  }

  @FXML
  private void handleEdit() {
    HangHoa selectedHangHoa = tableView.getSelectionModel().getSelectedItem();
    if (selectedHangHoa != null) {
      try {
        // Hiển thị hộp thoại để nhập thông tin hàng hóa mới
        TextInputDialog dialog = new TextInputDialog(selectedHangHoa.getTenHang());
        dialog.setTitle("Sửa Hàng Hóa");
        dialog.setHeaderText("Nhập thông tin hàng hóa mới");

        // Nhập tên hàng
        dialog.setContentText("Tên hàng:");
        Optional<String> tenHang = dialog.showAndWait();
        if (!tenHang.isPresent()) return;

        // Nhập số lượng
        dialog.setContentText("Số lượng:");
        Optional<String> soLuong = dialog.showAndWait();
        if (!soLuong.isPresent()) return;

        // Nhập giá
        dialog.setContentText("Giá:");
        Optional<String> gia = dialog.showAndWait();
        if (!gia.isPresent()) return;

        // Kết nối cơ sở dữ liệu và cập nhật hàng hóa
        String url = "jdbc:mysql://localhost:3306/thigk";
        try (Connection connection = DriverManager.getConnection(url, "root", "")) {
          String query = "UPDATE HangHoa SET tenHang = ?, soLuong = ?, gia = ? WHERE id = ?";
          PreparedStatement statement = connection.prepareStatement(query);
          statement.setString(1, tenHang.get());
          statement.setInt(2, Integer.parseInt(soLuong.get()));
          statement.setFloat(3, Float.parseFloat(gia.get()));
          statement.setInt(4, selectedHangHoa.getId());
          statement.executeUpdate();

          // Cập nhật danh sách hàng hóa
          loadHangHoa();
        }
      } catch (Exception e) {
        e.printStackTrace();
        showAlert(Alert.AlertType.ERROR, "Lỗi khi sửa hàng hóa!");
      }
    } else {
      showAlert(Alert.AlertType.WARNING, "Vui lòng chọn hàng hóa để sửa!");
    }
  }

}
