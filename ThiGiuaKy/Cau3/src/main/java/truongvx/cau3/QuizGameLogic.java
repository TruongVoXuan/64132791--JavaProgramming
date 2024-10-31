package truongvx.cau3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class QuizGameLogic {
  private QuizGameFrame frame;
  private int point = 0;
  private int time = 30;
  private Timer timer;

  public QuizGameLogic(QuizGameFrame frame) {
    this.frame = frame;
  }

  public void startTimer() {
    timer = new Timer(1000, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (time > 0) {
          time--;
          frame.updateTimerLabel(time);
        } else {
          timer.stop();
          for (JButton button : frame.getAnswerButtons()) {
            button.setEnabled(false);
          }
          frame.showEndMessage();
        }
      }
    });
    timer.start();
  }

  public void generateQuestion() {
    Random random = new Random();
    int num1 = random.nextInt(10) + 1;
    int num2 = random.nextInt(10) + 1;
    int correctAnswer = num1 * num2;

    frame.updateQuestionLabel("What is " + num1 + " x " + num2 + "?");

    int correctButtonIndex = random.nextInt(4);
    JButton[] buttons = frame.getAnswerButtons();
    for (int i = 0; i < buttons.length; i++) {
      if (i == correctButtonIndex) {
        buttons[i].setText(String.valueOf(correctAnswer));
      } else {
        buttons[i].setText(String.valueOf(random.nextInt(100)));
      }
    }
  }

  public void checkAnswer(JButton button) {
    int answer = Integer.parseInt(button.getText());
    String question = frame.getQuestionLabel().getText();
    String[] parts = question.split(" ");
    int num1 = Integer.parseInt(parts[2]);
    int num2 = Integer.parseInt(parts[4]);
    int correctAnswer = num1 * num2;

    if (answer == correctAnswer) {
      point++;
      frame.updatePointLabel(point);
      JOptionPane.showMessageDialog(frame, "Correct!");
    } else {
      JOptionPane.showMessageDialog(frame, "Incorrect!");
    }
  }
}
