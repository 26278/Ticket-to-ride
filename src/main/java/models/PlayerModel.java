package models;

/*todo
PLAYERHAND = PlayerHand
RoutesOwned = Arraylist van Routes
*/


import java.util.ArrayList;

public class PlayerModel implements Observable{
    public static ArrayList<String> playerHand = new ArrayList<>();
    private String playerColor;
    private String playerName;
    private int score;
    private int trainCount = 45;
    private int stationCount = 45;
    //PLAYERHAND
    //RoutesOwned
    private boolean playerTurn;

    private String getPlayerColor(){
        return playerColor;
    }


    private void isPlayerTurn(){

    }

    private int getScore(){
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
