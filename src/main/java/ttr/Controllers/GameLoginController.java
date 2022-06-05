package ttr.Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import ttr.App;
import ttr.Constants.Token;

import java.io.IOException;

public class GameLoginController {
    private Stage stage;
    private Scene scene;

    public void joinGame(String token, MouseEvent event) throws IOException {
        new Token().createToken(token);
        new App();

        loadFile(event, "game_start.fxml");
    }

    public void loadFile(MouseEvent event, String file) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/ttr/fxml/" + file));

        this.stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        this.scene = new Scene(root, 1000, 800);
        stage.setScene(scene);
        stage.show();
    }
}
