package ttr.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import ttr.Controllers.TrainCardDeckController;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class SelectTrainCardView {

    @FXML
    public javafx.scene.control.ListView ListView;
    public javafx.scene.control.TextField RequirementTextField;

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
        RequirementTextField.setText(requirement);
    }

    private void createCardsListView() {
        for (CheckBox trainCardCheckbox : trainCardDeckController.trainCardCheckboxes()) {
            trainCardCheckbox.applyCss();
            ListView.getItems().add(trainCardCheckbox);
        }
    }

    private void showRequirement() {

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
    protected void cancelSelectedCards(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/ttr/fxml/view.fxml"));
        this.stage = (Stage)((Node) mouseEvent.getSource()).getScene().getWindow();
        this.scene = new Scene(root, 1000, 800);
        stage.setScene(scene);
        stage.show();
    }
}