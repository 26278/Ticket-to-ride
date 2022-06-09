package ttr.Views;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import ttr.Controllers.BoardController;
import ttr.Model.PlayerModel;
import ttr.Model.TrainModel;

import java.util.ArrayList;
import java.util.Objects;

public class BoardView implements PlayerObserver, TrainObserver {
    public Group Edinburgh_London_R;
    public Group Edinburgh_London_L;
    public Group Brest_Diepe;
    public Group Brest_Paris;
    public Group Diepe_Bruxelles;
    public Group Amsterdam_Bruxelles;
    public Group London_Diepe_L;
    public Group London_Diepe_R;
    public Group London_Amsterdam;
    public Group Bruxelles_Paris_R;
    public Group Bruxelles_Paris_L;
    public Group Brest_Pamplona;
    public Group Paris_Pamplona_R;
    public Group Paris_Pamplona_L;
    public Group Pamplona_Marseille;
    public Group Paris_Marseille;
    public Group Barcelona_Marseille;
    public Group Pamplona_Barcelona;
    public Group Madrid_Barcelona;
    public Group Pamplona_Madrid_R;
    public Group Pamplona_Madrid_L;
    public Group Lisboa_Madrid;
    public Group Cadiz_Madrid;
    public Group Lisboa_Cadiz;
    public Group Amsterdam_Essen;
    public Group Paris_Zurich;
    public Group Zurich_Marseille;
    public Group Bruxelles_Frankfurt;
    public Group Amsterdam_Frankfurt;
    public Group Paris_Frankfurt_T;
    public Group Paris_Frankfurt_B;
    public Group Frankfurt_Essen;
    public Group Frankfurt_Munchen;
    public Group Munchen_Zurich;
    public Group Zurich_Venezia;
    public Group Munchen_Venezia;
    public Group Venezia_Rome;
    public Group Marseille_Roma;
    public Group Roma_Palermo;
    public Group Brindisi_Palermo;
    public Group Roma_Brindisi;
    public Group Venezia_Zagrab;
    public Group Wien_Zagrab;
    public Group Munchen_Wien;
    public Group Frankfurt_Berlin_B;
    public Group Frankfurt_Berlin_T;
    public Group Essen_Berlin;
    public Group Essen_KObenhavn_L;
    public Group Essen_Kobenhavn_R;
    public Group Kobenhavn_Stockholm_L;
    public Group Kobenhavn_Stockholm_R;
    public Group Stockholm_Petrograd;
    public Group Berlin_Danzig;
    public Group Danzig_Waszawa;
    public Group Berlin_Warszawa_T;
    public Group Berlin_Warszawa_B;
    public Group Berlin_Wien;
    public Group Wien_Budapest_T;
    public Group Wien_Budapest_B;
    public Group Budapest_Zagrab;
    public Group Zagrab_Sarajevo;
    public Group Budapest_Sarajevo;
    public Group Warszawa_Wien;
    public Group Sarajevo_Athina;
    public Group Brindisi_Athina;
    public Group Palermo_Smyrna;
    public Group Athina_Smyrna;
    public Group Sofia_Athina;
    public Group Sarajevo_Sofia;
    public Group Danzig_Riga;
    public Group Riga_Petrograd;
    public Group Riga_Wilno;
    public Group Warszawa_Wilno;
    public Group Petrograd_Wilno;
    public Group Petrograd_Moskva;
    public Group Wilno_Smolensk;
    public Group Smolensk_Moskva;
    public Group Moskva_Kharkov;
    public Group Kyiv_Kharkov;
    public Group Wilno_Kyiv;
    public Group Warszawa_Kyiv;
    public Group Smolensk_Kyiv;
    public Group Kyiv_Budapest;
    public Group Kyiv_Bucuresti;
    public Group Budapest_Bucuresti;
    public Group Bucuresti_Sofia;
    public Group Kharkov_Rostov;
    public Group Rostov_Sochi;
    public Group Rostov_Sevastopol;
    public Group Sevastopol_Sochi;
    public Group Bucuresti_Sevastopol;
    public Group Angora_Erzurum;
    public Group Contantinople_Smyrna;
    public Group Contantinople_Angora;
    public Group Sevastopol_Erzurum;
    public Group Sevastopol_Constantinople;
    public Group Smyrna_Angora;
    public Group Sochi_Erzurum;
    public Group Sofia_Constantinople;
    public Group Bucuresti_Constantinople;

    @FXML
    public AnchorPane boardPane;
    private ArrayList<Node> groups;
    BoardController bc;


    @FXML
    protected void initialize() {
        this.groups = new ArrayList<>(boardPane.getChildren());
        this.bc = BoardController.getInstance();
        this.bc.registerPlayerObserver(this);
        this.bc.registerTrainObserver(this);

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
        Rectangle r = (Rectangle) event.getSource();
        bc.placeTrain(r.getParent().getId());
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

    @Override
    public void update(PlayerModel playerModel) {

    }


    @FXML
    protected void endTurn() {
        bc.endTurn();
    }

    @Override
    public void update(TrainModel trainModel) {
        paintTrain(trainModel.getGroupName(), trainModel.getColor());
    }
}
