package ttr.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

import static ttr.Constants.ColorConstants.*;

public class TrainCardDeckModel implements Observable {
    private ArrayList<TrainCardModel> trainCardDeck = new ArrayList<TrainCardModel>();
    private ArrayList<TrainCardModel> discardTrainDeck = new ArrayList<TrainCardModel>();


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

        }
        for (int i = 0; i < 14; i++) {
            trainCardDeck.add(new TrainCardModel(COLOR_RAINBOW));
        }
    }

    public ArrayList<TrainCardModel> getTrainCardDeck() {
        return trainCardDeck;
    }


    public void shuffleDiscardPileIntoDeck() {
        Collections.shuffle(discardTrainDeck);
        trainCardDeck.addAll(discardTrainDeck);
        discardTrainDeck.clear();
    }

    public ArrayList<TrainCardModel> pullCards() {
        ArrayList<TrainCardModel> returnHand = new ArrayList<>();
        if (trainCardDeck.size() <= 2) {
            shuffleDiscardPileIntoDeck();
        }
        if (Objects.equals(trainCardDeck.get(1).getCardColor(), COLOR_RAINBOW)) {
            returnHand.add(trainCardDeck.get(0));
            discardTrainDeck.add(trainCardDeck.get(1));
            //firebase remove card!
        } else {
            returnHand.add(trainCardDeck.get(1));
            returnHand.add(trainCardDeck.get(0));
        }
        trainCardDeck.remove(1);
        trainCardDeck.remove(0);
        return returnHand;
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
