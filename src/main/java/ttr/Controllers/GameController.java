package ttr.Controllers;

import javafx.scene.control.*;
import ttr.Config.Database;
import ttr.Services.FirestoreService;
import com.google.cloud.firestore.Firestore;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

import java.util.HashMap;
import java.util.Map;

public class GameController {

    String id = "ABCDEG";
    int localPlayer;

    FirestoreService fs = new FirestoreService();

    Map playerData = new HashMap<String, String>();

    @FXML
    private VBox list;

    @FXML
    public Button playerSelect;
    @FXML
    public Button playerSubmit;
    @FXML
    private Label welcomeText;
    @FXML
    private TextField nameField;
    @FXML
    private ToggleGroup group;


    @FXML
    protected void playerSelect() {
        RadioButton groupSelected = (RadioButton) group.getSelectedToggle();
        welcomeText.setText("You are " + groupSelected.getText());
        list.getChildren().remove(playerSelect);

        localPlayer = 1;

        Database change = new Database();
        Firestore db = change.getDb();

        list.getChildren().remove(group.getSelectedToggle());
    }


    @FXML
    protected void playerNameSubmit() {
        RadioButton groupSelected = (RadioButton) group.getSelectedToggle();
        welcomeText.setText("Name submitted!");
        list.getChildren().remove(playerSubmit);

        localPlayer = 2;

        Database change = new Database();
        Firestore db = change.getDb();

        db.collection("games").document(id).update("Players", playerData(groupSelected.getId(), nameField.getText()));

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