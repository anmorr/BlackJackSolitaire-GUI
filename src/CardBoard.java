import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

public class CardBoard extends JPanel{

	private JPanel buttonPanel;
	private JPanel discardPanel;
	private JButton clearButton;
	private JTextField display;
	private JPanel discardGridPanel;
	private Card currentCard;
	private String currentNumber = "0";
	private ArrayList<Integer> discardSpots;
	private ArrayList<Integer> usedSpots;
	private boolean gameOver = false;

	
	/**
	 * Constructs the Board
	 */
	public CardBoard() {
		
		discardSpots = new ArrayList<Integer>();
		
		setLayout(new BorderLayout());
		
		// Add display field
		
		
		JPanel discardLabelPanel = new JPanel();
		JLabel discardLabel = new JLabel("      Discarded Cards");
		
		discardLabelPanel.setLayout(new BorderLayout());
		discardLabelPanel.add(discardLabel, BorderLayout.NORTH);
		discardPanel = new JPanel();
//		discardGridPanel.add(discardLabel);
		discardGridPanel = new JPanel();
		discardPanel.setLayout(new GridLayout(2,2));
		addButtonDiscards("17");
		addButtonDiscards("18");
		addButtonDiscards("19");
		addButtonDiscards("20");
		discardPanel.setSize(800, 400);
		discardLabelPanel.add(discardPanel);
		discardGridPanel.add(discardLabelPanel);
		add(discardGridPanel, "West");
		
		
		
		//Make Board
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4, 5));
		
		// Add Cards
		addButtonMain("1");
		addButtonMain("2");
		addButtonMain("3");
		addButtonMain("4");
		addButtonMain("5");
		addButtonMain("6");
		addButtonMain("7");
		addButtonMain("8");
		addButtonMain("9");
		addButtonMain("10");
		addButtonMain("");
		addButtonMain("11");
		addButtonMain("12");
		addButtonMain("13");
		addButtonMain("");
		addButtonMain("");
		addButtonMain("14");
		addButtonMain("15");
		addButtonMain("16");
		addButtonMain("");
		
		// Add the button numbers to the usedSpots ArrayList
		
		usedSpots = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16));
		
		add(buttonPanel, "Center");
	}

	/**
	 * Adds a button to the button panel
	 * @param string
	 */
	private void addButtonMain(String label) {
		// TODO Auto-generated method stub
		JButton button = new JButton(label);
		class DigitButtonListener implements ActionListener{
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boolean spaceUsed = true;
				if(!button.getText().isEmpty() && (gameOver == false)) {
					for(int val : usedSpots) {
						if(val == Integer.parseInt(button.getText())) {
							spaceUsed = false;
						}
					}
					if(spaceUsed) {
						return;
					}
					currentNumber = label;
//					usedSpots.add(currentCard.rankAndSuit);
					button.setText(currentCard.getRankandSuit());
				}
			}
		}
		
		if(button.getText().isEmpty()) {
			button.setVisible(false);
		}
		
		buttonPanel.add(button);
		ActionListener listener = new DigitButtonListener();
		button.addActionListener(listener);
	}
	
	/**
	 * Adds a button to the button panel
	 * @param string
	 */
	private void addButtonDiscards(String label) {
		// TODO Auto-generated method stub
		JButton button = new JButton(label);
		button.setSize(1000, 1000);
		class DigitButtonListener implements ActionListener{
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean spaceUsed = false;
				// TODO Auto-generated method stub
				if(!button.getText().isEmpty() && (gameOver == false)) {
					for(int val : discardSpots) {
						if(val == Integer.parseInt(label)) {
							spaceUsed = true;
						}
					}
					if(spaceUsed) {
						System.out.println("The label is: " + label);
						return;
					}
					currentNumber = label;
					button.setText(currentCard.getRankandSuit());
				}
			}
		}
		
		discardPanel.add(button);
		ActionListener listener = new DigitButtonListener();
		button.addActionListener(listener);
	}

	public void setCurrentCard(Card currentCard) {
		this.currentCard = currentCard;
	}

	public String getCurrentNumber() {
		return currentNumber;
	}

	public void setCurrentNumber(String currentNumber) {
		this.currentNumber = currentNumber;
	}
	
	public void updateDiscardSpots(int cardNumber) {
		discardSpots.add(cardNumber);
	}
	
	public void setGameStatus(boolean status) {
		gameOver = status;
	}
}
