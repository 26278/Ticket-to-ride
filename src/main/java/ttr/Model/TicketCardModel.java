package ttr.Model;

import ttr.Constants.Locations;

public class TicketCardModel {

    private String type;
    private Locations first_Destination;
    private Locations second_Destination;
    private Integer rewardPoints;
    private boolean completed;

    public TicketCardModel(String type, Locations first_Destination, Locations second_Destination, Integer rewardPoints,
                           boolean completed) {
        this.type = type;
        this.first_Destination = first_Destination;
        this.second_Destination = second_Destination;
        this.rewardPoints = rewardPoints;
        this.completed = completed;
    }

    public String getType() {
        return type;
    }

    public Locations getFirst_Destination() {
        return first_Destination;
    }

    public Locations getSecond_Destination() {
        return second_Destination;
    }

    public Integer getRewardPoints() {
        return rewardPoints;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
