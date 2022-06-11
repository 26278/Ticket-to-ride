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

        TicketModel ticket1 = new TicketModel("eu", "amsterdam", "pamplona", 7, false);
        TicketDeckModel.ticketDeck.add(ticket1);
        TicketModel ticket2 = new TicketModel("eu", "amsterdam", "wilno", 12, false);
        TicketDeckModel.ticketDeck.add(ticket2);
        TicketModel ticket3 = new TicketModel("eu", "angero", "kharkov", 10, false);
        TicketDeckModel.ticketDeck.add(ticket3);
        TicketModel ticket4 = new TicketModel("eu", "athina", "angora", 5, false);
        TicketDeckModel.ticketDeck.add(ticket4);
        TicketModel ticket5 = new TicketModel("eu", "athina", "wilno", 11, false);
        TicketDeckModel.ticketDeck.add(ticket5);
        TicketModel ticket6 = new TicketModel("eu", "barcelona", "bruxelles", 8, false);
        TicketDeckModel.ticketDeck.add(ticket6);
        TicketModel ticket7 = new TicketModel("eu", "barcelona", "munchen", 8, false);
        TicketDeckModel.ticketDeck.add(ticket7);
        TicketModel ticket8 = new TicketModel("eu", "berlin", "bucuresti", 8, false);
        TicketDeckModel.ticketDeck.add(ticket8);
        TicketModel ticket9 = new TicketModel("eu", "berlin", "moskva", 12, false);
        TicketDeckModel.ticketDeck.add(ticket9);
        TicketModel ticket10 = new TicketModel("eu", "berlin", "roma", 9, false);
        TicketDeckModel.ticketDeck.add(ticket10);
        TicketModel ticket11 = new TicketModel("eu", "brest", "marseille", 7, false);
        TicketDeckModel.ticketDeck.add(ticket11);
        TicketModel ticket12 = new TicketModel("eu", "brest", "petrograd", 20, false);
        TicketDeckModel.ticketDeck.add(ticket12);
        TicketModel ticket13 = new TicketModel("eu", "brest", "venezia", 8, false);
        TicketDeckModel.ticketDeck.add(ticket13);
        TicketModel ticket14 = new TicketModel("eu", "bruxelles", "danzig", 9, false);
        TicketDeckModel.ticketDeck.add(ticket14);
        TicketModel ticket15 = new TicketModel("eu", "budapest", "sofia", 5, false);
        TicketDeckModel.ticketDeck.add(ticket15);
        TicketModel ticket16 = new TicketModel("eu", "cadiz", "stockholm", 21, false);
        TicketDeckModel.ticketDeck.add(ticket16);
        TicketModel ticket17 = new TicketModel("eu", "edinburgh", "athina", 21, false);
        TicketDeckModel.ticketDeck.add(ticket17);
        TicketModel ticket18 = new TicketModel("eu", "edinburgh", "paris", 7, false);
        TicketDeckModel.ticketDeck.add(ticket18);
        TicketModel ticket19 = new TicketModel("eu", "essen", "kyiv", 10, false);
        TicketDeckModel.ticketDeck.add(ticket19);
        TicketModel ticket20 = new TicketModel("eu", "frankfurt", "kobenhavn", 5, false);
        TicketDeckModel.ticketDeck.add(ticket20);
        TicketModel ticket21 = new TicketModel("eu", "frankfurt", "smolensk", 13, false);
        TicketDeckModel.ticketDeck.add(ticket21);
        TicketModel ticket22 = new TicketModel("eu", "kobenhavn", "erzurum", 21, false);
        TicketDeckModel.ticketDeck.add(ticket22);
        TicketModel ticket23 = new TicketModel("eu", "kyiv", "petrograd", 6, false);
        TicketDeckModel.ticketDeck.add(ticket23);
        TicketModel ticket24 = new TicketModel("eu", "kyiv", "sochi", 8, false);
        TicketDeckModel.ticketDeck.add(ticket24);
        TicketModel ticket25 = new TicketModel("eu", "lisboa", "danzig", 20, false);
        TicketDeckModel.ticketDeck.add(ticket25);
        TicketModel ticket26 = new TicketModel("eu", "london", "berlin", 7, false);
        TicketDeckModel.ticketDeck.add(ticket26);
        TicketModel ticket27 = new TicketModel("eu", "london", "wien", 10, false);
        TicketDeckModel.ticketDeck.add(ticket27);
        TicketModel ticket28 = new TicketModel("eu", "madrid", "dieppe", 8, false);
        TicketDeckModel.ticketDeck.add(ticket28);
        TicketModel ticket29 = new TicketModel("eu", "madrid", "zurich", 8, false);
        TicketDeckModel.ticketDeck.add(ticket29);
        TicketModel ticket30 = new TicketModel("eu", "marseille", "essen", 8, false);
        TicketDeckModel.ticketDeck.add(ticket30);
        TicketModel ticket31 = new TicketModel("eu", "palermo", "constantinople", 8, false);
        TicketDeckModel.ticketDeck.add(ticket31);
        TicketModel ticket32 = new TicketModel("eu", "palermo", "moskva", 20, false);
        TicketDeckModel.ticketDeck.add(ticket32);
        TicketModel ticket33 = new TicketModel("eu", "paris", "wien", 8, false);
        TicketDeckModel.ticketDeck.add(ticket33);
        TicketModel ticket34 = new TicketModel("eu", "paris", "zagrab", 7, false);
        TicketDeckModel.ticketDeck.add(ticket34);
        TicketModel ticket35 = new TicketModel("eu", "riga", "bucuresti", 10, false);
        TicketDeckModel.ticketDeck.add(ticket35);
        TicketModel ticket36 = new TicketModel("eu", "roma", "smyrna", 8, false);
        TicketDeckModel.ticketDeck.add(ticket36);
        TicketModel ticket37 = new TicketModel("eu", "rostov", "erzurum", 5, false);
        TicketDeckModel.ticketDeck.add(ticket37);
        TicketModel ticket38 = new TicketModel("eu", "sarajevo", "sevastopol", 8, false);
        TicketDeckModel.ticketDeck.add(ticket38);
        TicketModel ticket39 = new TicketModel("eu", "smolenks", "rostov", 8, false);
        TicketDeckModel.ticketDeck.add(ticket39);
        TicketModel ticket40 = new TicketModel("eu", "sofia", "smyrna", 5, false);
        TicketDeckModel.ticketDeck.add(ticket40);
        TicketModel ticket41 = new TicketModel("eu", "stockholm", "wien", 11, false);
        TicketDeckModel.ticketDeck.add(ticket41);
        TicketModel ticket42 = new TicketModel("eu", "venezia", "constantinople", 10, false);
        TicketDeckModel.ticketDeck.add(ticket42);
        TicketModel ticket43 = new TicketModel("eu", "warszawa", "smolensk", 6, false);
        TicketDeckModel.ticketDeck.add(ticket43);
        TicketModel ticket44 = new TicketModel("eu", "zagrab", "brindisi", 6, false);
        TicketDeckModel.ticketDeck.add(ticket44);
        TicketModel ticket45 = new TicketModel("eu", "zurich", "brindisi", 6, false);
        TicketDeckModel.ticketDeck.add(ticket45);
        TicketModel ticket46 = new TicketModel("eu", "zurich", "budapest", 6, false);
        TicketDeckModel.ticketDeck.add(ticket46);

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
