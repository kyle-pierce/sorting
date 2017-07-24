package sorts;

import org.junit.*;

import auxiliary.Arrays;

import static org.junit.Assert.*;

import java.util.Random;

public class SortingAlgorithmsTest {
	private static final Random rand = new Random();
	
	public static final int shortLength = 10;
	public static final int mediumLength = 1000;
	public static final int longLength = 1000000;
	
	@Test
	public void testBogoWithInts() {
		int[] arr = makeIntArray(shortLength);
		Bogosort.bogoSort(arr);
		
		assertTrue(Arrays.isSorted(arr));
	}
	
	@Test
	public void testBogoWithStrings() {
		String[] arr = makeStringArray(shortLength);
		Bogosort.bogoSort(arr);
		
		assertTrue(Arrays.isSorted(arr));
	}
	
	@Test
	public void testMergeEmpty() {
		int[] arr = makeIntArray(0);
		Mergesort.mergeSort(arr);
		
		assertTrue(Arrays.isSorted(arr));
	}
	
	@Test 
	public void testMergeWithIntsShort() {
		int[] arr = makeIntArray(shortLength);
		Mergesort.mergeSort(arr);
		
		assertTrue(Arrays.isSorted(arr));
	}
	
	@Test 
	public void testMergeWithIntsMedium() {
		int[] arr = makeIntArray(mediumLength);
		Mergesort.mergeSort(arr);
		
		assertTrue(Arrays.isSorted(arr));
	}
	
	@Test 
	public void testMergeWithIntsLong() {
		int[] arr = makeIntArray(longLength);
		Mergesort.mergeSort(arr);
		
		assertTrue(Arrays.isSorted(arr));
	}
	
	@Test 
	public void testMergeWithStringsShort() {
		String[] arr = makeStringArray(shortLength);
		Mergesort.mergeSort(arr);
		
		assertTrue(Arrays.isSorted(arr));
	}
	
	@Test 
	public void testMergeWithStringMedium() {
		String[] arr = makeStringArray(mediumLength);
		Mergesort.mergeSort(arr);
		
		assertTrue(Arrays.isSorted(arr));
	}
	
	@Test 
	public void testMergeWithStringLong() {
		String[] arr = makeStringArray(longLength);
		Mergesort.mergeSort(arr);
		
		assertTrue(Arrays.isSorted(arr));
	}
	
	@Test
	public void testQuickEmpty() {
		int[] arr = makeIntArray(0);
		Quicksort.quickSort(arr);
		
		assertTrue(Arrays.isSorted(arr));
	}
	
	@Test
	public void testQuickWithIntsShort() {
		int[] arr = makeIntArray(shortLength);
		Quicksort.quickSort(arr);
		
		assertTrue(Arrays.isSorted(arr));
	}
	
	@Test
	public void testQuickWithIntsMedium() {
		int[] arr = makeIntArray(mediumLength);
		Quicksort.quickSort(arr);
		
		assertTrue(Arrays.isSorted(arr));
	}
	
	@Test
	public void testQuickWithIntsLong() {
		int[] arr = makeIntArray(longLength);
		Quicksort.quickSort(arr);
		
		assertTrue(Arrays.isSorted(arr));
	}
	
	@Test
	public void testQuickWithStringsShort() {
		String[] arr = makeStringArray(shortLength);
		Quicksort.quickSort(arr);
		
		assertTrue(Arrays.isSorted(arr));
	}
	
	@Test
	public void testQuickWithStringsMedium() {
		String[] arr = makeStringArray(mediumLength);
		Quicksort.quickSort(arr);
		
		assertTrue(Arrays.isSorted(arr));
	}
	
	@Test
	public void testQuickWithStringsLong() {
		String[] arr = makeStringArray(longLength);
		Quicksort.quickSort(arr);
		
		assertTrue(Arrays.isSorted(arr));
	}
	
	@Test
	public void testHeapEmpty() {
		int[] arr = makeIntArray(0);
		Heapsort.heapSort(arr);
		
		assertTrue(Arrays.isSorted(arr));
	}
	
	@Test
	public void testHeapWithIntsShort() {
		int[] arr = makeIntArray(shortLength);
		Heapsort.heapSort(arr);
		
		assertTrue(Arrays.isSorted(arr));
	}
	
	@Test
	public void TestHeapWithIntsMedium() {
		int[] arr = makeIntArray(mediumLength);
		Heapsort.heapSort(arr);
		
		assertTrue(Arrays.isSorted(arr));
	}
	
	@Test
	public void TestHeapWithIntsLong() {
		int[] arr = makeIntArray(longLength);
		Heapsort.heapSort(arr);
		
		assertTrue(Arrays.isSorted(arr));
	}
	
	@Test
	public void TestHeapWithStringsShort() {
		String[] arr = makeStringArray(shortLength);
		Heapsort.heapSort(arr);
		
		assertTrue(Arrays.isSorted(arr));
	}
	
	@Test
	public void TestHeapWithStringsMedium() {
		String[] arr = makeStringArray(mediumLength);
		Heapsort.heapSort(arr);
		
		assertTrue(Arrays.isSorted(arr));
	}
	
	@Test
	public void TestHeapWithStringLong() {
		String[] arr = makeStringArray(longLength);
		Heapsort.heapSort(arr);
		
		assertTrue(Arrays.isSorted(arr));
	}
	
	/*
	 * Returns a new int[] filled with random values of length capacity
	 */
	private static int[] makeIntArray(int capacity) {
		int[] arr = new int[capacity];
		for (int i = 0; i < capacity; i++) {
			arr[i] = rand.nextInt(100);
		}
		return arr;
	}
	
	/*
	 * Returns a new String[] filled with randomly generated Strings
	 * of length capacity
	 */
	private static String[] makeStringArray(int capacity) {
		String[] arr = new String[capacity];
		for (int i = 0; i < capacity; i++) {
			arr[i] = randomString(5, 10);
		}
		return arr;
	}
	
	/*
	 * Returns a random alphanumeric String (lower-case letters only) of a 
	 * length between the given lowerBound and upperBound
	 */
	private static String randomString(int lowerBound, int upperBound) {
		String result = "";
		String characterOptions = "abcdefghijklmnopqrstuvwxyz0123456789";
		int length = rand.nextInt(upperBound - lowerBound) + lowerBound;
		for (int i = 0; i < length; i++) {
			result += characterOptions.charAt(rand.nextInt(characterOptions.length()));
		}
		return result;
	}

}
