package se.hig.aod.lab1;

@SuppressWarnings("serial")
public class PriorityQueueEmptyException extends RuntimeException {
	/*
	 * A constructor that takes a message about which error has been generated. This
	 * can be written to the user when the exception is caught.
	 */
	public PriorityQueueEmptyException(String message) {
		super(message);
	}

}
