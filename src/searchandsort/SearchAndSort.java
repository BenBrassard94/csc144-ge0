package searchandsort;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class SearchAndSort {

    private static Random rng = new Random();
    private static final int SIZE_THRESHOLD = 20;
    // These statements create a random list of integers.

    public static List<Integer> createList(int size) {
        // Borrowed from Leon Tabak

        List<Integer> result = new ArrayList<>();
        // Creating an array list out of our new list

        for (int i = 0; i < size; i++) {
            int n = 10 + rng.nextInt(90);
            result.add(n);
            // Creating random list with numbers that only have 2 digits

        } //for loop
        return result;
    }  // createList (int size)  

    public static void printList(List<Integer> newList) {
        // Borrowed from Leon Tabak

        if (newList.size() < SIZE_THRESHOLD) {
            for (int n : newList) {
                System.out.printf("%4d", n);
                // Printing list in a row with 4 spaces apart

            } // for loop
            System.out.println();

        } // if
        else {
            for (int n : newList) {
                System.out.printf("%4d", n);
                // Printing list in a column with 4 spaces apart

            } // for loop
        } // else
    } // printList

    /* Find a method that determines the index
    *  of the first integer in a list of integers
    *  that matches a give integer. If there is
    *  no match, should return -1. Use the sequential
    *  search algorithm.
    *
    * @param linearSearh( List<Integer>)
    * @result result of linearSearch
    * 
    * @author Ben Brassard
    * @version 27 March 2020
    * 
     */
    public static int linearSearch(List<Integer> newList, int targetVal) {
        // Returns -1 if there is no match
        int result = -1;
        // Setting initial index
        int index = 0;

        // Only searches when these parameters are met
        // result < 0 stops while loop from being infinite
        while (index < newList.size() && result < 0) {
            if (targetVal == newList.get(index)) {
                result = index;

            } // if
        } // while loop
        return result;
    } // linearSearch (List<Integer> newList)

    /* Repeat the same instructions as linearSearch
    * but this time, use the binarySearch to find the 
    * index of the first integer of the given integer
    *
    * @param Using List<Integer> newList (List)
    * @result A list that has been search through with binary search
    *
     */
    public static int binarySearch(List<Integer> newList, int targetVal) {
        // Returns -1 if there is no match
        int result = -1;

        // Sets a lowest value perimeter
        int low = 0;
        // Sets a highest value perimeter thats 1 less that newList.size()
        int high = newList.size() - 1;

        /* Makes sure low < high and loop isn't infinite
        *  Also checks every possible parameter until it
        *  Finds the given integer's index
         */
        while (low < high && result < 0) {
            // Set the middle value
            int mid = (low + high) / 2;

            // If the low is the target value, then result equals the low
            if (targetVal == newList.get(low)) {
                result = low;
            } // if 
            // If the mid is the target value, then result equals the mid
            else if (targetVal == newList.get(mid)) {
                result = mid;
            } // else if
            // If the high is the target value, then result equals the high
            else if (targetVal == newList.get(high)) {
                result = high;
            } // else if
            // If targetVal is less the mid, high equals the mid value -1
            else if (targetVal < newList.get(mid)) {
                high = mid - 1;
            } // else if
            // If targetVal is more the mid, low equals the mid value +1
            else {
                low = mid + 1;
            } // else
        } // while loop
        return result;
    } // binarySearch(List<Integer> newList)

    // Makes a swap method to make the sort methods more clean
    public static void swap(List<Integer> newList, int i, int j) {
        // Swaps two integers
        int tempNum = newList.get(i);
        newList.set(i, newList.get(j));
        newList.set(j, tempNum);

    } // swap(List<Integer> newList

    // Find the minimum value in a list and makes code for sorts more clean
    public static int findMinPoint(List<Integer> newList, int start) {
        // Creating variable that changes to different min points
        int currentPoint = start;
        // Finding lowest possible integer then setting it to the start
        for (int i = start + 1; i < newList.size(); i++) {
            if (newList.get(i) < newList.get(currentPoint)) {
                currentPoint = i;
            } // if
        } // for loop
        return currentPoint;
    } // findMinPoint(List<Integer> newList

    /* Find a method that sorts a list using selection
    *  sort. Should put all integers in the list in order
    *  from smallest to largest.
    *
    *  @param newList Sorted list (List)
    *  @return newList ending list, should be sorted
     */
    public static void selectionSort(List<Integer> newList) {
        for (int i = 0; i < newList.size(); i++) {
            int j = findMinPoint(newList, i);
            swap(newList, i, j);
        } // for loop
    } // selectionSort(List<Integer> newList)

    // Helps compress the insertionSort method
    public static void insert(List<Integer> newList, int nextNum) {
        int i = nextNum;
        while (i > 0 && newList.get(i) < newList.get(i - 1)) {
            swap(newList, i, i - 1);
            i = i - 1;

        } // while loop

    } // insert(List<Integer> newList)

    /* Find a method that sorts a list of integers that uses the
     * insertion sort method
     *
     * @param newList
     * @param next
     * @return swap values in list and sorts it
     */
    public static void insertionSort(List<Integer> newList) {
        for (int i = 1; i < newList.size(); i++) {
            insert(newList, i);

        } // for loop
    } // insertionSort(List<Integer>)

    /* Find a method that sorts a list of integers
    *  using the merge sort method
    *
    *  @param NewList
    *  @param prefixStart, suffixStart, suffixEnd
    *  @result Sorted newList
     */
    // Borrowed from Leon Tabak
    public static void merge(List<Integer> newList, int prefixStart,
            int suffixStart, int suffixEnd) {
        List<Integer> temp = new ArrayList<>();

        int i = prefixStart;
        int j = suffixStart;

        while (i < suffixStart && j < suffixEnd) {
            if (newList.get(i) < newList.get(j)) {
                temp.add(newList.get(i));
                i++;
            } // if
            else {
                temp.add(newList.get(j));
                j++;
            } // else
        } // while

        while (i < suffixStart) {
            temp.add(newList.get(i));
            i++;
        } // while

        while (j < suffixEnd) {
            temp.add(newList.get(j));
            j++;
        } // while

        i = prefixStart;
        for (int index = 0; index < temp.size(); index++) {
            newList.set(i, temp.get(index));
            i++;
        } // for
    } // merge( List<Integer>, int, int )        

    // Borrowed from Leon Tabak    
    public static void mergeSort(List<Integer> newList) {
        for (int stepSize = 2; stepSize < newList.size(); stepSize *= 2) {
            for (int i = 0; i < newList.size(); i += stepSize) {
                int prefixStart = i;
                int suffixStart = i + stepSize / 2;
                int suffixEnd = Math.min(newList.size(), i + stepSize);
                merge(newList, prefixStart, suffixStart, suffixEnd);
            } // for
            if (stepSize > newList.size() / 2) {
                int prefixStart = 0;
                int suffixStart = stepSize;
                int suffixEnd = newList.size();
                merge(newList, prefixStart, suffixStart, suffixEnd);
            } // if
        } // for
    } // mergeSort(List<Integer> newList)  

    public static void main(String[] args) {
        System.out.println("Selection Sort");
        List<Integer> data = createList(10);
        printList(data);
        System.out.println(" **** ");
        selectionSort(data);
        printList(data);

        System.out.println(" **** ");

        System.out.println("Insertion Sort");
        data = createList(10);
        printList(data);
        System.out.println(" **** ");
        insertionSort(data);
        printList(data);

        System.out.println(" **** ");

        System.out.println("Merge Sort");
        data = createList(10);
        printList(data);
        System.out.println(" **** ");
        mergeSort(data);
        printList(data);

    } // main( String [] )

} // SearchAndSort

/* These examples of how to make the different methods and classes are
*  examples of how java can seem more complex than Python, which a lot of you
*  only have experience in. One of the easiest difference that are seen are
*  that in Python, one can code the same thing in Java but with much less lines.
*  Java is one of the foundation coding languages to leanr and once one learns it,
*  most of the other coding languages will become more clear.
*
*  When creating a random list of integers, this is another difference between Java
*  and Python. In Pythonn, it's pretty easy to create a list of random numbers.
*  But in Java, you have to create and object of the class Random, which is implemented
*  in the system itself.
*
*  One other difference to get used to is to make sure you have brackets, parantheses,
*  and semi-colons at the end of every spot they should be. If these are forgotten,
*  everything will seem to not work, even if it is spot on correct.
*
*  Overall, everyone should learn how to create different classes and create random list
*  by looking at this exercise. You can learn how to grab elements of list with different
*  commands and find the index of certain spots in the list. There are many things here
*  that one can take out and try on their own. Have fun!
*/
