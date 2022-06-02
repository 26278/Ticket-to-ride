package ttr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

import ttr.Constants.ClientConstants;

public class Main extends Application {

    ClientConstants cc = new ClientConstants();


    @Override
    public void start(Stage stage) throws IOException, InterruptedException {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/view.fxml"));
        stage.setTitle("TTR!");
        stage.setScene(new Scene(root, cc.getScreenX(), cc.getScreenY()));
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}