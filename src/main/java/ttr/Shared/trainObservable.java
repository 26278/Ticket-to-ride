package ttr.Shared;

import javafx.scene.shape.Rectangle;
import ttr.Model.PlayerModel;
import ttr.Views.PlayerObserver;
import ttr.Views.TrainObserver;

public interface trainObservable {
    void notifyObservers(Rectangle rect, PlayerModel player);

    void addObserver(TrainObserver observer);

    void removeObserver(TrainObserver observer);
}
