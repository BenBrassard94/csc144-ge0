
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
        
        for (int i = 0; i < size; i++){
            int n = 10 + rng.nextInt(90);
            result.add(n);
        // Creating random list with numbers that only have 2 digits
        
        } //for loop
        return result;
    }  // createList (int size)  

    public static void printList(List<Integer> newList) {
    // Borrowed from Leon Tabak
    
        if (newList.size() < SIZE_THRESHOLD){
            for (int n : newList) {
                System.out.printf("%4d", n);
                // Printing list in a row with 4 spaces apart
                
            } // for loop
            System.out.println();
             
        } // if
        else {
            for (int n : newList){
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
            if (targetVal == newList.get(index)){
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
    
    
    public static void main( String [] args ) {
    
    } // main( String [] )
    
    
} // SearchAndSort

