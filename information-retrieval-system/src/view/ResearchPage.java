//Noms : Karim Boumghar et Vincent Falardeau

package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import structures.*;
import tools.Tokenizer;


//This class is used to display our research page GUI
public class ResearchPage {
	
	WordIndexor wordIndexorList;
	
	public ResearchPage(WordIndexor wordIndexorList) {
		
		ResearchPageController RPC = new ResearchPageController(wordIndexorList);
		
		
		//Creating our main frame
		JFrame mainFrame = new JFrame("Research Page");
		
		//Main panel that will hold all the "sous-panels" for design purposes
		JPanel mainPanel = new JPanel();
		
		
		//Creating the panels which will hold our different lower components
		JPanel panelResultLabel = new JPanel();
		JPanel panelResult = new JPanel();
		JPanel panelResearchTextLabel = new JPanel();
		JPanel panelResearchText = new JPanel();
		JPanel panelButton = new JPanel();
		
		//Making our panel stack on top of each other if they're inside our main panel
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.PAGE_AXIS));
		
		
		//Creating label for our research results
		JLabel researchResultLabel = new JLabel();
		researchResultLabel.setFont(new Font("Serif", Font.BOLD, 14));
		researchResultLabel.setText("Search results");
		
		//Creating our Text area that will display the answer to the user's search request
		JTextArea researchResult = new JTextArea(20,40);
		researchResult.setEditable(false);
		
		//Putting it in a scrollPane so we can use scroll bar
		JScrollPane scrollPane = new JScrollPane(researchResult, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		
		//Creating label that indicates user where to make the research
		JLabel researchQueryLabel = new JLabel();
		researchQueryLabel.setFont(new Font("Serif", Font.BOLD, 14));
		researchQueryLabel.setText("Search query"); 
		
		
		//Creating our text area that our user can use to make his search query
		JTextArea researchQuery = new JTextArea(1,40);
		
		//Button to launch the research query
		JButton buttonResearch = new JButton("Launch search");
		buttonResearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String query = researchQuery.getText();
				
				if (!researchQuery.getText().isEmpty()) {
					String results = RPC.scoreResearch(researchQuery.getText());
					researchResult.setText(results);
				}
				
				else {
					//Alerting the user that something must be inputed before they can use the search button.
					//https://stackoverflow.com/questions/9119481/how-to-present-a-simple-alert-message-in-java
					JOptionPane.showMessageDialog(mainFrame, "Search query cannot be empty");
				}
				
			}
		});
		
		
		//Adding borders to our different text areas
		researchResult.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		researchQuery.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		
		
		
		
		
		//Adding all our lower components into our "sous-panels" 
		panelResultLabel.add(researchResultLabel);
		panelResult.add(scrollPane);
		panelResearchTextLabel.add(researchQueryLabel);
		panelResearchText.add(researchQuery);
		panelButton.add(buttonResearch);
		
		//Adding our "sous-panels" into the main one
		mainPanel.add(panelResultLabel);
		mainPanel.add(panelResult);
		mainPanel.add(panelResearchTextLabel);
		mainPanel.add(panelResearchText);
		mainPanel.add(panelButton);
		
		
		//Frame parameters
		mainFrame.add(mainPanel);
		mainFrame.setVisible(true);
		mainFrame.pack();
		mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //We just want to close that one frame when closing it
		mainFrame.setLocationRelativeTo(null);
		
		
	}

}
