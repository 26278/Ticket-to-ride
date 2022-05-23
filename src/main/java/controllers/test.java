package controllers;

public class test {
    public static TrainCardDeck trainCardDeck = new TrainCardDeck();

    public static void main(String[] args){
        for (int i = 0; i < 12; i++) {
            trainCardDeck.TrainDeck.add("red");
            trainCardDeck.TrainDeck.add("blue");
            trainCardDeck.TrainDeck.add("yellow");
            trainCardDeck.TrainDeck.add("orange");
            trainCardDeck.TrainDeck.add("pink");
            trainCardDeck.TrainDeck.add("black");
            trainCardDeck.TrainDeck.add("white");
            trainCardDeck.TrainDeck.add("green");
            trainCardDeck.TrainDeck.add("rainbow");
        }
        trainCardDeck.Shuffle();

        //Dit zal een button onAction zijn
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(trainCardDeck.TrainDeck.get(0));
                //hier naar hand arraylist sturen ofzo

                //Dit gaat naar deposit
                trainCardDeck.TrainDeck.remove(0);
            }
        }

        //System.out.println(trainDeck.get(i));





    }
}
