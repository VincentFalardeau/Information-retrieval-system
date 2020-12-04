//Noms : Karim Boumghar et Vincent Falardeau

package structures;

import java.io.File;
import java.util.ArrayList;

//Structure #1

public class DocumentIndexor{
	
	//Contains an array of DocumentIndex built from an array of files
	private DocumentIndex[] documentIndexes;
	
	public DocumentIndexor(File[] files) {
		documentIndexes = new DocumentIndex[files.length];
		index(files);
	}

	//Indexes the files
	public void index(File[] files) {
		
		for(int i = 0; i < files.length; i++) {
			documentIndexes[i] = new DocumentIndex(files[i], i);
		}
	}
	
	public int length() {
		return documentIndexes.length;
	}
	
	public DocumentIndex[] getDocumentIndexes() {
		return documentIndexes;
	}
	
	
	//Gives the ith document index
	public DocumentIndex get(int i) {
		return documentIndexes[i];
	}

	//Gives the ith document
	public Document getDocument(int i) {
		return documentIndexes[i].getDocument();
	}
	
	
	@Override
	public String toString() {
		String str = "";
		for(DocumentIndex di: documentIndexes) {
			str += di;
			str += "\n";
		}
		return str;
	}
}
