package controllers;

import models.PlayerHandModel;

public class test {
    public static TrainCardDeckController trainCardDeckController = new TrainCardDeckController();
    private static PlayerHandModel playerHandModel;
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
        trainCardDeckController.Shuffle();

        //Dit zal een button mouseEvent zijn
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //System.out.println(trainCardDeckController.TrainDeck.get(0));
                //trainCardDeckController.TrainDeck.remove(0);
                playerHandModel.playerHand.add(trainCardDeckController.TrainDeck.remove(0));
                System.out.println(playerHandModel.playerHand.get(0));
                playerHandModel.playerHand.remove(0);
            }
        }

        //System.out.println(trainDeck.get(i));





    }
}
