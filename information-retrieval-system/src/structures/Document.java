//Noms : Karim Boumghar et Vincent Falardeau

package structures;

import java.io.File;

public class Document implements Comparable{
	
	private String name;
	//The frequence of the document, also the score when searching for words
	private int frequence;
	private int id;

	//Id of the document represents it's position in the array.
	public Document(File file, int id) {
		setFrequence(0);
		setName(file.getName());
		this.id = id;
	}
	
	//Copy constructor
	public Document(Document document) {
		this.name = document.name;
		this.frequence = document.frequence;
		this.id = document.id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void incrementFrequence(){
		setFrequence(getFrequence() + 1);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFrequence() {
		return frequence;
	}

	public void setFrequence(int frequence) {
		this.frequence = frequence;
	}


	public void incrementFrequence(int amount) {
		this.frequence = frequence + amount;
	}
	
	@Override
	public String toString() {
		return "(" + getFrequence() + ") " + getName();
	}

	@Override
	public int compareTo(Object o) {
		//Allows to sort in a decreasing way according to the score
		return ((Document)o).getFrequence() - frequence;
	}
	
	
	
}
