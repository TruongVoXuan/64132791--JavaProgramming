package truongvx.th_bai5_dictionary;

import javafx.fxml.FXML;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.HashMap;

public class HelloController {

  @FXML
  private Button btnAdd;
  @FXML
  private TextField textFieldAddNew;

  @FXML
  private Button btnSearch;

  @FXML
  private TextField textFieldPA;

  @FXML
  private TextField textFieldSearch;

  @FXML
  private Button btnClear;

    @FXML
    private TextField textFieldTV;

  private HashMap<String, DicValue> td = new HashMap<>();

  @FXML
  public void initialize()
  {
    td.put("hello", new DicValue("həˈloʊ", "xin chào"));
    td.put("workout", new DicValue("wɜː.kaʊt", "tập luyện"));
    td.put("triceps", new DicValue("traɪ.seps", "cơ tay sau"));
    td.put("biceps", new DicValue("baɪ.seps", "bắp tay trước"));


    btnSearch.setOnAction(event -> searchWord());
    btnAdd.setOnAction(event -> addWord());
    btnClear.setOnAction(event -> clearText());
  }

  private void clearText() {
    textFieldSearch.clear();
    textFieldAddNew.clear();
    textFieldPA.clear();
    textFieldTV.clear();
  }

  private void addWord() {
    String word = textFieldAddNew.getText().trim().toLowerCase();
    String phienAm = textFieldPA.getText().trim();
    String nghiaTV = textFieldTV.getText().trim();

    if(word.isEmpty() || phienAm.isEmpty() || nghiaTV.isEmpty()){
      showAlert(Alert.AlertType.ERROR,"Cảnh báo","Nhập đầy đủ");
      return;
    }
    if(td.containsKey(word)){
      showAlert(Alert.AlertType.ERROR,"Lỗi","từ đã tồn tại");

    }
    else {
      td.put(word,new DicValue(phienAm,nghiaTV));
      showAlert(Alert.AlertType.ERROR,"Thêm","Thành công");
      textFieldAddNew.clear();
      textFieldPA.clear();
      textFieldTV.clear();
    }
  }

  private void searchWord() {

    String word = textFieldSearch.getText().trim().toLowerCase();
    if(word.isEmpty()){
      showAlert(Alert.AlertType.WARNING, "Cảnh báo", "Vui lòng nhập từ cần tra.");
    return;
    }

    DicValue value = td.get(word);
    if(value != null){
      textFieldPA.setText(value.getPhienAm());
      textFieldTV.setText(value.getNghiaTV());

    }
    else {
      showAlert(Alert.AlertType.ERROR,"Không tìm thấy","từ chưa có sẵn");
      textFieldPA.clear();
      textFieldTV.clear();
    }
  }



  private void showAlert(Alert.AlertType alertType, String title, String message) {
    Alert alert = new Alert(alertType);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
  }


}
