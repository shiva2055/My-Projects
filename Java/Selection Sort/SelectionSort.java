package recursion;

public class SelectionSort {
	
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
	
	/********************************************************************
	 * method: selectionSort(int[])
	 *         initial call to sort list using selection sort algorithm.
	 * ******************************************************************/
	public static void selectionSort(int[] list) {
		selectionSort(list, 0, list.length - 1);		//sort entire list
	}
	
	/***************************************************************
	 * method: selectionSort(int[])
	 *         sorts list using selection sort algorithm.
	 * *************************************************************/
	public static void selectionSort(int[] list, int low, int high) {
		
		if (low < high) {
			int currentMinIndex = low;
			int currentMin      = list[low];
			
			/****************************************************
			 * index: i
			 *        find the smallest number and its index in 
			 *        list (from low to high)
			 * **************************************************/
			for(int i = low + 1; i < high + 1; i++) {
				if(list[i] < currentMin){
					currentMin      = list[i];
					currentMinIndex = i;
				}
			}	
			
			/********************************************************
			 * swap: value
			 *       swap smallest in list with current low position
			 * ******************************************************/
			list[currentMinIndex] = list[low];
			list[low]             = currentMin;
			
			/********************************************************
			 * sort: recursion
			 *       make a recursive call to sort the list
			 * ******************************************************/
			selectionSort(list, low + 1, high);
		}
		
	}

	/******************************************************
	 * method: main(String[])
	 *         runs the program. Tests a list of numbers
	 * ****************************************************/
	public static void main(String[] args) {
		int[] list = {2, 9, 5, 4, 8, 1, 6};
		print(list);
		selectionSort(list);
		print(list);
	}

}
