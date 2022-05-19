package models;

public interface Observable {

    void notifyObservers();
    void addObserver();
    void removeObserver();

}
