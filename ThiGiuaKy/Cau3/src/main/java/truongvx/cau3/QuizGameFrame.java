package truongvx.cau3;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class QuizGameFrame {
  private Label pointLabel;
  private Label timerLabel;
  private Label questionLabel;
  private Button[] answerButtons;
  private Button generateQuestionButton;
  private QuizGameLogic logic;
  private Stage stage;

  public QuizGameFrame(Stage stage) {
    this.stage = stage;
    stage.setTitle("Quiz Game");

    // Initialize logic
    logic = new QuizGameLogic(this);

    // Set up the layout
    GridPane layout = new GridPane();
    layout.setVgap(10);
    layout.setHgap(10);

    // Create the labels
    pointLabel = new Label("Point: 0");
    timerLabel = new Label("Timer: 30");
    questionLabel = new Label("Question:");

    // Create the buttons
    answerButtons = new Button[4];
    for (int i = 0; i < answerButtons.length; i++) {
      answerButtons[i] = new Button("Answer " + (i + 1));
      int index = i;
      answerButtons[i].setOnAction(e -> logic.checkAnswer(answerButtons[index]));
    }
    generateQuestionButton = new Button("Generate Question");
    generateQuestionButton.setOnAction(e -> logic.generateQuestion());

    // Add components to the layout
    layout.add(pointLabel, 0, 0);
    layout.add(timerLabel, 1, 0);
    layout.add(questionLabel, 0, 1, 2, 1);
    for (int i = 0; i < answerButtons.length; i++) {
      layout.add(answerButtons[i], i % 2, 2 + i / 2);
    }
    layout.add(generateQuestionButton, 0, 4, 2, 1);

    // Create and set scene
    Scene scene = new Scene(layout, 400, 300);
    stage.setScene(scene);

    // Start timer and show stage
    logic.startTimer();
    stage.show();
  }

  public void updatePointLabel(int point) {
    pointLabel.setText("Point: " + point);
  }

  public void updateTimerLabel(int time) {
    timerLabel.setText("Timer: " + time);
  }

  public void updateQuestionLabel(String question) {
    questionLabel.setText(question);
  }

  public Button[] getAnswerButtons() {
    return answerButtons;
  }

  public Label getQuestionLabel() {
    return questionLabel;
  }

  public void showEndMessage() {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setContentText("Time's up! Your score: " + logic.getPoint());
    alert.showAndWait();
  }
}
