package models;

public class TicketModel {

    private String type;
    private String first_Destination;
    private String second_Destination;
    private Integer rewardPoints;
    private boolean completed;

    public TicketModel(String type, String first_Destination, String second_Destination, Integer rewardPoints, boolean completed) {
        this.type = type;
        this.first_Destination = first_Destination;
        this.second_Destination = second_Destination;
        this.rewardPoints = rewardPoints;
        this.completed = completed;
    }

    public String getType() {
        return type;
    }

    public String getFirst_Destination() {
        return first_Destination;
    }

    public String getSecond_Destination() {
        return second_Destination;
    }

    public Integer getRewardPoints() {
        return rewardPoints;
    }

    public boolean getCompleted() {
        return completed;
    }
}
