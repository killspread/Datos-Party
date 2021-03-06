package com.minigames.bombGame;


import com.gameLogic.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This class controlls the BombController.fxml
 */
public class BombController{
    @FXML Button helpButton;
    @FXML Button startButton;
    @FXML TextArea helpText;
    private Player[] players;

    /**
     * Shows additional help when pressing the button
     */
    public void showHelp(){
        if (!helpText.isVisible()){
            helpText.setVisible(true);
        }
        else{
            helpText.setVisible(false);
        }
    }

    /**
     *this method is bound to the start button on the minigame menu. Clicking the button summons this method.
     * @param buttonClick the event that occurs when the button is clicked.
     * @throws IOException if the file that the loader tries to access is not found or is corrupted.
     */
    public void startBombGame(ActionEvent buttonClick) throws IOException {
        FXMLLoader bombLoader = new FXMLLoader();
        bombLoader.setLocation(getClass().getResource("bombGame2.fxml"));

        Parent minigameParent = bombLoader.load();
        Scene bombScene = new Scene(minigameParent);
        BombGame2 controller = bombLoader.getController();
        controller.initData(players);

        // This gets the stage information to set the new scene.
        Stage window = (Stage) ((Node)buttonClick.getSource()).getScene().getWindow();
        //takes the obtained Stage and changes its Scene to the new fxml file.
        window.setScene(bombScene);
        window.show();
    }

    /**
     * Sets the initial data for the controller.
     * @param players Player array
     */
    public void initData(Player[] players){
        this.players = players;
    }

}
