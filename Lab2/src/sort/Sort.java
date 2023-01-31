package sort;



public class Sort {
	
	  /** The method for sorting the numbers */
	//From Pearson / Lab Page
	  public static void selectionSort(double[] list) {
	    for (int i = 0; i < list.length - 1; i++) {
	      // Find the minimum in the list[i..list.length-1]
	      double currentMin = list[i];
	      int currentMinIndex = i;

	      for (int j = i + 1; j < list.length; j++) {
	        if (currentMin > list[j]) {
	          currentMin = list[j];
	          currentMinIndex = j;
	        }
	      }

	      // Swap list[i] with list[currentMinIndex] if necessary;
	      if (currentMinIndex != i) {
	        list[currentMinIndex] = list[i];
	        list[i] = currentMin;
	      }
	    }
	  }
	  //Recursive Version
	  public static void recurSort(double[] list) {
		  recurSort(list, 0, list.length - 1);
	  }
	  public static void recurSort(double[] list, int low, int high) {
		  if(low < high) {
			  // Finds the smallest number and it's location on the list
			  int minPos = low;
			  double min = list[low];
			  for (int i = low + 1; i <= high; i++) {
				  if (list[i] < min) {
					  min = list[i];
					  minPos = i;
				  }
			  }
			  
			  list[minPos] = list[low];
			  list[low] = min;
			  
			  recurSort(list, low+1,high);
		  }
	  }
	  
	  //Tower of Hanoi
	
	public static void main(String[] args) {
		int size = 10;
		double[] list = new double[size];
		//For Worst Case, Starts from size and goes down.
		
		for (int i = 0; i < list.length; i++) {
			list[i] = size - i;
		}
		
		//For Best Case, Auto sorted by being added in the list by ascending order
		/**
		for (int i = 0; i < list.length; i ++) {
			list[i] = i;
		}
		*/
		long begin, end, time;
		System.out.println();
		begin = System.nanoTime();
		recurSort(list);
		end = System.nanoTime();
		time = end-begin;
		System.out.println();
		System.out.println("It took " + time + " nanoseconds to run a selection sort with a size of " + size );
	}

}
