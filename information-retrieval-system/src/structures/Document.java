package structures;

import java.io.File;

public class Document {
	
	private String name;
	private int frequence;
	
	public Document(String name) {
		setFrequence(1);
		setName(name);
	}
	
	public Document(String name, int frequence) {
		setFrequence(frequence);
		setName(name);
	}
	
	public Document(File file) {
		setFrequence(1);
		setName(file.getName());
	}
	
	@Override
	public String toString() {
		return "(" + getFrequence() + ") " + getName();
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
