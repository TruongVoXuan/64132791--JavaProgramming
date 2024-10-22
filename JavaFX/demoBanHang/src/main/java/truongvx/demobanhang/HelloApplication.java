package truongvx.demobanhang;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class HelloApplication {
  //extends Application
//  @Override
//  public void start(Stage stage) throws IOException {
//    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//    Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//    stage.setTitle("Hello!");
//    stage.setScene(scene);
//    stage.show();
//  }

  public static void main(String[] args) throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.cj.jdbc.Driver");

//2.1 chuỗi kết nối
    String strConn = "jdbc:mysql://localhost:3306/demobanhang";
//2.2 mở kết nối
    Connection conn = DriverManager.getConnection(strConn, "root","");



    //Select
    String sqlSelect = "Select * from SanPham";
    Statement lenh = conn.createStatement();
    ResultSet ketQua= lenh.executeQuery(sqlSelect);

    //Hiện kết quả
    while (ketQua.next()){
   int id=   ketQua.getInt(1);//Lây dữ liệu cột 0
      String tenSp=ketQua.getString(2);
      String giaSp = ketQua.getString(3);
      String moTa = ketQua.getString(4);
      System.out.println(id+ " | " + tenSp + " | " + giaSp+" | "+moTa);
    }
  }
}