package truongvx.cau3;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.Random;

public class QuizGameController {

  @FXML
  private Label pointLabel;
  @FXML
  private Label timerLabel;
  @FXML
  private Label questionLabel;
  @FXML
  private Button answerButton1;
  @FXML
  private Button answerButton2;
  @FXML
  private Button answerButton3;
  @FXML
  private Button answerButton4;

  private int point = 0;
  private int time = 20;  // Thời gian bắt đầu là 20 giây cho mỗi câu hỏi
  private Timeline timer;
  private int correctAnswer;

  @FXML
  public void initialize() {
    generateQuestion();  // Sinh câu hỏi khi khởi động
    startTimer();  // Bắt đầu timer
    answerButton1.setOnAction(e -> checkAnswer(answerButton1));
    answerButton2.setOnAction(e -> checkAnswer(answerButton2));
    answerButton3.setOnAction(e -> checkAnswer(answerButton3));
    answerButton4.setOnAction(e -> checkAnswer(answerButton4));
  }

  private void startTimer() {
    // Dừng timer cũ nếu có và khởi động lại timer mới mỗi lần bắt đầu một câu hỏi
    if (timer != null) {
      timer.stop();
    }

    // Đảm bảo thời gian đếm ngược không quá nhanh, thời gian một giây.
    timer = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
      if (time > 0) {
        time--;
        timerLabel.setText("Time: " + time);
      } else {
        timer.stop();
        disableButtons();
        showEndMessage();
      }
    }));
    timer.setCycleCount(Timeline.INDEFINITE);
    timer.play();
  }

  private void generateQuestion() {
    Random random = new Random();
    int a = random.nextInt(10) + 1;
    int b = random.nextInt(10) + 1;
    String[] operations = {"+", "-", "*", "/", "div", "mode"};
    String operation = operations[random.nextInt(6)];
    questionLabel.setText("What is " + a + " " + operation + " " + b + "?");

    // Tính kết quả đúng dựa trên phép toán
    switch (operation) {
      case "+":
        correctAnswer = a + b;
        break;
      case "-":
        correctAnswer = a - b;
        break;
      case "*":
        correctAnswer = a * b;
        break;
      case "/":
        correctAnswer = b != 0 ? a / b : 0;  // Kiểm tra tránh chia cho 0
        break;
      case "div":
        correctAnswer = a / b;  // Chia nguyên
        break;
      case "mode":
        correctAnswer = a % b;  // Phép chia lấy dư
        break;
    }

    // Gán câu trả lời đúng vào một trong các nút
    int correctButtonIndex = random.nextInt(4);
    Button[] buttons = {answerButton1, answerButton2, answerButton3, answerButton4};
    for (int i = 0; i < buttons.length; i++) {
      if (i == correctButtonIndex) {
        buttons[i].setText(String.valueOf(correctAnswer));
      } else {
        int wrongAnswer;
        do {
          wrongAnswer = random.nextInt(100);
        } while (wrongAnswer == correctAnswer); // Đảm bảo câu sai không trùng với câu đúng
        buttons[i].setText(String.valueOf(wrongAnswer));
      }
    }
  }

  private void checkAnswer(Button button) {
    int answer = Integer.parseInt(button.getText());

    // Kiểm tra xem có đúng không
    if (answer == correctAnswer) {
      point++;
      pointLabel.setText("Points: " + point);  // Cập nhật điểm số
      button.setStyle("-fx-background-color: green;");  // Màu xanh nếu đúng
    } else {
      point--;  // Trừ điểm khi chọn sai


      if (point < 0) {
        stopGame();  // Dừng game nếu điểm < 0
      } else {
        pointLabel.setText("Points: " + point);  // Cập nhật lại điểm
        timerLabel.setText("Time: " + time);  // Cập nhật lại thời gian
      }

      button.setStyle("-fx-background-color: red;");  // Màu đỏ nếu sai
    }

    // Sau khi trả lời, chờ 1 giây và sinh câu hỏi mới
    Timeline wait = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
      if (point >= 0) {
        generateQuestion();  // Sinh câu hỏi mới nếu điểm > 0
        resetButtonStyles();  // Reset màu các nút
        time = 20;  // Đặt lại thời gian về 20 giây
        startTimer();  // Bắt đầu lại thời gian đếm ngược
      }
    }));
    wait.setCycleCount(1);
    wait.play();
  }

  private void resetButtonStyles() {
    answerButton1.setStyle("-fx-background-color: #e0e0e0;");
    answerButton2.setStyle("-fx-background-color: #e0e0e0;");
    answerButton3.setStyle("-fx-background-color: #e0e0e0;");
    answerButton4.setStyle("-fx-background-color: #e0e0e0;");
  }

  private void disableButtons() {
    answerButton1.setDisable(true);
    answerButton2.setDisable(true);
    answerButton3.setDisable(true);
    answerButton4.setDisable(true);
  }

  private void stopGame() {
    // Dừng game khi điểm < 0
    timer.stop();  // Dừng timer
    disableButtons();  // Vô hiệu hóa các nút
    showEndMessage();  // Hiển thị thông báo kết thúc game
  }

  private void showEndMessage() {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    if (point < 0) {
      alert.setContentText("Game over! Your score is negative: " + point);
    } else {
      alert.setContentText("Time's up! Your score: " + point);
    }
    alert.showAndWait();
    // Sau khi game kết thúc, có thể thêm mã để reset hoặc thoát ứng dụng.
  }
}
