package ttr.Views;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import ttr.Controllers.GameLoginController;

import java.io.IOException;
import java.util.Locale;

public class GameLoginView {
    GameLoginController glc = new GameLoginController();

    @FXML
    protected TextField tokenTextField;

    @FXML
    protected void setGameToken(MouseEvent event) throws IOException {
        String token = tokenTextField.getText().toUpperCase(Locale.ROOT);

        if (token.length() == 6) {
            glc.joinGame(token, event);
        }
    }


}
