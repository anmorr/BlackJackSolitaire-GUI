import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JPanel;

//import javax.swing.*;

public class GUITest {
	
	
	
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Container container = new JFrame();
		
		JFrame container = new FilledFrame();
		container.setVisible(true);
		
		JPanel p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		p1.add(new JButton("A"), BorderLayout.NORTH);
		p1.add(new JButton("B"), BorderLayout.NORTH);
		p1.add(new JButton("C"), BorderLayout.NORTH);
		p1.add(new JButton("D"), BorderLayout.NORTH);
		p1.add(new JButton("E"), BorderLayout.NORTH);
		
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
		
		
		container.setLayout(new BorderLayout());
		container.add(p1);
		container.add(p2);
		container.add(p3);
		
		
	}

}
