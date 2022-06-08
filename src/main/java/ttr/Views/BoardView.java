package ttr.Views;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import ttr.Controllers.BoardController;
import ttr.Model.PlayerModel;

import java.util.ArrayList;

public class BoardView implements PlayerObserver {
    BoardController bc;

    public Rectangle Edinburgh_London_R1;
    public Rectangle Edinburgh_London_R2;
    public Rectangle Edinburgh_London_R3;
    public Rectangle Edinburgh_London_R4;
    public Rectangle Edinburgh_London_L1;
    public Rectangle Edinburgh_London_L2;
    public Rectangle Edinburgh_London_L3;
    public Rectangle Edinburgh_London_L4;
    public Rectangle Brest_Diepe_1;
    public Rectangle Brest_Diepe_2;
    public Rectangle Diepe_Paris_1;
    public Rectangle Brest_Paris_1;
    public Rectangle Brest_Paris_2;
    public Rectangle Brest_Paris_3;
    public Rectangle Diepe_Bruxelles_2;
    public Rectangle Diepe_Bruxelles_1;
    public Rectangle Amsterdam_Bruxelles_1;
    public Rectangle London_Diepe_L2;
    public Rectangle London_Diepe_R2;
    public Rectangle London_Amsterdam_1;
    public Rectangle London_Amsterdam_2;
    public Rectangle London_Diepe_L1;
    public Rectangle London_Diepe_R1;
    public Rectangle Bruxelles_Paris_R1;
    public Rectangle Bruxelles_Paris_R2;
    public Rectangle Bruxelles_Paris_L1;
    public Rectangle Bruxelles_Paris_L2;
    public Rectangle Brest_Pamplona_4;
    public Rectangle Brest_Pamplona_3;
    public Rectangle Brest_Pamplona_2;
    public Rectangle Brest_Pamplona_1;
    public Rectangle Paris_Pamplona_L1;
    public Rectangle Paris_Pamplona_L2;
    public Rectangle Paris_Pamplona_L3;
    public Rectangle Paris_Pamplona_L4;
    public Rectangle Paris_Pamplona_R1;
    public Rectangle Paris_Pamplona_R2;
    public Rectangle Paris_Pamplona_R3;
    public Rectangle Paris_Pamplona_R4;
    public Rectangle Pamplona_Marseille_1;
    public Rectangle Pamplona_Marseille_2;
    public Rectangle Pamplona_Marseille_3;
    public Rectangle Pamplona_Marseille_4;
    public Rectangle Paris_Marseille_1;
    public Rectangle Paris_Marseille_2;
    public Rectangle Paris_Marseille_3;
    public Rectangle Paris_Marseille_4;
    public Rectangle Barcelona_Marseille_4;
    public Rectangle Barcelona_Marseille_3;
    public Rectangle Barcelona_Marseille_2;
    public Rectangle Barcelona_Marseille_1;
    public Rectangle Pamplona_Barcelona_1;
    public Rectangle Pamplona_Barcelona_2;
    public Rectangle Madrid_Barcelona_2;
    public Rectangle Madrid_Barcelona_1;
    public Rectangle Pamplona_Madrid_R1;
    public Rectangle Pamplona_Madrid_R2;
    public Rectangle Pamplona_Madrid_R3;
    public Rectangle Pamplona_Madrid_L1;
    public Rectangle Pamplona_Madrid_L2;
    public Rectangle Pamplona_Madrid_L3;
    public Rectangle Lisboa_Madrid_1;
    public Rectangle Lisboa_Madrid_2;
    public Rectangle Lisboa_Madrid_3;
    public Rectangle Cadiz_Madrid_3;
    public Rectangle Cadiz_Madrid_2;
    public Rectangle Cadiz_Madrid_1;
    public Rectangle Lisboa_Cadiz_1;
    public Rectangle Lisboa_Cadiz_2;
    public Rectangle Amsterdam_Essen_2;
    public Rectangle Amsterdam_Essen_3;
    public Rectangle Amsterdam_Essen_1;
    public Rectangle Paris_Zurich_2;
    public Rectangle Paris_Zurich_3;
    public Rectangle Paris_Zurich_1;
    public Rectangle Zurich_Marseille_2;
    public Rectangle Zurich_Marseille_1;
    public Rectangle Bruxelles_Frankfurt_1;
    public Rectangle Bruxelles_Frankfurt_2;
    public Rectangle Amsterdam_Frankfurt_1;
    public Rectangle Amsterdam_Frankfurt_2;
    public Rectangle Paris_Frankfurt_T1;
    public Rectangle Paris_Frankfurt_T2;
    public Rectangle Paris_Frankfurt_T3;
    public Rectangle Paris_Frankfurt_B1;
    public Rectangle Paris_Frankfurt_B2;
    public Rectangle Paris_Frankfurt_B3;
    public Rectangle Frankfurt_Essen_2;
    public Rectangle Frankfurt_Essen_1;
    public Rectangle Frankfurt_Munchen_1;
    public Rectangle Frankfurt_Munchen_2;
    public Rectangle Munchen_Zurich_1;
    public Rectangle Munchen_Zurich_2;
    public Rectangle Zurich_Venezia_1;
    public Rectangle Zurich_Venezia_2;
    public Rectangle Munchen_Venezia_1;
    public Rectangle Munchen_Venezia_2;
    public Rectangle Venezia_Rome_1;
    public Rectangle Venezia_Rome_2;
    public Rectangle Marseille_Roma_1;
    public Rectangle Marseille_Roma_2;
    public Rectangle Marseille_Roma_3;
    public Rectangle Marseille_Roma_4;
    public Rectangle Roma_Palermo_1;
    public Rectangle Roma_Palermo_2;
    public Rectangle Roma_Palermo_3;
    public Rectangle Roma_Palermo_4;
    public Rectangle Brindisi_Palermo_1;
    public Rectangle Brindisi_Palermo_2;
    public Rectangle Brindisi_Palermo_3;
    public Rectangle Roma_Brindisi_1;
    public Rectangle Roma_Brindisi_2;
    public Rectangle Venezia_Zagrab_1;
    public Rectangle Venezia_Zagrab_2;
    public Rectangle Wien_Zagrab_1;
    public Rectangle Wien_Zagrab_2;
    public Rectangle Munchen_Wien_1;
    public Rectangle Munchen_Wien_2;
    public Rectangle Munchen_Wien_3;
    public Rectangle Frankfurt_Berlin_B1;
    public Rectangle Frankfurt_Berlin_B2;
    public Rectangle Frankfurt_Berlin_B3;
    public Rectangle Frankfurt_Berlin_T1;
    public Rectangle Frankfurt_Berlin_T2;
    public Rectangle Frankfurt_Berlin_T3;
    public Rectangle Essen_Berlin_1;
    public Rectangle Essen_Berlin_2;


    @FXML
    protected void initialize(){
        this.bc = BoardController.getInstance();
        this.bc.registerPlayerObserver(this);

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
        String routeID = ((Shape) event.getSource()).getParent().getId();
        Rectangle r = (Rectangle) event.getSource();
       r.getLayoutX();
       r.getLayoutY();
       r.getRotate();

    }


    @Override
    public void update(PlayerModel playerModel) {
    }

    @FXML
    protected void endTurn() {
        bc.endTurn();
    }
}
