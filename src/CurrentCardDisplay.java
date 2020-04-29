import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class is used to display the current card
 * from the top of the deck. Specifically, this panel
 * will be placed in the western portion of the border
 * layout.
 * @author myThinkTank
 *
 */

public class CurrentCardDisplay extends JPanel {


	JButton currentCardDisplay;
	
	public CurrentCardDisplay() {
		JLabel currentCardLabel = new JLabel("Current Card:");
		add(currentCardLabel);
		currentCardDisplay = new JButton("X");
		currentCardDisplay.setSize(400, 200);
		add(currentCardDisplay);
	}

	public void setCurrentCardDisplay(String currentCardDisplay) {
		this.currentCardDisplay.setText(currentCardDisplay);
	}
	
	
	
	

}
