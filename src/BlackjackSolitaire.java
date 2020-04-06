import java.util.Scanner;

public class BlackjackSolitaire {
	
	boolean run = true;
	
	Card[][] grid = new Card[4][5];
	
	Card[][] bjsBoard = new Card[4][5];
	/**
	 * This function creates the game matrix/board
	 * which will be used for placing and updating
	 * the pieces.
	 * @param bjsBoard
	 */
	private void createBoard(Card[][] bjsBoard) {
		int boardSpaceCounter = 1;
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 5; j++) {
				Card placeHolder = new Card(); 
				placeHolder.setValue(boardSpaceCounter);
				placeHolder.setRankAndSuit(Integer.toString(boardSpaceCounter));
				bjsBoard[i][j] = placeHolder;
				boardSpaceCounter++;
				
			}
		}
	}
	
	
	void display(Card[][] bjsBoard) {
		int boardSpaceCounter = 1;
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 5; j++) {
				if((boardSpaceCounter == 17) || (boardSpaceCounter == 18) || (boardSpaceCounter == 19) || (boardSpaceCounter == 20) ) {
					if(boardSpaceCounter == 17) {
						System.out.printf("%24s", " ");
					}
					System.out.printf("%12s", bjsBoard[i][j].rankAndSuit);
				} else {
					System.out.printf("%12s", bjsBoard[i][j].rankAndSuit);
				}
				boardSpaceCounter++;
				if (boardSpaceCounter == 6) {
					System.out.println();
					System.out.println();
				}
				if (boardSpaceCounter == 11) {
					System.out.println();
					System.out.println();
					System.out.print("            ");
	
				}
				if (boardSpaceCounter == 14) {
					System.out.printf("%60s", " " + "Discard Spots");
				}
				if (boardSpaceCounter == 14) {
					System.out.println();
					System.out.println();
					System.out.print("            ");
					
				}
			}
		}
	}
	
	/**
	 * This function updates the game-board and 
	 * discarded section with the when the
	 * user selects a card, whether it's
	 * a discarded card or a game board card.
	 * @param grid
	 * @param location
	 * @param currentCard
	 */
	private void updateGrid(Card[][] grid, int location, Card currentCard) {
		if(location == 2) {
			grid[0][1] = currentCard;
		}
		switch(location) {
			case 1: grid[0][0] = currentCard; break;
			case 2: grid[0][1] = currentCard; break;
			case 3: grid[0][2] = currentCard; break;
			case 4: grid[0][3] = currentCard; break;
			case 5: grid[0][4] = currentCard; break;
			case 6: grid[1][0] = currentCard; break;
			case 7: grid[1][1] = currentCard; break;
			case 8: grid[1][2] = currentCard; break;
			case 9: grid[1][3] = currentCard; break;
			case 10: grid[1][4] = currentCard; break;
			case 11: grid[2][0] = currentCard; break;
			case 12: grid[2][1] = currentCard; break;
			case 13: grid[2][2] = currentCard; break;
			case 14: grid[2][3] = currentCard; break;
			case 15: grid[2][4] = currentCard; break;
			case 16: grid[3][0] = currentCard; break;
			case 17: grid[3][1] = currentCard; break;
			case 18: grid[3][2] = currentCard; break;
			case 19: grid[3][3] = currentCard; break;
			case 20: grid[3][4] = currentCard; break;
		}
	}
	/**
	 * This function is a helper that is used to check for ACE
	 * If the total is above 21, and the aceCount is > 0,
	 * a new total for the row or column is computed until either
	 * the total is <= 21 or there are no more ACEs, whichever comes
	 * first.
	 * @param rowColTotal
	 * @param aceCount
	 * @return
	 */
	private int aceModifier(int rowColTotal, int aceCount) {
		if (rowColTotal > 21){
			while((rowColTotal > 21) && (aceCount > 0)){
				rowColTotal = rowColTotal - 10;
			  		aceCount--;
			}
		}
		return rowColTotal;
	}
	
	/**
	 * This function is a helper that counts the number of ACEs in the
	 * column elements that will be totaled.
	 * @param val1
	 * @param val2
	 * @param val3
	 * @param val4
	 * @return
	 */
	private int colAceCounter(int val1, int val2, int val3, int val4) {
		int aceCount = 0;
		int[] vals = {val1, val2, val3, val4};
		for (int element: vals) {
			if (element == 11) {
				aceCount++;
			}
		}
		return aceCount;
	}
	
	
	/**
	 * This function totals the points for
	 * the rows, then the columns, and lastly
	 * it sums all of them up to present the user 
	 * with a final score.
	 * @param grid
	 */
	private void totalPoints(Card[][] grid) {
		int aceCount = 0;
		int gameTotal = 0;
		int[] finalTotal = new int[9];
		int rowTotal = 0;
		int row1Total = 0;
		int row2Total = 0;
		int row3Total = 0;
		int row4Total = 0;
		int col1Total = 0;
		int col2Total = 0;
		int col3Total = 0;
		int col4Total = 0;
		int col5Total = 0;
		int[] row1 = new int[5];
		int[] row2 = new int[5];
		int[] row3 = new int[5];
		int[] row4 = new int[5];
		
		
		for (int i = 0; i < 4; i++) {
//			System.out.println("DEBUG => " +"i ="+i);
			for(int j = 0; j < 5; j++) {
//				System.out.println("DEBUG => " +"i ="+i);
//				System.out.println("DEBUG => " +"j ="+j);
//				System.out.println("DEBUG => " +"CurrentCard ="+grid[i][j].rankAndSuit);
				if(i < 2) {
					if(i == 0) {
						row1[j] = grid[i][j].value;
					}
					if(i == 1) {
						row2[j] = grid[i][j].value;
					}
				}
				if(i == 2) {
					if(j < 3) {
						row3[j] = grid[i][j].value;
					}else {
						row4[j-3] = grid[i][j].value;
					}
				}
				if(i == 3) {
					if(j == 0) {
						row4[j+2] = grid[i][j].value;
					}
				}
				Card currentCard = grid[i][j];
				rowTotal = rowTotal + currentCard.value;
			}
		}
		
		/*
		 * To handle the ACE, the approach will be to 
		 * 1. total all of the rows and columns.
		 * 2. Iterate back through, or on the first iteration, create a counter to keep track of any ACEs.
		 * 3. If the counter is not 0 in the end, and the total is higher than 21 then change then 
		 *    mulitply 10 * the counter value and subtract it from the total. This will both remove the 11 value and add a 1.
		 * 4. Maybe even remove 1 first, then check the score to see if it is above 21, then remove each additional one in succession until you get under 21.
		 * 5. Ok, so the final logic is:
		 * 	count = number of 11s in row.
		 * 	After the total is completed:
		 * 	if (total > 21){
		 * 		while((total > 21) && (count > 0)){
		 * 			total = total - 10;
		 * 			count--;
		 * 		}
		 * 	}	
		 */
		
		
		
		
		for(int element: row1) {
			if(element == 21) {
				aceCount++;
			}
			row1Total = row1Total + element;
		}
		row1Total = aceModifier(row1Total, aceCount);
		finalTotal[0] = row1Total;
		aceCount = 0;
//		System.out.println("Row 1 Total: "+row1Total);
		
		for(int element: row2) {
			if(element == 21) {
				aceCount++;
			}
			row2Total = row2Total + element;
		}
		row2Total = aceModifier(row2Total, aceCount);
		finalTotal[1] = row2Total;
		aceCount = 0;
//		System.out.println("Row 2 Total: "+row2Total);
		
		for(int element: row3) {
			if(element == 21) {
				aceCount++;
			}
			row3Total = row3Total + element;
		}
		row3Total = aceModifier(row3Total, aceCount);
		finalTotal[2] = row3Total;
		aceCount = 0;
//		System.out.println("Row 1 Total: "+row3Total);
		
		for(int element: row4) {
			if(element == 21) {
				aceCount++;
			}
			row4Total = row4Total + element;
		}
		row4Total = aceModifier(row4Total, aceCount);
		finalTotal[3] = row4Total;
		aceCount = 0;
//		System.out.println("Row 1 Total: "+row4Total);
		col1Total = row1[0] + row2[0];
		aceCount = colAceCounter(row1[0], row2[0], 0, 0);
		col1Total = aceModifier(col1Total, aceCount);
		finalTotal[4] = col1Total;
		aceCount = 0;
//		System.out.println("Col 1 Total: "+col1Total);
		col2Total = row1[1] + row2[1] + row3[0] + row4[0];
		aceCount = colAceCounter(row1[1], row2[1], row3[0], row4[0]);
		col2Total = aceModifier(col2Total, aceCount);
		finalTotal[5] = col2Total;
		aceCount = 0;
//		System.out.println("Col 2 Total: "+col2Total);
		col3Total = row1[2] + row2[2] + row3[1] + row4[1];
		aceCount = colAceCounter(row1[2], row2[2], row3[1], row4[1]);
		col3Total = aceModifier(col3Total, aceCount);
		finalTotal[6] = col3Total;
		aceCount = 0;
//		System.out.println("Col 3 Total: "+col3Total);
		col4Total = row1[3] + row2[3] + row3[2] + row4[2];
		aceCount = colAceCounter(row1[3], row2[3], row3[2], row4[2]);
		col4Total = aceModifier(col4Total, aceCount);
		finalTotal[7] = col4Total;
		aceCount = 0;
//		System.out.println("Col 4 Total: "+col4Total);
		col5Total = row1[4] + row2[4];
		aceCount = colAceCounter(row1[4], row2[4], 0, 0);
		col5Total = aceModifier(col5Total, aceCount);
		finalTotal[8] = col5Total;
		aceCount = 0;
//		System.out.println("Col 5 Total: "+col5Total);
		
		for (int i = 0; i < 9; i++) {
			if (((i == 4) || (i == 8)) && (finalTotal[i] == 21)) {
				gameTotal = gameTotal + 10;
				continue;
			}
			if (finalTotal[i] <= 16) {
				gameTotal = gameTotal + 1;
				continue;
			}
			if (finalTotal[i] > 21) {
				gameTotal = gameTotal + 0;
				continue;
			}
			if (finalTotal[i] == 21) {
				gameTotal = gameTotal + 7;
				continue;
			}
			if (finalTotal[i] == 20) {
				gameTotal = gameTotal + 5;
				continue;
			}
			if (finalTotal[i] == 19) {
				gameTotal = gameTotal + 4;
				continue;
			}
			if (finalTotal[i] == 18) {
				gameTotal = gameTotal + 3;
				continue;
			}
			if (finalTotal[i] == 17) {
				gameTotal = gameTotal + 2;
				continue;
			}
		}
		System.out.println("Final Score is: " + gameTotal + "!");
		System.out.println("Game is Done");
	}

	/**
	 * This is the game engine. It is
	 * responsible for making all of the
	 * magic happen!
	 */
	public void play() {
		System.out.println("Game has started!\n");
		Card currentCard;
		int num = 0;
		boolean discardCheck = false;
		boolean usedSpace = false;
		int deckCount = 0;
		Deck myDeck = new Deck();
		Card[] myDeckofCards;
		myDeckofCards = myDeck.createDeck();
		// Shuffle Deck
		myDeckofCards = myDeck.suffle(myDeckofCards);
		int placedCards = 0;
		int discardedCards = 0;
		int[] usedSpaces = new int[20];
		int[] usedDiscardSpots = new int[4];
		boolean invalidSpace = false;
		boolean discardSpaces = false;
		String[] usedCardOnBoard = new String[20];
		createBoard(bjsBoard);
		while(placedCards <= 16) {
			currentCard = myDeckofCards[deckCount];
			System.out.println("Current Card: " + currentCard.rankAndSuit +" "+ "Value: "+ currentCard.value);
			display(bjsBoard);
			System.out.println("\n\n");
			if(placedCards < 16) {
				if(invalidSpace) {
					System.out.println("***** This is not a valid space! *****");
					invalidSpace = false;
				}
				if(discardSpaces) {
					System.out.println("    ***** All discarded spots are full! *****");
					System.out.println("***** Choose a spot of the board for your card. *****\n");
					discardSpaces = false;
				}
				if(usedSpace) {
					System.out.println("***** This spot is taken! Please choose another! *****\n");
					usedSpace = false;
				}
				System.out.println("Please enter a number:");
				
			} else {
				System.out.println("Time to tally the final score!");
				totalPoints(bjsBoard);
			}
			Scanner in = new Scanner(System.in);
			num = in.nextInt();
			if ((num == 0) || (num >20)) {
				invalidSpace = true;
				continue;
			}
			for (int i = 0; i < 16; i++) {
				if (num == usedSpaces[i]) {
//					System.out.println("This spot is taken! Please choose another");
					usedSpace = true;
				}
			}
			if(usedSpace) {
				continue;
			}
			if((num <= 16) && (usedSpace == false)) {
				usedSpaces[deckCount] = num;
				usedCardOnBoard[deckCount] = currentCard.rankAndSuit;
			}
			if((num >= 17) && (discardedCards == 4)) {
//				System.out.println("All discarded spots are full!");
//				System.out.println("Choose a spot of the board for your card.");
				discardSpaces = true;
				continue;
			}
			if(num >= 17) {
				for(int i = 0; i < 4; i++) {
					if(num == usedDiscardSpots[i]) {
						discardCheck = true;
					}
				}
				
			}
			if((discardCheck == true) && (num >= 17)) {
				System.out.println("This spot is taken!");
				discardCheck = false;
				continue;
			}
			if (num >= 17) {
				usedDiscardSpots[discardedCards] = num;
				discardedCards++;
				updateGrid(bjsBoard, num, currentCard);
				deckCount++;
				continue;
			}
			if ((num <= 16) && (usedSpace != true)) {
				updateGrid(bjsBoard, num, currentCard);
				System.out.println("\n");
				deckCount++;
				placedCards++;
			} else {
				usedSpace = false;
			}
			
		}
	}
}
