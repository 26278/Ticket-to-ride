package ttr.Model;

import java.util.ArrayList;

public interface Observable {

    void notifyObservers();
    void addObserver();
    void removeObserver();
}
