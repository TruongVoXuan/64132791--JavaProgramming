package truongvx.demobanhang.BLL;

import truongvx.demobanhang.DAL.NhanVienDAL;
import truongvx.demobanhang.Model_DTO.NhanVien;

public class NhanVienBLL {
  private NhanVienDAL nvDAL;

  // Constructor để nhận DAL
  public NhanVienBLL(NhanVienDAL nvDAL) {
    this.nvDAL = nvDAL;
  }

  /**
   * Thêm nhân viên mới sau khi kiểm tra hợp lệ
   *
   * @param nv Thông tin nhân viên
   * @return True nếu thêm thành công, false nếu thất bại
   */
  public boolean ThemMoi(NhanVien nv) {
    // Kiểm tra logic nghiệp vụ (ví dụ: dữ liệu rỗng, định dạng không đúng)
    if (nv == null || nv.getUsername().isEmpty() || nv.getPassword().isEmpty()) {
      System.out.println("Thông tin nhân viên không hợp lệ.");
      return false;
    }
    // Gọi DAL để thêm dữ liệu vào cơ sở dữ liệu
    return nvDAL.AddNew(nv);
  }

  /**
   * Kiểm tra thông tin đăng nhập trước khi gửi đến DAL
   *
   * @param tenDN   Tên đăng nhập
   * @param matKhau Mật khẩu
   * @return True nếu đăng nhập thành công, false nếu thất bại
   */
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
