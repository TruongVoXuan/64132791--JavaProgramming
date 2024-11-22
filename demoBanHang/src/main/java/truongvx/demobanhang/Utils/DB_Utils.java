package truongvx.demobanhang.Utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB_Utils {
  public static Connection connectDB() {
    try {

      Class.forName("com.mysql.cj.jdbc.Driver");

      Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/banhang3layout", "root", "");
      return connect;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }



}