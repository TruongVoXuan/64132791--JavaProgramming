package truongvx.demobanhang.BLL;

import truongvx.demobanhang.DAL.NhanVienDAL;
import truongvx.demobanhang.Model_DTO.NhanVien;

public class NhanVienBLL {
  NhanVienDAL nvDAL;
 public boolean ThemMoi(NhanVien nv) {
    //cac xl kha o day
   boolean kq = nvDAL.AddNew(nv);
    return kq;
  }
  public  boolean checkLogin(String tenDN, String matKhau){
   //Kiem tra tinh dung dan
    //ten rong khong, co dung forrmat khong...
   return nvDAL.Login(tenDN,matKhau);
   // thoa man roi , thi ta goi ham dich vu DAL
  }
}
