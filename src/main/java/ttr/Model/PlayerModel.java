package ttr.Model;

/*todo
PLAYERHAND = PlayerHand
RoutesOwned = Arraylist van Routes
*/


import java.lang.reflect.Array;
import java.util.ArrayList;

public class PlayerModel implements Observable {
    private String playerColor;
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

    private String getPlayerColor() {
        return playerColor;
    }


    private void isPlayerTurn() {

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
