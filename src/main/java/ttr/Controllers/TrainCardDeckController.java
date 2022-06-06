package ttr.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import ttr.Constants.CardColorTypes;
import ttr.Model.TrainCardDeckModel;
import ttr.Model.TrainCardModel;
import ttr.Services.FirestoreService;

import java.util.ArrayList;
import java.util.Collections;

public class TrainCardDeckController {
    TrainCardDeckModel trainDeck = new TrainCardDeckModel();
    FirestoreService fs = new FirestoreService();
    static TrainCardDeckController trainCardDeckController;
    private ArrayList<String> trainCards = new ArrayList<>();
    private ArrayList<CheckBox> trainCardCheckboxes = new ArrayList<>();

    public void setTrainDeck(ArrayList<String> trainDeck) {

    }


    public void Shuffle() {
        Collections.shuffle(trainDeck.getTrainCardDeck());
    }

    public static TrainCardDeckController getInstance() {
        if (trainCardDeckController == null) {
            trainCardDeckController = new TrainCardDeckController();
        }
        return trainCardDeckController;
    }

    //    Instantie maken van TrainCardDeck, kaarten toevoegen
//    public ArrayList<CardColorTypes> getTrainCardsFromUserCards() {
//        TrainCardDeckModel trainCardDeckObject = new TrainCardDeckModel();
//        TrainCardModel kaart1 = new TrainCardModel(CardColorTypes.BLUE);
//        TrainCardModel kaart2 = new TrainCardModel(CardColorTypes.YELLOW);
//        TrainCardModel kaart3 = new TrainCardModel(CardColorTypes.WHITE);
//        TrainCardModel kaart4 = new TrainCardModel(CardColorTypes.ORANGE);
//        TrainCardModel kaart5 = new TrainCardModel(CardColorTypes.BLUE);

//        trainCardDeckObject
//        return ;

//    }

}

