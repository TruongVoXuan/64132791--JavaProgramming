package truongvx.demobanhang.Utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CommonUtils {

  public static String encodePasswordSHA256(String input) {
    try {
      // Static getInstance method is called with hashing SHA-256
      MessageDigest md = MessageDigest.getInstance("SHA-256");

      // digest() method is called to calculate message digest
      // of an input digest() return array of byte
      byte[] messageDigest = md.digest(input.getBytes());

      // Convert byte array into signum representation
      BigInteger no = new BigInteger(1, messageDigest);

      // Convert message digest into hex value
      String hashtext = no.toString(16);
      while (hashtext.length() < 64) {
        hashtext = "0" + hashtext;
      }
      return hashtext;
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }
}
