//Noms : Karim Boumghar et Vincent Falardeau

package view;

import structures.WordIndexor;
import tools.Tokenizer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ResearchPage {
	
	private WordIndexor wordIndexor;
	private JTextArea researchQuery;
	
	public ResearchPage(WordIndexor wordIndexor) {
		this.wordIndexor = wordIndexor;
		
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
		JTextArea researchResult = new JTextArea(10,40);
		researchResult.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(researchResult, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		
		//Creating label that indicates user where to make the research
		JLabel researchQueryLabel = new JLabel();
		researchQueryLabel.setFont(new Font("Serif", Font.BOLD, 14));
		researchQueryLabel.setText("Search for words"); //TO DO : CHANGE TEXT HERE
	
		
		//Creating our text area that our user can use to make his search query
		researchQuery = new JTextArea(1,40);
		
		//Button to launch the research qury
		JButton buttonResearch = new JButton("Launch search");
		buttonResearch.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String[] research = Tokenizer.tokenize(researchQuery.getText());
				String result = wordIndexor.search(research);
				researchResult.setText(result);
			}
		});
		
		//Adding borders to our different text areas
		researchResult.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		researchQuery.setBorder(BorderFactory.createLineBorder(Color.black, 1));

		
		//Adding all our lower components into our sub panels 
		panelResultLabel.add(researchResultLabel);
		panelResult.add(scrollPane);
		panelResearchTextLabel.add(researchQueryLabel);
		panelResearchText.add(researchQuery);
		panelButton.add(buttonResearch);
		
		//Adding our sub panels into the main one
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
