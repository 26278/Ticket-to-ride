package controllers;

import static controllers.test.trainCardDeckController;

public class PlayerController {


    private void updatePlayerHand(){

    }

    private void pullTrainCard(){
        for (int i = 0; i < 3; i++){
            trainCardDeckController.TrainDeck.get(0);
            //hier naar hand arraylist sturen ofzo

            //hier naar deposit sturen ipv removen
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
