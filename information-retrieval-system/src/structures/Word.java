//Noms : Karim Boumghar et Vincent Falardeau

package structures;

public class Word implements Comparable{
	
	private String name;
	//Number of times the word appears
	private int frequence;
	
	public Word(String name) {
		frequence = 1;
		setName(name);
	}
	
	public Word(String name, int frequence) {
		setFrequence(frequence);
		setName(name);
	}
	
	//The criteria for 2 words to be equivalent
	@Override
	public boolean equals(Object o) {
		return getName().equalsIgnoreCase(((Word)o).getName());
	}
	
	@Override
	public String toString() {
		return "(" + getFrequence() + ") " + getName();
	}
	
	@Override
	public int compareTo(Object o) {		
		return getName().compareToIgnoreCase(((Word)o).getName());
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

}
