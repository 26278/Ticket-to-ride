package controllers;

import java.util.ArrayList;
import java.util.Collections;

public class TrainCardDeckController {
    public ArrayList<String> TrainDeck = new ArrayList<>();

    public ArrayList<String> getTrainDeck() {
        return TrainDeck;
    }

    public void setTrainDeck(ArrayList<String> trainDeck) {
        TrainDeck = trainDeck;
    }


    public void Shuffle(){
        Collections.shuffle(TrainDeck);
    }
}
