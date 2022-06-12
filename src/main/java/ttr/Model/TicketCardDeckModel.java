package ttr.Model;

import ttr.Constants.Locations;
import ttr.Views.TicketCardObserver;

import java.util.ArrayList;

public class TicketCardDeckModel implements ThreeTicketCardObservable {
    private static TicketCardDeckModel controller;
    private ArrayList<TicketCardModel> ticketCardDeck = new ArrayList<TicketCardModel>();
    ArrayList<TicketCardObserver> observerlist = new ArrayList<>();
    private ArrayList<TicketCardModel> returnHand = new ArrayList<>();

    public TicketCardDeckModel() {
        initDeck();
    }

    public void initDeck() {
        TicketCardModel ticket1 = new TicketCardModel("eu", Locations.Amsterdam, Locations.Pamplona, 7, false);
        ticketCardDeck.add(ticket1);
        TicketCardModel ticket2 = new TicketCardModel("eu", Locations.Amsterdam, Locations.Wilno, 12, false);
        ticketCardDeck.add(ticket2);
        TicketCardModel ticket3 = new TicketCardModel("eu", Locations.Angora, Locations.Kharkov, 10, false);
        ticketCardDeck.add(ticket3);
        TicketCardModel ticket4 = new TicketCardModel("eu", Locations.Athina, Locations.Angora, 5, false);
        ticketCardDeck.add(ticket4);
        TicketCardModel ticket5 = new TicketCardModel("eu", Locations.Athina, Locations.Wilno, 11, false);
        ticketCardDeck.add(ticket5);
        TicketCardModel ticket6 = new TicketCardModel("eu", Locations.Barcelona, Locations.Bruxelles, 8, false);
        ticketCardDeck.add(ticket6);
        TicketCardModel ticket7 = new TicketCardModel("eu", Locations.Barcelona, Locations.Munchen, 8, false);
        ticketCardDeck.add(ticket7);
        TicketCardModel ticket8 = new TicketCardModel("eu", Locations.Berlin, Locations.Bucuresti, 8, false);
        ticketCardDeck.add(ticket8);
        TicketCardModel ticket9 = new TicketCardModel("eu", Locations.Berlin, Locations.Moskva, 12, false);
        ticketCardDeck.add(ticket9);
        TicketCardModel ticket10 = new TicketCardModel("eu", Locations.Berlin, Locations.Roma, 9, false);
        ticketCardDeck.add(ticket10);
        TicketCardModel ticket11 = new TicketCardModel("eu", Locations.Brest, Locations.Marseille, 7, false);
        ticketCardDeck.add(ticket11);
        TicketCardModel ticket12 = new TicketCardModel("eu", Locations.Brest, Locations.Petrograd, 20, false);
        ticketCardDeck.add(ticket12);
        TicketCardModel ticket13 = new TicketCardModel("eu", Locations.Brest, Locations.Venezia, 8, false);
        ticketCardDeck.add(ticket13);
        TicketCardModel ticket14 = new TicketCardModel("eu", Locations.Bruxelles, Locations.Danzig, 9, false);
        ticketCardDeck.add(ticket14);
        TicketCardModel ticket15 = new TicketCardModel("eu", Locations.Budapest, Locations.Sofia, 5, false);
        ticketCardDeck.add(ticket15);
        TicketCardModel ticket16 = new TicketCardModel("eu", Locations.Cadiz, Locations.Stockholm, 21, false);
        ticketCardDeck.add(ticket16);
        TicketCardModel ticket17 = new TicketCardModel("eu", Locations.Edinburgh, Locations.Athina, 21, false);
        ticketCardDeck.add(ticket17);
        TicketCardModel ticket18 = new TicketCardModel("eu", Locations.Edinburgh, Locations.Paris, 7, false);
        ticketCardDeck.add(ticket18);
        TicketCardModel ticket19 = new TicketCardModel("eu", Locations.Essen, Locations.Kyiv, 10, false);
        ticketCardDeck.add(ticket19);
        TicketCardModel ticket20 = new TicketCardModel("eu", Locations.Frankfurt, Locations.Kobenhavn, 5, false);
        ticketCardDeck.add(ticket20);
        TicketCardModel ticket21 = new TicketCardModel("eu", Locations.Frankfurt, Locations.Smolensk, 13, false);
        ticketCardDeck.add(ticket21);
        TicketCardModel ticket22 = new TicketCardModel("eu", Locations.Kobenhavn, Locations.Erzurum, 21, false);
        ticketCardDeck.add(ticket22);
        TicketCardModel ticket23 = new TicketCardModel("eu", Locations.Kyiv, Locations.Petrograd, 6, false);
        ticketCardDeck.add(ticket23);
        TicketCardModel ticket24 = new TicketCardModel("eu", Locations.Kyiv, Locations.Sochi, 8, false);
        ticketCardDeck.add(ticket24);
        TicketCardModel ticket25 = new TicketCardModel("eu", Locations.Lisboa, Locations.Danzig, 20, false);
        ticketCardDeck.add(ticket25);
        TicketCardModel ticket26 = new TicketCardModel("eu", Locations.London, Locations.Berlin, 7, false);
        ticketCardDeck.add(ticket26);
        TicketCardModel ticket27 = new TicketCardModel("eu", Locations.London, Locations.Wien, 10, false);
        ticketCardDeck.add(ticket27);
        TicketCardModel ticket28 = new TicketCardModel("eu", Locations.Madrid, Locations.Diepe, 8, false);
        ticketCardDeck.add(ticket28);
        TicketCardModel ticket29 = new TicketCardModel("eu", Locations.Madrid, Locations.Zurich, 8, false);
        ticketCardDeck.add(ticket29);
        TicketCardModel ticket30 = new TicketCardModel("eu", Locations.Marseille, Locations.Essen, 8, false);
        ticketCardDeck.add(ticket30);
        TicketCardModel ticket31 = new TicketCardModel("eu", Locations.Palermo, Locations.Constantinople, 8, false);
        ticketCardDeck.add(ticket31);
        TicketCardModel ticket32 = new TicketCardModel("eu", Locations.Palermo, Locations.Moskva, 20, false);
        ticketCardDeck.add(ticket32);
        TicketCardModel ticket33 = new TicketCardModel("eu", Locations.Paris, Locations.Wien, 8, false);
        ticketCardDeck.add(ticket33);
        TicketCardModel ticket34 = new TicketCardModel("eu", Locations.Paris, Locations.Zagrab, 7, false);
        ticketCardDeck.add(ticket34);
        TicketCardModel ticket35 = new TicketCardModel("eu", Locations.Riga, Locations.Bucuresti, 10, false);
        ticketCardDeck.add(ticket35);
        TicketCardModel ticket36 = new TicketCardModel("eu", Locations.Roma, Locations.Smyrna, 8, false);
        ticketCardDeck.add(ticket36);
        TicketCardModel ticket37 = new TicketCardModel("eu", Locations.Rostov, Locations.Erzurum, 5, false);
        ticketCardDeck.add(ticket37);
        TicketCardModel ticket38 = new TicketCardModel("eu", Locations.Sarajevo, Locations.Sevastopol, 8, false);
        ticketCardDeck.add(ticket38);
        TicketCardModel ticket39 = new TicketCardModel("eu", Locations.Smolensk, Locations.Rostov, 8, false);
        ticketCardDeck.add(ticket39);
        TicketCardModel ticket40 = new TicketCardModel("eu", Locations.Sofia, Locations.Smyrna, 5, false);
        ticketCardDeck.add(ticket40);
        TicketCardModel ticket41 = new TicketCardModel("eu", Locations.Stockholm, Locations.Wien, 11, false);
        ticketCardDeck.add(ticket41);
        TicketCardModel ticket42 = new TicketCardModel("eu", Locations.Venezia, Locations.Constantinople, 10, false);
        ticketCardDeck.add(ticket42);
        TicketCardModel ticket43 = new TicketCardModel("eu", Locations.Warszawa, Locations.Smolensk, 6, false);
        ticketCardDeck.add(ticket43);
        TicketCardModel ticket44 = new TicketCardModel("eu", Locations.Zagrab, Locations.Brindisi, 6, false);
        ticketCardDeck.add(ticket44);
        TicketCardModel ticket45 = new TicketCardModel("eu", Locations.Zurich, Locations.Brindisi, 6, false);
        ticketCardDeck.add(ticket45);
        TicketCardModel ticket46 = new TicketCardModel("eu", Locations.Zurich, Locations.Budapest, 6, false);
        ticketCardDeck.add(ticket46);
    }

    public TicketCardModel searchForTicket(String loc1, String loc2) {
        for (TicketCardModel ticket : ticketCardDeck) {
            String dest1 = ticket.getFirst_Destination().toString().toLowerCase();
            String dest2 = ticket.getSecond_Destination().toString().toLowerCase();
            if (dest1.equals(loc1) && dest2.equals(loc2)) {
                return ticket;
            }
        }
        return null;
    }

    public void removeTicket(ArrayList<TicketCardModel> tickets) {
        ticketCardDeck.removeAll(tickets);
    }


    public static TicketCardDeckModel getInstance() {
        if (controller == null) {
            controller = new TicketCardDeckModel();
        }
        return controller;
    }

    public void pullThreeCards() {
        for (int i = 0; i < 3; i++) {
            returnHand.add(ticketCardDeck.remove(0));
        }
        notifyObservers();
    }

    public ArrayList<TicketCardModel> getReturnHand() {
        return returnHand;
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observerlist.size(); i++) {
            observerlist.get(i).update(this);
        }
    }

    @Override
    public void addObserver(TicketCardObserver boardview) {
        this.observerlist.add(boardview);

    }

    @Override
    public void removeObserver() {

    }
}
