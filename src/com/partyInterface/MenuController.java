package com.partyInterface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuController extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     *
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set. The primary stage will be embedded in
     *                     the browser if the application was launched as an applet.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages and will not be embedded in the browser.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Creating the loader, the pane and all details
        Parent menu = FXMLLoader.load(getClass().getResource("MenuUI.fxml"));
        // Create scene
        primaryStage.setScene(new Scene(menu));

        // Set the title to the stage
        primaryStage.setTitle("Main Menu");

        // Set resizable options
        primaryStage.setResizable(false);

        // Displays the stage
        primaryStage.show();
        //TODO make the button summon the main board.
    }
}