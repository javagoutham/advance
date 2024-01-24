// Class representing a playing card
class Card {
    private final String suit;
    private final String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return rank + suit;
    }

    public String getRank() {
        return rank;
    }
}