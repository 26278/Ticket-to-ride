package ttr.Model;

/*
todo
ROTATION

*/

import javafx.scene.shape.Rectangle;
import ttr.Shared.trainObservable;
import ttr.Views.TrainObserver;

import java.util.ArrayList;
import java.util.List;

public class TrainModel implements trainObservable {
    private List<TrainObserver> observers = new ArrayList<TrainObserver>();


    public void placeTrain(Rectangle rect, PlayerModel player){
        // eerst firebase hier stop ik trein;
        // daarna een update naar de view;
        this.notifyObservers(rect, player);

    }

    @Override
    public void notifyObservers(Rectangle rect, PlayerModel player) {
        for (TrainObserver observer: this.observers){
            observer.update(rect, player);
        }
    }

    @Override
    public void addObserver(TrainObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(TrainObserver observer) {
        observers.remove(observer);
    }


}
