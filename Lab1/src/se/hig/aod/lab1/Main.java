package se.hig.aod.lab1;

import java.util.ArrayList;
import java.util.List;

public class Main {

	private static final Integer[] INT_FIXTURE = { 1, 9, 2, 8, 3, 7, 4, 6, 5, 5 };

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws PriorityQueueFullException, PriorityQueueEmptyException {

//		HeapPriorityQueue<Integer> heap = new HeapPriorityQueue<Integer>(7);
//		for (Integer integer : INT_FIXTURE) {
//			heap.enqueue(integer);
//		}
		
		List<Integer> testList = new ArrayList<>();
		for (Integer integer : INT_FIXTURE) {
			testList.add(integer);
		}
		
		HeapSorter heapSorter = new HeapSorter();
		
		heapSorter.sort(testList);
		System.out.println(testList);
	}

}
