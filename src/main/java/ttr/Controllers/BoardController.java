package ttr.Controllers;


import com.google.cloud.firestore.DocumentSnapshot;
import ttr.Constants.ClientConstants;
import ttr.Model.FirebaseModel;
import ttr.Model.PlayerModel;
import ttr.Services.FirestoreService;
import ttr.Views.PlayerObserver;

import java.util.Map;

public class BoardController implements Controller {
    FirebaseModel fbm = new FirebaseModel();
    FirestoreService fs = new FirestoreService();
    ClientConstants cc = new ClientConstants();
    PlayerModel player;
    private static BoardController boardController;

    private int currentPlayer;
    private int playerCount;

    private BoardController() {
        updatePlayerCount((Map) fs.get(cc.getID()).get("players"));
    }

    public static BoardController getInstance() {
        if (boardController == null) {
            boardController = new BoardController();
        }
        return boardController;
    }


    public void place_train_or_station() {

    }

    public void setPlayer(PlayerModel player) {
        this.player = player;
        checkPlayerTurn();
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void updatePlayerCount(Map playerMap) {
        playerCount = playerMap.size();
    }

    public void endTurn() {

        currentPlayer += 1;

        if (currentPlayer == (playerCount + 1)) {
            currentPlayer = 1;
        }

        fbm.setCurrentPlayer(currentPlayer);
        checkPlayerTurn();
    }

    public void checkPlayerTurn() {
        if (this.player.getPlayerNumber() == currentPlayer) {
            this.player.setPlayerTurn(true);
        }
        if (this.player.getPlayerNumber() != currentPlayer) {
            this.player.setPlayerTurn(false);
        }
    }

    public void pullCards(){
        this.player.pullCard();
    }



    public void registerPlayerObserver(PlayerObserver boardView) {
        this.player.addObserver(boardView);
    }

    public void update(DocumentSnapshot ds) {
        updatePlayerCount((Map) ds.get("players"));
        setCurrentPlayer((Integer) ds.get("current_player"));
        checkPlayerTurn();
    }
}
