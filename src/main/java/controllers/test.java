package controllers;

import javafx.scene.image.Image;
import models.PlayerHandModel;
import models.TicketDeckModel;
import models.TicketModel;
import models.TrainCardDeckModel;

public class test {
    public static TrainCardDeckController trainCardDeckController = new TrainCardDeckController();
    private static PlayerHandModel playerHandModel = new PlayerHandModel();

    private static TrainCardDeckModel trainCardDeckModel = new TrainCardDeckModel();

    public TicketDeckModel ticketDeckModel;
    public static void main(String[] args){
        for (int i = 0; i < 12; i++) {
            trainCardDeckModel.TrainDeck.add("red");
            trainCardDeckModel.TrainDeck.add("blue");
            trainCardDeckModel.TrainDeck.add("yellow");
            trainCardDeckModel.TrainDeck.add("orange");
            trainCardDeckModel.TrainDeck.add("pink");
            trainCardDeckModel.TrainDeck.add("black");
            trainCardDeckModel.TrainDeck.add("white");
            trainCardDeckModel.TrainDeck.add("green");
            trainCardDeckModel.TrainDeck.add("rainbow");
        }

        TicketModel ticket1 = new TicketModel("eu", "amsterdam", "pamplona", 100, false);
        TicketDeckModel.ticketDeck.add(ticket1);
        TicketModel ticket2 = new TicketModel("a", "java", "sa", 100, false);
        TicketDeckModel.ticketDeck.add(ticket2);

        for (TicketModel ticketModel: TicketDeckModel.ticketDeck){
            System.out.println(ticketModel.getRewardPoints());
            //Image image = new Image(ticketModel.getType()+"-"+ticketModel.getBegin_Destination()+"-"+ticketModel.getEnd_Destination()+".png");
        }

        trainCardDeckController.Shuffle();

        //Dit zal een button mouseEvent zijn
        for (int i = 0; i < 3; i++) {
            playerHandModel.playerHand.add(trainCardDeckModel.TrainDeck.remove(0));
            //System.out.println(playerHandModel.playerHand.get(0));
            playerHandModel.playerHand.remove(0);
        }
    }
}
