package controllers;

import models.TicketModel;

public class TicketController {

    public TicketModel ticketModel;

    public void isCompleted(){
        if(true){
             ticketModel.completed = !ticketModel.completed;
        }
    }
}
