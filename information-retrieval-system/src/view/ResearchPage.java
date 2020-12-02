package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ResearchPage {
	
	public ResearchPage() {
		
		//Creating our main frame
		JFrame mainFrame = new JFrame("Research Page");
		
		//Main panel that will hold all the "sous-panels" for design purposes
		JPanel mainPanel = new JPanel();
		
		//Creating the panels which will hold our different lower components
		
		
		
		
		
		
		
		//Adding all our lower components into our "sous-panels" 
		
		
		//Adding our "sous-panels" into the main one
		
		//Frame parameters
		mainFrame.add(mainPanel);
		mainFrame.setVisible(true);
		mainFrame.pack();
		mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //We just want to close that one frame when closing it
		mainFrame.setLocationRelativeTo(null);
		
		
	}

}
