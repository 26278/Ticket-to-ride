package ttr.Controllers;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import ttr.Constants.CardColorTypes;
import ttr.Model.PlayerModel;
import ttr.Model.RequirementModel;
import ttr.Model.TrainCardDeckModel;
import ttr.Model.TrainCardModel;
import ttr.Services.FirestoreService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Objects;

import static ttr.Constants.ColorConstants.COLOR_GRAY;
import static ttr.Constants.ColorConstants.COLOR_RAINBOW;

public class TrainCardDeckController {
    TrainCardDeckModel trainDeck = new TrainCardDeckModel();
    FirestoreService fs = new FirestoreService();
    static TrainCardDeckController trainCardDeckController;
    PlayerModel player;
    RequirementModel requirementModel;
    private Group route;


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
        if (amount > 0) {
            return true;
        }
        return false;
    }

    private boolean checkMaximum(String cardColorString, BorderPane borderPane) {
        int amountOfTrainCards = amountOfTrainCardsFromType(cardColorString);
        int maxAmount = getSelectedAmountOfCardsInt(cardColorString, borderPane);

        if (maxAmount < amountOfTrainCards) {
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

    private void checkRequirementMatch(BorderPane borderPane) {
        boolean matchWithRequirements = false;

        ArrayList<String> requirements = this.requirementModel.getRequirements();
        ArrayList<String> selectedCards = getSelectedCards(borderPane);

        if (requirements.contains(COLOR_GRAY)) {
            if (grayRequirements(requirements, selectedCards)){
                matchWithRequirements = true;
            }
        } else {
            if (normalRequirements(requirements, selectedCards)) {
                matchWithRequirements = true;
            }
        }
        Button confirmButton = ((Button) borderPane.lookup("#confirmButton"));
        confirmButton.setDisable(!matchWithRequirements);
    }

    private boolean normalRequirements(ArrayList<String> requirements, ArrayList<String> selectedCards) {
        if (requirements.size() == selectedCards.size()) {
            if (selectedCards.stream().distinct().count() == 1 && !selectedCards.contains(COLOR_RAINBOW)) {
                if (Objects.equals(selectedCards.get(0), requirements.get(0))) {
                    return true;
                }
            }
            if (selectedCards.stream().distinct().count() == 2 && selectedCards.contains(COLOR_RAINBOW)) {
                if (selectedCards.contains(requirements.get(0))) {
                    return true;
                }
            }
            if (selectedCards.stream().distinct().count() == 1 && selectedCards.contains(COLOR_RAINBOW)) {
                return true;
            }
        }
        return false;
    }

    private boolean grayRequirements(ArrayList<String> requirements, ArrayList<String> selectedCards) {
        int grayCountRequired = 0;
        int rainbowCountRequired = 0;

        int rainbowCountInput = 0;
        int normalCountInput = 0;

        if (requirements.size() == selectedCards.size()) {
            for (String requirement : requirements) {
                if (Objects.equals(requirement, COLOR_GRAY)) {
                    grayCountRequired++;
                }
                if (Objects.equals(requirement, COLOR_RAINBOW)) {
                    rainbowCountRequired++;
                }
            }

            if ((requirements.contains(COLOR_RAINBOW) && selectedCards.stream().distinct().count() == 2)
                    ||  (requirements.contains(COLOR_RAINBOW) && selectedCards.stream().distinct().count() == 1)
                    || (!requirements.contains(COLOR_RAINBOW) && selectedCards.stream().distinct().count() == 1)
                    || (!requirements.contains(COLOR_RAINBOW) && selectedCards.stream().distinct().count() == 2) && selectedCards.contains(COLOR_RAINBOW)){
                for (int i = 0; i < selectedCards.size(); i++) {
                    if (!Objects.equals(selectedCards.get(i), COLOR_RAINBOW)) {
                        normalCountInput++;
                    }
                    if (Objects.equals(selectedCards.get(i), COLOR_RAINBOW)) {
                        if (rainbowCountInput != rainbowCountInput) {
                            rainbowCountInput++;
                        } else {
                            normalCountInput++;
                        }
                    }
                }
            }
        }

        if (normalCountInput == grayCountRequired && rainbowCountInput == rainbowCountRequired) {
            return true;
        }
        return false;
    }


    private ArrayList<String> getSelectedCards(BorderPane borderPane) {
        ArrayList<String> selectedCards = new ArrayList<>();
        CardColorTypes cardColorTypes[] = getCardColorTypes();
        for (CardColorTypes cardColorType : cardColorTypes) {
            getSelectedAmountOfCardsInt(getCardColorTypeString(cardColorType), borderPane);
            for (int i = 0; i < getSelectedAmountOfCardsInt(getCardColorTypeString(cardColorType), borderPane); i++ ){
                selectedCards.add(getCardColorTypeString(cardColorType));
            }
        }
        return selectedCards;
    }

    public String getCardColorTypeString(CardColorTypes cardColorType) {
        return cardColorType.toString().toLowerCase(Locale.ROOT);
    }

    public void plusOne(String cardColorString, BorderPane borderPane) {
        if (checkMaximum(cardColorString, borderPane)) {
            int newValue = getSelectedAmountOfCardsInt(cardColorString, borderPane) + 1;
            getSelectedAmountOfCardsText(cardColorString, borderPane).setText(String.valueOf(newValue));
            checkRequirementMatch(borderPane);
        }
    }

    public void minusOne(String cardColorString, BorderPane borderPane) {
        if (checkMinimum(cardColorString, borderPane)) {
            int newValue = getSelectedAmountOfCardsInt(cardColorString, borderPane) - 1;
            getSelectedAmountOfCardsText(cardColorString, borderPane).setText(String.valueOf(newValue));
            checkRequirementMatch(borderPane);
        }
    }

    public void setRequirement(RequirementModel requirementModel) {
        this.requirementModel = requirementModel;
    }

    public void closePaymentScreen(MouseEvent event) {
        BoardController bc = BoardController.getInstance();
        bc.placeTrain(route, event);
        bc.loadFile(event, "game_interface.fxml");
    }

    public void setRoute(Group route) {
        this.route = route;
    }
}

