//Noms : Karim Boumghar et Vincent Falardeau

package tools;

import java.util.ArrayList;

import structures.Word;

public class Tokenizer {
	//Tokenizes a string
	public static void tokenize(String text, ArrayList<Comparable> words){
		
		
		//Add the word in the list or increment frequence if not new
		for(String w: tokenize(text)) {
			if(w.length() > 0) {
				Word word = new Word(w);
				int i = words.indexOf(word);		
				if(i < 0) {
					words.add(word);
				}
				else {
					((Word) words.get(i)).incrementFrequence();
				}
			}
			
		}		
	}

	public static String[] tokenize(String text) {
		//Detect words in the string
		//TODO: Refine word detection
		text = text.replaceAll("[^a-zA-z0-9]", " ");//[^a-zA-z0-9] Keep a-z, A-Z, 0-9
		String[] wordsFound = text.split(" +");//" +" means a space and a character
				
		return wordsFound;
	}
}
