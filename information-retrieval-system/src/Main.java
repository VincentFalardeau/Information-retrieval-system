import java.io.File;
import java.util.ArrayList;

import structures.DocumentIndexor;
import structures.Word;
import view.IndexationPage;

public class Main {

	public static void main(String[] args) {
		
		//new IndexationPage();
		
		
		//DocumentIndexor testing
		File f1 = new File("resources/f1.txt");
		File[] files = {f1};
		DocumentIndexor documentIndexor = new DocumentIndexor(files);
		System.out.println(documentIndexor);
		
//		Word w1 = new Word("allo");
//		ArrayList<Word> a = new ArrayList<Word>();
//		a.add(w1);
//		Word w2 = new Word("allo");
//		System.out.println(a.indexOf(w2));
	}

}
