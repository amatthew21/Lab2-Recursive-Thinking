package search;

public class LinearSearch {
	/** The method for finding a key in the list */
	public static int linearSearch(int[] list, int key) {
		for (int i = 0; i < list.length; i++) {
			if ( key == list[i]) {
				return i;
			}
		}
		return -1;
	}
	
	/** Recursive method for finding a key in the list */
	public static int recursiveSearch(int[] list, int min, int max, int key) {
		if (max < 1)
			return -1;
		if (list[min] == key)
			return min;
		if (list[max] == key)
			return max;
		return recursiveSearch(list, min + 1, max - 1, key);
	}
	
	public static void main(String[] args) {
		final int N = 100;
		//final int KEY = 150;
		//generate random key from 0 - 100
		final int KEY = (int)(Math.random() * (100 - 0 + 1) + 0);
		int[] list = new int[N];
		
		for (int i = 0; i < N; i++) {
			//MODIFIED CONDITION
			if (i == 0) {
				list[i] = 150;
			} else {
			//generate random positive and negative numbers from -100 to 100
			list[i] = (int)(Math.random() * 100 * (Math.random() > 0.5 ? 1 : -1));
			}
			//print them
			System.out.print(list[i] + ",");
		}
		
		long begin, end, time; //we will measure time it took to search
		begin = System.nanoTime();//we measure in nanoseconds
		
		//Starting the watch
		System.out.println(linearSearch(list, KEY));
		System.out.println(linearSearch(list, KEY));
		
		end = System.nanoTime();
		time = end - begin;
		System.out.println("it took " + time + " nanoseconds to run linear search with the key " + KEY
				+ " on the array of " + N + " elements."); 
		
		//RECURSIVE SEARCH
		int search = recursiveSearch(list, 0, list.length-1, KEY);
		if (search != -1) {
			System.out.println("KEY found at index: " + search);
		} else {
			System.out.println("KEY not found");
		}
	}
}