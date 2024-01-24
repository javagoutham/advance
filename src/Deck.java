import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
	
// Class representing a deck of cards
class Deck {
    private final String[] suits = {"♠", "♥", "♦", "♣"};
    private final String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    private final List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public List<Card> dealHand(int numCards) {
        List<Card> hand = new ArrayList<>();
        for (int i = 0; i < numCards; i++) {
            hand.add(cards.remove(0));
        }
        return hand;
    }
}