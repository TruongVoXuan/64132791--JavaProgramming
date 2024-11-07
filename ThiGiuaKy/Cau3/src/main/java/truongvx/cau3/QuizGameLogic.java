package truongvx.cau3;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.util.Duration;

import java.util.Random;

public class QuizGameLogic {
  private QuizGameFrame frame;
  private int point = 0;
  private int time = 30;
  private Timeline timer;

  public QuizGameLogic(QuizGameFrame frame) {
    this.frame = frame;
  }

  public void startTimer() {
    timer = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
      if (time > 0) {
        time--;
        frame.updateTimerLabel(time);
      } else {
        timer.stop();
        disableAnswerButtons();
        frame.showEndMessage();
      }
    }));
    timer.setCycleCount(Timeline.INDEFINITE);
    timer.play();
  }

  public void generateQuestion() {
    Random random = new Random();
    int num1 = random.nextInt(10) + 1;
    int num2 = random.nextInt(10) + 1;
    int correctAnswer = num1 * num2;

    frame.updateQuestionLabel("What is " + num1 + " x " + num2 + "?");

    int correctButtonIndex = random.nextInt(4);
    Button[] buttons = frame.getAnswerButtons();
    for (int i = 0; i < buttons.length; i++) {
      if (i == correctButtonIndex) {
        buttons[i].setText(String.valueOf(correctAnswer));
      } else {
        int wrongAnswer;
        do {
          wrongAnswer = random.nextInt(100);
        } while (wrongAnswer == correctAnswer); // Ensure incorrect answers are not the same as the correct answer
        buttons[i].setText(String.valueOf(wrongAnswer));
      }
    }
  }

  public void checkAnswer(Button button) {
    int answer = Integer.parseInt(button.getText());
    String question = frame.getQuestionLabel().getText();
    String[] parts = question.split(" ");
    int num1 = Integer.parseInt(parts[2]);
    int num2 = Integer.parseInt(parts[4]);
    int correctAnswer = num1 * num2;

    if (answer == correctAnswer) {
      point++;
      frame.updatePointLabel(point);
      showAlert("Correct!");
    } else {
      showAlert("Incorrect!");
    }
  }

  public int getPoint() {
    return point;
  }

  private void showAlert(String message) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setContentText(message);
    alert.showAndWait();
  }

  private void disableAnswerButtons() {
    for (Button button : frame.getAnswerButtons()) {
      button.setDisable(true);
    }
  }
}
