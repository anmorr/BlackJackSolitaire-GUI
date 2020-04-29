import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
/**
 * This is the Deck class test suite
 * @author myThinkTank
 *
 */
class DeckTest {

	/**
	 * This case tests the createDeck() method from the Deck() class.
	 * The length of the deck should be 52 following the deck creation.
	 */
	@Test
	void testCreateDeck() {
		Deck myTestDeck = new Deck();
		Card[] myDeckofCards;
		myDeckofCards = myTestDeck.createDeck();
//		int currentCount = 0;
//		for(Card c : myDeckofCards) {
//			System.out.println("Rank and Suit: " + c.getRankandSuit() + " Value: " + "Index: " + currentCount);
//			currentCount++;
//		}
		assertEquals(myDeckofCards.length,52);
	}
	
	/**
	 * This case tests the spades suit for 13 total cards.
	 */
	@Test
	void testSpadesSuite() {
		Deck myTestDeck = new Deck();
		Card[] myDeckofCards;
		ArrayList<Card> spadesSuite = new ArrayList<Card>();
		myDeckofCards = myTestDeck.createDeck();
		for (Card c : myDeckofCards) {
			if(c.getRankandSuit().contains("S")) {
				spadesSuite.add(c);
			}
		}
		assertEquals(spadesSuite.size(),13, "The size is Spades suit incorrect.");
	}
	
	/**
	 * This case tests the Club suit for 13 total cards.
	 */
	@Test
	void testClubSuite() {
		Deck myTestDeck = new Deck();
		Card[] myDeckofCards;
		ArrayList<Card> clubSuite = new ArrayList<Card>();
		myDeckofCards = myTestDeck.createDeck();
		for (Card c : myDeckofCards) {
			if(c.getRankandSuit().contains("C")) {
				clubSuite.add(c);
			}
		}
		assertEquals(clubSuite.size(),13, "The size is Club suit incorrect.");
	}
	
	/**
	 * This case tests the Heart suit for 13 total cards.
	 */
	@Test
	void testHeartSuite() {
		Deck myTestDeck = new Deck();
		Card[] myDeckofCards;
		ArrayList<Card> heartSuite = new ArrayList<Card>();
		myDeckofCards = myTestDeck.createDeck();
		for (Card c : myDeckofCards) {
			if(c.getRankandSuit().contains("H")) {
				heartSuite.add(c);
			}
		}
		assertEquals(heartSuite.size(),13, "The size is Heart suit incorrect.");
	}
	
	/**
	 * This case tests the Diamond suit for 13 total cards.
	 */
	@Test
	void testDiamondSuite() {
		Deck myTestDeck = new Deck();
		Card[] myDeckofCards;
		ArrayList<Card> diamondSuite = new ArrayList<Card>();
		myDeckofCards = myTestDeck.createDeck();
		for (Card c : myDeckofCards) {
			if(c.getRankandSuit().contains("D")) {
				diamondSuite.add(c);
			}
		}
		assertEquals(diamondSuite.size(),13, "The size is Diamond suit incorrect.");
	}

	

}
