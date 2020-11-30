package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

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
		
		//Frame parameters
		this.setSize(800, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Indexation page");

		//Content panel
		JPanel content = (JPanel)this.getContentPane();
		
		//File chooser
		JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setMultiSelectionEnabled(true);
		fileChooser.setDialogTitle("Please choose one or many files");
		
		//Document indexes display
		documentIndexes = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(documentIndexes); 
		documentIndexes.setEditable(false);
		content.add(scrollPane, BorderLayout.CENTER);
		
		
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
		content.add(fileButton, BorderLayout.NORTH);
		
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
		content.add(pageButton, BorderLayout.SOUTH);
		
		

		this.setVisible(true);
	}
}
