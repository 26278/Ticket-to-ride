package models;

public class TicketModel {

    private String type;
    private String begin_Destination;
    private String end_Destination;
    private Integer rewardPoints;
    private boolean completed;

    public TicketModel(String type, String begin_Destination, String end_Destination, Integer rewardPoints, boolean completed) {
        this.type = type;
        this.begin_Destination = begin_Destination;
        this.end_Destination = end_Destination;
        this.rewardPoints = rewardPoints;
        this.completed = completed;
    }

    public String getType() {
        return type;
    }

    public String getBegin_Destination() {
        return begin_Destination;
    }

    public String getEnd_Destination() {
        return end_Destination;
    }

    public Integer getRewardPoints() {
        return rewardPoints;
    }

    public boolean isCompleted() {
        return completed;
    }
}
