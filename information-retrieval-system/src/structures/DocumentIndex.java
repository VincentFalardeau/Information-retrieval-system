//Noms : Karim Boumghar et Vincent Falardeau

package structures;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import tools.QuickSort;
import tools.Tokenizer;


public class DocumentIndex {
	
	//ArrayList of words found in a document
	private ArrayList<Comparable> words;
	private Document document;
	
	public DocumentIndex(File file, int id) {
		words = new ArrayList<Comparable>();
		setDocument(new Document(file, id));
		tokenize(file);
	}
	
	public void sort() {
		QuickSort.sort(words);
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
				Tokenizer.tokenize(line, words);
				line = input.readLine();
			}
			
			//Sort the list
			this.sort();
			
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
	

	
	public int length() {
		return words.size();
	}
	
	//Gives the ith word
	public Word get(int i) {
		return (Word)words.get(i);
	}

	@Override
	public String toString() {
		String str = getDocument().getName() + ": \n";
		for(Comparable w: words) {
			str += "\t";
			str += w;
			str += "\n";
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
