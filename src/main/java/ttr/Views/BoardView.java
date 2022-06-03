package ttr.Views;

import javafx.fxml.FXML;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Shape;
import ttr.Controllers.BoardController;
import ttr.Model.PlayerModel;
import java.util.ArrayList;


public class BoardView implements PlayerObserver {
    public ImageView Card1;
    public ImageView Card2;
    public ImageView Card3;
    public ImageView Card4;
    public ImageView Card5;
    BoardController bc;
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
    public void Put_in_hand_and_replace(MouseEvent event){
        Open_cards.add(Card1);
        Open_cards.add(Card2);
        Open_cards.add(Card3);
        Open_cards.add(Card4);
        Open_cards.add(Card5);
        Image black = new Image("eu_WagonCard_black.png");
        String id = event.getPickResult().getIntersectedNode().getId();
        Card1.setImage(black);
        //for (int i = 0; i < Open_cards.size(); i++) {
          //  if (id == Open_cards.get(i).getId()){
            //    Open_cards.get(i).setImage(black);
            //}

        //}

    }


    @Override
    public void update(PlayerModel playerModel) {
    }

    @FXML
    protected void endTurn() {
        bc.endTurn();
    }
}
