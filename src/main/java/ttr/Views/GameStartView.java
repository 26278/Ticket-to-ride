package ttr.Views;

import com.google.cloud.firestore.DocumentSnapshot;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ttr.Controllers.Controller;
import ttr.Controllers.GameStartController;

import java.io.IOException;
import java.util.Locale;

public class GameStartView implements Controller {

    GameStartController gsc = new GameStartController();

    @FXML
    protected ToggleGroup group;

    @FXML
    protected TextField nameField;

    @FXML
    protected TextField tokenTextField;

    @FXML
    protected void setGameToken(MouseEvent event) throws IOException {
        String token = tokenTextField.getText().toUpperCase(Locale.ROOT);
        System.out.println(token.length());
        if (token.length() == 6) {
            gsc.joinGame(token);

            Parent root = FXMLLoader.load(getClass().getResource("/ttr/fxml/game_start.fxml"));

            this.stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            this.scene = new Scene(root, 1000, 800);
            stage.setScene(scene);
            stage.show();
        }

    }

    @FXML
    protected void playerSelect() {
        gsc.playerSelect(group);
    }

    @FXML
    protected void playerNameSubmit() {
        gsc.playerNameSubmit(nameField);
    }




    @Override
    public void update(DocumentSnapshot ds) {

    }

    private Stage stage;
    private Scene scene;

    @FXML
    protected void startGame(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/ttr/fxml/game_interface.fxml"));

        this.stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        this.scene = new Scene(root, 1000, 800);
        stage.setScene(scene);
        stage.show();
    }
}