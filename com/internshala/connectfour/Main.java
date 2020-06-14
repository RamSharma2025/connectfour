package com.internshala.connectfour;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {


    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("game.fxml"));
        GridPane rootGridPane=loader.load();

        controller=loader.getController();
        controller.createPlayground();

        MenuBar menuBar=createMenu();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

        Pane menuPane=(Pane) rootGridPane.getChildren().get(0);
        menuPane.getChildren().add(menuBar);

        Scene scene=new Scene(rootGridPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Connect Four Game");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private MenuBar createMenu(){
        //Creating File Menu in MenuBar
        Menu fileMenu=new Menu("File");

        MenuItem newGame=new MenuItem("New Game");
        newGame.setOnAction(event -> controller.resetGame());

        MenuItem resetGame=new MenuItem("Reset Game");
        resetGame.setOnAction(event -> controller.resetGame());

        SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();//seprator bw Reset Game and Exit Game
        MenuItem exitGame=new MenuItem("Exit Game");
        exitGame.setOnAction(event -> {
            exitGame();
        });
        fileMenu.getItems().addAll(newGame,resetGame,separatorMenuItem,exitGame);

        //Creating Help Menu in MenuBar
        Menu helpMenu=new Menu("Help");

        MenuItem aboutGame=new MenuItem("About Connect4 Game");
        aboutGame.setOnAction(event -> aboutConnect4());

        SeparatorMenuItem separator=new SeparatorMenuItem();//seprator
        MenuItem aboutMe=new MenuItem("About Developer");
        aboutMe.setOnAction(event -> aboutMe()) ;
        MenuItem rateForGame=new MenuItem("Rate Connect4 Game");
        rateForGame.setOnAction(event -> rateForGame());

        helpMenu.getItems().addAll(aboutGame,separator,aboutMe,rateForGame);

        MenuBar menuBar=new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);
        return menuBar;
    }

    private void rateForGame() {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Rate for Connect 4");
        alert.setHeaderText("Rate on--> Email Id: drramsharma1996@gmail.com");
        alert.setContentText("Connect 4 Game is fantastic game to play with nears and dears.please rate on-->>  Email Id: drramsharma1996@gmail.com   ");
        alert.show();
    }

    private void aboutMe() {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About The  Developer");
        alert.setHeaderText("Developer:-->RAMRATAN SHARMA");
        alert.setContentText("It's my first Game Application.I love to coding and this game is developed for Game Lovers" +
                " as well as normanl person.Connect 4 Game is one of the most popular Game." +
                "Whenever I feel depressed than I play this game with my siblings. ");
        alert.show();
    }

    private void aboutConnect4() {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Connect 4 Game");
        alert.setHeaderText("How to Play??");
        alert.setContentText("Connect Four is a two-player connection game in which the players first choose" +
                " a color and then take turns dropping colored discs from the top into a seven-column," +
                " six-row vertically suspended grid. The pieces fall straight down," +
                " occupying the next available space within the column. The objective of the game is to be" +
                " the first to form a horizontal, vertical, or diagonal line of four of one's own discs." +
                " Connect Four is a solved game."
                +"The first player can always win by playing the right moves. ");
        alert.show();
    }

    private void exitGame() {
        Platform.exit(); //Close application
        System.exit(0);//Close resources
    }



    public static void main(String[] args)
    {
        launch(args);
    }
}

