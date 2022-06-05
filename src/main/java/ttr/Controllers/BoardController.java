package ttr.Controllers;


import com.google.cloud.firestore.DocumentSnapshot;
import ttr.Constants.ClientConstants;
import ttr.Model.FirebaseModel;
import ttr.Services.FirestoreService;
import ttr.Views.PlayerObserver;

import java.util.Map;

public class BoardController implements Controller {
    FirebaseModel fbm = new FirebaseModel();
    FirestoreService fs = new FirestoreService();
    ClientConstants cc = new ClientConstants();
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


    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void updatePlayerCount(Map playerMap) {
        playerCount = playerMap.size();
    }

    public void endTurn() {

        currentPlayer += 1;

        if (currentPlayer == (playerCount + 2)) {
            currentPlayer = 1;
        }

        fbm.setCurrentPlayer(currentPlayer);
    }

    public void update(DocumentSnapshot ds) {
        setCurrentPlayer((Integer) ds.get("current_player"));
        updatePlayerCount((Map) ds.get("players"));
    }
}
