//Noms : Karim Boumghar et Vincent Falardeau

package structures;

import java.util.ArrayList;

import tools.QuickSort;

//Structure #2
public class WordIndexor {
	
	//ArrayList of words and the number of time they are found among documents
	public ArrayList<Comparable> wordIndexes;
	public static int documentCount;
	public DocumentIndexor documentIndexor;
	
	public WordIndexor(DocumentIndexor documentIndexor) {
		this.documentIndexor = documentIndexor;
		documentCount = documentIndexor.length();
		wordIndexes = new ArrayList<Comparable>();
		index();
	}

	//Procedure that indexes the documents (build the second structure from the first one)
	private void index() {
		
		//For every document
		for(int i = 0; i < documentCount; i++) {
			
			DocumentIndex doc = documentIndexor.get(i);
			
			//For every word in that document
			for(int j = 0; j < doc.length(); j++) {
				
				Word word = (Word)doc.get(j);
				int k = wordIndexes.indexOf(new WordIndex(word));
				
				//First time this word is found, make new wordIndex
				if(k < 0) {
					WordIndex wordIndex = new WordIndex(word);
					//Found in the ith document
					wordIndex.incrementFrequence(i, word.getFrequence());

					wordIndexes.add(wordIndex);
				}
				//Not the first time the word is found
				else {
					//Seen in the ith document once more
					((WordIndex) wordIndexes.get(k)).incrementFrequence(i, word.getFrequence());
				}
				
			}
		}
		
		sort();
		
		
	}
	
	public static int getDocumentCount() {
		return documentCount;
	}

	public DocumentIndexor getDocumentIndexor() {
		return documentIndexor;
	}

	public void sort() {
		QuickSort.sort(wordIndexes);
		
	}

	public ArrayList<Comparable> getWordIndexes() {
		return wordIndexes;
	}

	public void setWordIndexes(ArrayList<Comparable> wordIndexes) {
		this.wordIndexes = wordIndexes;
	}

	@Override
	public String toString() {
		String str = "";
		for(int i = 0; i < wordIndexes.size(); i++) {
			str += toString(i);
			str += "\n";
		}
		return str;
	}
	
	//Gives a String representation of the ith WordIndex
	public String toString(int i) {
		WordIndex wordIndex = (WordIndex) wordIndexes.get(i);
		Word word = wordIndex.getWord();
		String str = word.getName() + ": \n\t";
		
		for(int j = 0; j < documentCount; j++) {
			str += "(" + wordIndex.getFrequence(j) + ")" + documentIndexor.getDocument(j).getName();
			str += " ";
		}
		
		return str;
		
	}
}