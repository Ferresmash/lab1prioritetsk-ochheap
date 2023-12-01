package se.hig.aod.lab1;

public class Main {

	private static final Integer[] INT_FIXTURE = { 1, 9, 2, 8, 3, 7, 4, 6, 5, 5 };

	public static void main(String[] args) {

		HeapPriorityQueue<Integer> heap = new HeapPriorityQueue<Integer>(7);
		for (Integer integer : INT_FIXTURE) {
			heap.enqueue(integer);
		}
	}

}
