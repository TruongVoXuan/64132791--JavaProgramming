package truongvx.demobanhang.BLL;

import truongvx.demobanhang.DAL.NhanVienDAL;
import truongvx.demobanhang.Model_DTO.NhanVien;

import java.sql.Connection;

public class NhanVienBLL {

  private NhanVienDAL nvDAL;

  // Constructor để nhận DAL và Connection
  public NhanVienBLL(Connection connection) {
    this.nvDAL = new NhanVienDAL(connection);
  }

  public boolean dangkiTK(String tenDN, String matKhau) {
    return nvDAL.createAccount(tenDN, matKhau);
  }

  public boolean ThemMoi(NhanVien nv) {
    return nvDAL.AddNew(nv);
  }

  public boolean checkLogin(String tenDN, String matKhau) {
    // Kiểm tra tính hợp lệ của dữ liệu nhập
    if (tenDN == null || tenDN.isEmpty() || matKhau == null || matKhau.isEmpty()) {
      System.out.println("Tên đăng nhập hoặc mật khẩu không được để trống.");
      return false;
    }
    // Gọi DAL để kiểm tra đăng nhập
    return nvDAL.Login(tenDN, matKhau);
  }
}