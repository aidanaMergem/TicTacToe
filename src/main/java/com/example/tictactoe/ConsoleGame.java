package com.example.tictactoe;

import java.util.Scanner;

public class ConsoleGame {

    private static final int BOARD_SIZE = 3;
    private static final String EMPTY_CELL = "#";

    private static String[][] board;

    private static String userItem;
    private static String computerItem;

    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        initializeBoard();
        selectUserItem();
        showBoard();

        while (!isGameOver()) {
            userMove();
            if (isGameOver()) break;
            computerMove();
            showBoard();
        }

        showResult();
    }

    private static void initializeBoard() {
        board = new String[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = EMPTY_CELL;
            }
        }
    }

    private static void selectUserItem() {
        Scanner in = new Scanner(System.in);
        System.out.print("Select X or O: ");
        String userInput = in.nextLine().toUpperCase();

        if (userInput.equals("X")) {
            userItem = "X";
            computerItem = "O";
        } else if (userInput.equals("O")) {
            userItem = "O";
            computerItem = "X";
        } else {
            System.out.println("Invalid input. Please try again.");
            selectUserItem();
        }
    }

    private static void showBoard() {
        System.out.println("Current board:");
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void userMove() {
        Scanner in = new Scanner(System.in);

        System.out.println("Your turn:");
        System.out.print("Enter row (1-" + BOARD_SIZE + "): ");
        int row = in.nextInt() - 1;

        System.out.print("Enter column (1-" + BOARD_SIZE + "): ");
        int col = in.nextInt() - 1;

        if (isValidMove(row, col)) {
            board[row][col] = userItem;
        } else {
            System.out.println("Invalid move. Please try again.");
            userMove();
        }
    }

    private static boolean isValidMove(int row, int col) {
        if (row < 0 || row >= BOARD_SIZE || col < 0 || col >= BOARD_SIZE) {
            return false;
        }
        return board[row][col].equals(EMPTY_CELL);
    }

    private static void computerMove() {
        System.out.println("Computer's turn:");

        // Generate a random move for the computer
        int row, col;
        do {
            row = (int) (Math.random() * BOARD_SIZE);
            col = (int) (Math.random() * BOARD_SIZE);
        } while (!isValidMove(row, col));

        board[row][col] = computerItem;
    }

    private static boolean isGameOver() {
        if (isWinningMove(userItem)) {
            System.out.println("You win!");
            return true;
        } else if (isWinningMove(computerItem)) {
            System.out.println("Computer wins!");
            return true;
        } else if (isBoardFull()) {
            System.out.println("It's a tie!");
            return true;
        }
        return false;
    }

    private static boolean isWinningMove(String item) {
        // Check rows
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i][0].equals(item) && board[i][1].equals(item) && board[i][2].equals(item)) {
                return true;
            }
        }

        // Check columns
        for (int j = 0; j < BOARD_SIZE; j++) {
            if (board[0][j].equals(item) && board[1][j].equals(item) && board[2][j].equals(item)) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0].equals(item) && board[1][1].equals(item) && board[2][2].equals(item)) {
            return true;
        }

        if (board[0][2].equals(item) && board[1][1].equals(item) && board[2][0].equals(item)) {
            return true;
        }

        return false;
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j].equals(EMPTY_CELL)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void showResult() {
        System.out.println("Final board:");
        showBoard();
        System.out.println("Game Over!");
    }
}
