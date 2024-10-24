package truongvx.demobanhang;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


public class HelloController {
  public TextField txtName;
  public TextField txtDescription;
  public TextField txtPrice;
  public Button btnXoa;
  @FXML
  private Label welcomeText;
  @FXML
  private TableView<SanPham> tableView;
  @FXML
  private TableColumn<SanPham, String> colName;
  @FXML
  private TableColumn<SanPham, String> colPrice;
  @FXML
  private TableColumn<SanPham, String> colDescription;

  private ObservableList<SanPham> sanPhamList = FXCollections.observableArrayList();

  @FXML
  public void initialize() {
    colName.setCellValueFactory(new PropertyValueFactory<>("name"));
    colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
    colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));

    // Thêm dữ liệu vào bảng (chỉ để kiểm tra)
    sanPhamList.add(new SanPham("Product 1", "100", "Description 1"));
    sanPhamList.add(new SanPham("Product 2", "200", "Description 2"));

    tableView.setItems(sanPhamList);
  }

  @FXML
  protected void btnAdd(ActionEvent event) {
    SanPham sp = new SanPham(txtName.getText(),txtPrice.getText(),txtDescription.getText());
    tableView.getItems().add(sp); // Sửa lỗi thêm sản phẩm vào bảng
  }

  @FXML
  protected void btnXoa(ActionEvent event) {
    SanPham selected = tableView.getSelectionModel().getSelectedItem();
    if (selected != null) {
      tableView.getItems().remove(selected);
    }
  }
}
