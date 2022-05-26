package ttr.Controllers;

import com.google.firebase.internal.FirebaseService;
import ttr.Model.PlayerModel;
import ttr.Model.TrainCardDeckModel;
import ttr.Model.TrainCardModel;
import ttr.Services.FirestoreService;

public class PlayerController {
    PlayerModel playerModel = new PlayerModel();
    TrainCardDeckModel trainCardDeck = new TrainCardDeckModel();
    FirestoreService fs = new FirestoreService();


    private void updatePlayerHand(){

    }

    private void pullTrainCard(){
//        TrainCardModel card = trainCardDeck();
        //add card to hand in playermodel
//        playerModel.pullCard(card);

    }

    private void pullTicketCard(){

    }

    private void placeTrain(){

    }

    private void placeStation(){

    }


}
