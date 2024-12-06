package truongvx.bai_th1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class HelloController {
  @FXML
  private RadioButton ChiaRadio;

  @FXML
  private RadioButton CongRadio;

  @FXML
  private Button resetBtn;

  @FXML
  private TextField KQ;

  @FXML
  private RadioButton NhanRadio;

  @FXML
  private RadioButton TruRadio;

  @FXML
  private Button calculateBtn;

  @FXML
  private TextField numA;

  @FXML
  private TextField numB;
  @FXML
  void Tinh(ActionEvent event) {
    try{
      double a = Double.parseDouble(numA.getText());
      double b = Double.parseDouble(numB.getText());
      double result= 0;
      if (CongRadio.isSelected()){
        result=a+b;
      }
     else if (TruRadio.isSelected()){
        result=a-b;
      }
     else if (NhanRadio.isSelected()){
        result=a*b;
      }
      else if (ChiaRadio.isSelected()){
        result=a/b;
      }
      KQ.setText(String.valueOf(result));
    }
    catch (NumberFormatException e){
      KQ.setText("Vui lòng nhập hợp lệ");
    }

  }

  @FXML
 public void Reset(ActionEvent event) {
    numA.clear();
    numB.clear();
    KQ.clear();

  }

}
