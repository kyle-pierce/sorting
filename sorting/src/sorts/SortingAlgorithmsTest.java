package sorts;

import org.junit.*;

import auxiliary.Arrays;

import static org.junit.Assert.*;

import java.util.Random;

public class SortingAlgorithmsTest {
	private static final Random rand = new Random();
	
	public static final int SHORT_LENGTH = 10;
	public static final int MEDIUM_LENGTH = 1000;
	public static final int LONG_LENGTH = 1000000;
	
	@Test
	public void testBogoWithInts() {
		int[] arr = makeIntArray(SHORT_LENGTH);
		Bogosort.bogoSort(arr);
		
		assertTrue(Arrays.isSorted(arr));
	}
	
	@Test
	public void testBogoWithStrings() {
		String[] arr = makeStringArray(SHORT_LENGTH);
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
		int[] arr = makeIntArray(SHORT_LENGTH);
		Mergesort.mergeSort(arr);
		
		assertTrue(Arrays.isSorted(arr));
	}
	
	@Test 
	public void testMergeWithIntsMedium() {
		int[] arr = makeIntArray(MEDIUM_LENGTH);
		Mergesort.mergeSort(arr);
		
		assertTrue(Arrays.isSorted(arr));
	}
	
	@Test 
	public void testMergeWithIntsLong() {
		int[] arr = makeIntArray(LONG_LENGTH);
		Mergesort.mergeSort(arr);
		
		assertTrue(Arrays.isSorted(arr));
	}
	
	@Test 
	public void testMergeWithStringsShort() {
		String[] arr = makeStringArray(SHORT_LENGTH);
		Mergesort.mergeSort(arr);
		
		assertTrue(Arrays.isSorted(arr));
	}
	
	@Test 
	public void testMergeWithStringMedium() {
		String[] arr = makeStringArray(MEDIUM_LENGTH);
		Mergesort.mergeSort(arr);
		
		assertTrue(Arrays.isSorted(arr));
	}
	
	@Test 
	public void testMergeWithStringLong() {
		String[] arr = makeStringArray(LONG_LENGTH);
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
		int[] arr = makeIntArray(SHORT_LENGTH);
		Quicksort.quickSort(arr);
		
		assertTrue(Arrays.isSorted(arr));
	}
	
	@Test
	public void testQuickWithIntsMedium() {
		int[] arr = makeIntArray(MEDIUM_LENGTH);
		Quicksort.quickSort(arr);
		
		assertTrue(Arrays.isSorted(arr));
	}
	
	@Test
	public void testQuickWithIntsLong() {
		int[] arr = makeIntArray(LONG_LENGTH);
		Quicksort.quickSort(arr);
		
		assertTrue(Arrays.isSorted(arr));
	}
	
	@Test
	public void testQuickWithStringsShort() {
		String[] arr = makeStringArray(SHORT_LENGTH);
		Quicksort.quickSort(arr);
		
		assertTrue(Arrays.isSorted(arr));
	}
	
	@Test
	public void testQuickWithStringsMedium() {
		String[] arr = makeStringArray(MEDIUM_LENGTH);
		Quicksort.quickSort(arr);
		
		assertTrue(Arrays.isSorted(arr));
	}
	
	@Test
	public void testQuickWithStringsLong() {
		String[] arr = makeStringArray(LONG_LENGTH);
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
		int[] arr = makeIntArray(SHORT_LENGTH);
		Heapsort.heapSort(arr);
		
		assertTrue(Arrays.isSorted(arr));
	}
	
	@Test
	public void TestHeapWithIntsMedium() {
		int[] arr = makeIntArray(MEDIUM_LENGTH);
		Heapsort.heapSort(arr);
		
		assertTrue(Arrays.isSorted(arr));
	}
	
	@Test
	public void TestHeapWithIntsLong() {
		int[] arr = makeIntArray(LONG_LENGTH);
		Heapsort.heapSort(arr);
		
		assertTrue(Arrays.isSorted(arr));
	}
	
	@Test
	public void TestHeapWithStringsShort() {
		String[] arr = makeStringArray(SHORT_LENGTH);
		Heapsort.heapSort(arr);
		
		assertTrue(Arrays.isSorted(arr));
	}
	
	@Test
	public void TestHeapWithStringsMedium() {
		String[] arr = makeStringArray(MEDIUM_LENGTH);
		Heapsort.heapSort(arr);
		
		assertTrue(Arrays.isSorted(arr));
	}
	
	@Test
	public void TestHeapWithStringLong() {
		String[] arr = makeStringArray(LONG_LENGTH);
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
