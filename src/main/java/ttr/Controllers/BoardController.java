package ttr.Controllers;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import ttr.Model.FirebaseModel;
import ttr.Model.TrainCardDeckModel;

import java.util.ArrayList;
import java.util.HashMap;

public class BoardController {
    FirebaseModel fbm = new FirebaseModel();
    TrainCardDeckModel tcdm = new TrainCardDeckModel();
    HashMap<ImageView, String> Open_cards = new HashMap<>();
    ArrayList<String> taken_card = new ArrayList<>();
    ArrayList<String> decktest = new ArrayList<>();
    //move to gameController
    int currentPlayer = 1;


    public void place_train_or_station() {

    }

    public void Put_in_hand_and_replace() {

    }







    public void endTurn() {
        currentPlayer += 1;

        if (currentPlayer == 6) {
            currentPlayer = 1;
        }

        fbm.setCurrentPlayer(currentPlayer);
    }
}
