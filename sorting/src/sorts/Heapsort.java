package sorts;

import structures.MinHeap;

public class Heapsort {
	
	/**
	 * Sorts the given array using heapsort. O(n lg n) runtime, O(n) extra space.
	 * 
	 * @param arr array to be sorted.
	 */
	public static void heapSort(int[] arr) {
		MinHeap<Integer> heap = new MinHeap<Integer>(arr.length);
		for (int element: arr) {
			heap.offer(element);
		}
		int index = 0;
		while(!heap.isEmpty()) {
			arr[index++] = heap.poll();
		}
	}
	
	/**
	 * Sorts the given array using heapsort. O(n lg n) runtime, O(n) extra space.
	 * 
	 * @param arr array to be sorted.
	 */
	public static <E extends Comparable<E>> void heapSort(E[] arr) {
		MinHeap<E> heap = new MinHeap<E>(arr.length);
		for (E element: arr) {
			heap.offer(element);
		}
		int index = 0;
		while(!heap.isEmpty()) {
			arr[index++] = heap.poll();
		}
	}

}
