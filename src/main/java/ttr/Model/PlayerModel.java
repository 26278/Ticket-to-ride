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

    private boolean playerTurn;
    //PLAYERHAND
    //RoutesOwned


    public String getPlayerColor(){
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
