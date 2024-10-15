package com.example.sinhvien;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import netscape.javascript.JSObject;
import org.json.simple.JSONObject;

import java.io.*;
import java.text.ParseException;

public class HelloController {
  @FXML
  private Label welcomeText;
  @FXML
  private TextField txtMSSV, txtHoTen, txtNamSinh;
  public TextArea txtKQ;
  @FXML
  public void initialize() {
    // Đọc dữ liệu từ tệp JSON khi khởi tạo
    JSONObject jsonParser = new JSONObject();

    try (BufferedReader reader = new BufferedReader(new FileReader(Infor))) {
      String line;
      while ((line = reader.readLine()) != null) {
        JSONObject student = (JSONObject) jsonParser.parse(line);
        txtKQ.appendText(student.toJSONString() + "\n");
      }
    } catch (IOException | ParseException e) {
      e.printStackTrace();
    }
  }
  private static final String Infor = "Jsonfile.txt";
  @FXML
  protected void addSV(ActionEvent event) throws IOException {
    String MSSV = txtMSSV.getText();
    String HoTen = txtHoTen.getText();
    String NamSinh = txtNamSinh.getText();

    // Tạo đối tượng JSON

    JSONObject studentJson = new JSONObject();
    studentJson.put("MSSV", MSSV);
    studentJson.put("Tên", HoTen);
    studentJson.put("Năm sinh", NamSinh);

    try(FileWriter fw=  new FileWriter(Infor,true);){
      fw.write(studentJson.toJSONString() + "\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    // Hiển thị thông tin sinh viên
    txtKQ.appendText(studentJson.toJSONString() + "\n");

  }

  }
