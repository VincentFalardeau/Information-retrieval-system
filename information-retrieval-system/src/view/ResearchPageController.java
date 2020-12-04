package view;
import structures.*;
import tools.BinarySearch;
import tools.QuickSort;
import tools.Tokenizer;
import java.util.ArrayList;
import java.util.Arrays;

public class ResearchPageController{
	
	WordIndexor wordIndexorList;
	
	public ResearchPageController(WordIndexor wordIndexorList) {
		this.wordIndexorList = wordIndexorList;
	}

	public String scoreResearch(String searchQuery) {
		
		//Transforming our search query into an array of words using our tokenizer
		String[] wordsToSearch;
		wordsToSearch = Tokenizer.tokenize(searchQuery);
		
		//This is our list which contains the words that we have in all the documents and their frequences in each document
		ArrayList<Comparable> wordsList = wordIndexorList.getWordIndexes();
		
		//Our array list of answer
		ArrayList<Comparable> answerList = new ArrayList<Comparable>();
		

		
		//Searching for our first word in our words list and adding all the documents 
		int index = BinarySearch.search(wordsToSearch[0],wordsList);
		
		
		if (index == -1) {
			return "";
		}
		
		else {
			//The "Line" of our word which contains every documents and the word frequences in it
			WordIndex wordFound = (WordIndex)wordsList.get(index);
			
			for (int i = 0; i < WordIndexor.getDocumentCount(); i++) {
				
				//Getting the frequence of the word we're searching for in ith document
				int frequenceDocument = wordFound.getFrequence(i);
				
				if (frequenceDocument > 0) {
					//We make a COPY of our document so that we don't modify our original data
					Document doc = new Document (wordIndexorList.getDocumentIndexor().getDocument(i));
					//Increment the frequence by the amount we need and add it to our answers list
					doc.incrementFrequence(frequenceDocument);			
					answerList.add(doc);
				}
				
				
			}
		}
		
		
		//We loop through every words we have to search for
		for (int i = 1; i < wordsToSearch.length; i++) {
			
			//Finding the indexPosition of the word in our wordsList if it exists
			int indexWord = BinarySearch.search(wordsToSearch[i], wordsList);
			
			if (indexWord == -1) {
				return "";
			}
			
			else {
				
				//The "Line" of our word which contains every documents and the word frequences in it
				WordIndex wordFound = (WordIndex)wordsList.get(indexWord);
				
				for (int j = 0; j < answerList.size(); j++) {
					
					//Getting the frequence of the word we're searching for in jth document
					int frequenceDocument = wordFound.getFrequence(((Document)answerList.get(j)).getId());
					
					//If it's greater than 0, we increment our score
					if (frequenceDocument > 0) {
						((Document)answerList.get(j)).incrementFrequence(frequenceDocument);
					}
					
					//Otherwise, it's not in the document and we can remove the document from our answers list
					else {

						answerList.remove(j);
						j--;
					}
					
				}
				
				//If the answerList is already empty,we don't have to keep looping and we can just return an empty string
				if (answerList.isEmpty()) {
					return "";
				}
			}
		}
		
		
		//Sorting our answerList
		QuickSort.sort(answerList);
		
		//Returning all the document we found and their scores after manipulating the string a bit to remove brackets and commas
		return Arrays.toString(answerList.toArray()).replace(", ", "\n").replace("[","").replace("]", "");

	}

}
