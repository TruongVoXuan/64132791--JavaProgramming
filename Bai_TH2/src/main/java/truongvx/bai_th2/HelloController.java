package truongvx.bai_th2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class HelloController {
  @FXML
  private RadioButton AsiaRadio;

  @FXML
  private Button TinhBtn;

  @FXML
  private RadioButton WhoRadio;

  @FXML
  private TextField kqBMI;

  @FXML
  private TextField numCm;

  @FXML
  private TextField numKg;

  @FXML
  void TinhBMI(ActionEvent event) {
    double chieuCao, canNang, bmi;

    try {
      chieuCao = Double.parseDouble(numCm.getText()) / 100;
      canNang = Double.parseDouble(numKg.getText());
      bmi = canNang / (chieuCao * chieuCao);

      String resultChosse;
      if (WhoRadio.isSelected()) {
        if (bmi < 18.5) {
          resultChosse = "Gầy";
        } else if (bmi >= 18.5 && bmi < 24.9) {
          resultChosse = "Bình thường";
        } else if (bmi >= 25 && bmi < 29.9) {
          resultChosse = "Thừa cân";
        } else {
          resultChosse = "Béo phì";
        }
      } else if (AsiaRadio.isSelected()) {
        if (bmi < 17.5) {
          resultChosse = "Gầy";
        } else if (bmi >= 17.5 && bmi < 22.9) {
          resultChosse = "Bình thường";
        } else if (bmi >= 23 && bmi < 27.9) {
          resultChosse = "Thừa cân";
        } else {
          resultChosse = "Béo phì";
        }
      } else {
        resultChosse = "Hãy chọn tiêu chuẩn";
      }
      kqBMI.setText(String.format("BMI của bạn: %.2f - %s", bmi, resultChosse));
    } catch (NumberFormatException e) {
      kqBMI.setText("Nhập số đo hợp lệ");
    }
  }
}