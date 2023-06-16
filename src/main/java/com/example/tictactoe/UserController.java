package com.example.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class UserController {
    @FXML
    private Button btn00;

    @FXML
    private Button btn01;

    @FXML
    private Button btn02;

    @FXML
    private Button btn10;

    @FXML
    private Button btn11;

    @FXML
    private Button btn12;

    @FXML
    private Button btn20;

    @FXML
    private Button btn21;

    @FXML
    private Button btn22;

    @FXML
    private Label winnerLabel;


    @FXML
    private Label computerItem;

    @FXML
    private Label turn;

    @FXML
    private Label userItem;

    private String currentPlayer = "X";

    @FXML
    private void clickBtn(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        if (clickedButton.getText().isEmpty()) {
            clickedButton.setText(currentPlayer);
            checkWinner();
            switchPlayer();
        }
    }

    private void switchPlayer() {
        if (currentPlayer.equals("X")) {
            currentPlayer = "O";
            turn.setText("O's turn");
        } else {
            currentPlayer = "X";
            turn.setText("X's turn");

        }
    }

    private void checkWinner() {
        String[][] board = {
                {btn00.getText(), btn01.getText(), btn02.getText()},
                {btn10.getText(), btn11.getText(), btn12.getText()},
                {btn20.getText(), btn21.getText(), btn22.getText()}
        };

        // Check rows
        for (int i = 0; i < 3; i++) {
            if (!board[i][0].isEmpty() && board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2])) {
                displayWinner(board[i][0]);
                return;
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (!board[0][j].isEmpty() && board[0][j].equals(board[1][j]) && board[0][j].equals(board[2][j])) {
                displayWinner(board[0][j]);
                return;
            }
        }

        // Check diagonals
        if (!board[0][0].isEmpty() && board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2])) {
            displayWinner(board[0][0]);
            return;
        }

        if (!board[0][2].isEmpty() && board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0])) {
            displayWinner(board[0][2]);
        }
    }

    private void displayWinner(String winner) {
        winnerLabel.setText("Winner: " + winner);
        disableButtons();
    }

    private void disableButtons() {
        btn00.setDisable(true);
        btn01.setDisable(true);
        btn02.setDisable(true);
        btn10.setDisable(true);
        btn11.setDisable(true);
        btn12.setDisable(true);
        btn20.setDisable(true);
        btn21.setDisable(true);
        btn22.setDisable(true);
    }

    public void selectX(ActionEvent actionEvent) {
        userItem.setText("X");
        computerItem.setText("O");
        currentPlayer = "X";
    }

    public void selectO(ActionEvent actionEvent) {
        userItem.setText("O");
        computerItem.setText("X");
        currentPlayer ="O";
    }


    public void restart(ActionEvent actionEvent) {
        btn00.setText("");
        btn01.setText("");
        btn02.setText("");
        btn10.setText("");
        btn11.setText("");
        btn12.setText("");
        btn20.setText("");
        btn21.setText("");
        btn22.setText("");
    }
}
