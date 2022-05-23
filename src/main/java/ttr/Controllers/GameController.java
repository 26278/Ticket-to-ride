package ttr.Controllers;

import javafx.scene.control.TextField;
import ttr.Config.Database;
import ttr.Services.FirestoreService;
import com.google.cloud.firestore.Firestore;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.HashMap;
import java.util.Map;

public class GameController {

    String id = "ABCDEF";
    int localPlayer;

    FirestoreService fs = new FirestoreService();

    Map playerData = new HashMap<String, String>();

    @FXML
    private VBox list;

    @FXML
    public Button p1b;
    @FXML
    public Button p2b;
    @FXML
    private Label welcomeText;
    @FXML
    private TextField nameField;


    @FXML
    protected void playerSelect() {
        welcomeText.setText("You are player 1");
        list.getChildren().remove(p1b);
        list.getChildren().remove(p2b);

        localPlayer = 1;

        Database change = new Database();
        Firestore db = change.getDb();

        db.collection("games").document(id).update("Players", playerData("player_1", "bob"));

        list.getChildren().add(p2b);
    }

    @FXML
    protected void playerNameSubmit() {
        welcomeText.setText("Name submitted!");
        list.getChildren().remove(p1b);
        list.getChildren().remove(p2b);

        localPlayer = 2;

        Database change = new Database();
        Firestore db = change.getDb();

        db.collection("games").document(id).update("Players", playerData("player_2", nameField.getText()));

    }

    private Map playerData(String player, String name) {
        playerData.put(player, name);

        return playerData;
    }

    @FXML
    protected void deleteAndExit() {
        fs.delete(this.id);

    }
}