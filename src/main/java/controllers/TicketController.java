package controllers;

import models.TicketModel;

public class TicketController {

    public TicketModel ticketModel;

    public void isCompleted(){
        //conditie moet uiteindelijk veranderd worden.
        if(true){
             ticketModel.completed = !ticketModel.completed;
        }
    }
}
