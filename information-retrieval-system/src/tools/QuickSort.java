package tools;

import java.util.ArrayList;


public class QuickSort {
	
	public static void sort(ArrayList<Comparable> list) {
		sort(list, 0, list.size() - 1);
	}
	
	private static void sort(ArrayList<Comparable> list, int from, int to) {
		//If t still has to be sorted
		if(from < to) {
			
			int pivot = partition(list, from, to);
			
			sort(list, from, pivot);
			sort(list, pivot + 1, to);
		}	
	}

	/**
	 * @param from: The beginning of the partition
	 * @param to: The end of the partition
	 * @return Position of a sorted element
	 */
	private static int partition(ArrayList<Comparable> list, int from, int to) {
		
		Comparable pivot = list.get(from);
		
		int i = from - 1;
		int j = to + 1;
		
		while(i < j) {
			
			//Increment i until you find an element greater than pivot
			i++;
			while(list.get(i).compareTo(pivot) < 0) {
				i++;
			}
			
			//Decrement j until you find an element smaller than pivot
			j--;
			while(list.get(j).compareTo(pivot) > 0) {
				j--;
			}
			
			//If the two elements are not sorted, exchange them.
			//Sorted means the smallest should be to the left of the greatest.
			if(i < j) {
				Comparable temp = list.get(i);
				list.set(i, list.get(j));
				list.set(j, temp);
			}
		}
		
		//Return the position of one of the sorted element
		return j;
		
	}

}
