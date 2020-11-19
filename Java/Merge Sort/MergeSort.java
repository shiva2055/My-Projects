package recursion;

public class MergeSort {

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
	 * method: splitLeft(int[])
	 *         returns first half of list.
	 * *************************************************************/
	public static int[] splitLeft(int[ ] list) {
		int size        = list.length / 2;
		int[] leftList  = new int[size];
		
		for(int i = 0; i < size; i++) {
			leftList[i] = list[i];
		}
		return leftList;
	}
	
	/***************************************************************
	 * method: splitRight(int[])
	 *         returns second half of list.
	 * *************************************************************/
	public static int[] splitRight(int[ ] list) {
		int halfSize    = list.length / 2;					 // half of size
		int size        = list.length - (list.length / 2);	 // the rest
		int[] rightList = new int[size];
		
		for(int i = 0; i < size; i++) {
			rightList[i] = list[halfSize + i];
		}
		
		return rightList;
	}
	
	/***************************************************************
	 * method: merge(int[], int[], int[])
	 *         merge two halves into one list.
	 * *************************************************************/
	public static void merge(int[] left, int[] right, int[] list) {
		
		int leftIndex 	= 0;		//current left index
		int rightIndex 	= 0;		//current right index
		int listIndex  	= 0;		//current merged list index
		
		/************************************************************************
		 * merge: elements
		 *        if current left element is less than current right element add 
		 *        it as next item in list, otherwise insert right element.
		 * **********************************************************************/
		while(     leftIndex <  left.length 
				&& rightIndex < right.length ) {
			
			if(left[leftIndex] < right[rightIndex]) {
				list[listIndex++] = left[leftIndex++];
			}else {
				list[listIndex++] = right[rightIndex++];
			}
		}
		
		/*********************************************************
		 * increment: left index
		 *            increment and add any left over items in 
		 *            the first half to the merged list.
		 * *******************************************************/
		while(leftIndex <  left.length ) {
			list[listIndex++] = left[leftIndex++];
		}
		
		/*********************************************************
		 * increment: right index
		 *            increment and add any left over items in 
		 *            the second half to the merged list.
		 * *******************************************************/
		while(rightIndex <  right.length ) {
			list[listIndex++] = right[rightIndex++];
		}
		
	}
	
	/******************************************************
	 * method: mergeSort(int[])
	 *         sorts list using the merge sort algorithm
	 * ****************************************************/
	public static void mergeSort(int[ ] list) {
		if (list.length > 1) {
			
			int[] leftList  = splitLeft(list);
			int[] rightList = splitRight(list);	
			
			mergeSort(leftList);				//recursion
			mergeSort(rightList);				//recursion
			merge(leftList, rightList, list);
		}else if (list.length == 1){
			System.out.println("Merged: There is only one item in list");
		}
	}
	
	/******************************************************
	 * method: main(String[])
	 *         runs the program. Tests a list of numbers
	 * ****************************************************/
	public static void main(String[] args) {
		int[] list = {2, 9, 5, 4, 8, 1, 6, 7};
		print(list);
		mergeSort(list);
		print(list);
	}

}
