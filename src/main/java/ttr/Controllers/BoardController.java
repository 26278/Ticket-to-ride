package ttr.Controllers;


import com.google.cloud.firestore.DocumentSnapshot;
import javafx.scene.shape.Rectangle;
import ttr.Constants.ClientConstants;
import ttr.Model.FirebaseModel;
import ttr.Model.PlayerModel;
import ttr.Model.TrainModel;
import ttr.Services.FirestoreService;
import ttr.Views.PlayerObserver;
import ttr.Views.TrainObserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ttr.Constants.ClientConstants.TRAIN;

public class BoardController implements Controller {
    TrainModel tm = new TrainModel();
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

    public void placeTrain(String id){
        this.tm.placeTrain(id, this.player.getPlayerColor());
        this.fs.updateTrainOrStation(id, TRAIN, this.player.getPlayerColor());
    }

    public void checkBoardState(){
        HashMap<Object, HashMap> boardState = fs.getBoardState();

        for(Map.Entry<Object, HashMap> entry: boardState.entrySet()) {
            String key = (String) entry.getKey();
            HashMap map = entry.getValue();

            if (map.get(TRAIN) != null) {
                this.tm.placeTrain(key, map.get(TRAIN).toString());
            }
        }
    }

    public void registerPlayerObserver(PlayerObserver boardView) {
        this.player.addObserver(boardView);
    }
    public void registerTrainObserver(TrainObserver boardView){
        this.tm.addObserver(boardView);
    }

    public void update(DocumentSnapshot ds) {
        checkBoardState();
        updatePlayerCount((Map) ds.get("players"));
        setCurrentPlayer((Integer) ds.get("current_player"));
        checkPlayerTurn();
    }
}
