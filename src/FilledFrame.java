import java.awt.BorderLayout;
import java.awt.GridLayout;

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
		
//		buttonReplay = new JButton("Replay!");
//		labelTime = new JLabel("Time:");
//		labelScore = new JLabel("Score:");
//		
//		JPanel panel = new JPanel();
//		
//		
//		panel.add(labelTime, BorderLayout.WEST);
//		panel.add(labelScore);
//		panel.add(buttonReplay);
//		
//		add(panel);
		
		JPanel p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		p1.add(new JButton("A"));
		p1.add(new JButton("B"));
//		p1.add(new JButton("C"));
//		p1.add(new JButton("D"));
//		p1.add(new JButton("E"));
		
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(3, 2));
		p2.add(new JButton("F"));
		p2.add(new JButton("G"));
		p2.add(new JButton("H"));
		p2.add(new JButton("I"));
		p2.add(new JButton("J"));
		p2.add(new JButton("K"));
		
		
		JPanel p3 = new JPanel();
		p3.setLayout(new BoxLayout(p3, BoxLayout.Y_AXIS));
		p3.add(new JButton("L"));
		p3.add(new JButton("M"));
		
		
//		container.setLayout(new BorderLayout());
//		container.add(p1);
//		container.add(p2);
//		container.add(p3);
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);
		add(p3, BorderLayout.EAST);
		
	}

}
