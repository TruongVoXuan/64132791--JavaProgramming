package truongvx.cau3;

import javax.swing.*;

public class QuizGame {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        QuizGameFrame frame = new QuizGameFrame();
        frame.setVisible(true);
      }
    });
  }
}

