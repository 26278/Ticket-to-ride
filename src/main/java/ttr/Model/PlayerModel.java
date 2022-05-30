package ttr.Model;

/*todo
PLAYERHAND = PlayerHand
RoutesOwned = Arraylist van Routes
*/


import com.google.cloud.firestore.DocumentSnapshot;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class PlayerModel implements Observable {
    private String playerColor;
    private int playerNumber;
    private String playerName;
    private int score;
    private int trainCount = 45;
    private int stationCount = 45;
    //    private PlayerHandModel playerHand;
    private ArrayList<TrainCardModel> playerHand;
    private TrainCardDeckModel trainCardDeck;
    //RoutesOwned
    private boolean playerTurn;

    public PlayerModel() {
        trainCardDeck = new TrainCardDeckModel();
        playerHand = new ArrayList<TrainCardModel>();
    }

    public void pullCard() {
        ArrayList<TrainCardModel> hulpList = trainCardDeck.pullCards();
        playerHand.addAll(hulpList);
        notifyObservers();
    }

    public void pullCardTester(int Choice) {
        ArrayList<TrainCardModel> hulpList = trainCardDeck.pullCardsTester(Choice);
        playerHand.addAll(hulpList);
        notifyObservers();
    }


    public ArrayList<TrainCardModel> getPlayerHand() {
        return playerHand;
    }

    public String getPlayerColor() {
        return playerColor;
    }

    public void setPlayerColor(String playerColor) {
        this.playerColor = playerColor;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
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
        }
        else {
            setPlayerTurn(false);
        }
    }

    private int getScore() {
        return score;
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
