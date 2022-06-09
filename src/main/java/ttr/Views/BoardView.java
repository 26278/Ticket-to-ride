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
import java.util.Collections;
import java.util.HashMap;

import ttr.Controllers.TrainCardDeckController;
import ttr.Model.SelectOpenCardModel;


public class BoardView implements PlayerObserver, OpenCardObserver {
    public ImageView Card_1;
    public ImageView Card_2;
    public ImageView Card_3;
    public ImageView Card_4;
    public ImageView Card_5;
    BoardController bc;
    ArrayList<ImageView> imageview = new ArrayList();



    @FXML
    protected void initialize(){
        this.bc = BoardController.getInstance();
        Collections.addAll(imageview,Card_1, Card_2, Card_3, Card_4, Card_5);
        this.bc.register_open_card_observer(this);
        this.bc.setopencards();


    }
    public void clickoncard(MouseEvent event){
        bc.click_card(event);
    }

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
    }
    @FXML
    public void Change_Image(ArrayList arrayList){
        for (int i = 0; i < arrayList.size(); i++) {
            String url = "/ttr/fxml/eu_WagonCard_" + arrayList.get(i).toString() + ".png";
            imageview.get(i).setImage(new Image(getClass().getResourceAsStream(url)));
        }

    }
    @FXML
    public void Put_in_hand_and_replace(MouseEvent event) throws FileNotFoundException {
        bc.click_card(event);
        }



    @Override
    public void update(PlayerModel playerModel) {
    }

    @FXML
    protected void endTurn() {
        bc.endTurn();
    }

    @Override
    public void update(SelectOpenCardModel openCardModel) {
        Change_Image(openCardModel.getOpen_cards());
    }
}
