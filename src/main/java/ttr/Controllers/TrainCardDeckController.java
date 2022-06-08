package ttr.Controllers;

import javafx.scene.control.Button;
import ttr.Constants.CardColorTypes;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import ttr.Constants.CardColorTypes;
import ttr.Model.TrainCardDeckModel;
import ttr.Services.FirestoreService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class TrainCardDeckController {
    TrainCardDeckModel trainDeck = new TrainCardDeckModel();
    FirestoreService fs = new FirestoreService();
    CardColorTypes cardColorTypes;

    static TrainCardDeckController trainCardDeckController;
    private ArrayList<String> trainCards = new ArrayList<>();
    private ArrayList<CheckBox> trainCardCheckboxes = new ArrayList<>();

    public void setTrainDeck(ArrayList<String> trainDeck) {

    }

    public CardColorTypes[] getCardColorTypes() {
        return CardColorTypes.values();
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

    public CardColorTypes[] getCardColorTypes() {
        return CardColorTypes.values();
    }

    private boolean checkMinimum(String cardColorString, BorderPane borderPane) {
//        Check in Player's TrainCardDeck if the amount of cards from this type is already 0
        int amount = getSelectedAmountOfCardsInt(cardColorString, borderPane);
        if ( amount > 0) {
            return true;
        }
        return false;
    }

    private boolean checkMaximum(String cardColorString, BorderPane borderPane) {
//        Check in Player's TrainCardDeck if the amount of cards from this type is equal as selected.
        int x = 5;
        int maxAmount = getSelectedAmountOfCardsInt(cardColorString, borderPane);

        if ( maxAmount < x ) {
            return true;
        }
        return false;
    }

    private Text getSelectedAmountOfCardsText(String cardColorString, BorderPane borderPane) {
        String id = "#" + cardColorString;
        Text selectedAmountOfCardsText = ((Text) borderPane.lookup(id));

        return selectedAmountOfCardsText;
    }

    private int getSelectedAmountOfCardsInt(String cardColorString, BorderPane borderPane) {
        String selectAmountOfCardsText = getSelectedAmountOfCardsText(cardColorString, borderPane).getText();

        return Integer.valueOf(selectAmountOfCardsText);
    }

    private void checkRequirementMatch(BorderPane borderPane, String requiredTrainCardColor, int requiredTrainCardCount, boolean isTunnelBoolean) {
        boolean matchWithRequirements = false;
        Button confirmButton = ((Button) borderPane.lookup("#confirmButton"));
        CardColorTypes cardColorTypes[] = getCardColorTypes();

        for (CardColorTypes cardColorType : cardColorTypes) {
            String cardColorTypeString = cardColorType.toString().toLowerCase(Locale.ROOT);
            if (cardColorTypeString.equals(requiredTrainCardColor)) {
                int amountOfSelectedCards = getSelectedAmountOfCardsInt(cardColorTypeString, borderPane);
                if (amountOfSelectedCards == requiredTrainCardCount) {
                    matchWithRequirements = true;
                }
            }
        }
        confirmButton.setDisable(!matchWithRequirements);
    }

    @FXML
    protected void cancelSelectedCards() {

    }

    public void plusOne(String cardColorString, BorderPane borderPane) {
        if (checkMaximum(cardColorString, borderPane)) {
            int newValue = getSelectedAmountOfCardsInt(cardColorString, borderPane) + 1;
            getSelectedAmountOfCardsText(cardColorString, borderPane).setText(String.valueOf(newValue));
//            checkRequirementMatch(cardColorString)
        }
    }

    public void minusOne(String cardColorString, BorderPane borderPane) {
        if (checkMinimum(cardColorString, borderPane)) {
            int newValue = getSelectedAmountOfCardsInt(cardColorString, borderPane) - 1;
            getSelectedAmountOfCardsText(cardColorString, borderPane).setText(String.valueOf(newValue));
//            checkRequirementMatch(cardColorString)
        }
    }
}

