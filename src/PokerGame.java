import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Class representing the poker game
class PokerGame {
 private final Deck deck;
 private final String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

 public PokerGame() {
     deck = new Deck();
 }

 public void playGame() {
     System.out.println("Shuffling ... Shuffling ... Shuffling ...");

     // Shuffle the deck before dealing
     deck.shuffle();

     // Deal a hand of 5 cards to the player
     List<Card> hand = deck.dealHand(5);

     // Print the player's hand
     System.out.print("Your hand: ");
     for (Card card : hand) {
         System.out.print(card + " ");
     }
     System.out.println();

     // Evaluate the player's hand and print the result
     PokerHand pokerHand = evaluateHand(hand);
     System.out.println("You have: " + pokerHand);
 }

 PokerHand evaluateHand(List<Card> hand) {
     // Map to store the count of each rank in the hand
     Map<String, Integer> rankCount = new HashMap<>();

     // Populate the rankCount map
     for (Card card : hand) {
         String rank = card.getRank();
         rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
     }

     // Check for different poker hands based on the provided rules
     if (isStraightFlush(hand)) {
         return PokerHand.STRAIGHT_FLUSH;
     } else if (isFourOfAKind(rankCount)) {
         return PokerHand.FOUR_OF_A_KIND;
     } else if (isFullHouse(rankCount)) {
         return PokerHand.FULL_HOUSE;
     } else if (isFlush(hand)) {
         return PokerHand.FLUSH;
     } else if (isStraight(hand)) {
         return PokerHand.STRAIGHT;
     } else if (isThreeOfAKind(rankCount)) {
         return PokerHand.THREE_OF_A_KIND;
     } else if (isTwoPair(rankCount)) {
         return PokerHand.TWO_PAIR;
     } else if (isOnePair(rankCount)) {
         return PokerHand.ONE_PAIR;
     } else {
         return PokerHand.HIGH_CARDS;
     }
 }

 private boolean isStraightFlush(List<Card> hand) {
     return isStraight(hand) && isFlush(hand);
 }

 private boolean isFourOfAKind(Map<String, Integer> rankCount) {
     return rankCount.containsValue(4);
 }

 private boolean isFullHouse(Map<String, Integer> rankCount) {
     return rankCount.containsValue(3) && rankCount.containsValue(2);
 }

 private boolean isFlush(List<Card> hand) {
     String firstSuit = hand.get(0).toString().substring(1, 2);
     return hand.stream().allMatch(card -> card.toString().substring(1, 2).equals(firstSuit));
 }

 private boolean isStraight(List<Card> hand) {
     Collections.sort(hand, (card1, card2) -> {
         int rank1 = Arrays.asList(ranks).indexOf(card1.getRank());
         int rank2 = Arrays.asList(ranks).indexOf(card2.getRank());
         return Integer.compare(rank1, rank2);
     });

     for (int i = 0; i < hand.size() - 1; i++) {
         if (Arrays.asList(ranks).indexOf(hand.get(i + 1).getRank()) - Arrays.asList(ranks).indexOf(hand.get(i).getRank()) != 1) {
             return false;
         }
     }

     return true;
 }

 private boolean isThreeOfAKind(Map<String, Integer> rankCount) {
     return rankCount.containsValue(3);
 }

 private boolean isTwoPair(Map<String, Integer> rankCount) {
     int pairs = 0;
     for (int count : rankCount.values()) {
         if (count == 2) {
             pairs++;
         }
     }
     return pairs == 2;
 }

 private boolean isOnePair(Map<String, Integer> rankCount) {
     return rankCount.containsValue(2);
 }
}