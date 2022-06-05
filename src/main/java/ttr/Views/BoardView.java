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
import ttr.Controllers.TrainCardDeckController;


public class BoardView implements PlayerObserver {
    public ImageView Card1;
    public ImageView Card2;
    public ImageView Card3;
    public ImageView Card4;
    public ImageView Card5;;
    BoardController bc;
    TrainCardDeckController deck;
    ArrayList<ImageView> Open_cards = new ArrayList<>();




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
        Open_cards.add(Card1);
        Open_cards.add(Card2);
        Open_cards.add(Card3);
        Open_cards.add(Card4);
        Open_cards.add(Card5);
        Image pink = new Image(getClass().getResourceAsStream("/ttr/fxml/eu_WagonCard_pink.png"));
        Image black = new Image(getClass().getResourceAsStream("/ttr/fxml/eu_WagonCard_black.png"));
        Image orange = new Image(getClass().getResourceAsStream("/ttr/fxml/eu_WagonCard_orange.png"));
        Image green = new Image(getClass().getResourceAsStream("/ttr/fxml/eu_WagonCard_green.png"));
        Image loco = new Image(getClass().getResourceAsStream("/ttr/fxml/eu_WagonCard_loco.png"));
        Image blue = new Image(getClass().getResourceAsStream("/ttr/fxml/eu_WagonCard_blue.png"));
        Image red = new Image(getClass().getResourceAsStream("/ttr/fxml/eu_WagonCard_red.png"));
        Image white = new Image(getClass().getResourceAsStream("/ttr/fxml/eu_WagonCard_white.png"));
        Image yellow = new Image(getClass().getResourceAsStream("/ttr/fxml/eu_WagonCard_yellow.png"));
        String id = event.getPickResult().getIntersectedNode().getId();
        for (int i = 0; i < Open_cards.size(); i++) {
            if (id == Open_cards.get(i).getId()){
                Open_cards.get(i).setImage(pink);
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
