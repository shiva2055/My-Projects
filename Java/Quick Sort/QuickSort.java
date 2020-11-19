package recursion;

public class QuickSort {

	/******************************************************
	 * method: main(String[])
	 *         runs the program. Tests a list of numbers
	 * ****************************************************/
	public static void main(String[] args) {
		int[] list = {5, 2, 9, 3, 8, 4, 0, 1, 6, 7};
		print(list);
		quickSort(list);
		print(list);
	}
	
	/***************************************************************
	 * method: partition(int[], int , int)
	 *         returns the pivot index.
	 * *************************************************************/
	public static int partition(int[] list, int low, int high) {
		int temp;							// temporary variable for swap
		boolean done = false;
		int mid      = (low + high) / 2; 	// pick middle element as pivot
		int pivot    = list[mid];			// choose middle location as pivot
		
		while(!done) {
			
			/************************************************************
			 * increment: low
			 *        	  increment low while value in low index < pivot
			 * **********************************************************/
			while(list[low] < pivot) {	
				low++;
			}
			
			/**************************************************************
			 * decrement: high
			 *        	  decrement high while pivot < value in high index 
			 * ************************************************************/
			while(pivot < list[high]) {	
				high--;
			}
			
			/********************************************************
			 * check: index
			 *        if there are zero or one items remaining, all 
			 *        items are now partitioned. return high index.
			 * ******************************************************/
			if (low >= high) {
				done = true;
			}else {
				/********************************************************
				 * swap: index
				 *       swap list[low] and list[high], update low and
				 *       high indexes.
				 * ******************************************************/
				temp       = list[low];
				list[low]  = list[high];
				list[high] = temp;
				low++;
				high--;
			}
		}
		return high;
	}
	
	/***************************************************************
	 * method: print(int[])
	 *         prints contents of list.
	 * *************************************************************/
	public static void print(int[] list) {
		
		for(int i = 0; i < list.length; i++) {
			System.out.print("[" + i + "]");
		}
		System.out.println();
		
		for(int item : list) {
			System.out.print(" " + item + " ");
		}
		System.out.println();
		System.out.println();
	}
	
	/***************************************************************
	 * method: quickSort(int[])
	 *         initial call to sort list using quick sort algorithm.
	 * *************************************************************/
	public static void quickSort(int[] list) {
		quickSort(list, 0, list.length - 1);
	}
	
	/*****************************************************************
	 * method: quickSort(int[], int, int)
	 *         sorts list using quick sort algorithm using recursion.
	 * ***************************************************************/
	public static void quickSort(int[] list, int low, int high) {
		
		int last;				// last item in low partition
		
		/***************************************************************
		 * base case: sorted partitions
		 *        	  if there are zero or one items to sort, partition 
		 *        	  is already sorted.
		 * *************************************************************/
		if (low >= high) {
			return;
		}
		
		/*****************************************************************
		 * partition: index
		 *            partition the data within the array. Value returned
		 *        	  from partitioning is the location of the last item 
		 *            in low partition.
		 * ***************************************************************/
		last = partition(list, low, high);
		
		/**********************************************************
		 * recursion: sort
		 *        	  recursively sort low partition (low to last) 
		 *            and high partition (last + 1 to high).
		 * ********************************************************/
		quickSort(list, low, last);
		quickSort(list, last + 1, high);
	}
	
}
