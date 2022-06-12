package ttr.Views;

import ttr.Model.StationModel;


public interface StationObserver {
    void notifyObservers();

    void addObserver(StationObserver observer);

    void removeObserver(StationObserver observer);

    void update(StationModel stationModel);
}
