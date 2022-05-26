package ttr.Model;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import ttr.Config.Database;
import ttr.Constants.ClientConstants;

import java.util.HashMap;
import java.util.Map;

public class FirebaseModel implements Observable{
    ClientConstants cc = new ClientConstants();

    Database change = new Database();
    Firestore db = change.getDb();
    DocumentReference docRef = db.collection("games").document(cc.getID());
    Map<String, String> playerData = new HashMap<String, String>();


    //add players on selection with name and color
    public void setNewPlayerData(String map, String mapKey, String mapValue) {
        docRef.update(map, playerMapData(mapKey, mapValue));
    }

    private Map<String, String> playerMapData(String key, String value) {
        playerData.put(key, value);
        return playerData;
    }

    //change current player in firebase
    public void setCurrentPlayer(int nextPlayer) {
        docRef.update("current_player", nextPlayer);
    }

    @Override
    public void notifyObservers() {
    }

    @Override
    public void addObserver() {
    }

    @Override
    public void removeObserver() {
    }
}
