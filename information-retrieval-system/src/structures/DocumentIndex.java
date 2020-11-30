package structures;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//ArrayList of words found in a document
public class DocumentIndex extends ArrayList<Word>{

	private Document document;
	
	public DocumentIndex(File file) {
		setDocument(new Document(file));
		tokenize(file);
	}
	
	//Tokenizes the file
	private void tokenize(File file) {

		//Open the file
		BufferedReader input = null;
		try {
			input = new BufferedReader(new FileReader(file));
			
			//Read file line by line and tokenize
			String line = "";
			line = input.readLine();
			while(line != null) {
				tokenize(line);
				line = input.readLine();
				
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Cannot open file " + file.getName());
		} catch (IOException e) {
			System.out.println("Error while reading file " + file.getName());
		}
		//Close the reader
		finally {
			if(input != null) {
				try {
					input.close();
				} catch (IOException e) {
					System.out.println("Cannot close file " + file.getName());
				}
			}
		}
	}	
	
	//Tokenizes a string
	private void tokenize(String str) {
		//Detect words in the string
		//TODO: Refine word detection
		str = str.replaceAll("[^a-zA-z0-9]", " ");//[^a-zA-z0-9] Keep a-z, A-Z, 0-9
		String[] words = str.split(" +");//" +" means a space and a character
		
		//Add the word in the list or increment frequence if not new
		for(String w: words) {
			Word word = new Word(w);
			int i = this.indexOf(word);		
			if(i < 0) {
				this.add(word);
			}
			else {
				this.get(i).incrementFrequence();
			}
		}		
	}
	
	@Override
	public String toString() {
		String str = getDocument().getName() + ": ";
		for(Word w: this) {
			str += w;
			str += ", ";
		}
		return str;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

}
