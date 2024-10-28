package truongvx.appmaytinh;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

public class HelloController implements Initializable {

    @FXML
    private TextField display;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Không cần ScriptEngine nữa
    }

    @FXML
    private void handleButtonPress(javafx.event.ActionEvent event) {
        String text = ((javafx.scene.control.Button) event.getSource()).getText();
        switch (text) {
            case "=":
                calculateResult();
                break;
            case "sin":
            case "cos":
            case "e^x":
            case "ln":
            case "log":
                calculateFunction(text);
                break;
            default:
                display.appendText(text);
                break;
        }
    }

    @FXML
    private void handleReset() {
        display.clear();
    }

    private void calculateResult() {
        try {
            String expression = display.getText();
            double result = evalExpression(expression);
            display.setText(String.valueOf(result));
        } catch (Exception e) {
            display.setText("Lỗi");
        }
    }

    private void calculateFunction(String function) {
        try {
            double value = Double.parseDouble(display.getText());
            double result = 0;
            switch (function) {
                case "sin":
                    result = Math.sin(Math.toRadians(value));
                    break;
                case "cos":
                    result = Math.cos(Math.toRadians(value));
                    break;
                case "e^x":
                    result = Math.exp(value);
                    break;
                case "ln":
                    result = Math.log(value);
                    break;
                case "log":
                    result = Math.log10(value);
                    break;
            }
            display.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            display.setText("Lỗi");
        }
    }

    private double evalExpression(String expression) throws Exception {
        Stack<Double> values = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c) || c == '.') {
                StringBuilder sb = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    sb.append(expression.charAt(i++));
                }
                values.push(Double.parseDouble(sb.toString()));
                i--; // Giảm chỉ số vì vòng lặp for cũng sẽ tăng chỉ số
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!operators.isEmpty() && precedence(c) <= precedence(operators.peek())) {
                    values.push(applyOperation(operators.pop(), values.pop(), values.pop()));
                }
                operators.push(c);
            }
        }

        while (!operators.isEmpty()) {
            values.push(applyOperation(operators.pop(), values.pop(), values.pop()));
        }

        return values.pop();
    }

    private int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    private double applyOperation(char operator, double b, double a) {
        switch (operator) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        return 0;
    }
}