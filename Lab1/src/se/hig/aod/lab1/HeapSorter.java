package se.hig.aod.lab1;
import java.util.ArrayList;
import java.util.List;

public class HeapSorter {

	public static <T extends Comparable<? super T>> List<T> sort(List<T> inputList) throws PriorityQueueFullException, PriorityQueueEmptyException {
		List<T> sortedList = new ArrayList<T>();
		HeapPriorityQueue<T> heap = new HeapPriorityQueue<T>(inputList.size());
		for (T t : inputList) {
			heap.enqueue(t);
		}
		for(int i = 0; i < heap.size(); i++) {
			sortedList.add(heap.getFront());
			heap.dequeue();
		}
		return sortedList;
		}
}
