import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Purpose: To look at different sorting algorithms 
 * 
 * @author Ridout and ... Hannah Kim
 * @version October 2013
 */

public class SortComparison
{
	/** Generates a random String of characters of the given length
	 * @param length the length of the string
	 * @return the randomly generated String
	 */
	static String randomString(int length)
	{
		char[] charString = new char[length];
		for (int i = 0; i < length; i++)
			charString[i] = (char) ('A' + Math.random() * 26);
		return new String(charString);
	}

	/**
	 * Generates an ArrayList of random Strings of length 5
	 * @param noOfElements the size of the ArrayList to generate
	 * @return the new ArrayList
	 */
	private static ArrayList<String> generateArrayList(int noOfElements)
	{
		ArrayList<String> list = new ArrayList<String>(noOfElements);
		for (int i = 0; i < noOfElements; i++)
			list.add(randomString(5));
		return list;
	}

	/**
	 * Displays the elements of an List of Strings in nice columns
	 * @param list the list to display
	 */
	private static void displayList(List<String> list)
	{
		int colCount = 0;
		for (String next : list)
		{
			System.out.printf("%8s", next);
			colCount++;
			if (colCount == 10)
			{
				System.out.println();
				colCount = 0;
			}
		}
		System.out.println();
	}

	/**
	 * Sorts a List in ascending order (lowest to highest) using the
	 * bubble sort algorithm
	 * @param list the List to sort
	 */
	private static  void bubbleSort(List<String> list)
	{
		// The upperLimit starts with the last position in the list
		// and counts down. We will exit this outer loop early if
		// no exchanges are made in the inner loop
		boolean exchangeMade = true;
		for (int upperLimit = list.size() - 1; upperLimit > 0 && exchangeMade; upperLimit--)
		{
			// Passes through the list up to the upperLimit,
			// exchanging elements that are out of order.
			// After completing this loop, the largest element found in
			// this pass should be "bubbled" up to the upperLimit position
			// If the list is in order, the exchangeMade flag will
			// remain false and we are done
			exchangeMade = false;
			for (int i = 0; i < upperLimit; i++)
				if (list.get(i).compareTo(list.get(i + 1)) > 0)
				{
					// Swap the out of order elements
					String temp = list.get(i);
					list.set(i, list.get(i + 1));
					list.set(i + 1, temp);
					exchangeMade = true;
				}
		}
	}

	/**
	 * Sorts a List in ascending order (lowest to highest) using the
	 * selection sort algorithm
	 * 
	 * @param list the List to sort
	 */
	private static void selectionSort(List<String> list)
	{
            for (int i = 0; i < list.size() - 1; i++) 
            {
                for (int j = i + 1; j < list.size(); j++) 
                {
                    if (list.get(i).compareTo(list.get(j)) >= 0) 
                    {
                        // Swap smaller and bigger
                        String word = list.get(i);
                        list.set(i, list.get(j));
                        list.set(j, word);
                    }
                }
            }
	}

	/**
	 * Sorts a List in ascending order (lowest to highest) using the
	 * insertion sort algorithm
	 * 
	 * @param list the List to sort
	 */
	private static void insertionSort(List<String> list)
	{
        // Make a variable to keep track of largest
        int largest;
        
          for (int i=0; i < list.size () - 1; i++)
          {
            largest = 0;
            for (int j=largest + 1; j < list.size () - i; j++)
            {
              if ((list.get (largest)).compareTo (list.get (j)) < 0)
              {
                 largest = j;
              }
            }
            String word = list.get (list.size () - 1 - i);
            list.set (list.size () - 1 - i, list.get (largest));
            list.set (largest, word);
          }
	}

	/**
	 * Sorts an List in ascending order (lowest to highest) using the merge
	 * sort algorithm
	 * 
	 * @param list the List to sort
	 */
	private static void mergeSort(List<String> list)
	{
		// This will call the recursive merge sort for the whole list
		// Do not change this code.  
	  mergeSort(list, 0, list.size());
	}
	
	// You may want to use these helper methods for the merge sort
	// Make sure that your methods work as described
	
	/**
	 * Sorts a section of an List in ascending order (lowest to highest). 
	 * Sorts the section between start (inclusive) and end (exclusive).
	 * This method will call itself as well as the merge method
	 * @param list the List to sort
	 * @param start the start position of the list to sort (inclusive)
	 * @param end the end position of the list to sort (exclusive)     
	 */
	private static void mergeSort(List<String> list, int start, int end)
	{
		// I changed my mind and decided to give you this code
		// Don't change this code - just write the merge method code
		// However, make sure that you understand this code
		
		// When you have a section of the list with
		// 0 or 1 elements it must be sorted
	    if (end -start<= 1)
	    return;
		 
	   // Sort the two halves of the list
       int middle = (start + end)/2;
       mergeSort(list, start, middle);
       mergeSort(list, middle, end);
       
       // And then merge the sorted halves
       merge(list, start, middle, end);
	}
	
	/**
	 * Merges two sorted sections of an ArrayList into one.
	 * The merged elements are eventually stored in the given List.
	 * Merges the section from [start, middle) and from [middle, end).
	 * First section is from start (inclusive) to middle (exclusive).
	 * Second section is from middle (inclusive) to end (exclusive).
	 * @param list the List to merge in
	 * @param start the start position of the first section to merge (inclusive)
	 * @param middle the middle of the list.  This will also be:
	 *               the end position of the first section to merge (exclusive)
	 *               the start position of the second section to merge (inclusive)
	 * @param end the end position of the second section to merge (exclusive)
	 */
	private static void merge(List<String> list, int start, int middle, int end)
	{
	   // This is similar (but different) to the merge we did last year.
	   // You will need to merge into another List and then copy back the elements to the given list
	   // Remember you are only merging a section of the list
	   // Also, since we are using ArrayLists instead of arrays, you only need two indexes
	   // Finally, as a first step you should check if any merging is required
		  
	}

	/**
	 * Checks if the given List is sorted in ascending order
	 * 
	 * @param list the List to check to see if it is in order
	 * @param listInOrder the List in order
	 * @return true if the list is sorted in ascending order, false otherwise
	 */
	public static boolean isSorted(List<String> list, List<String> listInOrder)
	{
		// Check if something is out of order
		for (int i = 0; i < list.size(); i++)
			if (list.get(i).compareTo(listInOrder.get(i)) != 0)
				return false;

		// Everything was in order
		return true;
	}

	public static void main(String[] args)
	{
		final int LIST_SIZE = 50;
		System.out.println("            Sorting an Array of Strings");
		
		// You may want to comment out some of this codes as you work through the assignment

		// Generate an ArrayList and display the initial array
		ArrayList<String> list = generateArrayList(LIST_SIZE);
		
		// Make a copy of this list and then sort it for later comparison in isSorted
		ArrayList<String> listInOrder = new ArrayList<String> (list);
		Collections.sort(listInOrder);
		
		System.out.println("Here is the original list: ");
		displayList(list);

		// Sort the ArrayList using different sorts
		bubbleSort(list);
		// Display the sorted list
		System.out.println("\nHere is the sorted list for bubble sort: ");
		displayList(list);
		if (isSorted(list, listInOrder))
			System.out.println("Bubble sort works");
		else
			System.out.println("Bubble sort doesn't work");

		// Mix up the list for the next sort
		Collections.shuffle(list);
		selectionSort(list);
		// Display the sorted list
		System.out.println("\nHere is the sorted list for selection sort: ");
		displayList(list);
		if (isSorted(list, listInOrder))
			System.out.println("Selection sort works");
		else
			System.out.println("Selection sort doesn't work");

		// Mix up the list for the next sort
		Collections.shuffle(list);
		insertionSort(list);
		// Display the sorted list
		System.out.println("\nHere is the sorted list for insertion sort: ");
		displayList(list);
		if (isSorted(list, listInOrder))
			System.out.println("Insertion sort works");
		else
			System.out.println("Insertion sort doesn't work");

		// Mix up the list for the next sort
		Collections.shuffle(list);
		mergeSort(list);
		// Display the sorted list
		System.out.println("\nHere is the sorted list for merge sort: ");
		displayList(list);
		if (isSorted(list, listInOrder))
			System.out.println("Merge sort works");
		else
			System.out.println("Merge sort doesn't work");

		// Compare the run times of each sort for different ordered lists
		// Change the type of sort to test each sort
		
		System.out.println("Timing each of the sorts...");
		// Create a new Random list
		int sizeToCheck = 10000;   // Change to 100000 and 1000000 later (for merge only)
		list = generateArrayList(sizeToCheck);

		// Check the sort time of an random ordered list
		long startTime = System.nanoTime();
		bubbleSort(list);
		long endTime = System.nanoTime();
		System.out.printf("Total time to sort %,d elements in random order: ", sizeToCheck);
		System.out.printf("%.1f ms%n", (endTime - startTime) / 1000000.0);
		
		// Check the sort time of an ordered list (sorted above)
		startTime = System.nanoTime();
		bubbleSort(list);
		endTime = System.nanoTime();
		System.out.printf("Total time to sort %,d elements in order: ", sizeToCheck);
		System.out.printf("%.1f ms%n", (endTime - startTime) / 1000000.0);
		
		// Check the sort time of an reverse ordered list
		Collections.reverse(list);
		startTime = System.nanoTime();
		bubbleSort(list);
		endTime = System.nanoTime();
		System.out.printf("Total time to sort %,d elements in reverse order: ", sizeToCheck);
		System.out.printf("%.1f ms%n", (endTime - startTime) / 1000000.0);

		System.out.println("Program is Complete");
	} // main method
} // Sorting class

