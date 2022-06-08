package ttr.Views;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import ttr.Constants.CardColorTypes;
import ttr.Controllers.TrainCardDeckController;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class SelectTrainCardView {

    @FXML
    public javafx.scene.control.ListView ListView;
    public BorderPane borderPane;

    TrainCardDeckController trainCardDeckController;
    private Stage stage;
    private Scene scene;

    @FXML
    protected void initialize() {
        this.trainCardDeckController = TrainCardDeckController.getInstance();
        this.createCardsListView();
        this.createRequirementMessage("blauw", 4, false);
        //        ArrayList<CheckBox> trainCardCheckboxes = this.trainCardDeckController.showPlayerTrainCards();
    }

    private void createRequirementMessage(String trainCardColor, int trainCardCount,  boolean isTunnelBoolean) {
        String requirement;
        Text requirementText = new Text();
        if (trainCardColor == "") {
            requirement = "Om deze rails te bouwen heb je " + String.valueOf(trainCardCount) + " kaarten van" +
                    " dezelfde kleur nodig.";
        } else {
            requirement = "Om deze rails te bouwen heb je " + String.valueOf(trainCardCount) + " kaarten van de kleur " +
                    trainCardColor + " nodig.";
        }

        if (isTunnelBoolean) {
            requirement += " Pas op, dit is een tunnel.";
        }
        requirementText.setText(requirement);
        borderPane.setTop(requirementText);
    }

//  Making dynamic cards for the view based on the CardColorTyped enum and user's TrainCardDeck
    private void createCardsListView() {
        GridPane gridPane = new GridPane();
        CardColorTypes cardColorTypes[] = this.trainCardDeckController.getCardColorTypes();
        int i = 0;

        for (CardColorTypes cardColorType : cardColorTypes) {
            String cardColorString = cardColorType.toString().toLowerCase(Locale.ROOT);
            String url = "/ttr/fxml/eu_WagonCard_" + cardColorString + ".png";
            int userAmountOfCards = 0; //Replace 0 with dynamic user amount of cards
            int selectAmountOfCards = 3; //Replace 0 with dynamic selected amount of cards

            Text userAmountOfCardsText = new Text("Aantal kaarten: " + String.valueOf(userAmountOfCards));
            Text selectAmountOfCardsText = new Text(String.valueOf(selectAmountOfCards));
            selectAmountOfCardsText.setId(cardColorString);
            TextFlow centerAlignUserAmountOfCardsText = new TextFlow(userAmountOfCardsText);
            Button selectPlusOneCard = new Button("+1");
            Button selectMinusOneCard = new Button("-1");
            selectPlusOneCard.setOnAction(event -> plusOne(cardColorString));
            selectMinusOneCard.setOnAction(event -> minusOne(cardColorString));
            HBox selectAmountOfCardsHBox = new HBox(selectMinusOneCard, selectAmountOfCardsText, selectPlusOneCard);
            selectAmountOfCardsHBox.setAlignment(Pos.CENTER);
            centerAlignUserAmountOfCardsText.setTextAlignment(TextAlignment.CENTER);
            Image cardImg = new Image(getClass().getResourceAsStream(url));
            ImageView cardImageView = new ImageView(cardImg);
            VBox cardVbox = new VBox(cardImageView, centerAlignUserAmountOfCardsText, selectAmountOfCardsHBox);
            cardVbox.prefHeight(200);
            cardVbox.prefWidth(50);

//          Spread the cards over the GridPane with if-statement
            if (i < 3) {
                int x = i;
                gridPane.add(cardVbox, x, 0);
            } else if (i > 2 && i < 6) {
                int x = i - 3;
                gridPane.add(cardVbox, x, 1);
            } else {
                int x = i - 6;
                gridPane.add(cardVbox, x, 2);
            }
            i++;
        }
        borderPane.setCenter(gridPane);
    }

    private void plusOne(String cardColorString) {
        this.trainCardDeckController.plusOne(cardColorString, borderPane);
    }

    private void minusOne(String cardColorString) {
        this.trainCardDeckController.minusOne(cardColorString, borderPane);
    }

    public void confirmSelectedCards(MouseEvent mouseEvent) {
//        SelectTrainCardView word gesloten
//
//        Kaarten worden naar de Deposit stapel gegooid
//
//        BuildTrain functie word aangeroepen
    }


    public void cancelSelectedCards(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/ttr/fxml/view.fxml"));

        this.stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        this.scene = new Scene(root, 1000, 800);
        stage.setScene(scene);
        stage.show();
    }
}