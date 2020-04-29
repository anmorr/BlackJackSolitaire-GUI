import java.awt.Color;

import javax.swing.JFrame;

/**
 * This is the main game runner
 * @author myThinkTank
 *
 */
public class BlackjackSolitaireRunner {
	
	public static void main(String[] args) {
		BlackjackSolitaire bjs = new BlackjackSolitaire(); 
		bjs.setTitle("Blackjack Solitaire");
		bjs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bjs.getContentPane().setBackground(Color.GREEN);
		bjs.setVisible(true);
		bjs.play();
	}
}
