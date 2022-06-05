package ttr.Shared;

import ttr.Views.GameStartObserver;
import ttr.Views.PlayerObserver;

public interface GameStartObservable {
    void notifyObservers();
    void addObserver(GameStartObserver observer);
    void removeObserver(GameStartObserver observer);
}
