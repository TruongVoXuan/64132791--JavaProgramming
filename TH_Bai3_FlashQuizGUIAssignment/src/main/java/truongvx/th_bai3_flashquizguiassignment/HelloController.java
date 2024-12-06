package truongvx.th_bai3_flashquizguiassignment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {

  @FXML
  private Button cau10btn;

  @FXML
  private Button cau1btn;

  @FXML
  private Button cau2btn;

  @FXML
  private Button cau3btn;

  @FXML
  private Button cau4btn;

  @FXML
  private Button cau5btn;

  @FXML
  private Button cau6btn;

  @FXML
  private Button cau7btn;

  @FXML
  private Button cau8btn;

  @FXML
  private Button cau9btn;

  @FXML
  private Button cauAbtn;

  @FXML
  private Button cauBbtn;

  @FXML
  private Button cauCbtn;

  @FXML
  private Button cauDbtn;

  public void changeColor(ActionEvent event) {
    defaultColor();
    if (event.getSource() == cau1btn) {
      cau1btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #8b0000);");
    } else if (event.getSource() == cau2btn) {
      cau2btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #8b0000);");
    } else if (event.getSource() == cau3btn) {
      cau3btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #8b0000);");
    } else if (event.getSource() == cau4btn) {
      cau4btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #8b0000);");
    } else if (event.getSource() == cau5btn) {
      cau5btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #8b0000);");
    } else if (event.getSource() == cau6btn) {
      cau6btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #8b0000);");
    } else if (event.getSource() == cau7btn) {
      cau7btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #8b0000);");
    } else if (event.getSource() == cau8btn) {
      cau8btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #8b0000);");
    } else if (event.getSource() == cau9btn) {
      cau9btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #8b0000);");
    } else if (event.getSource() == cau10btn) {
      cau10btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #8b0000);");
    }
  }

  private void defaultColor() {
    cau1btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #4d8c7e);");
    cau2btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #4d8c7e);");
    cau3btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #4d8c7e);");
    cau4btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #4d8c7e);");
    cau5btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #4d8c7e);");
    cau6btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #4d8c7e);");
    cau7btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #4d8c7e);");
    cau8btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #4d8c7e);");
    cau9btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #4d8c7e);");
    cau10btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #4d8c7e);");
  }

  @FXML
  void changeColorQuestion(ActionEvent event) {

    defaultColorQuestion();
    if (event.getSource() == cauAbtn) {
      cauAbtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #8b0000);");
    } else if (event.getSource() == cauBbtn) {
      cauBbtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #8b0000);");
    } else if (event.getSource() == cauCbtn) {
      cauCbtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #8b0000);");
    }
  }
  private void defaultColorQuestion() {
    cauAbtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #4d8c7e);");
    cauBbtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #a8e6cf, #2459a6);");
    cauCbtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #a8e6cf, #2459a6);");

  }

}