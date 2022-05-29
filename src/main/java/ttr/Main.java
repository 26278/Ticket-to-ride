package com.example.iipsene_ttr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.util.ArrayList;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException, InterruptedException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
        stage.setTitle("TTR!");
        stage.setScene(scene);
        stage.show();

        listen();
    }

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

    private void listen() throws IOException, InterruptedException {
        new App();
    }

    public static void main(String[] args) {
        launch(args);
    }
}