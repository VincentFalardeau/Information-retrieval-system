package structures;

import java.util.ArrayList;

//ArrayList of words and the number of time they are found among documents
public class WordIndexor extends ArrayList<WordIndex>{
	
	public static int documentCount;
	public static DocumentIndexor documentIndexor;
	
	public WordIndexor(DocumentIndexor documentIndexor) {
		this.documentIndexor = documentIndexor;
		documentCount = documentIndexor.length();
		index();
	}

	private void index() {
		
		//TODO: find every single unique word and count their occurrences in every document
		//Create a WordIndex for every word.
		//WordIndex contains an array of int.
			//The ith element of the array of int is the ith element of documentIndexor (ith document)
			//It is filled with zero automatically
			//increment documents[i] whenever you find an occurence of the word in the ith document
		
		ArrayList<WordIndex> uniqueWords = new ArrayList<WordIndex>();
		
		//For every document
		for(int i = 0; i < documentCount; i++) {
			
			DocumentIndex doc = documentIndexor.get(i);
			
			//For every word in that document
			for(int j = 0; j < doc.size(); j++) {
				
				Word word = doc.get(j);
				
				int k = uniqueWords.indexOf(word);
				
				//First time this word is found, make new wordIndex
				if(k < 0) {
					WordIndex wordIndex = new WordIndex(word);
					wordIndex.incrementFrequence(i);//Found in the ith document
					uniqueWords.add(wordIndex);
				}
				//Not the first time the word is found
				else {
					WordIndex wordIndex = uniqueWords.get(k);
					wordIndex.incrementFrequence(i);//Seen in the ith document
				}
			}
		}
		
		
	}
	
	@Override
	public String toString() {
		
	}
}
