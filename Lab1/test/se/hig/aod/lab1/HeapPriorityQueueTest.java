package se.hig.aod.lab1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit testing for HeapPriorityQueue.
 * This class contains test cases for the functionalities of HeapPriorityQueue.
 * The tests cover enqueue, dequeue, getFront, clear, and isEmpty operations.
 * 
 * @author Ferdinand Öhrn
 */
class HeapPriorityQueueTest {
    /**
     * Fixture data for testing, containing a set of integers.
     */
	static final Integer[] INT_FIXTURE = { 1, 9, 2, 8, 3, 7, 4, 6, 5, 5 };

	HeapPriorityQueue<Integer> nonEmptyQueue;
	HeapPriorityQueue<Integer> emptyQueue;
    /**
     * Sets up the test environment before each test case execution.
     * Initializes nonEmptyQueue and emptyQueue with specified capacities.
     * Enqueues test data into the nonEmptyQueue.
     * 
     * @throws Exception if an error occurs during setup
     */
	@BeforeEach
	void setUp() throws Exception {
		nonEmptyQueue = new HeapPriorityQueue<Integer>(INT_FIXTURE.length);
		emptyQueue = new HeapPriorityQueue<Integer>(INT_FIXTURE.length);

		for (int testData : INT_FIXTURE) {
			nonEmptyQueue.enqueue(testData);
		}
	}
    /**
     * Clears resources after each test case execution.
     * Sets nonEmptyQueue and emptyQueue to null.
     * 
     * @throws Exception if an error occurs during teardown
     */
	@AfterEach
	void tearDown() throws Exception {
		nonEmptyQueue = null;
		emptyQueue = null;
	}

    /**
     * Tests the clear method for a non-empty queue.
     * Verifies that the queue becomes empty after clearing.
     */
	@Test
	void testClearNonEmptyQueue() {
		nonEmptyQueue.clear();
		assertTrue(nonEmptyQueue.isEmpty(), "intQueue borde vara tom efter en clear");
	}
    /**
     * Tests the clear method for an empty queue.
     * Verifies that the empty queue remains empty after clearing.
     */
	@Test
	void testClearEmptyQueue() {
		emptyQueue.clear();
		assertTrue(emptyQueue.isEmpty(), "emptyQueue should be empty after clear");
	}
    /**
     * Tests the isEmpty method for both non-empty and empty queues.
     * Verifies the initial state of the queues.
     */
	@Test
	void testIsEmpty() {
		assertFalse(nonEmptyQueue.isEmpty(), "intQueue should not be empty from start");
		assertTrue(emptyQueue.isEmpty(), "emptyQueue should be empty from start");
	}
    /**
     * Tests the enqueue method by adding an element to an empty queue.
     * Verifies the increase in size after adding an element.
     * 
     * @throws PriorityQueueFullException if the queue is full
     * @throws PriorityQueueEmptyException if the queue is empty
     */
	@Test
	void testEnqueue() throws PriorityQueueFullException, PriorityQueueEmptyException {
		int size = emptyQueue.size();
		assertEquals(size, emptyQueue.size());
		Integer nbr = 1;
		emptyQueue.enqueue(nbr);
		assertEquals(size + 1, emptyQueue.size());
	}
    /**
     * Tests the dequeue method by removing an element from a non-empty queue.
     * Verifies the decrease in size after removing an element.
     * 
     * @throws PriorityQueueFullException if the queue is full
     * @throws PriorityQueueEmptyException if the queue is empty
     */
	@Test
	void testDequeue() throws PriorityQueueFullException, PriorityQueueEmptyException {
		int size = nonEmptyQueue.size();
		assertEquals(size, nonEmptyQueue.size());
		nonEmptyQueue.dequeue();
		assertEquals(size - 1, nonEmptyQueue.size());
	}
    /**
     * Tests the getFront method by retrieving the front element from a non-empty queue.
     * Verifies the correct front element of the queue.
     * 
     * @throws PriorityQueueEmptyException if the queue is empty
     */
	@Test
	void testGetFront() throws PriorityQueueEmptyException {
		assertEquals(9, nonEmptyQueue.getFront());
	}
    /**
     * Tests dequeuing the entire non-empty queue.
     * Verifies that the queue becomes empty after successive dequeuing operations.
     * 
     * @throws PriorityQueueEmptyException if the queue is empty
     */
	@Test
	void testDequeueWholeQueue() throws PriorityQueueEmptyException {
		for (@SuppressWarnings("unused") Integer integer : INT_FIXTURE) {
			nonEmptyQueue.dequeue();
		}
	}
}
