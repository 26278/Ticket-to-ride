package ttr.Views;

import ttr.Model.TicketCardDeckModel;
import ttr.Model.TicketCardModel;

public interface TicketCardObserver {
    void update(TicketCardDeckModel ticketCardModel);
}
