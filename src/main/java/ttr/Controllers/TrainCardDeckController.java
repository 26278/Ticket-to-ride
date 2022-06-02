package ttr.Controllers;

import ttr.Constants.CardColorTypes;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import ttr.Model.TrainCardDeckModel;
import ttr.Services.FirestoreService;

import java.util.ArrayList;
import java.util.Collections;

public class TrainCardDeckController {
    TrainCardDeckModel trainDeck = new TrainCardDeckModel();
    FirestoreService fs = new FirestoreService();
    CardColorTypes cardColorTypes;

    static TrainCardDeckController trainCardDeckController;
    private ArrayList<String> trainCards = new ArrayList<>();
    private ArrayList<CheckBox> trainCardCheckboxes = new ArrayList<>();

    public void setTrainDeck(ArrayList<String> trainDeck) {

    }

    public CardColorTypes[] getCardColorTypes() {
        return CardColorTypes.values();
    }


    public void Shuffle() {
        Collections.shuffle(trainDeck.getTrainCardDeck());
    }

    public static TrainCardDeckController getInstance() {
        if (trainCardDeckController == null){
            trainCardDeckController = new TrainCardDeckController();
        }
        return trainCardDeckController;
    }

    //    Verplaats naar PlayerHand als deze af is
    public ArrayList<CheckBox> trainCardCheckboxes() {
        //        ArrayList<TrainCard> trainCards = new ArrayList<>();
        trainCards.add("Green");
        trainCards.add("Blue");
        trainCards.add("Pink");
        trainCards.add("Yellow");
        trainCards.add("Green");
        trainCards.add("Green");

        for (String trainCard : trainCards) {
            CheckBox card = new CheckBox();
//            card.setText(trainCard.getColor());
//            card.setGraphic(trainCard.getGraphic());
            card.setText(trainCard);
            trainCardCheckboxes.add(card);
        }

        return trainCardCheckboxes;
    }

    @FXML
    protected void confirmSelectedCards() {

    }

    @FXML
    protected void cancelSelectedCards() {

    }

}

