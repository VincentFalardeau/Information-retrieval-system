package tools;

import java.util.ArrayList;
import structures.*;

public class BinarySearch {
	
	//Method that search for x word in arraylist from index start to index end and returns position in array
	//or -1 if it's not there. This search ignores capitalization and uses binary search
	public static int search(String x, ArrayList<Comparable> arr, int start, int end) {
		
		x = x.toLowerCase();
		
		//Initialize the middle of our array
		int middle = (start + end) / 2;
		
		if (start > end) {
			return -1;
		}
		
		//If both Strings are equal
		if (((WordIndex)arr.get(middle)).compareTo(x) == 0) {
			return middle;
		}
		
		//If the string in the array is greater than the one we're searching for
		else if (((WordIndex)arr.get(middle)).compareTo(x) > 0) {
			return search(x, arr, start, middle-1);
		}
		
		//If the string in the array is lesser than the one we're searching for
		else {
			return search(x, arr, middle+1, end);
			
		}
		
		
		
	}
	
	//Binarysearch overload (to search through whole arraylist)
	public static int search(String x, ArrayList<Comparable> arr) {
		
		return search(x, arr, 0, arr.size()-1);
		
	}

}
