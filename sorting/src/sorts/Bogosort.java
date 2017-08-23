package sorts;

import auxiliary.Arrays;

public class Bogosort {
	
	/**
	 * Sorts the given array using Bogosort. Note the nondeterministic
	 * nature of this method prevents runtime from being analyzed. 
	 * 
	 * @param arr arrays to be sorted
	 */
	public static void bogoSort(int[] arr) {
		while (!Arrays.isSorted(arr)) {
			Arrays.shuffle(arr);
		}
	}
	
	/**
	 * Sorts the given array using Bogosort. Note the nondeterministic
	 * nature of this method prevents runtime from being analyzed.
	 * 
	 * @param arr arrays to be sorted
	 */
	public static <E extends Comparable<E>> void bogoSort(E[] arr) {
		while (!Arrays.isSorted(arr)) {
			Arrays.shuffle(arr);
		}
	}
}