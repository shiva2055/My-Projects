/********************************************************************************
 * Concept:     Linear Search
 * Category:    Search Algorithms
 * Description: This class demonstrates the use of a linear search algorithm. 
 * Algorithm:   A key value is compared with each index value.
 * 				The key is checked against each element in the array.
 *              (a) if key matches a value in an index, return the index
 *                  of the value.
 *              (b) if a match is not found it returns -1.
 ********************************************************************************/

package search;

public class LinearSearch {
	
	/******************************************************
	 * method: linearSearch(int[], int)
	 *         implements the linear search algorithm
	 * ****************************************************/
	public static int linearSearch(int[] list, int key) {
		
		System.out.println("key value: " + key);
		
		for(int i = 0; i < list.length; i++) {
			if (key == list[i]) {
				return i;
			}
		}
			
		return -1;
	}
	
	/******************************************************
	 * method: main(String[])
	 *         runs the program. Tests a list of numbers
	 * ****************************************************/
	public static void main(String[] args) {
		
		int[] list = {2, 3, 1, 5, 8, 6};
		print(list);
		
		int index  = linearSearch(list, 3);
		showLocation(index);
		
		index      = linearSearch(list, 7);
		showLocation(index);
		
		index      = linearSearch(list, 8);
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
