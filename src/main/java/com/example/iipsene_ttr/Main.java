package com.example.iipsene_ttr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.util.ArrayList;

public class Main extends Application {

    public static void main(String [] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/startSelectCardsScreen.fxml"));

        //        ArrayList<TrainCard> trainCards = new ArrayList<>();
//        ArrayList<String> trainCards = new ArrayList<>();
//        ArrayList<Button> trainCardButtons = new ArrayList<>();
//        trainCards.add("Green");
//        trainCards.add("Blue");
//        trainCards.add("Pink");
//        trainCards.add("Yellow");
//        trainCards.add("Green");
//        trainCards.add("Green");
//
////        In plaats van String color de TrainCard class gebruiken
////        for (TrainCard trainCard : trainCards
//        System.out.println(trainCards.size());
//
//        for (String trainCard : trainCards) {
//            Button card = new Button();
////            card.setText(trainCard.getColor());
////            card.setGraphic(trainCard.getGraphic());
//            card.setText(trainCard);
//            trainCardButtons.add(card);
//        }

        primaryStage.setTitle("Tickets to Ride");
        primaryStage.setScene(new Scene(root, 1000, 800));
        primaryStage.show();
    }
}