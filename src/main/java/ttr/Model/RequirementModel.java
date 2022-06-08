package ttr.Model;

public class RequirementModel implements RequirementObservable {
    private String trainCardColor;
    private int trainCardCount;
    private boolean isTunnelBoolean;

    public RequirementModel(String trainCardColor, int trainCardCount, boolean isTunnelBoolean) {
        this.trainCardColor = trainCardColor;
        this.trainCardCount = trainCardCount;
        this.isTunnelBoolean = isTunnelBoolean;
    }

    @Override
    public void addRequirementObserver(RequirementObserver requirementObserver) {
        requirementObserverList.add(requirementObserver);
    }

    @Override
    public void removeRequirementObserver(RequirementObserver requirementObserver) {
        requirementObserverList.remove(requirementObserver);
    }

    @Override
    public void notifyRequirementObservers() {
        for (RequirementObserver requirementObserver : requirementObserverList) {
            requirementObserver.update(trainCardColor, trainCardCount, isTunnelBoolean);
        }
    }

    public void setRequirement(String requirementTrainCardColor, int requirementTrainCardCount, boolean requirementIsTunnelBoolean) {
        trainCardColor = requirementTrainCardColor;
        trainCardCount = requirementTrainCardCount;
        isTunnelBoolean = requirementIsTunnelBoolean;
        notifyRequirementObservers();
    }
}
