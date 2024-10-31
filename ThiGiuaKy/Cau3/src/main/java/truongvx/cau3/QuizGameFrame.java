package truongvx.cau3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizGameFrame extends JFrame {
  private JLabel pointLabel;
  private JLabel timerLabel;
  private JLabel questionLabel;
  private JButton[] answerButtons;
  private JButton generateQuestionButton;
  private int point = 0;
  private int time = 30;
  private Timer timer;
  private QuizGameLogic logic;

  public QuizGameFrame() {
    // Set up the frame
    setTitle("Quiz Game");
    setSize(400, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new GridLayout(6, 2));

    // Initialize logic
    logic = new QuizGameLogic(this);

    // Create the labels
    pointLabel = new JLabel("Point: 0");
    timerLabel = new JLabel("Timer: 30");
    questionLabel = new JLabel("Question:");

    // Create the buttons
    answerButtons = new JButton[4];
    for (int i = 0; i < answerButtons.length; i++) {
      answerButtons[i] = new JButton("Button " + (i + 1));
    }
    generateQuestionButton = new JButton("Generate Question");

    // Add the components to the frame
    add(pointLabel);
    add(timerLabel);
    add(new JLabel(" ")); // Empty label for spacing
    add(new JLabel(" ")); // Empty label for spacing
    add(questionLabel);
    add(new JLabel(" ")); // Empty label for spacing
    add(answerButtons[0]);
    add(answerButtons[1]);
    add(answerButtons[2]);
    add(answerButtons[3]);
    add(generateQuestionButton);

    // Set the button actions
    for (JButton button : answerButtons) {
      button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          logic.checkAnswer(button);
        }
      });
    }
    generateQuestionButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        logic.generateQuestion();
      }
    });

    // Start the timer
    logic.startTimer();
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

  public JButton[] getAnswerButtons() {
    return answerButtons;
  }

  public JLabel getQuestionLabel() {
    return questionLabel;
  }

  public void showEndMessage() {
    JOptionPane.showMessageDialog(this, "Time's up! Your score: " + point);
  }
}
