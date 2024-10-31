package truongvx.cau2;

public class HangHoa {
  private int id;
  private String tenHang;
  private int soLuong;
  private float gia;

  public HangHoa(int id, String tenHang, int soLuong, float gia) {
    this.id = id;
    this.tenHang = tenHang;
    this.soLuong = soLuong;
    this.gia = gia;
  }

  // Getter và Setter cho id
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  // Getter và Setter cho tenHang
  public String getTenHang() {
    return tenHang;
  }

  public void setTenHang(String tenHang) {
    this.tenHang = tenHang;
  }

  // Getter và Setter cho soLuong
  public int getSoLuong() {
    return soLuong;
  }

  public void setSoLuong(int soLuong) {
    this.soLuong = soLuong;
  }

  // Getter và Setter cho gia
  public float getGia() {
    return gia;
  }

  public void setGia(float gia) {
    this.gia = gia;
  }
}
