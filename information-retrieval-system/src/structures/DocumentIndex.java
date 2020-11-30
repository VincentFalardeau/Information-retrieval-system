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
	
	private void sort(int beginning, int end) {
		//If t still has to be sorted
		if(beginning < end) {
			
			int pivot = partition(beginning, end);
			
			sort(beginning, pivot - 1);
			sort(pivot + 1, end);
		}	
	}

	/**
	 * @param beginning: The beginning of the partition
	 * @param end: The end of the partition
	 * @return The sorted position of pivot
	 */
	private int partition(int beginning, int end) {
		
		Word pivot = get(beginning);
		
		int i = beginning;
		int j = end;
		
		//While i is smaller than j
		while(i < j) {

			//Increment i until you find an element greater than pivot (or i becomes greater or equal to j)
			while(i < j && get(i).compareTo(pivot) <= 0) {//While get(i) is smaller than pivot (or equal to it
				i++;
			}
			
			//Decrement j until you find an element smaller than pivot
			while(get(j).compareTo(pivot) > 0) {
				j--;
			}
			
			if(i < j) {
				Word temp = get(i);
				set(i, get(j));
				set(j, temp);
			}
			
		}
		
		//j becomes the position of pivot, so interchange j and pivot
		set(beginning, get(j));
		set(j, pivot);
		
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
