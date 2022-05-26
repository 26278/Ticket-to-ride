package ttr.Views;

import com.google.cloud.firestore.DocumentSnapshot;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import ttr.Controllers.Controller;
import ttr.Controllers.GameStartController;

public class GameStartView implements Controller {

    GameStartController gsc = new GameStartController();

    @FXML
    protected ToggleGroup group;

    @FXML
    protected TextField nameField;

    @FXML
    protected void playerSelect() {
        gsc.playerSelect(group);
    }

    @FXML
    protected void playerNameSubmit() {
        gsc.playerNameSubmit(nameField);
    }

    @FXML
    protected void startGame() {
        gsc.startGame();
    }

    @FXML
    protected void endTurn() {
        gsc.endTurn();
    }


    @Override
    public void update(DocumentSnapshot ds) {

    }
}