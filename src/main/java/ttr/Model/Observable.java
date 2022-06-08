package ttr.Model;

public interface Observable {

    void notifyObservers();
    void addObserver();
    void removeObserver();

}
