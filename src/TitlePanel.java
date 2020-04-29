import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitlePanel extends JPanel {
	
	private JLabel gameTitle;
	
	public void setGameTitleText(String gameTitleText) {
		this.gameTitle.setText(gameTitleText);
	}

	private JButton replay;
	private String gameTitleText;
	
	public TitlePanel() {
		gameTitleText = "Blackjack Solitaire!";
		gameTitle = new JLabel(gameTitleText);
		JPanel title = new JPanel();
		title.setLayout(new FlowLayout(FlowLayout.CENTER));
		title.add(gameTitle);
		add(title, "North");
		
	}
	

}
