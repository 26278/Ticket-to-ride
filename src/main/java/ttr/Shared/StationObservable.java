package ttr.Shared;

import ttr.Views.StationObserver;
import ttr.Views.TrainObserver;

public interface StationObservable {
    void notifyObservers();

    void addObserver(StationObserver observer);

    void removeObserver(StationObserver observer);
}
