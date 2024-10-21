package com.example.carroapp;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class MainController {

  @FXML
  private GridPane gridPane;

  private boolean playerXTurn = true;
  private int[][] board = new int[3][3]; // 0: empty, 1: X, 2: O

  @FXML
  private void handleButtonAction(javafx.event.ActionEvent event) {
    Button button = (Button) event.getSource();
    int row = GridPane.getRowIndex(button);
    int col = GridPane.getColumnIndex(button);

    if (board[row][col] == 0) {
      board[row][col] = playerXTurn ? 1 : 2;
      button.setText(playerXTurn ? "X" : "O");
      if (checkWinner()) {
        showAlert("Player " + (playerXTurn ? "X" : "O") + " wins!");
        disableButtons();
      } else if (isBoardFull()) {
        showAlert("It's a draw!");
      }
      playerXTurn = !playerXTurn;
    }
  }

  @FXML
  private void handleResetAction() {
    playerXTurn = true;
    board = new int[3][3];
    for (int i = 0; i < gridPane.getChildren().size(); i++) {
      Button button = (Button) gridPane.getChildren().get(i);
      button.setText("");
      button.setDisable(false);
    }
  }

  private boolean checkWinner() {
    int[][] winPositions = {
        {0, 0, 0, 1, 0, 2}, {1, 0, 1, 1, 1, 2}, {2, 0, 2, 1, 2, 2}, // rows
        {0, 0, 1, 0, 2, 0}, {0, 1, 1, 1, 2, 1}, {0, 2, 1, 2, 2, 2}, // columns
        {0, 0, 1, 1, 2, 2}, {0, 2, 1, 1, 2, 0}  // diagonals
    };

    for (int[] pos : winPositions) {
      if (board[pos[0]][pos[1]] == board[pos[2]][pos[3]] &&
          board[pos[2]][pos[3]] == board[pos[4]][pos[5]] &&
          board[pos[0]][pos[1]] != 0) {
        return true;
      }
    }
    return false;
  }

  private boolean isBoardFull() {
    for (int[] row : board) {
      for (int cell : row) {
        if (cell == 0) {
          return false;
        }
      }
    }
    return true;
  }

  private void disableButtons() {
    for (int i = 0; i < gridPane.getChildren().size(); i++) {
      Button button = (Button) gridPane.getChildren().get(i);
      button.setDisable(true);
    }
  }

  private void showAlert(String message) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Game Over");
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
  }
}
