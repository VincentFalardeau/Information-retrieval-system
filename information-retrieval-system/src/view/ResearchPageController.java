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
		
		//UTILISER RECHERCHE BINAIRE POUR TROUVER LE PREMIER MOT DE wordsToSearch DANS WORD INDEXOR ET AJOUTER CHAQUE DOCUMENT QUI ONT UNE FR�QUENCE 
		// > 0 DANS NOTRE LISTE ANSWERLIST.
		
		//PARCOURIR LES AUTRES MOTS DE NOTRE WORDSTOSEARCH ET V�RIFIER LES FR�QUENCES OBTENUES DE NOS DOCUMENTS DANS ANSWERLIST SI 0 = ENLEV�, SI != 0 ON ADDITIONNE � LA FR�QUENCE
		
		//RETOURNER SOIT UN TABLEAU DES DOCUMENTS + FR�QUENCES (SCORE DANS CE CAS) OU LE STRING REPR�SENTANT CA ET L'AFFICHER DANS LA BO�TE
		
		//QUESTIONS : PK COMPARABLE
		//BEAUCOUP DE DOCUMENTINDEXOR C'EST TR�S TR�S TR�S TR�S M�LANT
		//PK C'EST PAS DES SOUS-CLASSES
		//COMMENT J'ACC�DE � LA LISTE DE MOTS TOUT COURT?
		//IL FAUT FAIRE + DE TOUT STRING
		//EST-CE QU'ON PEUT ACCEDER � WORDSINDEXORLIST D'UNE AUTRE FA�ON?
		//FAIRE LES ALERTS
		
		
		
		
		//Creating our first 
		
		
		
		return "a";
	}

}
