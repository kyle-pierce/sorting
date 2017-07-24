package sorts;

import auxiliary.Arrays;

public class Quicksort {

	/**
	 * Sorts the given array using Quicksort. O(n^2) runtime, no extra space needed.
	 * 
	 * Despite the above asymptotic runtime analysis, the runtime is usually
	 * much more alike that of O(n lg n) algorithms like Mergesort if not faster.
	 * 
	 * @param arr
	 */
	public static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length);
	}
	
	/*
	 * Sorts the given array between the given low (inclusive) and high (exclusive)
	 * indices using Quicksort.  
	 */
	private static void quickSort(int[] arr, int low, int high) {
		if (high - low > 1) {	// 0 or 1 element array is sorted
			
			// choose the middle value as pivot element
			int pivot = arr[low + (high - low) / 2];
			
			// keep track of locations on either side of the pivot
			int leftIndex = low;
			int rightIndex = high - 1;
			
			// loop until the two pointers collide or pass each other
			while (leftIndex <= rightIndex) {
				// move leftIndex past all elements less than pivot
				while (arr[leftIndex] < pivot) {
					leftIndex++;
				}
				
				// move rightIndex past all elements greater than pivot
				while (arr[rightIndex] > pivot) {
					rightIndex--;
				}
				
				// if they haven't collided or passed each other, swap the elements
				if (leftIndex <= rightIndex) {
					Arrays.swap(arr, leftIndex++, rightIndex--);
				}
			}
			
			// recursively sort the subarrays on either side of the pivot
			quickSort(arr, low, rightIndex + 1);
			quickSort(arr, leftIndex, high);
		}
	}
	
	/**
	 * Sorts the given array using Quicksort. O(n^2) runtime, no extra space needed.
	 * 
	 * Despite the above asymptotic runtime analysis, the runtime is usually
	 * much more alike that of O(n lg n) algorithms like Mergesort if not faster.
	 * 
	 * @param arr
	 */
	public static <E extends Comparable<E>> void quickSort(E[] arr) {
		quickSort(arr, 0, arr.length);
	}
	
	/*
	 * Sorts the given array between the given low (inclusive) and high (exclusive)
	 * indices using Quicksort.  
	 */
	private static <E extends Comparable<E>> void quickSort(E[] arr, int low, 
																	 int high) {
		if (high - low > 1) {	// 0 or 1 element array is sorted
			
			// choose the middle value as pivot element
			E pivot = arr[low + (high - low) / 2];
			
			// keep track of locations on either side of the pivot
			int leftIndex = low;
			int rightIndex = high - 1;
			
			// loop until the two pointers collide or pass each other
			while (leftIndex <= rightIndex) {
				// move leftIndex past all elements less than pivot
				while (arr[leftIndex].compareTo(pivot) < 0) {
					leftIndex++;
				}
				
				// move rightIndex past all elements greater than pivot
				while (arr[rightIndex].compareTo(pivot) > 0) {
					rightIndex--;
				}
				
				// if they haven't collided or passed each other, swap the elements
				if (leftIndex <= rightIndex) {
					Arrays.swap(arr, leftIndex++, rightIndex--);
				}
			}
			
			// recursively sort the subarrays on either side of the pivot
			quickSort(arr, low, rightIndex + 1);
			quickSort(arr, leftIndex, high);
		}
	}
}
