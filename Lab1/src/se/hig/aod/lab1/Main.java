package se.hig.aod.lab1;

import java.util.ArrayList;
import java.util.List;

public class Main {

	private static final Integer[] INT_FIXTURE = { 1, 9, 2, 8, 3, 7, 4, 6, 5, 5 };

	public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(INT_FIXTURE));

        try {
        	System.out.println("Non-sorted List: " +  numbers);
            List<Integer> sortedNumbers = HeapSorter.sort(numbers);
            System.out.println("Sorted List: " + sortedNumbers);
        } catch (PriorityQueueFullException | PriorityQueueEmptyException e) {
            e.printStackTrace();
        }
    }

}
