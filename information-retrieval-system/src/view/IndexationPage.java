package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.filechooser.FileSystemView;

public class IndexationPage extends JFrame{
	
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
		
		//Button to open the file chooser
		JButton fileButton = new JButton("Open file(s)");
		content.add(fileButton, BorderLayout.NORTH);
		fileButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
			
		});
		
		//Document index
		JList documentIndex = new JList();
		content.add(documentIndex, BorderLayout.CENTER);
		
		//Research page button
		JButton pageButton = new JButton("Go to research page");
		content.add(pageButton, BorderLayout.SOUTH);

		this.setVisible(true);
	}
}
