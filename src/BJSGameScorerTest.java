import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BJSGameScorerTest {

	/**
	 * This test is designed to test the score of
	 * a board with the following output. This would 
	 * naturally lend itself to random testing with
	 * known outputs. To do a fully exhaustive test
	 * would be laborious, but necessary.
	 * 
	 *  9S 2S 7C 10S 4S
	 *  3C 6D 2H 7S  9C
	 *     6C 5D 4H
	 *     3H 8H JH
	 */
	@Test
	void testPreFilledGameBoardNoAce() {
		BJSGameBoard bjsBoard = new BJSGameBoard();
		BJSGameScorer bjsScorer = new BJSGameScorer();
		Deck myDeck = new Deck();
		Card[] myDeckofCards = myDeck.createDeck();
		bjsScorer.totalPoints(bjsBoard.getBjsBoard());
		Card card1 = myDeckofCards[7];
		Card card2 = myDeckofCards[0];
		Card card3 = myDeckofCards[18];
		Card card4 = myDeckofCards[8];
		Card card5 = myDeckofCards[2];
		
		Card card6 = myDeckofCards[14];
		Card card7 = myDeckofCards[43];
		Card card8 = myDeckofCards[26];
		Card card9 = myDeckofCards[5];
		Card card10 = myDeckofCards[20];
		
		Card card11 = myDeckofCards[17];
		Card card12 = myDeckofCards[42];
		Card card13 = myDeckofCards[28];
		
		Card card14 = myDeckofCards[27];
		Card card15 = myDeckofCards[32];
		Card card16 = myDeckofCards[38];
		
		bjsBoard.updateGrid(1,card1);
		bjsBoard.updateGrid(2,card2);
		bjsBoard.updateGrid(3,card3);
		bjsBoard.updateGrid(4,card4);
		bjsBoard.updateGrid(5,card5);
		
		bjsBoard.updateGrid(6,card6);
		bjsBoard.updateGrid(7,card7);
		bjsBoard.updateGrid(8,card8);
		bjsBoard.updateGrid(9,card9);
		bjsBoard.updateGrid(10,card10);
		
		bjsBoard.updateGrid(11,card11);
		bjsBoard.updateGrid(12,card12);
		bjsBoard.updateGrid(13,card13);
		
		bjsBoard.updateGrid(14,card14);
		bjsBoard.updateGrid(15,card15);
		bjsBoard.updateGrid(16,card16);
//		System.out.println(bjsScorer.totalPoints(bjsBoard.getBjsBoard()));
		assertEquals(12, bjsScorer.totalPoints( bjsBoard.getBjsBoard()), "The score is incorrect");
	}
	
	
	/**
	 * This test is designed to test the score of
	 * a board with the following output, which 
	 * includes an ACE
	 * 
	 *  KH 7S 9S 5S 10H
	 *  4H 4S 9C 2C AD
	 *     5D KC 3H
	 *     4D 3S 10D
	 */
	@Test
	void testPreFilledGameBoardWithAce() {
		BJSGameBoard bjsBoard = new BJSGameBoard();
		BJSGameScorer bjsScorer = new BJSGameScorer();
		Deck myDeck = new Deck();
		Card[] myDeckofCards = myDeck.createDeck();
		bjsScorer.totalPoints(bjsBoard.getBjsBoard());
		Card card1 = myDeckofCards[36];
		Card card2 = myDeckofCards[5];
		Card card3 = myDeckofCards[7];
		Card card4 = myDeckofCards[3];
		Card card5 = myDeckofCards[34];
		
		Card card6 = myDeckofCards[28];
		Card card7 = myDeckofCards[2];
		Card card8 = myDeckofCards[20];
		Card card9 = myDeckofCards[13];
		Card card10 = myDeckofCards[48];
		
		Card card11 = myDeckofCards[42];
		Card card12 = myDeckofCards[23];
		Card card13 = myDeckofCards[27];
		
		Card card14 = myDeckofCards[41];
		Card card15 = myDeckofCards[1];
		Card card16 = myDeckofCards[47];
		
		bjsBoard.updateGrid(1,card1);
		bjsBoard.updateGrid(2,card2);
		bjsBoard.updateGrid(3,card3);
		bjsBoard.updateGrid(4,card4);
		bjsBoard.updateGrid(5,card5);
		
		bjsBoard.updateGrid(6,card6);
		bjsBoard.updateGrid(7,card7);
		bjsBoard.updateGrid(8,card8);
		bjsBoard.updateGrid(9,card9);
		bjsBoard.updateGrid(10,card10);
		
		bjsBoard.updateGrid(11,card11);
		bjsBoard.updateGrid(12,card12);
		bjsBoard.updateGrid(13,card13);
		
		bjsBoard.updateGrid(14,card14);
		bjsBoard.updateGrid(15,card15);
		bjsBoard.updateGrid(16,card16);
//		System.out.println(bjsScorer.totalPoints(bjsBoard.getBjsBoard()));
		assertEquals(31, bjsScorer.totalPoints(bjsBoard.getBjsBoard()), "The score is incorrect");
	}

}
