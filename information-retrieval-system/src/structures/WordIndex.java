package structures;

public class WordIndex implements Comparable{
	
	//The documents array, 0 at index i means no occurence of the current word in the ith document of documentIndexor
	//1 means there is an occurence of the current word in the ith document of documentIndexor
	public int[] documents;
	private Word word;
	
	public WordIndex(Word word) {
		this.word = word;
		this.documents = new int[WordIndexor.documentCount];
	}
	
	//Gives the frequence of the word in the ith document
	public int getFrequence(int i) {
		
		//TODO  special cases
		assert documents.length > i;
		
		return documents[i];
	}
	
	//Increments the frequence of the word in the ith document
	public void incrementFrequence(int i) {
		
		//TODO  special cases
		assert documents.length > i;
				
		documents[i]++;
	}
	
	public Word getWord() {
		return word;
	}
	
	@Override
	public boolean equals(Object o) {
		return ((WordIndex)o).getWord().equals(getWord());
		
	}

	@Override
	public int compareTo(Object o) {
		return getWord().compareTo(((WordIndex)o).getWord());
	}
}
