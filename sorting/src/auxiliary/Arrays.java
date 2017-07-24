package auxiliary;

/**
 * Contains useful methods for sorting arrays.  Many of these are included
 * in the Arrays class, but I wanted a go at implementing them myself.
 * 
 * @author Kyle
 */
public class Arrays {
	
	/**
	 * Returns a copy of the given array.
	 * 
	 * @param arr array to be copied
	 * @return a copy of the given array
	 */
	public static int[] getCopy(int[] arr) {
		int[] newArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i];
		}
		return arr;
	}
	
	/**
	 * Returns a copy of the given array.
	 * 
	 * @param arr array to be copied
	 * @return a copy of the given array (not a deep copy)
	 */
	@SuppressWarnings("unchecked")
	public static <E> E[] getCopy(E[] arr) {
		E[] newArr = (E[])new Object[arr.length];
		for (int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i];
		}
		return newArr;
	}
	
	/**
	 * Copies all values from 'from' to 'to'
	 * 
	 * @param from array from which values are copied
	 * @param to array to which values are copied
	 */
	public static <E, T> void copy(E[] from, T[] to) {
		copy(from, to, from.length);
	}
	
	/**
	 * Copies the first size elements from 'from' into 'to'.
	 * 
	 * @param from array from which values are copied
	 * @param to array to which values are copied
	 * @param size number of elements to be copied
	 */
	@SuppressWarnings("unchecked")
	public static <E, T> void copy(E[] from, T[] to, int size) {
		for (int i = 0; i < size; i++) {
			to[i] = (T)from[i];
		}
	}
	
	/**
	 * Returns an Integer[] with the same elements as the given int[]
	 * 
	 * @param arr array with values to be copied
	 * @return Integer[] with the same elements as arr
	 */
	public static Integer[] intCopy(int[] arr) {
		Integer[] result = new Integer[arr.length];
		for (int i = 0; i < arr.length; i++) {
			result[i] = arr[i];
		}
		return result;
	}
	
	/**
	 * Returns an int[] with the same elements as the given Integer[]
	 * 
	 * @param arr array with values to be copied
	 * @return int[] with the same elements as arr
	 */
	public static int[] intCopy(Integer[] arr) {
		int[] result = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			result[i] = arr[i];
		}
		return result;
	}
	
	/**
	 * Tests whether or not the given array is sorted.
	 * 
	 * @param arr array to be tested
	 * @return true if the given array is sorted, false otherwise
	 */
	public static boolean isSorted(int[] arr) {
		return isSorted(intCopy(arr));
	}
	
	/**
	 * Tests whether or not the given array is sorted.
	 * 
	 * @param arr array to be tested
	 * @return true if the given array is sorted, false otherwise
	 */
	public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i].compareTo(arr[i + 1]) > 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Randomly shuffles the elements in the given array
	 * 
	 * @param arr array to be shuffled
	 */
	public static void shuffle(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int otherIndex = (int)(Math.random() * (arr.length - i) + i);
			swap(arr, i, otherIndex);
		}
	}
	
	/**
	 * Randomly shuffles the elements in the given array
	 * 
	 * @param arr array to be shuffled
	 */
	public static <E> void shuffle(E[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int otherIndex = (int)(Math.random() * (arr.length - i) + i);
			swap(arr, i, otherIndex);
		}
	}

	/**
	 * Swaps the elements stored at firstIndex and secondIndes in the given
	 * array.
	 * 
	 * @param arr array with elements to be swapped
	 * @param firstIndex first index of element to be swapped
	 * @param secondIndex second index of element to be swapped
	 */
	public static void swap(int[] arr, int firstIndex, int secondIndex) {
		int temp = arr[firstIndex];
		arr[firstIndex] = arr[secondIndex];
		arr[secondIndex] = temp;
	}
	
	/**
	 * Swaps the elements stored at firstIndex and secondIndes in the given
	 * array.
	 * 
	 * @param arr array with elements to be swapped
	 * @param firstIndex first index of element to be swapped
	 * @param secondIndex second index of element to be swapped
	 */
	public static <E> void swap(E[] arr, int firstIndex, int secondIndex) {
		E temp = arr[firstIndex];
		arr[firstIndex] = arr[secondIndex];
		arr[secondIndex] = temp;
	}
	
	/**
	 * Returns the String representation of an array.  Format is all
	 * values, comma-separated, and enclosed in square brackets.
	 * 
	 * @param arr
	 * @return
	 */
	public static String toString(int[] arr) {
		return (toString(intCopy(arr)));
	}
	
	/**
	 * Returns the String representation of an array.  Format is all
	 * values, comma-separated, and enclosed in square brackets.
	 * 
	 * @param arr
	 * @return
	 */
	public static <E> String toString(E[] arr) {
		String result = "[";
		for (int i = 0; i < arr.length - 1; i++) {
			result += arr[i] + ", ";
		}
		if (arr.length > 0) {
			result += arr[arr.length - 1];
		}
		return result += "]";
	}
	
}
