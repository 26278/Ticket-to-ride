package ttr.Views;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import ttr.Constants.ColorConstants;
import ttr.Controllers.BoardController;
import ttr.Model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;


public class BoardView implements PlayerObserver, OpenCardObserver, TrainObserver, FirebaseObserver {
    public ImageView Card_1;
    public ImageView Card_2;
    public ImageView Card_3;
    public ImageView Card_4;
    public ImageView Card_5;
    public HBox PlayerHandHbox;
    public VBox PlayerInfoVbox;
    public HBox PlayerHandInfoHbox;
    public HBox TrainTicketDecksHbox;
    private BoardController bc;
    private ArrayList<ImageView> imageview = new ArrayList();
    @FXML
    private AnchorPane boardPane;
    @FXML
    private Label CurrentPlayer;
    @FXML
    private Button endTurnButton;
    @FXML
    private Button endGameButton;

    private ArrayList<Node> groups;


    @FXML
    protected void initialize() {
        this.groups = new ArrayList<>(boardPane.getChildren());
        this.bc = BoardController.getInstance();
        Collections.addAll(imageview, Card_1, Card_2, Card_3, Card_4, Card_5);
        this.bc.register_open_card_observer(this);
        this.bc.setopencards();
        this.bc.registerPlayerObserver(this);
        this.bc.registerTrainObserver(this);
        this.bc.registerFirebaseObserver(this);
    }

    public void clickoncard(MouseEvent event) {
        bc.click_card(event);

    }

    @FXML
    private void createTrainCardDeckView(PlayerModel player) {
        TrainTicketDecksHbox.getChildren().clear();
        int deckSize = player.getDeckSize();
        String imageUrl = "/ttr/decks/trainDeck/deck-cardLevel-" + chooseDeckImage(deckSize) + ".png";
        Image trainDeckImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imageUrl)));
        ImageView trainDeckImageView = new ImageView(trainDeckImage);
        trainDeckImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                bc.pullCards();
            }
        });//On mouse click event
        trainDeckImageView.setFitWidth(150);
        TrainTicketDecksHbox.getChildren().add(trainDeckImageView);
    }//Creates an image of the TrainCardDeck, which can be pressed to draw cards from the TrainCardDeck


    public String chooseDeckImage(int deckSize) {
        if (deckSize > 70) {
            return "100";
        } else if (deckSize > 40) {
            return "70";
        } else if (deckSize > 10) {
            return "40";
        } else {
            return "10";
        }
    }//Helper function to decide what image to use for the deck


    @FXML
    private void createPlayerInfoVbox(PlayerModel player) {
        HBox stationHBox = new HBox();
        HBox trainHBox = new HBox();
        Label stationLabel = new Label(" X " + player.getStationCount());
        stationLabel.setFont(new Font(20));
        Label trainLabel = new Label(" X " + player.getTrainCount());
        trainLabel.setFont(new Font(20));
        PlayerInfoVbox.getChildren().clear();
        String stationUrl = "/ttr/station/station-" + player.getPlayerColor() + ".png";
        Image stationImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(stationUrl)));
        ImageView stationImageView = new ImageView(stationImage);
        String trainUrl = "/ttr/trains/train-" + player.getPlayerColor() + "-Claimed.png";
        Image trainImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(trainUrl)));
        ImageView trainImageView = new ImageView(trainImage);
        trainImageView.setFitWidth(50);
        stationHBox.getChildren().add(stationImageView);
        stationHBox.getChildren().add(stationLabel);
        trainHBox.getChildren().add(trainImageView);
        trainHBox.getChildren().add(trainLabel);
        stationHBox.setAlignment(Pos.CENTER);
        trainHBox.setAlignment(Pos.CENTER);
        PlayerInfoVbox.getChildren().addAll(stationHBox, trainHBox);
    }//dynamically creates the view of amount of Stations and Trains the player has left


    @FXML
    private void createPlayerHandHBox(PlayerModel player) {
        ColorAdjust greyOut = new ColorAdjust();
        greyOut.setSaturation(-1);
        PlayerHandHbox.getChildren().clear();
        ArrayList<String> colors = ColorConstants.getColors();
        for (String colorTypes : colors) {
            VBox cardBox = new VBox();
            Label cardCounter = new Label();
            int cardCount = 0;
            String cardColorString = colorTypes.toLowerCase();
            String url = "/ttr/cards/vertical/eu_WagonCard_" + cardColorString + ".png";
            Image cardImg = new Image(Objects.requireNonNull(getClass().getResourceAsStream(url)));
            ImageView cardImageView = new ImageView(cardImg);
            cardImageView.setFitWidth(100);
            cardImageView.setFitHeight(200);
            cardCounter.setFont(new Font(20));

            for (TrainCardModel card : player.getPlayerHand()) {
                if (Objects.equals(card.getCardColor(), cardColorString)) {
                    cardCount++;
                }
            }//goes through playerHand and counts how many cards there are of the color

            if (cardCount == 0) {
                cardImageView.setEffect(greyOut);
            }

            cardBox.getChildren().add(cardCounter);
            cardBox.getChildren().add(cardImageView);
            giveHoverEffect(cardImageView, cardBox, cardCounter);
            cardCounter.setText("X " + cardCount);
            PlayerHandHbox.getChildren().add(cardBox);
        }
    }//dynamically creates the view of the playerHand


    public void giveHoverEffect(ImageView cardImageView, VBox cardBox, Label cardCounter) {
        cardImageView.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                cardBox.getChildren().remove(cardCounter);
            }
        });

        cardImageView.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                cardBox.getChildren().add(0, cardCounter);
            }
        });
    }//removes label from cardBox, to create a visual effect when hovering over a card

    @FXML
    public void highlight(MouseEvent event) {
        // light up event source
        Shape glowRec = (Shape) event.getSource();
        glowRec.setEffect(new Glow(1));
    }

    @FXML
    public void no_highlight(MouseEvent event) {
        // removes event source effect
        Shape glowRec = (Shape) event.getSource();
        glowRec.setEffect(null);
    }


    @FXML
    public void place_train_or_station(MouseEvent event) {
        Rectangle r = (Rectangle) event.getSource();
        bc.placeTrain(r.getParent().getId(), r.getParent().getChildrenUnmodifiable().size());
    }

    @FXML
    public void pullTrainCards(ActionEvent actionEvent) {
        bc.pullCards();
    }

    @FXML
    public void pullTickerCards(ActionEvent actionEvent) {
    }

    @FXML
    public void change_OpenCardImage(ArrayList arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            String url = "/ttr/cards/horizontal/eu_WagonCard_" + arrayList.get(i).toString() + ".png";
            imageview.get(i).setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream(url))));
        }
    }

    private void showPlayerCount(String playerName) {
        Platform.runLater(() -> {
            CurrentPlayer.setText("Current Players: " + playerName);
        });
    }

    @FXML
    public void Put_in_hand_and_replace(MouseEvent event)  {
        bc.click_card(event);
    }

    @Override
    public void update(SelectOpenCardModel openCardModel) {
        change_OpenCardImage(openCardModel.getOpen_cards());
    }

    @FXML
    public void paintTrain(String groupName, String color) {
        String url = "/ttr/trains/train-" + color + "-Claimed.png";
        Image train = new Image(Objects.requireNonNull(getClass().getResourceAsStream(url)));
        for (int i = 0; i < groups.size(); i++) {
            if (Objects.equals(groups.get(i).getId(), groupName)) {
                Group group = (Group) groups.get(i);
                for (Node node : group.getChildren()) {
                    Rectangle rec = (Rectangle) node;
                    if (!(rec.getFill() instanceof ImagePattern))
                        rec.setFill(new ImagePattern(train));

                }
            }
        }
    }

    private void showEndGameButton(Boolean gameFinished) {
        if (gameFinished) {
            endTurnButton.setVisible(false);
            endGameButton.setVisible(true);
        }
    }

    public void openEndScreen(MouseEvent event) {
        this.bc.openEndScreen(event);
    }

    @Override
    public void update(PlayerModel playerModel) {
        createPlayerInfoVbox(playerModel);
        createPlayerHandHBox(playerModel);
        createTrainCardDeckView(playerModel);
    }


    @FXML
    protected void endTurn() {
        bc.endTurn();
    }

    @Override
    public void update(TrainModel trainModel) {
        paintTrain(trainModel.getGroupName(), trainModel.getColor());
    }

    @Override
    public void update(FirebaseModel firebaseModel) {
        showPlayerCount(firebaseModel.getCurrentPlayerName());
        showEndGameButton(firebaseModel.isGameFinished());
    }


}
