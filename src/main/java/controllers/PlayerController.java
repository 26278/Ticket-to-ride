package controllers;

import javafx.scene.image.Image;
import models.PlayerHandModel;
import models.TicketDeckModel;
import models.TicketModel;
import models.TrainCardDeckModel;


public class PlayerController {

    private PlayerHandModel playerHandModel;
    private TicketDeckModel ticketDeckModel;

    private TrainCardDeckModel trainCardDeckModel;

    private Image image;


    private void updatePlayerHand(){

    }

    private void pullTrainCard(){
        for (int i = 0; i < 3; i++){
            playerHandModel.playerHand.add(String.valueOf(trainCardDeckModel.TrainDeck.remove(0)));


            System.out.println(playerHandModel.playerHand.get(0));
            playerHandModel.playerHand.remove(0);
        }

    }

    private void pullTicketCard(){
        playerHandModel.ticketHand.add(ticketDeckModel.ticketDeck.get(0));
        for (TicketModel ticketModel : playerHandModel.ticketHand) {
            image = new Image(ticketModel.getType() + "-" + ticketModel.getFirst_Destination() + "-" + ticketModel.getSecond_Destination()+".png");
        }
    }

    private void placeTrain(){

    }

    private void placeStation(){

    }


}
