package structures;

//Class that holds our array of documents and link each word with that array of documents
public class WordIndex implements Comparable{
	
	//The ith index of the documents array represents the number of occurences of the word in the ith document
	public int[] documents;
	private Word word;
	
	public WordIndex(Word word) {
		this.word = word;
		this.documents = new int[WordIndexor.documentCount];//since the number of documents is fixed
	}
	
	//Gives the frequence of the word in the ith document
	public int getFrequence(int i) {
		return documents[i];
	}
	
	//Increments the frequence for 1
	public void incrementFrequence(int i) {				
		documents[i]++;		
	}
	
	//Increments the frequence of the word in the ith document by amount
	public void incrementFrequence(int i, int amount) {				
		documents[i] += amount;		
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
	
	//Overload of compareTo method when we want to compare to a string.
	public int compareTo(String str) {
		return getWord().getName().compareToIgnoreCase(str);
	}
}