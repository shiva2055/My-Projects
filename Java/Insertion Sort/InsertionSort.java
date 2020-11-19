package sort;

public class InsertionSort {

	/*********************************************************
	 * method: insertionSort(int[])
	 *         sorts list using the insertion  sort algorithm
	 * *******************************************************/
	public static void insertionSort(int[] list) {
		int currentElement;
		int j;
		
		for (int i = 1; i < list.length; i++) {
			
			currentElement = list[i];
			
			/************************************************************
			 * shift: list
			 *        shift elements up by one, if current element is less
			 *        than the current list position. 
			 * **********************************************************/
			for (j = i - 1; j >= 0 && currentElement < list[j]; j--) {
				list[j + 1]     = list[j];
			}
				
			/********************************************************
			 * insert: elements
			 *         insert element in open position
			 * ******************************************************/
			list[j + 1] = currentElement;			
			
		}
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
	
	/******************************************************
	 * method: main(String[])
	 *         runs the program. Tests a list of numbers
	 * ****************************************************/
	public static void main(String[] args) {
		int[] list = {2, 9, 5, 4, 8, 1, 6};
		print(list);
		insertionSort(list);
		print(list);
		print(list);
	}

}
