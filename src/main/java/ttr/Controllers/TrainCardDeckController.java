package ttr.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;

import java.util.ArrayList;

public class TrainCardDeckController {

    static TrainCardDeckController trainCardDeckController;
    private ArrayList<String> trainCards = new ArrayList<>();
    private ArrayList<CheckBox> trainCardCheckboxes = new ArrayList<>();

    public static TrainCardDeckController getInstance() {
        if (trainCardDeckController == null){
            trainCardDeckController = new TrainCardDeckController();
        }
        return trainCardDeckController;
    }

    public ArrayList<CheckBox> trainCardCheckboxes() {
        //        ArrayList<TrainCard> trainCards = new ArrayList<>();
        trainCards.add("Green");
        trainCards.add("Blue");
        trainCards.add("Pink");
        trainCards.add("Yellow");
        trainCards.add("Green");
        trainCards.add("Green");

        for (String trainCard : trainCards) {
            CheckBox card = new CheckBox();
//            card.setText(trainCard.getColor());
//            card.setGraphic(trainCard.getGraphic());
            card.setText(trainCard);
            trainCardCheckboxes.add(card);
        }

        return trainCardCheckboxes;
    }

    public void SelectCards(int amount, String color) {
//        Open SelectCards view with form

//        Check which color is needed
        if (color.equals("grey")) {

        } else {

        }
    }



    @FXML
    protected void confirmSelectedCards() {

    }

    @FXML
    protected void cancelSelectedCards() {

    }
}
