package com.example.iipsene_ttr.Controllers;

import com.example.iipsene_ttr.App;
import com.example.iipsene_ttr.Config.Database;
import com.example.iipsene_ttr.Services.FirestoreService;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.Date;
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
    protected void playerSelect1() {
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
    protected void playerSelect2() {
        welcomeText.setText("You are player 2");
        list.getChildren().remove(p1b);
        list.getChildren().remove(p2b);

        localPlayer = 2;

        Database change = new Database();
        Firestore db = change.getDb();

        db.collection("games").document(id).update("Players", playerData("player_2", "pete"));

        list.getChildren().add(p1b);
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