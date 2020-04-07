import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class DeckTest {

	
	@Test
	void testCreateDeck() {
		Deck myTestDeck = new Deck();
		Card[] myDeckofCards;
		myDeckofCards = myTestDeck.createDeck();
		assertEquals(myDeckofCards.length,52);
	}
	
	
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
