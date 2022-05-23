package controllers;

import models.PlayerModel;

public class test {
    public static TrainCardDeckController trainCardDeckController = new TrainCardDeckController();

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
                //hier naar hand arraylist sturen ofzo
                //System.out.println(trainCardDeckController.TrainDeck.get(0));
                //Dit gaat naar deposit
                //trainCardDeckController.TrainDeck.remove(0);
                models.PlayerModel.playerHand.add(trainCardDeckController.TrainDeck.remove(0));
                System.out.println(PlayerModel.playerHand.get(0));
                PlayerModel.playerHand.remove(0);
            }
        }

        //System.out.println(trainDeck.get(i));





    }
}
