//Noms : Karim Boumghar et Vincent Falardeau

package structures;

import java.util.ArrayList;
import java.util.Arrays;

import tools.QuickSort;

//Structure #2
public class WordIndexor {
	
	//ArrayList of words and the number of time they are found among documents
	public ArrayList<Comparable> wordIndexes;
	public static int documentCount;
	public DocumentIndexor documentIndexor;
	private ArrayList<Document> searchResult;
	
	public WordIndexor(DocumentIndexor documentIndexor) {
		this.documentIndexor = documentIndexor;
		documentCount = documentIndexor.length();
		wordIndexes = new ArrayList<Comparable>();
		index();
	}

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
					wordIndex.incrementFrequence(i);//Found in the ith document
					wordIndexes.add(wordIndex);
				}
				//Not the first time the word is found
				else {
					((WordIndex) wordIndexes.get(k)).incrementFrequence(i);//Seen in the ith document once more
				}
			}
		}
		
		sort();
		
		
	}
	
	public String search(String[] words) {
		
		//Effectuer la recherche binaire
		
		
		//TODO: Modifier pour faire comme le TP le dit, ceci est juste pour tester
		//Supposons qu'on a comme resultat:
		int resultIndex = 0;
		WordIndex[] wordIndexOfResults = {(WordIndex) wordIndexes.get(resultIndex), (WordIndex) wordIndexes.get(1)};//Aller chercher les wordIndexes des resultats
		ArrayList<Comparable> results = new ArrayList<Comparable>();
		for(int i = 0; i < documentCount; i++) {
			int frequence = wordIndexOfResults[0].getFrequence(i);//La frequence du premier mot dans le ieme document
			
			
			if(frequence > 0) {//Si le mot est bel et bien dans le ieme document
				Document doc = documentIndexor.getDocument(i);//Prendre le document et le mettre dans la liste des resultats
				doc.setFrequence(frequence);
				
				//Verifier pour les autres mots de la recherche
				Word autreMot = wordIndexOfResults[1].getWord();
				DocumentIndex docIndex = documentIndexor.get(i);
				if(docIndex.contains(autreMot.getName())) {
					doc.incrementFrequence(autreMot.getFrequence());//Augmenter le score
					results.add(doc);//Si oui, le document peut etre imprime en resultat
				}
				
				
			}
			
		}
		QuickSort.sort(results);//Ordonner les documents selon leur score
		
		return Arrays.toString(results.toArray());//Retourner la version string de l'array
		
	}
	
	public void sort() {
		QuickSort.sort(wordIndexes);
		
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
	private String toString(int i) {
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
