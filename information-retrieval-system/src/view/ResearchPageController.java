package view;
import structures.*;
import tools.BinarySearch;
import tools.QuickSort;
import tools.Tokenizer;
import java.util.ArrayList;

public class ResearchPageController{
	
	WordIndexor wordIndexorList;
	
	public ResearchPageController(WordIndexor wordIndexorList) {
		this.wordIndexorList = wordIndexorList;
	}

	public String scoreResearch(String searchQuery) {
		
		//Transforming our search query into an array of words using our tokenizer
		String[] wordsToSearch;
		wordsToSearch = Tokenizer.tokenize(searchQuery);
		
		
		ArrayList<Comparable> wordsList = wordIndexorList.getWordIndexes();
		
		
		System.out.println("worIndexorList = " + wordIndexorList.toString());
		//Our array list of answer
		ArrayList<Document> answerList = new ArrayList<Document>();
		

		
		//Searching for our first word in our words list.
		int index = BinarySearch.search(wordsToSearch[0],wordsList);
		
		
		if (index == -1) {
			return "";
		}
		
		else {
			WordIndex test = (WordIndex)wordsList.get(index);
			
			for (int i = 0; i < WordIndexor.getDocumentCount(); i++) {
				
				int frequenceDocument = test.getFrequence(i);
				
				System.out.println("Frequence document" + frequenceDocument);
				
				if (frequenceDocument > 0) {
					Document doc = wordIndexorList.getDocumentIndexor().getDocument(i);
					doc.incrementFrequence(frequenceDocument);
					answerList.add(doc);
				}
				
				
			}
		}
		
		System.out.println(answerList.get(0).toString());
		
		
		
		
		
		//UTILISER RECHERCHE BINAIRE POUR TROUVER LE PREMIER MOT DE wordsToSearch DANS WORD INDEXOR ET AJOUTER CHAQUE DOCUMENT QUI ONT UNE FRÉQUENCE 
		// > 0 DANS NOTRE LISTE ANSWERLIST.
		
		for (int i = 1; i < wordsToSearch.length; i++) {
			int indexWord = BinarySearch.search(wordsToSearch[i], wordsList);
			
			if (indexWord == -1) {
				return "";
			}
			
			else {
				
				WordIndex WordFound = (WordIndex)wordsList.get(indexWord);
				
				
				for (int j = 0; j < answerList.size(); j++) {
					
					int frequenceDocument = WordFound.getFrequence(j);
					
					if (frequenceDocument > 0) {
						answerList.get(j).incrementFrequence(frequenceDocument);
					}
					
					else {
						answerList.remove(j);
						--j;
						//TO DO : Check if answeList.size() is re-calculated every cycle
					}
					
				}
				
				if (answerList.isEmpty()) {
					return "";
				}
			}
		}
		
		for (int i = 0; i < answerList.size(); i++) {
			//System.out.println(answerList.get(i));
		}
		//RETOURNER SOIT UN TABLEAU DES DOCUMENTS + FRÉQUENCES (SCORE DANS CE CAS) OU LE STRING REPRÉSENTANT CA ET L'AFFICHER DANS LA BOÎTE
		
		
		
		
		
		
		
		
		

		
		
		
		
		//Creating our first 
		
		
		
		return "a";
	}

}
