
package searchandsort;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class SearchAndSort {
    
    private static Random rng = new Random();
    private static final int SIZE_THRESHOLD = 25;
    // These statements create a random list of integers.
    
    public static List<Integer> createList(int size) {
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
    
    public static void main( String [] args ) {
    
    } // main( String [] )
} // SearchAndSort
