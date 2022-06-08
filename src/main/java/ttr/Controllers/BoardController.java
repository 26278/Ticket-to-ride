package ttr.Controllers;


import com.google.cloud.firestore.DocumentSnapshot;
import ttr.Constants.ClientConstants;
import ttr.Model.FirebaseModel;
import ttr.Model.PlayerModel;
import ttr.Services.FirestoreService;
import ttr.Views.PlayerObserver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class BoardController implements Controller {
    FirebaseModel fbm = new FirebaseModel();
    FirestoreService fs = new FirestoreService();
    ClientConstants cc = new ClientConstants();
    PlayerModel player;
    private static BoardController boardController;

    private int currentPlayer;
    private ArrayList<Integer> players;

    private BoardController() {
        updatePlayerList((Map) fs.get(cc.getID()).get("players"));
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

    public void setCurrentPlayer(DocumentSnapshot ds) {
        String value = ds.get("current_player").toString();
        this.currentPlayer = Integer.parseInt(value);
    }

    public void updatePlayerList(Map playerMap) {
        players = new ArrayList<>();
        List<String> playerList = new ArrayList<>(playerMap.keySet());
        for (int i = 0; i < playerMap.size(); i++) {
            String[] numString = playerList.get(i).split("_");
            players.add(Integer.parseInt(numString[1]));
        }

    }

    public void endTurn() {
        if (this.player.isPlayerTurn()) {
            currentPlayer += 1;

            if (currentPlayer == Collections.max(players) + 1) {
                currentPlayer = 1;
            }

            if (!players.contains(currentPlayer)) {
               currentPlayer += 1;
           }

            fbm.setCurrentPlayer(currentPlayer);
        }
    }

    public void checkPlayerTurn() {
        if (this.player.getPlayerNumber() == currentPlayer) {
            this.player.setPlayerTurn(true);
        }
        if (this.player.getPlayerNumber() != currentPlayer) {
            this.player.setPlayerTurn(false);
        }

    }


    public void registerPlayerObserver(PlayerObserver boardView) {
        this.player.addObserver(boardView);
    }

    public void update(DocumentSnapshot ds) {
        updatePlayerList((Map) ds.get("players"));
        setCurrentPlayer(ds);
        checkPlayerTurn();
    }
}
