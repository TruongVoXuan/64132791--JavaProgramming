package truongvx.cau3;

import javafx.fxml.FXML;
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
  @FXML
  private Button generateQuestionButton;

  private int point = 0;
  private int time = 30;
  private Timeline timer;

  @FXML
  public void initialize() {
    startTimer();
    generateQuestionButton.setOnAction(e -> generateQuestion());
    answerButton1.setOnAction(e -> checkAnswer(answerButton1));
    answerButton2.setOnAction(e -> checkAnswer(answerButton2));
    answerButton3.setOnAction(e -> checkAnswer(answerButton3));
    answerButton4.setOnAction(e -> checkAnswer(answerButton4));
  }

  private void startTimer() {
    timer = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
      if (time > 0) {
        time--;
        timerLabel.setText(String.valueOf(time));
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
    int num1 = random.nextInt(10) + 1;
    int num2 = random.nextInt(10) + 1;
    int correctAnswer = num1 * num2;

    questionLabel.setText("What is " + num1 + " x " + num2 + "?");

    int correctButtonIndex = random.nextInt(4);
    Button[] buttons = {answerButton1, answerButton2, answerButton3, answerButton4};
    for (int i = 0; i < buttons.length; i++) {
      if (i == correctButtonIndex) {
        buttons[i].setText(String.valueOf(correctAnswer));
      } else {
        int wrongAnswer;
        do {
          wrongAnswer = random.nextInt(100);
        } while (wrongAnswer == correctAnswer); // Ensure wrong answer is not the same as correct answer
        buttons[i].setText(String.valueOf(wrongAnswer));
      }
    }
  }

  private void checkAnswer(Button button) {
    try {
      int answer = Integer.parseInt(button.getText());
      String question = questionLabel.getText();
      String[] parts = question.split(" ");
      int num1 = Integer.parseInt(parts[2]);
      int num2 = Integer.parseInt(parts[4]);
      int correctAnswer = num1 * num2;

      if (answer == correctAnswer) {
        point++;
        pointLabel.setText(String.valueOf(point));
        showAlert("Correct!");
      } else {
        showAlert("Incorrect!");
      }
    } catch (NumberFormatException e) {
      showAlert("Invalid answer format!");
    }
  }

  private void disableButtons() {
    answerButton1.setDisable(true);
    answerButton2.setDisable(true);
    answerButton3.setDisable(true);
    answerButton4.setDisable(true);
  }

  private void showEndMessage() {
    showAlert("Time's up! Your score: " + point);
  }

  private void showAlert(String message) {
    javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
    alert.setContentText(message);
    alert.showAndWait();
  }
}
