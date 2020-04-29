import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class BlackjackSolitaire extends JFrame {
	
	private static final int FRAME_WIDTH = 1200;
	private static final int FRAME_HEIGHT = 600;
	
	public Card getCurrentCard() {
		return currentCard;
	}

	boolean run = true;
	CardBoard gameBoard;
	TitlePanel boardTitle;
	CurrentCardDisplay currentCardDisplayPanel;
	Card currentCard;
	JButton replay;
	JButton currentCardDisplay;
	int finalScore;
	boolean discardCheck;
	BJSGameBoard bjsBoard;
	BJSGameScorer bjsScorer;
	
	
	public BlackjackSolitaire() {
		
		// Create the game board
		bjsBoard = new BJSGameBoard();
		bjsScorer = new BJSGameScorer();
		
		// Border Panel North and Center
		setLayout(new BorderLayout());
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		boardTitle = new TitlePanel();
		gameBoard = new CardBoard();
		add(boardTitle, "North");
		add(gameBoard, "Center");
		
		// Border Panel East
//		replay = new JButton("Replay!");
		JPanel replayPanel = new JPanel();
		replayPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
//		replayPanel.add(replay);
		add(replayPanel, "East");
		

		// Border Panel West
		currentCardDisplayPanel = new CurrentCardDisplay();
		add(currentCardDisplayPanel, "West");
		
		
	}

	/**
	 * This is the game engine. It is
	 * responsible for making all of the
	 * magic happen!
	 */
	public void play() {
//		System.out.println("Game has started!\n");
		int num = 0;
		boolean discardCheck = false;
		boolean usedSpace = false;
		int deckCount = 0;
		Deck myDeck = new Deck();
		Card[] myDeckofCards = myDeck.createDeck();
		// Shuffle Deck
		myDeckofCards = myDeck.suffle(myDeckofCards);
		int placedCards = 0;
		int discardedCards = 0;
		int[] usedSpaces = new int[20];
		int[] usedDiscardSpots = new int[4];
		boolean invalidSpace = false;
		boolean discardSpaces = false;
		String[] usedCardOnBoard = new String[20];
		while(placedCards <= 16) {
			currentCard = myDeckofCards[deckCount];
			gameBoard.setCurrentCard(currentCard); // Just removed
			currentCardDisplayPanel.setCurrentCardDisplay(currentCard.getRankandSuit());
			gameBoard.setCurrentNumber("0");
			System.out.println("\n\n");
			if(placedCards < 16) {
				if(invalidSpace) {
					invalidSpace = false;
				}
				if(discardSpaces) {
					discardSpaces = false;
				}
				if(usedSpace) {
					usedSpace = false;
				}
				
			} else {
				int finalScore = bjsScorer.totalPoints(bjsBoard.getBjsBoard());
				boardTitle.setGameTitleText("Finished! Final Score is " + Integer.toString(finalScore));
				gameBoard.setGameStatus(true);
				
				
			}
			
			num = Integer.parseInt(gameBoard.getCurrentNumber());
			
			if ((num == 0) || (num >20)) {
				invalidSpace = true;
				continue;
			}
			for (int i = 0; i < 16; i++) {
				if (num == usedSpaces[i]) {
					usedSpace = true;
				}
			}
			if(usedSpace) {
				continue;
			}
			if((num <= 16) && (usedSpace == false)) {
				usedSpaces[deckCount] = num;
				usedCardOnBoard[deckCount] = currentCard.getRankandSuit();
			}
			if((num >= 17) && (discardedCards == 4)) {
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
//				System.out.println("This spot is taken!");
				discardCheck = false;
				continue;
			}
			if (num >= 17) {
				gameBoard.updateDiscardSpots(num);
				usedDiscardSpots[discardedCards] = num;
				discardedCards++;
//				updateGrid(bjsBoard, num, currentCard);
				bjsBoard.updateGrid(num, currentCard);
				deckCount++;
				continue;
			}
			if ((num <= 16) && (usedSpace != true)) {
//				updateGrid(bjsBoard, num, currentCard);
				bjsBoard.updateGrid(num, currentCard);
				deckCount++;
				placedCards++;
			} else {
				usedSpace = false;
			}
			
		}
	}
}
