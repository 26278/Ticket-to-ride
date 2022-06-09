package controllers;

import models.PlayerHandModel;
import models.TicketModel;

public class TicketController {
    private PlayerHandModel playerHandModel;
    private TicketModel ticketModel;
    public void isCompleted(){
        //conditie moet uiteindelijk veranderd worden.
        //if(//road is completed){
            ticketModel.setCompleted(true);
            //completed = !completed;
        //}
    }
}
