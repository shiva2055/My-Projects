/********************************************************************************
 * Concept:     Binary Search
 * Category:    Search Algorithms
 * Description: This class demonstrates the use of a binary search algorithm. 
 * Algorithm:   A key value is compared with the middle index value.
 * 				Initially the low end and high end index is set to 0 and 
 * 				length - 1 respectively, and the middle index is set to
 * 				the integer average of high and low.
 *              (a) if key value is less than the middle element, search only
 *                  in the front half of the array for index.
 *              (b) if key value is greater than the middle element, search only
 *                  in the back half of the array for index.
 *              (c) if key value matches the middle element, return the index
 *                  of the middle value.
 *              (d) if a match is not found it returns -1.
 ********************************************************************************/

package search;

public class BinarySearch {

	/******************************************************
	 * method: binarySearch(int[], int)
	 *         implements the binary search algorithm
	 * ****************************************************/
	public static int binarySearch(int[] list, int key) {
		
		System.out.println("key value: " + key);
		
		int low  = 0;						// low index set to front of list
		int high = list.length - 1;			// high index set to end of list
		int mid;							// middle index
		
		while (low <= high) {
			
			mid = (low + high) / 2;		   //  set middle index 
			
			if(key < list[mid]) {
				
				high = mid - 1;				// highest index set below middle
				
			}else if(key == list[mid]) {
				
				return mid;
				
			}else {
				low = mid + 1;				// highest index set above middle
			}
		}
		return -1;
	}
	
	/******************************************************
	 * method: main(String[])
	 *         runs the program. Tests a list of numbers
	 * ****************************************************/
	public static void main(String[] args) {
		
		int[] list = {1, 3, 5, 7, 8, 9};
		print(list);
		
		int index = binarySearch(list, 2);
		showLocation(index);
		index = binarySearch(list, 5);
		showLocation(index);
		index = binarySearch(list, 9);
		showLocation(index);
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
	 * method: showLocation(int)
	 *         formats and prints out the key location in
	 *         array if found.
	 * ****************************************************/
	public static void showLocation(int index) {
		
		if (index == -1) {
			System.out.println("no match found ");
		}else {
			System.out.println("match found at index: " + index);
		}
		System.out.println();
			
	}

}
