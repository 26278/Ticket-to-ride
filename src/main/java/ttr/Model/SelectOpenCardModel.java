package ttr.Model;

import ttr.Views.OpenCardObserver;
import java.util.ArrayList;



public class SelectOpenCardModel implements OpenCardObservable{
    ArrayList<String> taken_card = new ArrayList<>();
    ArrayList<String> Open_cards = new ArrayList<>();
    ArrayList<OpenCardObserver> observerlist = new ArrayList<>();

    public ArrayList<String> getOpen_cards() {
        return Open_cards;
    }


    public void setOpen_cards(ArrayList<String> deck){
        int count = 0;
        while (Open_cards.size() < 5){
            Open_cards.add(deck.get(count));
            count += 1;
        }
        notifyObservers();
    }




    public void Put_in_hand_and_replace(String id, ArrayList<TrainCardModel> deck, ArrayList<TrainCardModel> hand){
        String[] parts = id.split("_");
        int cardid = Integer.parseInt(parts[1]);
        for (int i = 0; i < Open_cards.size(); i++) {
            String color = Open_cards.get(i);
            if (taken_card.size() < 3 && i+1 == cardid) {
                    taken_card.add(color);
                    Open_cards.add((i), deck.get(0).getCardColor());
                    Open_cards.remove(i + 1);
                    deck.remove(deck.get(0));
                    notifyObservers();
                }
            }
            if (taken_card.size() == 2 || taken_card.get(0) == "rainbow") {
                System.out.println("volgende beurt");
                for (int i = 0; i < taken_card.size(); i++) {
                    hand.add(new TrainCardModel(taken_card.get(i)));
                }
                taken_card.clear();


            }
            notifyObservers();
        }



    @Override
    public void notifyObservers() {
        for (int i = 0; i < observerlist.size(); i++) {
            observerlist.get(i).update(this);

        }

    }

    @Override
    public void addObserver(OpenCardObserver boardview) {
        this.observerlist.add(boardview);

    }

    @Override
    public void removeObserver() {

    }
}
