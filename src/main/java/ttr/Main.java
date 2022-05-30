package ttr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import ttr.App;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException, InterruptedException {
        Parent root = FXMLLoader.load(getClass().getResource("view.fxml"));
//        URL url = new File("src/main/resources/ttr/view.fxml").toURI().toURL();

//        Parent root = FXMLLoader.load(url);
//        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/startMenu.fxml"));

//        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
        stage.setTitle("TTR!");
        stage.setScene(new Scene(root, 600, 6000));
        stage.show();

        listen();

//        listen();
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