package ttr.Controllers;

import com.google.cloud.firestore.DocumentSnapshot;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import ttr.Model.FirebaseModel;
import ttr.Model.PlayerModel;

import java.io.IOException;
import java.util.Objects;

public class GameStartController implements Controller {
    PlayerModel player = new PlayerModel();
    FirebaseModel fbm = new FirebaseModel();


    public void playerSelect(ToggleGroup group) {
        player.setPlayerColor(getSelectedPlayer(group));
    }

    public void playerNameSubmit(TextField nameField) {
        player.setPlayerName(nameField.getText());
    }

    private String getSelectedPlayer(ToggleGroup group) {
        RadioButton groupSelected = (RadioButton) group.getSelectedToggle();

        return groupSelected.getText();

    }



    public void startGame(MouseEvent event) throws IOException {
        //change fxml file if following conditions are met: min 3 players with name, player starting is player 1 (red)
        if (Objects.equals(player.getPlayerColor(), "red")) {
            //load file

        }
    }

    @Override
    public void update(DocumentSnapshot ds) {

    }


}