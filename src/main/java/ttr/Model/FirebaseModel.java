package ttr.Model;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import ttr.Config.Database;
import ttr.Constants.ClientConstants;
import ttr.Shared.FirebaseObservable;
import ttr.Views.FirebaseObserver;
import ttr.Views.PlayerObserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirebaseModel implements FirebaseObservable {
    ClientConstants cc = new ClientConstants();

    Database change = new Database();
    Firestore db = change.getDb();
    DocumentReference docRef = db.collection("games").document(cc.getID());

    private List<FirebaseObserver> observers = new ArrayList<>();

    private String currentPlayerName;

    private boolean final_turn = true;
    private boolean gameFinished = false;

    //change current player in firebase
    public void setCurrentPlayer(int nextPlayer) {
        docRef.update("current_player", nextPlayer);
    }

    public void setCurrentPlayerName(String currentPlayerName) {
        this.currentPlayerName = currentPlayerName;
        notifyObservers();
    }

    public String getCurrentPlayerName() {
        return currentPlayerName;
    }

    public boolean isFinal_turn() {
        return final_turn;
    }

    public boolean isGameFinished() {
        return gameFinished;
    }

    public void setFinal_turn(boolean final_turn) {
        this.final_turn = final_turn;
        notifyObservers();
    }

    public void setGameFinished(boolean gameFinished) {
        this.gameFinished = gameFinished;
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for (FirebaseObserver observer : this.observers) {
            observer.update(this);
        }
    }

    @Override
    public void addObserver(FirebaseObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(FirebaseObserver observer) {
    }
}
