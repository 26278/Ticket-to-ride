package ttr.Model;

/*todo
PLAYERHAND = PlayerHand
RoutesOwned = Arraylist van Routes
*/


import com.google.cloud.firestore.DocumentSnapshot;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import ttr.Controllers.BoardController;
import ttr.Services.FirestoreService;
import ttr.Shared.PlayerObservable;
import ttr.Views.BoardView;
import ttr.Views.PlayerObserver;

import java.util.ArrayList;
import java.util.List;

public class PlayerModel implements PlayerObservable {
    private FirestoreService fs = new FirestoreService();
    private ConnectionModel cm = new ConnectionModel();
    private String playerColor;
    private int playerNumber;
    private String playerName;
    private int score;
    private int trainCount = 45;
    private int stationCount = 3;


    private ArrayList<TrainCardModel> playerHand;
    private TrainCardDeckModel trainCardDeck;
    private boolean playerTurn;

    private List<PlayerObserver> observers = new ArrayList<PlayerObserver>();


    public PlayerModel() {
        trainCardDeck = new TrainCardDeckModel();
        playerHand = new ArrayList<TrainCardModel>();
    }

    public void awardPoints(int trainAmount) {
        if (trainAmount == 1) {
            this.score += 1;
        } else if (trainAmount == 2) {
            this.score += 2;
        } else if (trainAmount == 3) {
            this.score += 4;
        } else if (trainAmount == 4) {
            this.score += 7;
        } else if (trainAmount == 6) {
            this.score += 15;
        } else if (trainAmount == 8) {
            this.score += 21;
        }
        notifyObservers();
    }


    public ConnectionModel getCm() {
        return cm;
    }

    public void pullCard() {
        ArrayList<TrainCardModel> hulpList = trainCardDeck.pullCards();
        playerHand.addAll(hulpList);
        notifyObservers();
    }

    public void reduceTrainCount(int trainAmount) {
        trainCount = trainCount - trainAmount;
        notifyObservers();
    }

    public ArrayList<TrainCardModel> getTrainCardDeck() {
        return trainCardDeck.getTrainCardDeck();
    }

    public int getDeckSize() {
        return trainCardDeck.getDeckCount();
    }

    public int getTrainCount() {
        return trainCount;
    }

    public int getStationCount() {
        return stationCount;
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
        for (PlayerObserver observer : this.observers) {
            observer.update(this);
        }

    }

    @Override
    public void addObserver(PlayerObserver observer) {
        this.observers.add(observer);
        this.notifyObservers();
    }

    @Override
    public void removeObserver(PlayerObserver observer) {

    }
}
