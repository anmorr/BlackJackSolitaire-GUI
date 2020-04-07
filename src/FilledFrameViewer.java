import javax.swing.*;

/**
 * FilledFrameViewer is used to call the FilledFrame Class
 * @author myThinkTank
 *
 */
public class FilledFrameViewer {

	public FilledFrameViewer() {
		JFrame frame = new FilledFrame();
		frame.setTitle("BlackJack Solitaire");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
//	public static void main(String[] args) {
//		
//		JFrame frame = new FilledFrame();
//		frame.setTitle("BlackJack Solitaire");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
//		
//	}

}
