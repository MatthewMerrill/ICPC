import java.util.Scanner;

import static java.lang.System.in;

/**
 * Created by merrillm on 9/26/16.
 *
 * CSUS 12-13 S1: "EVEN vs ODD"
 */
public class EvenOdd {
    
    /*
7
1962
1993
2001
1977
1998
1996
1995
     */
    public static void main(String[] args) {
        Scanner scn = new Scanner(in);
        
        int[] counts = new int[2];
        
        for (int _N = scn.nextInt(); _N > 0; --_N) {
            counts[scn.nextInt()&1]++;
        }
        
        System.out.printf("" +
                "Number of odds: %d\n" +
                "Number of evens: %d\n" +
                "The winner is %s.",
                counts[1], counts[0],
                (counts[1]>counts[0]?"Sarah":"Joe"));
    }
    
}
