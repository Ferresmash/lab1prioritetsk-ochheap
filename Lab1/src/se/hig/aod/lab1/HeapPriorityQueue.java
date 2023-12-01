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

	public HeapPriorityQueue(int maxSize) {
		this.maxSize = maxSize;
		clear();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		heap = (T[]) (new Comparable[maxSize]); // Create empty array of size maxSize
		size = 0;
	}

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

	@Override
	public int size() {
		return size;
	}

	private int parent(int currentIndex) {
		return (currentIndex) / 2;
	}

	private int leftChild(int currentIndex) {
		return (currentIndex + 1) * 2;
	}

	private int rightChild(int currentIndex) {
		return (currentIndex + 2) * 2;
	}

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

	private void reHeapDown(int currentIndex) {
		if(leftChild(currentIndex) > maxSize) {
			return;
		}
		if(heap[rightChild(currentIndex)] == null) {
			if(heap[currentIndex].compareTo(heap[leftChild(currentIndex)]) < 0) {
				T temp = heap[leftChild(currentIndex)];
				heap[leftChild(currentIndex)] = heap[currentIndex];
				heap[currentIndex] = temp;
				reHeapDown(leftChild(currentIndex));
			}
			return;
		}
		if(heap[leftChild(currentIndex)].compareTo(heap[rightChild(currentIndex)]) > 0) {
			if(heap[currentIndex].compareTo(heap[leftChild(currentIndex)]) < 0) {
				T temp = heap[leftChild(currentIndex)];
				heap[leftChild(currentIndex)] = heap[currentIndex];
				heap[currentIndex] = temp;
				reHeapDown(leftChild(currentIndex));
			}
		}else {
			if(heap[currentIndex].compareTo(heap[rightChild(currentIndex)]) < 0) {
				T temp = heap[rightChild(currentIndex)];
				heap[rightChild(currentIndex)] = heap[currentIndex];
				heap[currentIndex] = temp;
				reHeapDown(rightChild(currentIndex));
			}
		}
	}

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

	@Override
	public T dequeue() throws PriorityQueueFullException, PriorityQueueEmptyException {
		if (isEmpty()) {
			throw new PriorityQueueEmptyException("Cannot dequeue empty Queue!");
		} else {
			T dequeuedElement = heap[0];// the root element of the heap
			// TODO Code that moves the last element in the heap to the root of the heap
			heap[0] = heap[size-1];
			heap[size-1] = null;
			size--;
			// TODO reHeapDown for the new root of the heap
			reHeapDown(0);
			
			return dequeuedElement;
		}
	}

	@Override
	public T getFront() throws PriorityQueueEmptyException {
		if (isEmpty()) {
			throw new PriorityQueueEmptyException("Cannot get front of empty Queue!");
		} else {
			return heap[0];
		}
	}

	@Override
	public String toString() {
		String stringRepresentation = "";
		for (int i = 0; i < size; i++) {
			stringRepresentation = stringRepresentation + heap[i] + " ";
		}
		return stringRepresentation;
	}

}
