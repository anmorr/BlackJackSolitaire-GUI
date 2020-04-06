import java.util.Random;
public class Deck {
	
	String dealtCard;
	
	/**
	 * This function creates a deck of cards.
	 * @return
	 */
	public Card[] createDeck() {
		Card[] cards = new Card[52];
		String[] suits = {
				"S",
				"C",
				"H",
				"D"
		};
		int deckCounter = 0;
		int count = 2;
		String rank;
		for(int j = 0; j < suits.length; j++) {
			for(int i = 0; i < 13; i++) {
				if (count < 11) {
					cards[deckCounter] = new Card();
					cards[deckCounter].rank = Integer.toString(count);
					rank = Integer.toString(count);
					cards[deckCounter].rankAndSuit = rank + suits[j];
//					System.out.print(cards[deckCounter].rankAndSuit + " ");
					cards[deckCounter].value = count;
					count++;
					deckCounter++;
				}
				if (count == 11) {
					cards[deckCounter] = new Card();
					cards[deckCounter].rankAndSuit = "A" + suits[j];
//					System.out.print(cards[deckCounter].rankAndSuit + " ");
					cards[deckCounter].value = 11;
					count++;
					deckCounter++;
				}
				if (count == 12) {
					cards[deckCounter] = new Card();
					cards[deckCounter].rankAndSuit = "K" + suits[j];
//					System.out.print(cards[deckCounter].rankAndSuit + " ");
					cards[deckCounter].value = 10;
					count++;
					deckCounter++;
				}
				if (count == 13) {
					cards[deckCounter] = new Card();
					cards[deckCounter].rankAndSuit = "Q" + suits[j];
//					System.out.print(cards[deckCounter].rankAndSuit + " ");
					cards[deckCounter].value = 10;
					count++;
					deckCounter++;
				}
				if (count == 14) {
					cards[deckCounter] = new Card();
					cards[deckCounter].rankAndSuit = "J" + suits[j];
//					System.out.print(cards[deckCounter].rankAndSuit + " ");
					cards[deckCounter].value = 10;
					count++;
					deckCounter++;
//					System.out.println();
				}
				
				if (count == 15) {
					count = 2;
					break;
				}
			}
		}
		return cards;
	}
	
	/**
	 * This function takes a deck and shuffles it
	 * It then returns the shuffle deck.
	 * @param deck
	 * @return
	 */
	public Card[] suffle(Card[] deck) {
		
		Random r = new Random();
		
		for(int i = 0; i < deck.length; i ++) {
			int tempIndex = r.nextInt(deck.length);
			Card tempCard = deck[tempIndex];
			deck[tempIndex] = deck[i];
			deck[i] = tempCard;
			}
		return deck;
	}
	
	/**
	 * This function deals a card from the deck.
	 * @param deck
	 * @param next
	 * @return
	 */
	public String deal(Card[] deck, int next) {
		Card currentCard = deck[next];
		return currentCard.rankAndSuit;
	}
	
	/**
	 * This main function is used for testing the Deck class.
	 * @param args
	 */
	public static void main(String[] args) {
		Deck myDeck = new Deck();
		Card[] myDeckofCards;
		myDeckofCards = myDeck.createDeck();
		for (Card card: myDeckofCards) {
			System.out.println(card.rankAndSuit);
		}
		myDeckofCards = myDeck.suffle(myDeckofCards);
		for (Card card: myDeckofCards) {
			System.out.println(card.rankAndSuit);
		}
	}
}
