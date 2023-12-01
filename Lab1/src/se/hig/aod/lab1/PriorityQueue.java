package se.hig.aod.lab1;

/**
 * A Java interface for the Abstract Data Type PriorityQueue.
 * <p>
 * 
 * @author Hanna Holmgren
 * @param <T> The data type that is to be stored in the queue.
 */
public interface PriorityQueue<T> {

	/**
	 * Removes all element in the queue
	 */
	public void clear();

	/**
	 * Checks if the queue is empty
	 * 
	 * @return A boolean, True if its empty, false if its not
	 */
	public boolean isEmpty();

	/**
	 * 
	 * Inserts an element in the queue
	 * 
	 * @param t an element to be put in the queue
	 * @throws PriorityQueueFullException 
	 */
	public void enqueue(T t) throws PriorityQueueFullException;

	/**
	 * Removes the element at the front of the queue
	 * 
	 * @return The element at the front of the queue
	 * @throws PriorityQueueFullException 
	 * @throws PriorityQueueEmptyException if queue is empty
	 */
	public T dequeue() throws PriorityQueueFullException, PriorityQueueEmptyException;

	/**
	 * Returns the size of the queue
	 * 
	 * @return an int representing the size
	 */
	public int size();

	/**
	 * Returns the element at the front of the queue but does not remove it
	 * 
	 * @return The element at the front of the queue
	 * @throws PriorityQueueEmptyException if queue is empty
	 */
	public T getFront() throws PriorityQueueEmptyException;
}
