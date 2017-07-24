package structures;

import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

import auxiliary.Arrays;

/**
 * Data structure which stores elements in a sorted order such that
 * removing an element will always return the smallest element
 * stored.  
 * 
 * @author Kyle Pierce (primary)
 * @author Dylan Jergens (secondary)
 *
 * @param <E> Type of element to be stored in this heap
 */
public class MinHeap<E extends Comparable<E>> extends AbstractQueue<E> {
	private E[] data;
	private int height;
	private int size;
	
	public static final int CHILDREN = 4;
	public static final int DEFAULT_CAPACITY = 1 + CHILDREN;
	
	/**
	 * Initializes a new heap with capacity of 5.  
	 */
	public MinHeap() {
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * Initializes a new heap with the given capacity.
	 * 
	 * @param capacity
	 */
	@SuppressWarnings("unchecked")
	public MinHeap(int capacity) {
		data = (E[])new Comparable[capacity];
		height = 1;
		size = 0;
	}

	@Override
	public boolean add(E element) {
		if (size == data.length) {
			throw new IllegalStateException();
		}
		if (element == null) {
			throw new NullPointerException();
		}
		
		// add the given value into the heap and move to correct location
        data[size] = element;
        percolateUp(size);
        
        size++;			// increment size
        return true;	// addition always succeeds if no exception thrown
	}

	@Override
	public boolean addAll(Collection<? extends E> other) {
		if (other == this) {
			throw new IllegalArgumentException();
		}
		
		// individually add every value in the given collection
		for (E element : other) {
			add(element);
		}
		
		// addition always succeeds if an exception is not thrown
		return true;
	}

	@Override
	public void clear() {
		size = 0;
		height = 1;
	}
	
	@Override
	public E remove() {
		if(isEmpty()) {
    		throw new NoSuchElementException();
    	}
		
		E value = data[0];			// store the value at the front
    	data[0] = data[size - 1];	// move the last value to the front
    	data[size - 1] = null;		// set the last value to null
    	size--;						// decrement size b/c removed element
    	
    	percolateDown(0);			// move the new front value to correct index
    	
    	return value;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Object[] toArray() {
		return Arrays.getCopy(data);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> T[] toArray(T[] other) {
		if (other.length < size) {
			return (T[]) Arrays.getCopy(data);
		} else {
			Arrays.copy(data, other, size);
			if (other.length > size) {
				other[size] = null;
			}
			return other;
		}
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean offer(E element) {
		ensureCapacity();
		return add(element);
	}

	@Override
	public E peek() {
		return isEmpty() ? null : data[0];
	}

	@Override
	public E poll() {
		if (!isEmpty()) {
			return remove();
		}
		return null;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(data);
	}

	@Override
	public Iterator<E> iterator() {
		return new HeapIterator();
	}
	
	/* Resizes the heap to allow for more values. Adds a full level to the heap if
	 * the heap is currently full */ 
	@SuppressWarnings("unchecked")
	private void ensureCapacity() {
		if (data.length == size) {
			// make a new array with 1 level more of nodes
	    	E[] temp = (E[]) new Comparable[data.length + 
	    	                                (int)Math.pow(CHILDREN, height++)];
	    	
	    	// copy all values into the new array
	    	Arrays.copy(data, temp);
	    	data = temp;
		}
    }
		
	/* 
	 * Given an index, moves the value at said index up the heap
	 * until it is in the correct location. Throws an 
	 * IllegalArgumentException if given a negative index.
	 */
    private void percolateUp(int child) {
    	if (child < 0) {
    		throw new IllegalArgumentException();
    	}
    	
    	int parent = getParentOf(child);	// prime the loop
    	
    	while (data[child].compareTo(data[parent]) < 0) {
    		// swap the child and parent values
    		Arrays.swap(data, child, parent);
    		
    		// parent <- parent index of current parent
    		child = parent;
    		parent = getParentOf(parent);
    	}
    }
	
	/*
	 * Given an int index, moves the value at that index down the heap
	 * until it is in the correct location.
	 */
    private void percolateDown(int parent) {
    	int child = findMin(parent);
    	if (child != parent) {
    		Arrays.swap(data, parent, child);
    		percolateDown(child);
    	}
    }
    
    /*
     * Returns the minimum value of the given index and that index's
     * children in this heap.
     */
    private int findMin(int parent) {
    	/// find the index of the leftmost child of the given parent index
    	int child = getLeftChildOf(parent);
    	
    	// initialize the result to the given index
    	int minIndex = parent;
    	
    	// loop over the children of the given parent node
    	for (int i = child; i < child + CHILDREN && i < size; i++) {
    		// record the minimum of the values at minIndex and i
			if (data[minIndex].compareTo(data[i]) > 0) {
				minIndex = i;
			}
    	}	
    	
    	return minIndex;
    }
    
    /*
     * Returns the index which is the parent of the given child.
     */
    private int getParentOf(int child) {
    	return (child - 1) / CHILDREN;
    }
    
    /*
     * Returns the index which is the child of the given parent.
     */
    private int getLeftChildOf(int parent) {
    	return (CHILDREN * (parent + 1)) - (CHILDREN - 1);
    }
    
    /**
     * An iterator over the elements in this heap.  Iterates over the 
     * elements in stored order.
     * 
     * @author Kyle Pierce
     */
    private class HeapIterator implements Iterator<E> {
    	private int currentIndex;
    	
    	/**
    	 * Initialize an iterator over this heap
    	 */
    	public HeapIterator() {
    		currentIndex = 0;
    	}

		@Override
		public boolean hasNext() {
			if (currentIndex < size) {
				return true;
			}
			return false;
		}

		@Override
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return data[currentIndex++];
		}
    	
    }
}
