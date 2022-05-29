package ttr.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

import static ttr.Constants.ColorConstants.*;

public class TrainCardDeckModel implements Observable {
    private ArrayList<TrainCardModel> trainCardDeck = new ArrayList<TrainCardModel>();


    public TrainCardDeckModel() {
        initDeck();
        Collections.shuffle(trainCardDeck);
    }

    private void initDeck() {
        for (int i = 0; i < 12; i++) {
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


    public ArrayList<TrainCardModel> pullCards() {
        ArrayList<TrainCardModel> returnHand = new ArrayList<>();
        if (Objects.equals(trainCardDeck.get(1).getCardColor(), COLOR_RAINBOW)) {
            returnHand.add(trainCardDeck.get(0));
            trainCardDeck.remove(0);
            //firebase remove card!
        } else {
            returnHand.add(trainCardDeck.get(1));
            returnHand.add(trainCardDeck.get(0));
            trainCardDeck.remove(1);
            trainCardDeck.remove(0);
        }
        return returnHand;
    }

    public ArrayList<TrainCardModel> pullCardsTester(int Choice) {
        ArrayList<TrainCardModel> hulpTestHand = new ArrayList<>();
        if (Choice == 1) {
            trainCardDeck.add(1, new TrainCardModel(COLOR_BLACK));
            hulpTestHand = pullCards();
        } else if (Choice == 2) {
            trainCardDeck.add(1, new TrainCardModel(COLOR_RAINBOW));
            hulpTestHand = pullCards();
        }
        return hulpTestHand;
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
