package ttr.Views;

import javafx.fxml.FXML;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Shape;
import ttr.Controllers.BoardController;
import ttr.Model.PlayerModel;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

import ttr.Controllers.TrainCardDeckController;



public class BoardView implements PlayerObserver {
    public ImageView Card1;
    public ImageView Card2;
    public ImageView Card3;
    public ImageView Card4;
    public ImageView Card5;
    BoardController bc;
    TrainCardDeckController deck;
    HashMap<ImageView, String> Open_cards = new HashMap<>();
    ArrayList<String> taken_card = new ArrayList<>();
    ArrayList<String> decktest = new ArrayList<>();




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
    public void place_train_or_station() {

    }
    @FXML
    public void Put_in_hand_and_replace(MouseEvent event) throws FileNotFoundException {
        Open_cards.put(Card1, "loco");
        Open_cards.put(Card2, "pink");
        Open_cards.put(Card3, "green");
        Open_cards.put(Card4, "white");
        Open_cards.put(Card5, "black");
        decktest.add("pink");
        decktest.add("green");
        decktest.add("orange");
        decktest.add("loco");
        String id = event.getPickResult().getIntersectedNode().getId();
        for (ImageView i : Open_cards.keySet()) {
            String color = Open_cards.get(i);
            if (id == i.getId().toString() && taken_card.size() < 3) {
                if (taken_card.size() == 0) {
                    taken_card.add(color);
                    Open_cards.remove(i);
                    Open_cards.put(i, decktest.get(0));
                    String url = "/ttr/fxml/eu_WagonCard_" + decktest.get(0).toString() + ".png";
                    i.setImage(new Image(getClass().getResourceAsStream(url)));
                    break;
                }
                    if (taken_card.size() == 1) {
                        taken_card.add(color);
                        decktest.remove(Open_cards.get(i));
                        Open_cards.remove(i);
                        Open_cards.put(i, decktest.get(0));
                        String url = "/ttr/fxml/eu_WagonCard_" + decktest.get(0).toString() + ".png";
                        i.setImage(new Image(getClass().getResourceAsStream(url)));

                    }
                }
                if (taken_card.size() == 2) {
                    System.out.println("volgende beurt");
                    System.out.println(taken_card);
                    break;
                }
            }
        }




    @Override
    public void update(PlayerModel playerModel) {
    }

    @FXML
    protected void endTurn() {
        bc.endTurn();
    }
}
