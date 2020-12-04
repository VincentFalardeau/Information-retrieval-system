package view;
import structures.*;
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
		
		//Our array list of answer
		ArrayList<Document> answerList;
		
		//UTILISER RECHERCHE BINAIRE POUR TROUVER LE PREMIER MOT DE wordsToSearch DANS WORD INDEXOR ET AJOUTER CHAQUE DOCUMENT QUI ONT UNE FRÉQUENCE 
		// > 0 DANS NOTRE LISTE ANSWERLIST.
		
		//PARCOURIR LES AUTRES MOTS DE NOTRE WORDSTOSEARCH ET VÉRIFIER LES FRÉQUENCES OBTENUES DE NOS DOCUMENTS DANS ANSWERLIST SI 0 = ENLEVÉ, SI != 0 ON ADDITIONNE À LA FRÉQUENCE
		
		//RETOURNER SOIT UN TABLEAU DES DOCUMENTS + FRÉQUENCES (SCORE DANS CE CAS) OU LE STRING REPRÉSENTANT CA ET L'AFFICHER DANS LA BOÎTE
		
		//QUESTIONS : PK COMPARABLE
		//BEAUCOUP DE DOCUMENTINDEXOR C'EST TRÈS TRÈS TRÈS TRÈS MÉLANT
		//PK C'EST PAS DES SOUS-CLASSES
		//COMMENT J'ACCÈDE À LA LISTE DE MOTS TOUT COURT?
		//IL FAUT FAIRE + DE TOUT STRING
		//EST-CE QU'ON PEUT ACCEDER À WORDSINDEXORLIST D'UNE AUTRE FAÇON?
		//FAIRE LES ALERTS
		
		
		
		
		//Creating our first 
		
		
		
		return "a";
	}

}
