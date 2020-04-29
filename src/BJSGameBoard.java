/**
 * This will serve as the BJS game's main board.
 * The board will hold all required values to perform
 * the cards, as selected, which are ultimately used for 
 * calculating the final score.
 * @author myThinkTank
 *
 */
public class BJSGameBoard {

	public Card[][] bjsBoard;
	
	/**
	 * Constructor for the game board.
	 */
	public BJSGameBoard() {
		
		bjsBoard = new Card[4][5];
		createBoard(bjsBoard);
	}
	
	
	
	/**
	 * This function creates the game matrix/board
	 * which will be used for placing and updating
	 * the pieces.
	 * @param bjsBoard
	 */
	public void createBoard(Card[][] bjsBoard) {
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
	
	
	/**
	 * This function updates the game-board and 
	 * discarded section when the
	 * user selects a card, whether it's
	 * a discarded card or a game board card.
	 * @param grid
	 * @param location
	 * @param currentCard
	 */
	public void updateGrid(int location, Card currentCard) {
		if(location == 2) {
			bjsBoard[0][1] = currentCard;
		}
		switch(location) {
			case 1: bjsBoard[0][0] = currentCard; break;
			case 2: bjsBoard[0][1] = currentCard; break;
			case 3: bjsBoard[0][2] = currentCard; break;
			case 4: bjsBoard[0][3] = currentCard; break;
			case 5: bjsBoard[0][4] = currentCard; break;
			case 6: bjsBoard[1][0] = currentCard; break;
			case 7: bjsBoard[1][1] = currentCard; break;
			case 8: bjsBoard[1][2] = currentCard; break;
			case 9: bjsBoard[1][3] = currentCard; break;
			case 10: bjsBoard[1][4] = currentCard; break;
			case 11: bjsBoard[2][0] = currentCard; break;
			case 12: bjsBoard[2][1] = currentCard; break;
			case 13: bjsBoard[2][2] = currentCard; break;
			case 14: bjsBoard[2][3] = currentCard; break;
			case 15: bjsBoard[2][4] = currentCard; break;
			case 16: bjsBoard[3][0] = currentCard; break;
			case 17: bjsBoard[3][1] = currentCard; break;
			case 18: bjsBoard[3][2] = currentCard; break;
			case 19: bjsBoard[3][3] = currentCard; break;
			case 20: bjsBoard[3][4] = currentCard; break;
		}
	}
	
	
	/**
	 * This function is used to display the board.
	 * Only used for the console version of the game.
	 * @param bjsBoard
	 */
	public void display(Card[][] bjsBoard) {
			
			int boardSpaceCounter = 1;
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 5; j++) {
					if((boardSpaceCounter == 17) || (boardSpaceCounter == 18) || (boardSpaceCounter == 19) || (boardSpaceCounter == 20) ) {
						if(boardSpaceCounter == 17) {
							System.out.printf("%24s", " ");
						}
						System.out.printf("%12s", bjsBoard[i][j].getRankandSuit());
					} else {
						System.out.printf("%12s", bjsBoard[i][j].getRankandSuit());
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
	
	
	public Card[][] getBjsBoard() {
		return bjsBoard;
	}
		
}
