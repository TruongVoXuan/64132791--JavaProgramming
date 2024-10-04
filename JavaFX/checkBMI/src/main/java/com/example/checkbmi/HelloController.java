package com.example.checkbmi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

  @FXML
  private TextField txtTen, txtCao, txtNang, txtKQ;
  public void check(ActionEvent event) {
    try{
      String ten = txtTen.getText();
      double cao = Double.parseDouble(txtCao.getText());
      double nang = Double.parseDouble(txtNang.getText());
      double KQ = Double.parseDouble(String.valueOf(nang/(cao*cao)));
      String result;
      if (KQ < 18.5) {
        result = "Gầy";
      } else if (KQ < 25) {
        result = "Bình thường";
      } else {
        result = "Béo phì";
      }

      txtKQ.setText(String.format("Name:%s - BMI:%.2f - %s",ten, KQ, result));
    } catch (NumberFormatException e) {
      txtKQ.setText("Input không hợp lệ");
    }
  }
}