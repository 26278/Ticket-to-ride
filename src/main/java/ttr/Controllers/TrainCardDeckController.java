package ttr.Controllers;

import ttr.Constants.CardColorTypes;
import ttr.Model.TrainCardDeckModel;
import ttr.Services.FirestoreService;

import java.util.ArrayList;
import java.util.Collections;

public class TrainCardDeckController {
    TrainCardDeckModel trainDeck = new TrainCardDeckModel();
    FirestoreService fs = new FirestoreService();
    CardColorTypes cardColorTypes;


    public void setTrainDeck(ArrayList<String> trainDeck) {

    }

    public CardColorTypes[] getCardColorTypes() {
        return CardColorTypes.values();
    }


    public void Shuffle() {
        Collections.shuffle(trainDeck.getTrainCardDeck());
    }
}
