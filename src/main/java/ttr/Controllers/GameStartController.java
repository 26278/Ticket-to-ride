package ttr.Controllers;

import com.google.cloud.firestore.DocumentSnapshot;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import ttr.Constants.ClientConstants;
import ttr.Model.GameStartModel;
import ttr.Model.PlayerModel;
import ttr.Services.FirestoreService;
import ttr.Views.GameStartObserver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GameStartController implements Controller {
    private PlayerModel player = new PlayerModel();
    private GameStartModel gsm = new GameStartModel();
    private ClientConstants cc = new ClientConstants();
    private FirestoreService fs = new FirestoreService();
    public static GameStartController gsc;

    private Stage stage;
    private Scene scene;

    public static GameStartController getInstance(){
        if (gsc == null){
            gsc = new GameStartController();
        }
        return gsc;
    }

    private Map playerMap() {
        return (HashMap) fs.get(cc.getID()).get("players");
    }

    public void firstPlayerCheck() {
        Map playerMap = playerMap();
        if (playerMap.size() == 0) {
            player.setPlayerColor("red");
            player.setPlayerNumber(1);
            player.setPlayerName("host");
        }
    }

    public void playerSelect(ToggleGroup group) {
        player.setPlayerColor(getSelectedPlayerName(group));
        player.setPlayerNumber(getSelectedPlayerNumber(group));
    }

    public void playerNameSubmit(TextField nameField) {
        player.setPlayerName(nameField.getText());
    }

    private String getSelectedPlayerName(ToggleGroup group) {
        RadioButton groupSelected = (RadioButton) group.getSelectedToggle();
        return groupSelected.getText();
    }

    private int getSelectedPlayerNumber(ToggleGroup group) {
        RadioButton groupSelected = (RadioButton) group.getSelectedToggle();
        String[] parts = groupSelected.getId().split("_");
        return Integer.parseInt(parts[1]);
    }



    public void startGame(MouseEvent event) throws IOException {
        //change fxml file if following conditions are met: min 3 players with name, player starting is player 1 (red)
        Map playerMap = playerMap();
        int playerCount = playerMap.size();

        if (player.getPlayerColor() == null) {
            return;
        }
        if (player.getPlayerColor().equals("red") && playerCount >= 3) {
            //load file
            loadFile(event, "game_interface.fxml");
        }
    }


    public void loadFile(MouseEvent event, String file) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/ttr/fxml/" + file));

        this.stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        this.scene = new Scene(root, 1000, 800);
        stage.setScene(scene);
        stage.show();
    }

    public void addGameStartObserver(GameStartObserver gameStartView) {
        this.gsm.addObserver(gameStartView);
    }

    @Override
    public void update(DocumentSnapshot ds) {
        gsm.setPlayerCount((Map) ds.get("players"));

    }


}