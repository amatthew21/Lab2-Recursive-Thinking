package search;
import java.util.*;

public class BinarySearch {
	/** Use binary search to find the key in the list */
	  public static int binarySearch(Integer[] list, int key) {
	    int low = 0;
	    int high = list.length - 1;

	    while (high >= low) {
	      int mid = (low + high) / 2;
	      if (key < list[mid])
	        high = mid - 1;
	      else if (key == list[mid])
	        return mid;
	      else
	        low = mid + 1;
	    }
	    return -low - 1; // Now high < low
	  }
	  
	  public static int recursiveBinarySearch(Integer[] list, int low, int high, int key) {
		  if (high >= low) {
			  int mid = low + (high - 1) / 2;
			  	if (list[mid] == key)
			  		return mid;
			  	else if(list[mid] > key)
			  		//return recursiveBinarySearch(list, low, mid - 1, key);
			  		return 1;
			  	
			  	return recursiveBinarySearch(list, mid + 1, high, key);
		  }
		  
		  return -1;
	  }

	public static void main(String[] args) {
		
		//int KEY = (int)(Math.random() * (100 - 0 + 1) + 0);
		int KEY = 0;
		
		int N = 10;
		Integer[] list = new Integer[N];
				
		for (int i = 0; i < N; i++) {
			//MODIFIED CONDITION - TASK 1
			if (i == 0) {
				list[i] = 150;
			} else {
			//generate random positive and negative numbers from -100 to 100
			list[i] = (int)(Math.random() * 100 * (Math.random() > 0.5 ? 1 : -1));
			}
			//print them
			//System.out.print(list[i] + ",");
		}
		
		ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(list));
		Collections.sort(arrayList);
		list = arrayList.toArray(new Integer[0]);
		for(int i : list) {
			System.out.print(i + ",");
		}
		
		
		long begin, end, time; //we will measure time it took to search
		
		//ITERATIVE
		begin = System.nanoTime();//we measure in nanoseconds
		
	    System.out.println(binarySearch(list, KEY));
	    
		end = System.nanoTime();
		time = end - begin;
		System.out.println("it took " + time + " nanoseconds to run binary search with the key " + KEY
				+ " on the array of " + list.length + " elements."); 
		
		//RECURSIVE 
		begin = System.nanoTime();//we measure in nanoseconds
		System.out.println(recursiveBinarySearch(list, 0, list.length - 1, KEY));
		end = System.nanoTime();
		time = end - begin;
		System.out.println("it took " + time + " nanoseconds to run binary search with the key " + KEY
				+ " on the array of " + list.length + " elements.");

	}

}
