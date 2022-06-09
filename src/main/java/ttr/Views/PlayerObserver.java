package ttr.Views;

import javafx.scene.shape.Rectangle;
import ttr.Model.PlayerModel;

public interface PlayerObserver {
    void update(PlayerModel player);

}
