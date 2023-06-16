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
    private Label Winner;


    @FXML
    private Label computerItem;

    @FXML
    private Label turn;

    @FXML
    private Label userItem;



    @FXML
    void restart(ActionEvent event) {

    }

    @FXML
    void selectO(ActionEvent event) {

    }

    @FXML
    void selectX(ActionEvent event) {

    }


    @FXML
    private void clickBtn(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        clickedButton.setText("X");
    }

}
