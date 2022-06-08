package ttr.Model;

import javafx.scene.shape.Rectangle;

public interface Observable {

    void notifyObservers();

    void notifyObservers(Rectangle rect, PlayerModel player);

    void addObserver();
    void removeObserver();

}
