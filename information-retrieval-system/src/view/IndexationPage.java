package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileSystemView;

import structures.DocumentIndex;
import structures.DocumentIndexor;
import structures.WordIndexor;

public class IndexationPage extends JFrame{
	
	DocumentIndexor documentIndexor;
	JTextArea documentIndexes;
	
	public IndexationPage() {
		
		//Creating our main frame
		JFrame mainFrame = new JFrame("Indexation Page");
		
		//Creating the panels which will hold our different lower components
		JPanel mainPanel = new JPanel();
		JPanel panelMainText = new JPanel();
		JPanel panelButtons = new JPanel();
		
		//Making our panel stack on top of each other if they're inside our main panel
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.PAGE_AXIS));
		

				
		//File chooser
		JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setMultiSelectionEnabled(true);
		fileChooser.setDialogTitle("Please choose one or many files");
		
		//Document indexes display
		documentIndexes = new JTextArea(20,80);
		documentIndexes.setEditable(false);
		
		//Putting it into a JScrollPane so that we can use the scrollbar features.
		JScrollPane scrollPane = new JScrollPane(documentIndexes, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 

		
		
		//Button to open the file chooser
		JButton fileButton = new JButton("Open file(s)");
		documentIndexor = null;
		fileButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//Open the file chooser
				int result = fileChooser.showOpenDialog(null);
				if(result == JFileChooser.APPROVE_OPTION) {
					File[] files = fileChooser.getSelectedFiles();
					
					//Index the choosen files
					documentIndexor = new DocumentIndexor(files);
					
					documentIndexes.setText(documentIndexor.toString());
				}
				
				
			}
			
		});
		
		
		
		//Research page button
		JButton pageButton = new JButton("Go to research page");
//		pageButton.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				
//				if(documentIndexor != null) {
//					WordIndexor wordIndexor = new WordIndexor(documentIndexor);
//				}
//				else {
//					//TODO
//				}
//				
//				
//			}
//			
//		});
		
		//Adding all our lower components into our "sous-panels" 
		panelMainText.add(scrollPane);
		panelButtons.add(fileButton);
		panelButtons.add(pageButton);
		
		//Adding our "sous-panels" into the main one
		mainPanel.add(panelMainText);
		mainPanel.add(panelButtons);
		
		
		//Frame parameters
		mainFrame.add(mainPanel);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.pack();
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
	}
}
