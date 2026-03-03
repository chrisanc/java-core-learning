package leetcode.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    public static void main(String[] args) {
        // Write a program that prints the N-th number of the Fibonacci
        // sequence with and without DP
        //System.out.println("Normal recursion: " + fibo(45));
        System.out.println("Dynamic Programming: " + fibo(45, new HashMap<>()));
    }

    public static int fibo(int n) {
        // Using basic recursion: Could be very slow with high numbers (struggles with >= 45)
        if (n <= 1) {
            return n;
        }

        return fibo(n - 1) + fibo(n - 2);
    }


    public static long fibo(int n, Map<Integer, Long> memo) {
        // Using DP with Memoization of data using a Hashmap
        // This allows the algorithm to save up some computations...
        if (n <= 1) {
            return n;
        }

        // If the key already exists, just return the value
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        // Save the result of the recursion in variables
        long left = fibo(n - 1, memo);
        long right = fibo(n - 2, memo);

        // Put the values in the map if they don't exist
        memo.putIfAbsent(n - 1, left);
        memo.putIfAbsent(n - 2, right);

        // Return their sum
        return left + right;
    }
}
