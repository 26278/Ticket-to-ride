package controllers;

import models.PlayerHandModel;
import models.TicketDeckModel;
import models.TicketModel;

public class test {
    public static TrainCardDeckController trainCardDeckController = new TrainCardDeckController();
    private static PlayerHandModel playerHandModel;

    public TicketDeckModel ticketDeckModel;
    public static void main(String[] args){
        for (int i = 0; i < 12; i++) {
            trainCardDeckController.TrainDeck.add("red");
            trainCardDeckController.TrainDeck.add("blue");
            trainCardDeckController.TrainDeck.add("yellow");
            trainCardDeckController.TrainDeck.add("orange");
            trainCardDeckController.TrainDeck.add("pink");
            trainCardDeckController.TrainDeck.add("black");
            trainCardDeckController.TrainDeck.add("white");
            trainCardDeckController.TrainDeck.add("green");
            trainCardDeckController.TrainDeck.add("rainbow");
        }

        TicketModel ticket1 = new TicketModel("a", "java", "sa", 100, false);
        TicketDeckModel.ticketDeck.add(ticket1);
        TicketModel ticket2 = new TicketModel("a", "java", "sa", 100, false);
        TicketDeckModel.ticketDeck.add(ticket2);

        for (TicketModel ticketModel: TicketDeckModel.ticketDeck){
            System.out.println(ticketModel.getRewardPoints());
        }

        trainCardDeckController.Shuffle();

        //Dit zal een button mouseEvent zijn
        for (int i = 0; i < 3; i++) {
            playerHandModel.playerHand.add(trainCardDeckController.TrainDeck.remove(0));
            //System.out.println(playerHandModel.playerHand.get(0));
            playerHandModel.playerHand.remove(0);
        }
    }
}
