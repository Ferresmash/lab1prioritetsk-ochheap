package se.hig.aod.lab1;

import java.util.ArrayList;
import java.util.List;
/**
 * Provides a static method to perform sorting using Heap Sort algorithm.
 * @author Ferdinand Öhrn
 */
public class HeapSorter {
    /**
     * Sorts the inputList using the Heap Sort algorithm.
     *
     * @param <T>        The type of elements in the list, must implement Comparable interface.
     * @param inputList  The list to be sorted.
     * @return           A new list containing elements from the inputList sorted in ascending order.
     * @throws PriorityQueueFullException   If the priority queue becomes full during sorting.
     * @throws PriorityQueueEmptyException  If the priority queue becomes empty during sorting.
     */
	public static <T extends Comparable<? super T>> List<T> sort(List<T> inputList)
			throws PriorityQueueFullException, PriorityQueueEmptyException {
		List<T> sortedList = new ArrayList<T>();
		HeapPriorityQueue<T> heap = new HeapPriorityQueue<T>(inputList.size());
		for (T t : inputList) {
			heap.enqueue(t);
		}
		while(!heap.isEmpty()) {
			sortedList.add(heap.dequeue());
		}
		return sortedList;
	}
}
