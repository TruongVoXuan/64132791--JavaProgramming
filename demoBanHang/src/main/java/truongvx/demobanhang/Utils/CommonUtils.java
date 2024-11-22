package truongvx.demobanhang.Utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CommonUtils {

  /**
   * Tạo hash SHA-512 cho chuỗi đầu vào
   *
   * @param input Chuỗi cần băm
   * @return Giá trị hash dạng chuỗi (hexadecimal) hoặc null nếu có lỗi
   */
  public static String hashSHA512(String input) {
    try {
      // Khởi tạo đối tượng MessageDigest với thuật toán SHA-512
      MessageDigest digest = MessageDigest.getInstance("SHA-512");

      // Băm chuỗi đầu vào và trả về mảng byte
      byte[] encodedHash = digest.digest(input.getBytes(StandardCharsets.UTF_8));

      // Chuyển mảng byte thành chuỗi dạng hexadecimal
      return bytesToHex(encodedHash);
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Chuyển mảng byte thành chuỗi dạng hexadecimal
   *
   * @param hash Mảng byte
   * @return Chuỗi hexadecimal
   */
  private static String bytesToHex(byte[] hash) {
    StringBuilder hexString = new StringBuilder();
    for (byte b : hash) {
      String hex = Integer.toHexString(0xff & b);
      if (hex.length() == 1) {
        hexString.append('0'); // Thêm số 0 nếu hex chỉ có 1 ký tự
      }
      hexString.append(hex);
    }
    return hexString.toString();
  }
}
