package ttr.Controllers;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import ttr.Constants.CardColorTypes;
import ttr.Model.PlayerModel;
import ttr.Model.TrainCardDeckModel;
import ttr.Model.TrainCardModel;
import ttr.Services.FirestoreService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class TrainCardDeckController {
    TrainCardDeckModel trainDeck = new TrainCardDeckModel();
    FirestoreService fs = new FirestoreService();
    static TrainCardDeckController trainCardDeckController;
    PlayerModel player;

    public void Shuffle() {
        Collections.shuffle(trainDeck.getTrainCardDeck());
    }

    public static TrainCardDeckController getInstance() {
        if (trainCardDeckController == null) {
            trainCardDeckController = new TrainCardDeckController();
        }
        return trainCardDeckController;
    }

    public void setPlayer(PlayerModel player) {
        this.player = player;
    }

    public CardColorTypes[] getCardColorTypes() {
        return CardColorTypes.values();
    }

    public int amountOfTrainCardsFromType(String cardColorString) {
        int amountOfTrainCards = 0;
        ArrayList<TrainCardModel> playerTrainCards = this.player.getPlayerHand();
        for (TrainCardModel trainCards : playerTrainCards) {
            if (trainCards.getCardColor().equals(cardColorString)) {
                amountOfTrainCards++;
            }
        }
        return amountOfTrainCards;
    }

    private boolean checkMinimum(String cardColorString, BorderPane borderPane) {
        int amount = getSelectedAmountOfCardsInt(cardColorString, borderPane);
        if ( amount > 0) {
            return true;
        }
        return false;
    }

    private boolean checkMaximum(String cardColorString, BorderPane borderPane) {
        int amountOfTrainCards = amountOfTrainCardsFromType(cardColorString);
        int maxAmount = getSelectedAmountOfCardsInt(cardColorString, borderPane);

        if ( maxAmount < amountOfTrainCards ) {
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

