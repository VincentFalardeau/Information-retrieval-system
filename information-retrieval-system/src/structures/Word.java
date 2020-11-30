package structures;

public class Word {
	
	private String name;
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
		return getName().toLowerCase().equals(((Word)o).getName().toLowerCase());
	}
	
	@Override
	public String toString() {
		return getName() + "(" + getFrequence() + ")";
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
