package ttr.Controllers;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import ttr.Model.*;
import ttr.Views.OpenCardObserver;

import java.util.ArrayList;


public class BoardController {
    SelectOpenCardModel som = new SelectOpenCardModel();
    FirebaseModel fbm = new FirebaseModel();
    TrainCardDeckModel tcdm = new TrainCardDeckModel();
    PlayerModel pm = new PlayerModel();
    private static BoardController boardController;

    //move to gameController
    int currentPlayer = 1;

    public static BoardController getInstance() {
        if (boardController == null) {
            boardController = new BoardController();
        }
        return boardController;
    }


    public void place_train_or_station() {

    }

    public void Put_in_hand_and_replace() {


    }
    public void click_card(MouseEvent event){
        ImageView image = (ImageView) event.getSource();
        String id = image.getId();
        som.Put_in_hand_and_replace(id, tcdm.getTrainCardDeck(), pm.getPlayerHand());
    }
    public void setopencards(){
        ArrayList<String> col = new ArrayList<>();
        while (col.size() != 5){
            col.add(tcdm.getTrainCardDeck().get(0).getCardColor());
            tcdm.getTrainCardDeck().remove(0);

        }
        som.setOpen_cards(col);

    }



    public void endTurn() {
        currentPlayer += 1;

        if (currentPlayer == 6) {
            currentPlayer = 1;
        }

        fbm.setCurrentPlayer(currentPlayer);
    }

    public void register_open_card_observer(OpenCardObserver boardview){
        this.som.addObserver(boardview);

    }
}
