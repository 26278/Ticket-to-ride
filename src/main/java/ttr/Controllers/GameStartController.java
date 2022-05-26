package ttr.Controllers;

import com.google.cloud.firestore.DocumentSnapshot;
import javafx.scene.control.*;
import ttr.Config.Database;
import ttr.Constants.ClientConstants;
import ttr.Model.FirebaseModel;
import ttr.Model.PlayerModel;
import ttr.Services.FirestoreService;
import com.google.cloud.firestore.Firestore;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GameStartController implements Controller {
    PlayerModel player = new PlayerModel();
    FirebaseModel fbm = new FirebaseModel();


    public void playerSelect(ToggleGroup group) {
        player.setPlayerColor(getSelectedPlayer(group));
    }

    public void playerNameSubmit(TextField nameField) {
        player.setPlayerName(nameField.getText());
    }

    private String getSelectedPlayer(ToggleGroup group) {
        RadioButton groupSelected = (RadioButton) group.getSelectedToggle();

        return groupSelected.getText();

    }

    public void startGame() {
        //change fxml file if following conditions are met: min 3 players with name, player starting is player 1 (red)
        if (Objects.equals(player.getPlayerColor(), "red")) {
            //load file
        }
    }

    @Override
    public void update(DocumentSnapshot ds) {

    }

    //move to gameController
    int currentPlayer = 1;

    public void endTurn() {
        currentPlayer += 1;

        if (currentPlayer == 6) {
            currentPlayer = 1;
        }

        fbm.setCurrentPlayer(currentPlayer);
    }
}