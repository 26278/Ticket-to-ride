package com.example.iipsene_ttr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException, InterruptedException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("bord.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1006, 670);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        listen();
    }

    private void listen() throws IOException, InterruptedException {
        new App();
    }

    public static void main(String[] args) {
        launch(args);


    }
}