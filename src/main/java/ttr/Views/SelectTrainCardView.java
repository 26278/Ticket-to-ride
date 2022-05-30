package ttr.Views;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import ttr.Controllers.TrainCardDeckController;
import ttr.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SelectTrainCardView {

    @FXML
    public javafx.scene.control.ListView ListView;

    TrainCardDeckController trainCardDeckController;

    @FXML
    protected void initialize() {
        this.trainCardDeckController = TrainCardDeckController.getInstance();
        this.createCardsListView();
        //        ArrayList<CheckBox> trainCardCheckboxes = this.trainCardDeckController.showPlayerTrainCards();
    }

    private void createCardsListView() {
        for (CheckBox trainCardCheckbox : trainCardDeckController.trainCardCheckboxes()) {
            ListView.getItems().add(trainCardCheckbox);
        }
    }


//    private Stage stage;
//    private Scene scene;
//    private Parent root;

//    @FXML
//    public void startSelectCards(MouseEvent event) throws IOException {
//        this.root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/selectCardsScreen.fxml"));
//        this.stage = (Stage)((Node) event.getSource()).getScene().getWindow();
//        this.scene = new Scene(root, 1000, 800);
//        stage.setScene(scene);
//
//        stage.show();
//    }

    public void confirmSelectedCards(MouseEvent mouseEvent) {
//        SelectTrainCardView word gesloten

//        Kaarten worden naar de Deposit stapel gegooid

//        BuildTrain functie word aangeroepen
    }

    @FXML
    protected void cancelSelectedCards(MouseEvent mouseEvent) {
//      reset choices

    }
}