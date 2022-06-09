package ttr.Views;

import javafx.scene.shape.Rectangle;
import ttr.Model.PlayerModel;
import ttr.Model.TrainModel;

public interface TrainObserver {
    void update(TrainModel trainModel);
}
