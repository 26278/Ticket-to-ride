package ttr.Controllers;


import com.google.cloud.firestore.DocumentSnapshot;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import ttr.Constants.ClientConstants;
import ttr.Constants.Locations;
import ttr.Model.*;
import ttr.Services.FirestoreService;
import ttr.Views.FirebaseObserver;
import ttr.Views.OpenCardObserver;
import ttr.Views.PlayerObserver;
import ttr.Views.TrainObserver;

import java.util.*;

import static ttr.Constants.ClientConstants.TRAIN;

public class BoardController implements Controller {
    SelectOpenCardModel som = new SelectOpenCardModel();
    TrainModel tm = new TrainModel();
    FirebaseModel fbm = new FirebaseModel();
    FirestoreService fs = new FirestoreService();
    ClientConstants cc = new ClientConstants();
    FirebaseModel fm = new FirebaseModel();
    PlayerModel player;
    private static BoardController boardController;

    private int currentPlayer;
    private int playerCount;
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


    public void setCurrentPlayer(DocumentSnapshot ds) {
        String value = ds.get("current_player").toString();
        this.currentPlayer = Integer.parseInt(value);
    }


    public void checkPlayerTurn() {
        if (this.player.getPlayerNumber() == currentPlayer) {
            this.player.setPlayerTurn(true);
        }
        if (this.player.getPlayerNumber() != currentPlayer) {
            this.player.setPlayerTurn(false);
        }
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

            while (true) {
                if (!players.contains(currentPlayer)) {
                    currentPlayer += 1;
                } else {
                    break;
                }
            }

            fbm.setCurrentPlayer(currentPlayer);
        }
    }


    public void pullCards() {
        this.player.pullCard();
    }

    public ArrayList<Locations> getRoute(String id) {
        String[] routes = id.split("_");
        ArrayList<Locations> locations = new ArrayList<>();
        for (Locations loc : Locations.values()) {
            if (routes[0].toLowerCase(Locale.ROOT).equals(loc.toString().toLowerCase(Locale.ROOT))) {
                locations.add(loc);
            }
            if (routes[1].toLowerCase(Locale.ROOT).equals(loc.toString().toLowerCase(Locale.ROOT))) {
                locations.add(loc);
            }
        }
        return locations;
    }

    public void placeTrain(String id, int size) {
        ArrayList<Locations> routes = getRoute(id);
        RouteModel route = new RouteModel(routes.get(0), routes.get(1), size);
        this.player.getCm().addRoute(route);
        this.player.awardPoints(size);
        this.fs.updateTrainOrStation(id, TRAIN, this.player.getPlayerColor());
        this.player.reduceTrainCount(size);
    }

    public void checkCurrentPlayerName(HashMap<String, String> players) {
        for (Map.Entry<String, String> entry : players.entrySet()) {
            if (Objects.equals(entry.getKey(), "player_" + currentPlayer)) {
                String playerName = entry.getValue();
                fm.setCurrentPlayerName(playerName);
            }
        }
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

    public void register_open_card_observer(OpenCardObserver boardview) {
        this.som.addObserver(boardview);
    }

    public void registerFirebaseObserver(FirebaseObserver boardview) {
        this.fm.addObserver(boardview);
    }

    public void update(DocumentSnapshot ds) {
        updatePlayerList((Map) ds.get("players"));
        checkBoardState();
        checkCurrentPlayerName((HashMap<String, String>) ds.get("players"));
        setCurrentPlayer(ds);
        checkPlayerTurn();
    }
}


