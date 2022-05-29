import org.junit.Test;
import ttr.Model.PlayerModel;
import ttr.Model.TrainCardModel;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class shuffleDiscardTest {

    @Test // Letop, deze annotatie moet wel voor een test staan
    public void test_shuffleDeck() {
        // Arrange
        PlayerModel player = new PlayerModel();
        ArrayList<TrainCardModel> testHand;
        int handSize;

        // act
        player.pullCardTester(1);
        testHand = player.getPlayerHand();
        handSize = testHand.size();

        // assert
        final int expected = 2;
        assertEquals(expected, handSize);

    }

    @Test
    public void test_PlayerPullOneBecauseRainbowCard() {
        // Arrange
        PlayerModel player = new PlayerModel();
        ArrayList<TrainCardModel> testHand;
        int handSize;

        // act
        player.pullCardTester(2);
        testHand = player.getPlayerHand();
        handSize = testHand.size();

        // assert
        final int expected = 1;
        assertEquals(expected, handSize);

    }


}
