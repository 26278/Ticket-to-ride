import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/selectCardsScreen.fxml"));
        primaryStage.setTitle("Tickets to Ride");
        primaryStage.setScene(new Scene(root, 1000, 800));
        primaryStage.show();
    }
}
