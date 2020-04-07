import java.awt.BorderLayout;

import javax.swing.*;
/**
 * Filled Frame class used to create the board for the
 * game.
 * @author myThinkTank
 *
 */
public class FilledFrame extends JFrame{

	// Instance variable for components
	private JButton buttonReplay;
	private JLabel labelTime;
	private JLabel labelScore;
	private JLabel labelReplay;
	
	private static final int FRAME_WIDTH = 600;
	private static final int FRAME_HEIGHT = 300;
	
	/**
	 * Constructor for FilledFrame
	 */
	public FilledFrame() {
		createComponents();
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	/**
	 * This method creates the components for the GUI
	 */
	private void createComponents() {
		
		buttonReplay = new JButton("Replay!");
		labelTime = new JLabel("Time:");
		labelScore = new JLabel("Score:");
		
		JPanel panel = new JPanel();
		
		panel.add(labelTime);
		panel.add(labelScore);
		panel.add(buttonReplay);
		
		add(panel);
		
	}

}
