package ttr.Model;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import ttr.Config.Database;

import java.util.*;

import static ttr.Constants.ColorConstants.*;

public class TrainCardDeckModel implements Observable {
    private ArrayList<TrainCardModel> trainCardDeck = new ArrayList<TrainCardModel>();
    private ArrayList<TrainCardModel> discardTrainDeck = new ArrayList<TrainCardModel>();

    Database change = new Database();

    Firestore db = change.getDb();

    HashMap<TrainCardModel, Integer> trainDeckData = new HashMap<>();

    ApiFuture<WriteResult> future = db.collection("playerhand").document("train").set(trainDeckData);


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
            trainCardDeck.add(new TrainCardModel(COLOR_BROWN));
            trainCardDeck.add(new TrainCardModel(COLOR_PURPLE));
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
        if (trainCardDeck.size() <= 2){
            shuffleDiscardPileIntoDeck();
        }

        if (Objects.equals(trainCardDeck.get(1).getCardColor(), COLOR_RAINBOW)) {
            returnHand.add(trainCardDeck.get(0));
            discardTrainDeck.add(trainCardDeck.get(1));
            //firebase remove card!
            //decreases amount of cards of rainbow
            trainDeckData.put(trainCardDeck.get(1), trainDeckData.getOrDefault(COLOR_RAINBOW, 0) - 1);
        }
        else {
            returnHand.add(trainCardDeck.get(1));
            returnHand.add(trainCardDeck.get(0));
            //increases amount of cards of one color
            trainDeckData.merge(returnHand.get(0), 1, Integer::sum);
            trainDeckData.merge(returnHand.get(1), 1, Integer::sum);
        }
        trainCardDeck.remove(1);
        trainCardDeck.remove(0);
        return returnHand;
    }

    public int getDeckCount(){
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
