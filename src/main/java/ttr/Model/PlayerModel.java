package ttr.Model;

/*todo
PLAYERHAND = PlayerHand
RoutesOwned = Arraylist van Routes
*/


import com.google.cloud.firestore.DocumentSnapshot;
import ttr.Controllers.BoardController;
import ttr.Services.FirestoreService;
import ttr.Shared.PlayerObservable;
import ttr.Views.PlayerObserver;

import java.util.ArrayList;
import java.util.List;

public class PlayerModel implements PlayerObservable {
    private FirestoreService fs = new FirestoreService();

    private String playerColor;
    private int playerNumber;
    private String playerName;
    private int score;
    private int trainCount = 45;
    private int stationCount = 45;
    private ArrayList<TrainCardModel> playerHand;
    private TrainCardDeckModel trainCardDeck;
    private boolean playerTurn;

    private List<PlayerObserver> observers = new ArrayList<PlayerObserver>();


    public PlayerModel() {
        trainCardDeck = new TrainCardDeckModel();
        playerHand = new ArrayList<TrainCardModel>();
    }



    public void pullCard() {
        ArrayList<TrainCardModel> hulpList = trainCardDeck.pullCards();
        playerHand.addAll(hulpList);
        notifyObservers();
    }


    public ArrayList<TrainCardModel> getPlayerHand() {
        return playerHand;
    }

    public String getPlayerColor() {
        return playerColor;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public void setPlayerColor(String playerColor) {
        this.playerColor = playerColor;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
        fs.updateField("players", ("player_" + this.playerNumber), playerName);
    }

    public boolean isPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(boolean playerTurn) {
        this.playerTurn = playerTurn;
    }

    public void hasCurrentTurn(DocumentSnapshot ds) {
        int current_Player = (int) ds.get("current_player");
        if (current_Player == playerNumber) {
            setPlayerTurn(true);
        } else {
            setPlayerTurn(false);
        }
    }

    private int getScore() {
        return score;
    }

    @Override
    public void notifyObservers() {
        for (PlayerObserver observer: this.observers){
            observer.update(this);
        }

    }

    @Override
    public void addObserver(PlayerObserver observer) {

    }

    @Override
    public void removeObserver(PlayerObserver observer) {

    }
}
