package searchandsort;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class SearchAndSort {

    private static Random rng = new Random();
    private static final int SIZE_THRESHOLD = 25;
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
            else if (targetVal < newList.get(mid)){
                high = mid -1;
            } // else if
            // If targetVal is more the mid, low equals the mid value +1
            else {
                low = mid + 1;
            } // else
        } // while loop
        return result;
    } // binarySearch(List<Integer> newList)

    public static void main(String[] args) {

    } // main( String [] )

} // SearchAndSort

