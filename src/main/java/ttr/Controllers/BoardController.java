package ttr.Controllers;


import ttr.Model.FirebaseModel;

public class BoardController {
    FirebaseModel fbm = new FirebaseModel();

    //move to gameController
    int currentPlayer = 1;


    public void place_train_or_station() {

    }


    public void endTurn() {
        currentPlayer += 1;

        if (currentPlayer == 6) {
            currentPlayer = 1;
        }

        fbm.setCurrentPlayer(currentPlayer);
    }
}
