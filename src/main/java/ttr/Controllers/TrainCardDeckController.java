package ttr.Controllers;

import ttr.Model.TrainCardDeckModel;
import ttr.Services.FirestoreService;

import java.util.ArrayList;
import java.util.Collections;

public class TrainCardDeckController {
    TrainCardDeckModel trainDeck = new TrainCardDeckModel();
    FirestoreService fs = new FirestoreService();


    public void setTrainDeck(ArrayList<String> trainDeck) {

    }


    public void Shuffle(){
        Collections.shuffle(trainDeck.getTrainCardDeck());
    }
}
