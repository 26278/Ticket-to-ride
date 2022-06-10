package ttr.Controllers;


import com.google.cloud.firestore.DocumentSnapshot;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import ttr.Constants.ClientConstants;
import ttr.Model.FirebaseModel;
import ttr.Model.PlayerModel;
import ttr.Model.TrainModel;
import ttr.Model.SelectOpenCardModel;
import ttr.Services.FirestoreService;
import ttr.Views.OpenCardObserver;
import ttr.Views.PlayerObserver;
import ttr.Views.TrainObserver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static ttr.Constants.ClientConstants.TRAIN;

public class BoardController implements Controller {
    SelectOpenCardModel som = new SelectOpenCardModel();
    TrainModel tm = new TrainModel();
    FirebaseModel fbm = new FirebaseModel();
    FirestoreService fs = new FirestoreService();
    ClientConstants cc = new ClientConstants();
    PlayerModel player;
    private static BoardController boardController;

    private int currentPlayer;
    private int playerCount;
    private Stage stage;
    private Scene scene;

    private BoardController() {
        updatePlayerCount((Map) fs.get(cc.getID()).get("players"));
    }


    public static BoardController getInstance() {
        if (boardController == null) {
            boardController = new BoardController();
        }
        return boardController;
    }


    public boolean place_train_or_station(MouseEvent event) throws IOException {
        // player model -> notifyObserver die selectTrainCardView, update je hand
        Parent root = FXMLLoader.load(getClass().getResource("/ttr/fxml/selectCardsScreen.fxml"));
        this.stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        this.scene = new Scene(root, cc.getScreenX(), cc.getScreenY());
//        scene.getStylesheets().add(
//                Objects.requireNonNull(getClass().getResource("/ttr/stylesheets/chooseCards.css"))
//                        .toExternalForm());
        stage.setScene(scene);
        stage.show();
//        RequirementModel requirement = new RequirementModel(trainCardColor, trainCardCount, isTunnelBoolean);

//        functie dat player heeft betaald schrijven
        
        return true;
    }

    public void setPlayer(PlayerModel player) {
        this.player = player;
        checkPlayerTurn();
    }

    public void Put_in_hand_and_replace() {


    }

    public void click_card(MouseEvent event) {
        ImageView image = (ImageView) event.getSource();
        String id = image.getId();
        som.Put_in_hand_and_replace(id, player.getTrainCardDeck(), player.getPlayerHand());
    }

    public void setopencards() {
        ArrayList<String> col = new ArrayList<>();
        while (col.size() != 5) {
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

    public void pullCards() {
        this.player.pullCard();
    }

    public void placeTrain(String id, int size) {
        this.fs.updateTrainOrStation(id, TRAIN, this.player.getPlayerColor());
        this.player.reduceTrainCount(size);
    }

    public void checkBoardState() {
        HashMap<Object, HashMap> boardState = fs.getBoardState();

        for (Map.Entry<Object, HashMap> entry : boardState.entrySet()) {
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

    public void registerTrainObserver(TrainObserver boardView) {
        this.tm.addObserver(boardView);
    }

    public void update(DocumentSnapshot ds) {
        checkBoardState();
        updatePlayerCount((Map) ds.get("players"));
        setCurrentPlayer((Integer) ds.get("current_player"));
        checkPlayerTurn();
    }

    public void register_open_card_observer(OpenCardObserver boardview) {
        this.som.addObserver(boardview);
    }
}
