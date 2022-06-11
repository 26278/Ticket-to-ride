package ttr.Views;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import ttr.Controllers.GameLoginController;
import ttr.Controllers.VolumeController;

import java.io.IOException;
import java.util.Locale;

public class GameLoginView {
    public VBox mainMenu;
    public VBox login;
    public VBox settings;
    GameLoginController glc = new GameLoginController();
    VolumeController vm = new VolumeController();

    @FXML
    protected TextField tokenTextField;

    @FXML
    protected void setGameToken(MouseEvent event) throws IOException {
        String token = tokenTextField.getText().toUpperCase(Locale.ROOT);

        if (token.length() == 6) {
            glc.joinGame(token, event);
        }
    }


    public void playClicked(MouseEvent event) {
        mainMenu.setVisible(false);
        login.setVisible(true);
    }

    public void closeClicked(MouseEvent event) {
        Platform.exit();
        System.exit(0);
    }

    public void settingsClicked(MouseEvent event) {
        mainMenu.setVisible(false);
        settings.setVisible(true);
    }
}
