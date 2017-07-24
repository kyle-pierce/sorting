package sorts;

public class Mergesort {

	/**
	 * Sorts the given array using Mergesort. O(n lg n) runtime, O(n) extra space needed.
	 * 
	 * @param arr array to be sorted
	 */
	public static void mergeSort(int[] arr) {
		mergeSort(arr, new int[arr.length], 0, arr.length);
	}

	/*
	 * Sorts the given array between the given low (inclusive) and high (exclusive)
	 * indices using Mergesort.  Uses the given aux array for temporary storage.
	 */
	private static void mergeSort(int[] arr, int[] aux, int low, int high) {
		if (high - low > 1) {	// 0 or 1 element array is sorted
			int mid = low + (high - low) / 2;

			// recursively sort the subarrays
			mergeSort(arr, aux, low, mid);
			mergeSort(arr, aux, mid, high);

			// keep track of locations in subarrays
			int leftIndex = low;
			int rightIndex = mid;
			
			// merge the two sorted subarrays
			for (int i = low; i < high; i++) {
				if (leftIndex == mid) {
					aux[i] = arr[rightIndex++];
				} else if (rightIndex == high || arr[leftIndex] < arr[rightIndex]) {
					aux[i] = arr[leftIndex++];
				} else {
					aux[i] = arr[rightIndex++];
				}
			}
			
			// copy sorted values back into arr from result
			for (int i = low; i < high; i++) {
				arr[i] = aux[i];
			}
			
		}
	}

	/**
	 * Sorts the given array using Mergesort. O(n lg n) runtime, O(n) extra space needed.
	 * 
	 * @param arr array to be sorted
	 */
	@SuppressWarnings("unchecked")
	public static <E extends Comparable<E>> void mergeSort(E[] arr) {
		mergeSort(arr, (E[])new Comparable[arr.length], 0, arr.length);
	}

	/*
	 * Sorts the given array between the given low (inclusive) and high (exclusive)
	 * indices using Mergesort.  Uses the given aux array for temporary storage.
	 */
	private static <E extends Comparable<E>> void mergeSort(E[] arr, E[] aux, 
															int low, int high) {
		if (high - low > 1) {	// 0 or 1 element array is sorted
			int mid = low + (high - low) / 2;

			// recursively sort the subarrays
			mergeSort(arr, aux, low, mid);
			mergeSort(arr, aux, mid, high);

			// keep track of locations in subarrays
			int leftIndex = low;
			int rightIndex = mid;
			
			// merge the two sorted subarrays
			for (int i = low; i < high; i++) {
				if (leftIndex == mid) {
					aux[i] = arr[rightIndex++];
				} else if (rightIndex == high || arr[leftIndex].compareTo(
												 arr[rightIndex]) < 0) {
					aux[i] = arr[leftIndex++];
				} else {
					aux[i] = arr[rightIndex++];
				}
			}
			
			// copy sorted values back into arr from result
			for (int i = low; i < high; i++) {
				arr[i] = aux[i];
			}
			
		}
	}
}
