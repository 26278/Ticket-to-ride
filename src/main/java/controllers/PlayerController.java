package controllers;

import models.PlayerModel;

import static controllers.test.trainCardDeckController;

public class PlayerController {


    private void updatePlayerHand(){

    }

    private void pullTrainCard(){
        for (int i = 0; i < 3; i++){
            models.PlayerModel.playerHand.add(trainCardDeckController.TrainDeck.remove(0));
            System.out.println(PlayerModel.playerHand.get(0));
            PlayerModel.playerHand.remove(0);
            //hier naar deposit sturen i.p.v. removen
            trainCardDeckController.TrainDeck.remove(0);
        }

    }

    private void pullTicketCard(){

    }

    private void placeTrain(){

    }

    private void placeStation(){

    }


}
