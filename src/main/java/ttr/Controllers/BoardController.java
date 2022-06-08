package ttr.Controllers;

import ttr.Model.FirebaseModel;
import ttr.Model.PlayerModel;
import ttr.Model.TrainCardDeckModel;


public class BoardController {
    FirebaseModel fbm = new FirebaseModel();
    TrainCardDeckModel tcdm = new TrainCardDeckModel();
    PlayerModel pm = new PlayerModel();

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
