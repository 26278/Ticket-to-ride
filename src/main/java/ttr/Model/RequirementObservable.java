package ttr.Model;

import java.util.ArrayList;

public interface RequirementObservable {
    ArrayList<RequirementObserver> requirementObserverList = new ArrayList<RequirementObserver>();

    void addRequirementObserver(RequirementObserver requirementObserver);
    void removeRequirementObserver(RequirementObserver requirementObserver);
    void notifyRequirementObservers();
}
