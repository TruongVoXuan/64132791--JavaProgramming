package truongvx.th_bai4_flashquizassignment;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.util.ArrayList;

public class HelloController {
  @FXML
  private Button optionABtn;

  @FXML
  private Button optionACircleBtn;

  @FXML
  private Button optionBBtn;

  @FXML
  private Button optionBCircleBtn;

  @FXML
  private Button optionCBtn;

  @FXML
  private Button optionCCircleBtn;

  @FXML
  private Button optionDBtn;

  @FXML
  private Button optionDCircleBtn;

  @FXML
  private Button question10Btn;

  @FXML
  private Button question1Btn;

  @FXML
  private Button question2Btn;

  @FXML
  private Button question3Btn;

  @FXML
  private Button question4Btn;

  @FXML
  private Button question5Btn;

  @FXML
  private Button question6Btn;

  @FXML
  private Button question7Btn;

  @FXML
  private Button question8Btn;

  @FXML
  private Button question9Btn;

  @FXML
  private Label questionLabel;

  @FXML
  private AnchorPane quizTextPane;

  @FXML
  private Label scoreLabel;

  @FXML
  private TextField scoreTextField;


  private int currentQuestionIndex = 0; // Theo dõi câu hỏi hiện tại
  private double score = 0; // Điểm của người chơi

  private ArrayList<Question> questionList;
  private Question currentQuestion;
  @FXML
  public void initialize() {
    // Generate questions when the controller is initialized
    questionList = Question.QuestionGenerator.generateQuestions();
    // Hiển thị câu hỏi đầu tiên
    displayNextQuestion();

  }

  private void displayNextQuestion() {
    if (currentQuestionIndex < questionList.size()) {
      // Get the current question
      currentQuestion = questionList.get(currentQuestionIndex);
      questionLabel.setText(currentQuestion.getQuestionText());
      optionABtn.setText("A: " + currentQuestion.getOptions()[0]);
      optionBBtn.setText("B: " + currentQuestion.getOptions()[1]);
      optionCBtn.setText("C: " + currentQuestion.getOptions()[2]);
      optionDBtn.setText("D: " + currentQuestion.getOptions()[3]);

      scoreLabel.setText("Điểm: " + score); // Display the score before showing next question
    } else {
      // End of game
      questionLabel.setText("Kết thúc trò chơi! Điểm của bạn: " + score);
      optionABtn.setDisable(true);
      optionBBtn.setDisable(true);
      optionCBtn.setDisable(true);
      optionDBtn.setDisable(true);
    }
  }


  @FXML
  void handleAnswer(ActionEvent event) {
    // Kiểm tra nút nào được nhấn
    String selectedAnswer = "";
    if (event.getSource() == optionABtn) {
      selectedAnswer = currentQuestion.getOptions()[0];
    } else if (event.getSource() == optionBBtn) {
      selectedAnswer = currentQuestion.getOptions()[1];
    } else if (event.getSource() == optionCBtn) {
      selectedAnswer = currentQuestion.getOptions()[2];
    } else if (event.getSource() == optionDBtn) {
      selectedAnswer = currentQuestion.getOptions()[3];
    }

    // So sánh với đáp án đúng
    if (selectedAnswer.equals(currentQuestion.getCorrectAnswer())) {
      score += 1; // Cộng điểm nếu đúng
    } else {
      score -= 0.2; // Trừ điểm nếu sai
    }

    // Cập nhật điểm trong TextField
    scoreTextField.setText(String.format("%.2f", score)); // Hiển thị điểm với 2 chữ số thập phân

    // Chuyển đến câu hỏi tiếp theo sau một khoảng thời gian ngắn
    currentQuestionIndex++;

    // Thêm trì hoãn một lúc để người dùng xem kết quả
    PauseTransition pause = new PauseTransition(Duration.seconds(1));
    pause.setOnFinished(e -> displayNextQuestion());
    pause.play();
  }



  private void displayQuestion(int questionIndex) {
    if (questionIndex < questionList.size()) {
      currentQuestion = questionList.get(questionIndex);
      questionLabel.setText(currentQuestion.getQuestionText());
      optionABtn.setText("A: " + currentQuestion.getOptions()[0]);
      optionBBtn.setText("B: " + currentQuestion.getOptions()[1]);
      optionCBtn.setText("C: " + currentQuestion.getOptions()[2]);
      optionDBtn.setText("D: " + currentQuestion.getOptions()[3]);

      scoreLabel.setText("Điểm: " + score);
    } else {
      questionLabel.setText("Kết thúc trò chơi! Điểm của bạn: " + score);
      optionABtn.setDisable(true);
      optionBBtn.setDisable(true);
      optionCBtn.setDisable(true);
      optionDBtn.setDisable(true);
    }
  }


  @FXML
  void handleQuestionButton(ActionEvent event) {
    if (event.getSource() == question1Btn) {
      displayQuestion(0);
    } else if (event.getSource() == question2Btn) {
      displayQuestion(1);
    } else if (event.getSource() == question3Btn) {
      displayQuestion(2);
    } else if (event.getSource() == question4Btn) {
      displayQuestion(3);
    } else if (event.getSource() == question5Btn) {
      displayQuestion(4);
    } else if (event.getSource() == question6Btn) {
      displayQuestion(5);
    } else if (event.getSource() == question7Btn) {
      displayQuestion(6);
    } else if (event.getSource() == question8Btn) {
      displayQuestion(7);
    } else if (event.getSource() == question9Btn) {
      displayQuestion(8);
    } else if (event.getSource() == question10Btn) {
      displayQuestion(9);
    }
  }

  public void changeColor(ActionEvent event) {
    defaultColor();
    if (event.getSource() == question1Btn) {
      question1Btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #8b0000);");
    } else if (event.getSource() == question2Btn) {
      question2Btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #8b0000);");
    } else if (event.getSource() == question3Btn) {
      question3Btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #8b0000);");
    } else if (event.getSource() == question4Btn) {
      question4Btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #8b0000);");
    } else if (event.getSource() == question5Btn) {
      question5Btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #8b0000);");
    } else if (event.getSource() == question6Btn) {
      question6Btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #8b0000);");
    } else if (event.getSource() == question7Btn) {
      question7Btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #8b0000);");
    } else if (event.getSource() == question8Btn) {
      question8Btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #8b0000);");
    } else if (event.getSource() == question9Btn) {
      question9Btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #8b0000);");
    } else if (event.getSource() == question10Btn) {
      question10Btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #8b0000);");
    }
  }

  private void defaultColor() {
    question1Btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #4d8c7e);");
      question2Btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #4d8c7e);");
    question3Btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #4d8c7e);");
    question4Btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #4d8c7e);");
    question5Btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #4d8c7e);");
    question6Btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #4d8c7e);");
    question7Btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #4d8c7e);");
    question8Btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #4d8c7e);");
    question9Btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #4d8c7e);");
    question10Btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #4d8c7e);");
  }

  @FXML
  void changeColorQuestion(ActionEvent event) {

    defaultColorQuestion();
    if (event.getSource() == optionABtn) {
      optionABtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #8b0000);");
    } else if (event.getSource() == optionBBtn) {
      optionBBtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #8b0000);");
    } else if (event.getSource() == optionCBtn) {
      optionCBtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #8b0000);");
    }
    else if (event.getSource() == optionDBtn) {
      optionDBtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3979a6, #8b0000);");
    }

  }
  private void defaultColorQuestion() {
    optionABtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #a8e6cf, #2459a6);");
    optionBBtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #a8e6cf, #2459a6);");
    optionCBtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #a8e6cf, #2459a6);");
    optionDBtn.setStyle("-fx-background-color: linear-gradient(to bottom right, #a8e6cf, #2459a6);");

  }


}