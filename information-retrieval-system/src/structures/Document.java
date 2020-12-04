//Noms : Karim Boumghar et Vincent Falardeau

package structures;

import java.io.File;

public class Document {
	
	private String name;
	private int frequence;
	private int id;

	//Id of the document represents it's position in the array.
	public Document(File file, int id) {
		setFrequence(0);
		setName(file.getName());
		this.id = id;
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
