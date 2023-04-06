package com.example.task14;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class StartOrEnd
{

    public Label namePlayer;
    public TextField enterName;

    public void startGame(ActionEvent actionEvent)
    {
        namePlayer.setVisible(true);
        enterName.setVisible(true);
    }

    public void endGame(ActionEvent actionEvent)
    {
        System.exit(0);
    }

    public void switchToGame(KeyEvent keyEvent)
    {

    }
}
