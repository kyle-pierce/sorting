package sorts;

import auxiliary.Arrays;

public class BubbleSort {
	
	
	/**
	 * Sorts the given array using Bubblesort
	 * O(n^2) worst case runtime, no extra space requirement
	 * 
	 * @param arr array to be sorted
	 */
	public static void bubbleSort(int[] arr) {
		boolean done = true;
		
		do {
			done = true;
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					Arrays.swap(arr, i, i + 1);
					done = false;
				}
			}
		} while (!done);
	}
	
	/**
	 * Sorts the given array using Bubblesort
	 * O(n^2) worst case runtime, no extra space requirement
	 * 
	 * @param arr array to be sorted
	 */
	public static <E extends Comparable<E>> void bubbleSort(E[] arr) {
		boolean done = true;
		
		do {
			done = true;
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i].compareTo(arr[i + 1]) > 0) {
					Arrays.swap(arr, i, i + 1);
					done = false;
				}
			}
		} while (!done);
	}

}
