package ttr.Views;

import javafx.scene.shape.Rectangle;
import ttr.Model.PlayerModel;

public interface TrainObserver {
    void update(Rectangle rect, PlayerModel player);

}
