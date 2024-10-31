package truongvx.cau1;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class MayTinhController {

    @FXML
    private TextField number1Field;
    @FXML
    private TextField number2Field;
    @FXML
    private TextField resultField;

    private Queue<String> history = new LinkedList<>();

    @FXML
    private void handleAdd() {
        performOperation((a, b) -> a + b, "+");
    }

    @FXML
    private void handleSubtract() {
        performOperation((a, b) -> a - b, "-");
    }

    @FXML
    private void handleMultiply() {
        performOperation((a, b) -> a * b, "*");
    }

    @FXML
    private void handleDivide() {
        performOperation((a, b) -> a / b, "/");
    }

    @FXML
    private void handleDiv() {
        performOperation((a, b) -> a / b, "div");
    }

    @FXML
    private void handleMod() {
        performOperation((a, b) -> a % b, "mod");
    }

    private void performOperation(Operation operation, String operator) {
        try {
            double number1 = Double.parseDouble(number1Field.getText());
            double number2 = Double.parseDouble(number2Field.getText());
            double result = operation.apply(number1, number2);
            resultField.setText(String.valueOf(result));
            logOperation(number1, number2, operator, result);
        } catch (NumberFormatException e) {
            resultField.setText("Invalid input");
        }
    }

    private void logOperation(double number1, double number2, String operator, double result) {
        String logEntry = number1 + " " + operator + " " + number2 + " = " + result;
        history.add(logEntry);
        if (history.size() > 10) {
            history.poll();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true))) {
            writer.write(logEntry);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FunctionalInterface
    interface Operation {
        double apply(double a, double b);
    }
}
