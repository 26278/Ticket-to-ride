package views;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


public class Rules extends Application {

    @Override
    public void start(Stage stage) throws FileNotFoundException {

        //creating the image
        InputStream stream = new FileInputStream("ttr/rules/te_rules_en.png");
        Image image = new Image(stream);
        ImageView imageView = new ImageView();
        imageView.setImage(image);

        //Setting the image view parameters
        imageView.setX(0);
        imageView.setY(0);
        imageView.setFitWidth(594);
        imageView.setPreserveRatio(true);

        //Creating the scroll pane
        ScrollPane scroll = new ScrollPane();
        scroll.setPrefSize(594, 807);
        scroll.setContent(imageView);
        //Button button = new Button("Back");

        //Setting the stage
        //button.setMaxSize(100, 200);
        Group root = new Group();
        root.getChildren().addAll(scroll);
        //root.getChildren().addAll(button);
        Scene scene = new Scene(root, 594, 807, Color.BEIGE);
        stage.setTitle("Game Rules");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
