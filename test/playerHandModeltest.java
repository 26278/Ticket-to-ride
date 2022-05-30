import models.PlayerHandModel;
import models.TicketDeckModel;
import models.TicketModel;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import controllers.TrainCardDeckController;

public class playerHandModeltest {

    @Test
    public void test_playerHandModel_Train(){
        TrainCardDeckController trainCardDeckController = new TrainCardDeckController();
        PlayerHandModel playerHandModel = new PlayerHandModel();
        trainCardDeckController.TrainDeck.add("test1");
        trainCardDeckController.TrainDeck.add("test2");

        playerHandModel.playerHand.add(String.valueOf(trainCardDeckController.TrainDeck.remove(0)));
        playerHandModel.playerHand.add(String.valueOf(trainCardDeckController.TrainDeck.remove(0)));

        assertEquals(Arrays.asList("test1", "test2"), playerHandModel.playerHand);

    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_playerHandModel_Train_unsupported(){
        TrainCardDeckController trainCardDeckController = new TrainCardDeckController();
        PlayerHandModel playerHandModel = new PlayerHandModel();
        trainCardDeckController.TrainDeck.add(1);

        playerHandModel.playerHand.add(String.valueOf(trainCardDeckController.TrainDeck.remove(0)));
    }

    @Test
    public void test_playerHandModel_Ticket(){
        PlayerHandModel playerHandModel = new PlayerHandModel();
        TicketDeckModel ticketDeckModel = new TicketDeckModel();
        TicketModel ticket1 = new TicketModel("a", "Test", "model", 123, false);
        ticketDeckModel.ticketDeck.add(ticket1);

        playerHandModel.ticketHand.add(TicketDeckModel.ticketDeck.remove(0));


    }
}
