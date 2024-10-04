package com.example.hellofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;

public class HelloController {
  @FXML
  private Circle myCircal;
  private  double x;
  private  double y;
 public  void up(ActionEvent e){
   //System.out.println("UP");
   myCircal.setCenterY(y=y-10);
 }
  public  void down(ActionEvent e){
    //System.out.println("DOWN");
    myCircal.setCenterY(y=y+10);
  }
  public  void left(ActionEvent e){
    //System.out.println("LEFT");
    myCircal.setCenterX(x=x-10);
  }
  public  void right(ActionEvent e){
   // System.out.println("RIGHT");
    myCircal.setCenterX(x=x+10);
  }
}