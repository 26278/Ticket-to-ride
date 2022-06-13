package ttr.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

import ttr.Services.FirestoreService;

import java.util.*;

import static ttr.Constants.ClientConstants.TRAINCARD_DECK;
import static ttr.Constants.ColorConstants.*;

public class TrainCardDeckModel implements Observable {
    private ArrayList<TrainCardModel> trainCardDeck = new ArrayList<TrainCardModel>();
    private ArrayList<TrainCardModel> discardDeck = new ArrayList<TrainCardModel>();


    FirestoreService firestoreService = new FirestoreService();
    boolean updating = false;

    public TrainCardDeckModel() {
        initDeck();
        Collections.shuffle(trainCardDeck);
    }

    private void initDeck() {
        updateDecks();
    }

    public void updateDecks() {
        if (!updating) {
            updating = true;
            updateTraincardDeck();
            updateDiscardDeck();
            updating = false;
        }
    }

    public void updateTraincardDeck() {
        trainCardDeck.clear();
        HashMap<String, Object> trainCardDeckMap = firestoreService.getTraincardDeck();
        for (Map.Entry<String, Object> entry : trainCardDeckMap.entrySet()) {
            String s = entry.getValue().toString();
            int count = Integer.parseInt(s);
            for (int i = 0; i < count; i++) {
                trainCardDeck.add(new TrainCardModel(entry.getKey()));
            }
        }
        Collections.shuffle(trainCardDeck);
    }

    public void updateDiscardDeck() {
        discardDeck.clear();
        HashMap<String, Object> discardDeckMap = firestoreService.getDiscardDeck();
        for (Map.Entry<String, Object> entry : discardDeckMap.entrySet()) {
            String s = entry.getValue().toString();
            int count = Integer.parseInt(s);
            for (int i = 0; i < count; i++) {
                discardDeck.add(new TrainCardModel(entry.getKey()));
            }
        }
    }

    public ArrayList<TrainCardModel> getTrainCardDeck() {
        return trainCardDeck;
    }

    public void shuffleDiscardPileIntoDeck() {
        updating = true;
        HashMap<String, Object> discardMap = firestoreService.getDiscardDeck();
        HashMap<String, Object> traincardMap = firestoreService.getTraincardDeck();

        HashMap<String, Integer> shuffledCards = new HashMap<>();
        for (Map.Entry<String, Object> entry : discardMap.entrySet()) {
            if (traincardMap.get(entry.getKey()) != null) {
                String s1 = traincardMap.get(entry.getKey()).toString();
                String s2 = entry.getValue().toString();

                int value = Integer.parseInt(s1) + Integer.parseInt(s2);

                shuffledCards.put(entry.getKey(), value);
            }
        }
        firestoreService.updateValue(TRAINCARD_DECK, shuffledCards);
        updating = false;
    }

    public ArrayList<TrainCardModel> pullCards() {
        ArrayList<TrainCardModel> returnHand = new ArrayList<>();
        if (trainCardDeck.size() <= 5) {
            shuffleDiscardPileIntoDeck();
            updateDecks();
        }

        if (Objects.equals(trainCardDeck.get(1).getCardColor(), COLOR_RAINBOW)) {
            firestoreService.updateField(TRAINCARD_DECK, trainCardDeck.get(0).getCardColor(),
                    String.valueOf(firestoreService.getTrainCardValue(String.valueOf(trainCardDeck.get(0))) - 1));
            //decreases amount of cards of rainbow
            firestoreService.updateField(TRAINCARD_DECK, COLOR_RAINBOW,
                    String.valueOf(firestoreService.getTrainCardValue(String.valueOf(trainCardDeck.get(1).getCardColor())) - 1));
            returnHand.add(trainCardDeck.get(0));
            discardDeck.add(trainCardDeck.get(1));
        } else {
            //decreases amount of cards of one color

            Collections.addAll(returnHand, trainCardDeck.get(0), trainCardDeck.get(1));

            firestoreService.updateField(TRAINCARD_DECK, returnHand.get(0).getCardColor(),
                    String.valueOf(firestoreService.getTrainCardValue(String.valueOf(trainCardDeck.get(0).getCardColor())) - 1));
            firestoreService.updateField(TRAINCARD_DECK, trainCardDeck.get(1).getCardColor(),
                    String.valueOf(firestoreService.getTrainCardValue(String.valueOf(trainCardDeck.get(1).getCardColor())) - 1));
            returnHand.add(trainCardDeck.get(0));
            returnHand.add(trainCardDeck.get(1));
        }
        trainCardDeck.remove(1);
        trainCardDeck.remove(0);
        return returnHand;
    }

    public void discardCards(String color) {
        firestoreService.updateField(TRAINCARD_DECK, color,
                String.valueOf(firestoreService.getDiscardCardValue(color) + 1));
    }

    public int getDeckCount() {
        return trainCardDeck.size();
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
