import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class PokerGameTest {

    @Test
    public void testEvaluateHandFourOfAKind() {
        PokerGame pokerGame = new PokerGame();
        // Create a four of a kind hand (e.g., 7♠ 7♥ 7♦ 7♣ 2♠)
        assertTrue(pokerGame.evaluateHand(Arrays.asList(
                new Card("♠", "7"),
                new Card("♥", "7"),
                new Card("♦", "7"),
                new Card("♣", "7"),
                new Card("♠", "2")
        )) == PokerHand.FOUR_OF_A_KIND);
    }

    @Test
    public void testEvaluateHandHighCards() {
        PokerGame pokerGame = new PokerGame();
        // Create a high card hand (e.g., A♠ 10♦ 8♣ 5♥ 2♠)
        assertTrue(pokerGame.evaluateHand(Arrays.asList(
                new Card("♠", "A"),
                new Card("♦", "10"),
                new Card("♣", "8"),
                new Card("♥", "5"),
                new Card("♠", "2")
        )) == PokerHand.HIGH_CARDS);
    }
}
