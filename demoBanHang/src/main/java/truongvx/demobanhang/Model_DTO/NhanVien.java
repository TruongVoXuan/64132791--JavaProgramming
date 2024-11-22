package truongvx.demobanhang.Model_DTO;

public class NhanVien {

  private String username;  // Tên đăng nhập
  private String password;  // Mật khẩu

  // Constructor để tạo đối tượng nhân viên với tên đăng nhập và mật khẩu
  public NhanVien(String username, String password) {
    this.username = username;
    this.password = password;
  }

  // Getter cho tên đăng nhập
  public String getUsername() {
    return username;
  }

  // Setter cho tên đăng nhập
  public void setUsername(String username) {
    this.username = username;
  }

  // Getter cho mật khẩu
  public String getPassword() {
    return password;
  }

  // Setter cho mật khẩu
  public void setPassword(String password) {
    this.password = password;
  }

  // Phương thức kiểm tra tính hợp lệ của tên đăng nhập và mật khẩu (tuỳ chọn)
  public boolean isValid() {
    // Kiểm tra nếu tên đăng nhập và mật khẩu không trống
    return username != null && !username.isEmpty() && password != null && !password.isEmpty();
  }

  @Override
  public String toString() {
    return "NhanVien{username='" + username + "', password='" + password + "'}";
  }
}
