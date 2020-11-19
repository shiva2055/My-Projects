/********************************************************************************
 * Concept:     Bubble Sort
 * Category:    Sorting Algorithms
 * Description: This class demonstrates the use of a bubble sort algorithm. 
 * Algorithm:   Sort the list in multiple passes..
 * 				The key is checked against each element in the array.
 *              (a) Each pass successively swaps the neighboring elements
 *                  if the elements are not in order.
 ********************************************************************************/

package sort;

public class BubbleSort {

	/*********************************************************
	 * method: bubbleSort(int[])
	 *         sorts list using the insertion  sort algorithm
	 * *******************************************************/
	public static void bubbleSort(int[ ] list) {
		
		int temp = 0;
		
		//k number of passes 
		for (int k = 1; k < list.length; k++) {
			for(int j = 0; j < list.length - 1; j++) {
		
				if( list[j] > list[j + 1] ) {
					temp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = temp;
				}
			}
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
		int[] list = {2, 9, 5, 4, 8, 1};
		print(list);
	    bubbleSort(list);
		print(list);

	}

}
