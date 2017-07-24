package structures;

public class MinHeapDebug {

	public static void main(String[] args) {
		MinHeap<Integer> heap = new MinHeap<>();
		int[] arr = {3, 1, 7, 5, 9, 2, 6, 4, 10, 8, 11, 13, 15, 12, 14};
		
		for (int element : arr) {
			heap.offer(element);
			System.out.println(heap);
		}
		
		while (!heap.isEmpty()) {
			System.out.print(heap.poll() + " ");
		}
	}
	
}
