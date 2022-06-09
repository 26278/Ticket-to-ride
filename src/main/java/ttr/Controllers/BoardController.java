package ttr.Controllers;


import com.google.cloud.firestore.DocumentSnapshot;
import javafx.scene.input.MouseEvent;
import ttr.Constants.ClientConstants;
import ttr.Controllers.Controller;
import ttr.Model.FirebaseModel;
import ttr.Model.PlayerModel;
import ttr.Model.SelectOpenCardModel;
import ttr.Services.FirestoreService;
import ttr.Views.OpenCardObserver;
import ttr.Views.PlayerObserver;

import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

public class BoardController implements Controller {
    SelectOpenCardModel som = new SelectOpenCardModel();
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

    public void Put_in_hand_and_replace() {


    }
    public void click_card(MouseEvent event){
        ImageView image = (ImageView) event.getSource();
        String id = image.getId();
        som.Put_in_hand_and_replace(id, player.getTrainCardDeck(), player.getPlayerHand());
    }

    public void setopencards(){
        ArrayList<String> col = new ArrayList<>();
        while (col.size() != 5){
            col.add(player.getTrainCardDeck().get(0).getCardColor());
            player.getTrainCardDeck().remove(0);

        }
        som.setOpen_cards(col);
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

    public void register_open_card_observer(OpenCardObserver boardview){
        this.som.addObserver(boardview);
    }
}
