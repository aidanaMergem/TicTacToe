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


    private Button[] buttons;

    @FXML
    public void initialize() {
        turn.setText("X's turn");

        userItem.setText("X");
        computerItem.setText("O");
        buttons = new Button[]{
                btn00, btn01, btn02,
                btn10, btn11, btn12,
                btn20, btn21, btn22
        };
    }




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

    private static boolean isBoardFull(String[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals("")) {
                    return false;
                }
            }
        }
        return true;
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

        if (isBoardFull(board)) {
            winnerLabel.setText("It's a tie!");
        }
    }

    private void displayWinner(String winner) {

        winnerLabel.setText("Winner: " + winner);
        disableButtons();

    }

    private void disableButtons() {

        for (Button button: buttons){
            button.setDisable(true);
        }

    }

    public void selectX() {
        turn.setText("X's turn");
        userItem.setText("X");
        computerItem.setText("O");
        currentPlayer = "X";
    }

    public void selectO() {
        turn.setText("O's turn");

        userItem.setText("O");
        computerItem.setText("X");
        currentPlayer = "O";
    }


    public void restart() {

        winnerLabel.setText("");
        restartAllBtn();
    }

    private void restartAllBtn() {


        for(Button b : buttons){
            b.setDisable(false);
            b.setText("");
        }
    }


}
