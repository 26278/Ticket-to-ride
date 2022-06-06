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
