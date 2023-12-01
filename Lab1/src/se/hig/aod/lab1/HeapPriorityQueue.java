package se.hig.aod.lab1;

/**
 * A static heap implementation of a priority queue for elements of type T.
 * 
 * @author Ferdinand Öhrn
 * 
 * @param <T> Data type of elements stored in the queue.
 */
public class HeapPriorityQueue<T extends Comparable<? super T>> implements PriorityQueue<T> {

	private T[] heap;
	private int size;
	private int maxSize;

	/**
	 * Constructs a heap with the specified maximum size.
	 * 
	 * @param maxSize Maximum size of the heap.
	 */
	public HeapPriorityQueue(int maxSize) {
		this.maxSize = maxSize;
		clear();
	}

	/**
	 * Clears the heap by initializing a new empty array of the specified maximum
	 * size.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		heap = (T[]) (new Comparable[maxSize]); // Create empty array of size maxSize
		size = 0;
	}

	/**
	 * Checks if the heap is empty.
	 * 
	 * @return true if the heap is empty, false otherwise.
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 
	 * Method that is specific for a static implementation of the heap, checks if
	 * the underlying array is full.
	 * 
	 * @return true if the underlying array is full
	 */
	public boolean isFull() {
		return size == maxSize;
	}

	/**
	 * Returns the current size of the heap.
	 * 
	 * @return The current size of the heap.
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Calculates the parent index of a given index in the heap array.
	 * 
	 * @param currentIndex The index for which the parent index is calculated.
	 * @return The index of the parent node in the heap array.
	 */
	private int parent(int currentIndex) {
		return (currentIndex) / 2;
	}

	/**
	 * Calculates the left child index of a given index in the heap array.
	 * 
	 * @param currentIndex The index for which the left child index is calculated.
	 * @return The index of the left child node in the heap array.
	 */
	private int leftChild(int currentIndex) {
		return (currentIndex*2)+1;
	}

	/**
	 * Calculates the right child index of a given index in the heap array.
	 * 
	 * @param currentIndex The index for which the right child index is calculated.
	 * @return The index of the right child node in the heap array.
	 */
	private int rightChild(int currentIndex) {
		return (currentIndex*2)+2;
	}

	/**
	 * Restores the heap property by moving the node up the heap.
	 * 
	 * @param currentIndex The index of the node to be moved up the heap.
	 */
	private void reHeapUp(int currentIndex) {
		if (parent(currentIndex) < 0) {
			return;
		}
		if (heap[currentIndex].compareTo(heap[parent(currentIndex)]) > 0) {
			T temp = heap[parent(currentIndex)];
			heap[parent(currentIndex)] = heap[currentIndex];
			heap[currentIndex] = temp;
			reHeapUp(parent(currentIndex));
		}
	}

	/**
	 * Restores the heap property by moving the node down the heap.
	 * 
	 * @param currentIndex The index of the node to be moved down the heap.
	 */
	private void reHeapDown(int currentIndex) {
		if (leftChild(currentIndex) >= size) {
			return;
		}
		if (rightChild(currentIndex) >= size) {
			if (heap[currentIndex].compareTo(heap[leftChild(currentIndex)]) < 0) {
				T temp = heap[leftChild(currentIndex)];
				heap[leftChild(currentIndex)] = heap[currentIndex];
				heap[currentIndex] = temp;
				reHeapDown(leftChild(currentIndex));
			}
			return;
		}
		if (heap[leftChild(currentIndex)].compareTo(heap[rightChild(currentIndex)]) > 0) {
			if (heap[currentIndex].compareTo(heap[leftChild(currentIndex)]) < 0) {
				T temp = heap[leftChild(currentIndex)];
				heap[leftChild(currentIndex)] = heap[currentIndex];
				heap[currentIndex] = temp;
				reHeapDown(leftChild(currentIndex));
			}
		} else {
			if (heap[currentIndex].compareTo(heap[rightChild(currentIndex)]) < 0) {
				T temp = heap[rightChild(currentIndex)];
				heap[rightChild(currentIndex)] = heap[currentIndex];
				heap[currentIndex] = temp;
				reHeapDown(rightChild(currentIndex));
			}
		}
	}

	/**
	 * Inserts a new element into the heap with the specified priority.
	 * 
	 * @param newElement The element to be added to the heap.
	 * @throws PriorityQueueFullException If the heap is full and cannot accommodate
	 *                                    more elements.
	 */
	@Override
	public void enqueue(T newElement) throws PriorityQueueFullException {
		if (isFull()) {
			throw new PriorityQueueFullException("Heap is full!");
		}
		heap[size] = newElement;
		reHeapUp(size);
		size++;
		// TODO Code that inserts the new element at the last position in the array
		// TODO reHeapUp for new node
	}

	/**
	 * Removes and returns the element with the highest priority from the heap.
	 * 
	 * @return The element with the highest priority in the heap.
	 * @throws PriorityQueueEmptyException If the heap is empty and no elements are
	 *                                     present.
	 */
	@Override
	public T dequeue() throws PriorityQueueEmptyException {
		if (isEmpty()) {
			throw new IllegalStateException("Heap is empty");
		}

		T root = heap[0];
		heap[0] = heap[size - 1];
		size--;
		reHeapDown(0);
		return root;
	}

	/**
	 * Retrieves the element with the highest priority (at the front) from the heap
	 * without removing it.
	 * 
	 * @return The element with the highest priority in the heap.
	 * @throws PriorityQueueEmptyException If the heap is empty and no elements are
	 *                                     present.
	 */
	@Override
	public T getFront() throws PriorityQueueEmptyException {
		if (isEmpty()) {
			throw new PriorityQueueEmptyException("Cannot get front of empty Queue!");
		} else {
			return heap[0];
		}
	}

	/**
	 * Generates a string representation of the elements in the heap.
	 * 
	 * @return A string representation of the elements in the heap.
	 */
	@Override
	public String toString() {
		String stringRepresentation = "";
		for (int i = 0; i < size; i++) {
			stringRepresentation = stringRepresentation + heap[i] + " ";
		}
		return stringRepresentation;
	}

}
