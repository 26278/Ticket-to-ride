package ttr.Views;

import com.google.cloud.firestore.DocumentSnapshot;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import ttr.Controllers.Controller;
import ttr.Controllers.GameStartController;
import ttr.Controllers.TrainCardDeckController;

import java.io.IOException;
import java.util.Objects;

public class GameStartView implements Controller {

    @FXML
    GameStartController gsc = new GameStartController();

    @FXML
    protected ToggleGroup group;

    @FXML
    protected TextField nameField;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    protected void playerSelect() {
        gsc.playerSelect(group);
    }

    @FXML
    protected void playerNameSubmit() {
        gsc.playerNameSubmit(nameField);
    }

    @FXML
    protected void startGame() {
        gsc.startGame();
    }

    @FXML
    protected void endTurn() {
        gsc.endTurn();
    }


    @Override
    public void update(DocumentSnapshot ds) {

    }

    @FXML
    public void chooseCard(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/ttr/fxml/selectCardsScreen.fxml"));
        this.stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        this.scene = new Scene(root, 1000, 800);
        scene.getStylesheets().add(
                Objects.requireNonNull(getClass().getResource("/ttr/stylesheets/chooseCards.css"))
                        .toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}