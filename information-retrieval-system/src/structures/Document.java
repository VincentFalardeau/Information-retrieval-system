//Noms : Karim Boumghar et Vincent Falardeau

package structures;

import java.io.File;

public class Document implements Comparable{
	
	private String name;
	private int frequence;
	
	public Document(String name) {
		setFrequence(0);
		setName(name);
	}
	
	public Document(String name, int frequence) {
		setFrequence(frequence);
		setName(name);
	}
	
	public Document(File file) {
		setFrequence(0);
		setName(file.getName());
	}
	
	@Override
	public String toString() {
		return "(" + getFrequence() + ") " + getName();
	}

	public void incrementFrequence(){
		setFrequence(getFrequence() + 1);
	}
	
	public void incrementFrequence(int amount){
		setFrequence(getFrequence() + amount);
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

	@Override
	public int compareTo(Object o) {
		
		//allows to sort in a decreasing way according to the score
		return ((Document)o).getFrequence() - frequence;
	}

}
