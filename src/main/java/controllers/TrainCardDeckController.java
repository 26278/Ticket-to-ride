package controllers;

import models.TrainCardDeckModel;

import java.util.ArrayList;
import java.util.Collections;

public class TrainCardDeckController {
    TrainCardDeckModel trainCardDeckModel = new TrainCardDeckModel();

    public void Shuffle(){
        Collections.shuffle(trainCardDeckModel.TrainDeck);
    }
}
