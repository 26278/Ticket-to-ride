import models.PlayerHandModel;
import models.TicketDeckModel;
import models.TicketModel;
import models.TrainCardDeckModel;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import controllers.TrainCardDeckController;

public class playerHandModeltest {

    @Test
    public void test_playerHandModel_Train(){
        TrainCardDeckModel trainCardDeckModel = new TrainCardDeckModel();
        PlayerHandModel playerHandModel = new PlayerHandModel();
        trainCardDeckModel.TrainDeck.add("test1");
        trainCardDeckModel.TrainDeck.add("test2");

        playerHandModel.playerHand.add(String.valueOf(trainCardDeckModel.TrainDeck.remove(0)));
        playerHandModel.playerHand.add(String.valueOf(trainCardDeckModel.TrainDeck.remove(0)));

        assertEquals(Arrays.asList("test1", "test2"), playerHandModel.playerHand);

    }

    @Test(expected = AssertionError.class)
    public void test_playerHandModel_Train_unsupported(){
        PlayerHandModel playerHandModel = new PlayerHandModel();
        TrainCardDeckModel trainCardDeckModel = new TrainCardDeckModel();
        trainCardDeckModel.TrainDeck.add("test1");

        assertNull(playerHandModel.playerHand);
    }

    @Test
    public void test_playerHandModel_Ticket(){
        PlayerHandModel playerHandModel = new PlayerHandModel();
        TicketDeckModel ticketDeckModel = new TicketDeckModel();
        TicketModel ticket1 = new TicketModel("a", "Test", "model", 123, false);
        ticketDeckModel.ticketDeck.add(ticket1);

        playerHandModel.ticketHand.add(ticketDeckModel.ticketDeck.remove(0));

        for (TicketModel ticketModel : ticketDeckModel.ticketDeck){
            ticketModel.getType();
            ticketModel.getBegin_Destination();
            ticketModel.getEnd_Destination();
            ticketModel.getRewardPoints();
            ticketModel.isCompleted();

            assertEquals("a", playerHandModel.ticketHand.get(0));
            assertEquals("Test", playerHandModel.ticketHand.get(1));
            assertEquals("model", playerHandModel.ticketHand.get(2));
            assertEquals(123, playerHandModel.ticketHand.get(3));
            assertEquals(false, playerHandModel.ticketHand.get(4));


        }
    }
}
