package se.hig.aod.lab1;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit testing for heapPriorityQueue
 * 
 * @author Ferdinand Öhrn
 */
class HeapPriorityQueueTest {

	static final Integer[] INT_FIXTURE = {1,9,2,8,3,7,4,6,5,5};

	HeapPriorityQueue<Integer> nonEmptyQueue;
	HeapPriorityQueue<Integer> emptyQueue;
	

	@BeforeEach
	void setUp() throws Exception {
		nonEmptyQueue = new HeapPriorityQueue<Integer>(INT_FIXTURE.length);
		emptyQueue = new HeapPriorityQueue<Integer>(INT_FIXTURE.length);

		for (int testData : INT_FIXTURE) {
			nonEmptyQueue.enqueue(testData);
		}
	}

	@AfterEach
	void tearDown() throws Exception {
		nonEmptyQueue = null;
		emptyQueue = null;
	}

	@Test
	void testClearNonEmptyQueue() {
		nonEmptyQueue.clear();
		assertTrue(nonEmptyQueue.isEmpty(), "intQueue borde vara tom efter en clear");
	}

	@Test
	void testClearEmptyQueue() {
		emptyQueue.clear();
		assertTrue(emptyQueue.isEmpty(), "emptyQueue should be empty after clear");
	}

	@Test
	void testIsEmpty(){
		assertFalse(nonEmptyQueue.isEmpty(),"intQueue should not be empty from start");
		assertTrue(emptyQueue.isEmpty(),"emptyQueue should be empty from start");
	}
	
	@Test
	void testEnqueue() throws PriorityQueueFullException, PriorityQueueEmptyException {
		int size = emptyQueue.size();
		assertEquals(size, emptyQueue.size());
		Integer nbr = 1;
		emptyQueue.enqueue(nbr);
		assertEquals(size+1, emptyQueue.size());
	}
	
	@Test
	void testDequeue() throws PriorityQueueFullException, PriorityQueueEmptyException {
		int size = nonEmptyQueue.size();
		assertEquals(size, nonEmptyQueue.size());
		nonEmptyQueue.dequeue();
		assertEquals(size-1, nonEmptyQueue.size());
	}
	
	@Test
	void testGetFront() throws PriorityQueueEmptyException {
		assertEquals(9, nonEmptyQueue.getFront());
	}
	
	@Test
	void testDequeueWholeQueue() {
		for (Integer integer : INT_FIXTURE) {
			nonEmptyQueue.dequeue();
		}
	}
}
