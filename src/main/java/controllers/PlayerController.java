package controllers;

import models.PlayerHandModel;
import models.TicketDeckModel;


public class PlayerController {

    private PlayerHandModel playerHandModel;
    private TicketDeckModel ticketDeckModel;

    private TrainCardDeckController trainCardDeckController;


    private void updatePlayerHand(){

    }

    private void pullTrainCard(){
        for (int i = 0; i < 3; i++){
            playerHandModel.playerHand.add(String.valueOf(trainCardDeckController.TrainDeck.remove(0)));


            System.out.println(playerHandModel.playerHand.get(0));
            playerHandModel.playerHand.remove(0);
        }

    }

    private void pullTicketCard(){
            playerHandModel.ticketHand.add(ticketDeckModel.ticketDeck.remove(0));
    }

    private void placeTrain(){

    }

    private void placeStation(){

    }


}
