package ttr.Model;

import ttr.Constants.ColorConstants;

import java.util.ArrayList;
import java.util.Collections;

import static ttr.Constants.ColorConstants.*;

public class TrainCardDeckModel implements Observable{
    private ArrayList<TrainCardModel> trainCardDeck = new ArrayList<TrainCardModel>();



    public TrainCardDeckModel(){
        initDeck();
        Collections.shuffle(trainCardDeck);
    }

    private void initDeck(){
        for (int i = 0; i < 12; i++){
            trainCardDeck.add(new TrainCardModel(COLOR_RED));
            trainCardDeck.add(new TrainCardModel(COLOR_WHITE));
            trainCardDeck.add(new TrainCardModel(COLOR_BLACK));
            trainCardDeck.add(new TrainCardModel(COLOR_BLUE));
            trainCardDeck.add(new TrainCardModel(COLOR_YELLOW));
            trainCardDeck.add(new TrainCardModel(COLOR_GREEN));
            trainCardDeck.add(new TrainCardModel(COLOR_RAINBOW));
        }
    }

    public ArrayList<TrainCardModel> getTrainCardDeck() {
        return trainCardDeck;
    }


    public void pullTwoCards(){
//        if (trainCardDeck.get(0) == )
    }



    @Override
    public void notifyObservers() {

    }

    @Override
    public void addObserver() {

    }

    @Override
    public void removeObserver() {

    }
}
