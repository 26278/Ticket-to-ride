package ttr.Views;

import com.google.cloud.firestore.DocumentSnapshot;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ttr.Controllers.Controller;
import ttr.Controllers.GameStartController;
import ttr.Model.GameStartModel;

import java.io.IOException;
import java.util.*;

public class GameStartView implements GameStartObserver {

    @FXML
    public VBox list;
    GameStartController gsc;

    @FXML
    protected ToggleGroup group;

    @FXML
    protected TextField nameField;

    @FXML
    protected Label playerCountLabel;

    @FXML
    protected Button nameSubmit;

    @FXML
    protected Button selectPlayer;

    @FXML
    protected RadioButton player_1;
    @FXML
    protected RadioButton player_2;
    @FXML
    protected RadioButton player_3;
    @FXML
    protected RadioButton player_4;
    @FXML
    protected RadioButton player_5;

    private ArrayList<RadioButton> playerButtons = new ArrayList<>();

    @FXML
    protected void initialize(){
        this.gsc = GameStartController.getInstance();
        this.gsc.addGameStartObserver(this);
        this.gsc.firstPlayerCheck();
        nameField.setVisible(false);
        nameSubmit.setVisible(false);
        Collections.addAll(playerButtons, player_1, player_2, player_3, player_4, player_5);
    }

    @FXML
    protected void playerSelect() {
        if (group.getSelectedToggle() != null) {
            gsc.playerSelect(group);
            nameField.setVisible(true);
            nameSubmit.setVisible(true);
            selectPlayer.setVisible(false);
            for (int i = 0; i < playerButtons.size(); i++) {
                playerButtons.get(i).setVisible(false);
            }
        }
    }

    @FXML
    protected void playerNameSubmit() {
        gsc.playerNameSubmit(nameField);
    }

    private void showPlayerCount(int playerCount) {
        Platform.runLater(() -> {
            playerCountLabel.setText("Current Players: " + playerCount);
        });
    }

    private void hideSelectedPlayers(Map playerMap) {
        for (int i = 0; i < playerButtons.size(); i++) {
            if (playerMap.get(playerButtons.get(i).getId()) != null) {
                playerButtons.get(i).setVisible(false);
            }
        }
    }

    @FXML
    protected void startGame(MouseEvent event) throws IOException {
        gsc.startGame(event);
    }

    @Override
    public void update(GameStartModel gameStartModel) {
        showPlayerCount(gameStartModel.getPlayerCount().size());
        hideSelectedPlayers(gameStartModel.getPlayerCount());
    }
}