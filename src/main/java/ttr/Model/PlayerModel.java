package ttr.Model;

/*todo
PLAYERHAND = PlayerHand
RoutesOwned = Arraylist van Routes
*/


public class PlayerModel implements Observable{
    private String playerColor;
    private String playerName;
    private int score;
    private int trainCount = 45;
    private int stationCount = 45;
    private PlayerHandModel playerHand;

    //RoutesOwned
    private boolean playerTurn;

    public void pullCard(TrainCardModel trainCard){

        notifyObservers();
    }

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
