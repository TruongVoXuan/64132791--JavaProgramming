package com.example.tinhtong;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.TextField;

public class HelloController {


  @FXML

  private TextField txtA, txtB, txtKQ;

  public void tinhTong(ActionEvent event) {
  int a = Integer.parseInt(txtA.getText());
  int b= Integer.parseInt(txtB.getText());
  String KQ = String.valueOf(a+b);
   txtKQ.setText(KQ);
  }
}