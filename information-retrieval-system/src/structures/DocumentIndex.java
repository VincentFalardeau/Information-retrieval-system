package structures;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

//ArrayList of words found in a document
public class DocumentIndex extends ArrayList<Word>{

	private Document document;
	
	public DocumentIndex(File file) {
		setDocument(new Document(file));
		tokenize(file);
	}
	
	//Our own sort method
	public void sort() {
		//Quicksort
		sort(0, this.size() - 1);
	}
	
	private void sort(int from, int to) {
		//If t still has to be sorted
		if(from < to) {
			
			int pivot = partition(from, to);
			
			sort(from, pivot);
			sort(pivot + 1, to);
		}	
	}

	/**
	 * @param from: The beginning of the partition
	 * @param to: The end of the partition
	 * @return The sorted position of pivot
	 */
	private int partition(int from, int to) {
		
		Word pivot = get(from);
		
		int i = from - 1;
		int j = to + 1;
		
		while(i < j) {
			
			//Increment i until you find an element greater than pivot
			i++;
			while(get(i).smallerThan(pivot)) {
				i++;
			}
			
			//Decrement j until you find an element smaller than pivot
			j--;
			while(get(j).greaterThan(pivot)) {
				j--;
			}
			
			//If the two elements are not sorted, exchange them.
			//Sorted means the smallest should be to the left of the pivot
			//and the greatest to the right.
			if(i < j) {
				Word temp = get(i);
				set(i, get(j));
				set(j, temp);
			}
		}
		
		//Return the position of the pivot
		return j;
		
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
		String str = getDocument().getName() + ": \n";
		for(Word w: this) {
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
