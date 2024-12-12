package truongvx.th_bai4_flashquizassignment;


import java.util.ArrayList;
import java.util.Random;

// Question class to represent a quiz question
class Question {
  private String questionText;
  private String[] options;
  private String correctAnswer;

  public Question(String questionText, String[] options, String correctAnswer) {
    this.questionText = questionText;
    this.options = options;
    this.correctAnswer = correctAnswer;
  }

  public String getQuestionText() {
    return questionText;
  }

  public String[] getOptions() {
    return options;
  }

  public String getCorrectAnswer() {
    return correctAnswer;
  }

  public class QuestionGenerator {
    public static ArrayList<Question> generateQuestions() {
      ArrayList<Question> questionList = new ArrayList<>();

      questionList.add(new Question(
          "Thành phố của Khánh Hòa tên là gì?",
          new String[]{"Nha Trang", "Cam ranh", "Nha Phu", "Hàm thuận"},
          "Nha Trang"
      ));

      questionList.add(new Question(
          "Hành tinh nào được gọi là Hành tinh Đỏ?",
          new String[]{"Trái Đất", "Sao Hỏa", "Sao Mộc", "Sao Kim"},
          "Sao Hỏa"
      ));

      questionList.add(new Question(
          "Thủ đô của Pháp là gì?",
          new String[]{"Paris", "London", "Berlin", "Madrid"},
          "Paris"
      ));

      questionList.add(new Question(
          "Thủ đô Việt Nam là ở đâu?",
          new String[]{"Hà Nội", "Sài Gòn", "Hải Phòng", "Vũng Tàu"},
          "Hà Nội"
      ));

      questionList.add(new Question(
          "Câu hỏi toán học : 1+1=?",
          new String[]{"2", "999", "1+1", "?"},
          "2"
      ));

      questionList.add(new Question(
          "Incline Dumbell Press là bài gì?",
          new String[]{"Đẩy ngực", "Đẩy ngực ghế dốc", "Ép ngực", "Đẩy vai"},
          "Đẩy ngực ghế dốc"
      ));


      questionList.add(new Question(
          "Cable Chest Fly là bài gì?",
          new String[]{"Bay vai", "Ép ngực với dây", "Đẩy ngực", "Bay vai"},
          "Ép ngực với dây"
      ));


      questionList.add(new Question(
          "Lateral Raise là bài gì?",
          new String[]{"Bay vai", "Đẩy vai", "Đẩy ngực", "Đẩy ngực dưới"},
          "Bay vai"
      ));


      questionList.add(new Question(
          "EZ Bar Skull Crushers là bài gì?",
          new String[]{"Cuộn tay trước", "Tay sau", "Ép ngực", "Đẩy vai"},
          "Cuộn tay trước"
      ));


      questionList.add(new Question(
          "Hành tinh nào được gọi là Hành tinh Xinh?",
          new String[]{"Trái Đất", "Sao Hỏa", "Sao Mộc", "Sao Kim"},
          "Trái Đất"
      ));



      return questionList;
    }

    public static Question getRandomQuestion(ArrayList<Question> questionList) {
      Random random = new Random();
      int index = random.nextInt(questionList.size());
      return questionList.get(index);
    }
  }
}
