package ttr.Views;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import ttr.Controllers.GameLoginController;

public class RulesView {
    public ScrollPane scrollpane;
    GameLoginController glc = new GameLoginController();


    @FXML
    protected void initialize(){

    }


    public void backClicked(MouseEvent event) {
        glc.loadFile(event, "game_login.fxml");

    }
}
