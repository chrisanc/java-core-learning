package leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Permutations {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(1, 2, 3));
        List<List<Integer>> results = new ArrayList<>();
        permutate(nums, results, 0);
        System.out.println("Recursive: " + results);
        results = permutate(nums);
        System.out.println("Iterative: " + results);
    }

    public static void permutate(List<Integer> nums, List<List<Integer>> results, int index) {
        /*
        * Permutation recursive method to get all the permutations from a list
        * */
        if (index == nums.size() - 1) {
            results.add(new ArrayList<>(nums));
            return;
        }

        for (int i = index; i < nums.size(); i++) {
            Collections.swap(nums, index, i);
            permutate(nums, results, index + 1);
            Collections.swap(nums, index, i);
        }
    }

    public static List<List<Integer>> permutate(List<Integer> nums) {
        /*
        * Permutation iterative method to get all the permutations from a given list
        * */
        // Helper class (Data Transfer Object)
        record Data(List<Integer> nums, int index) {}

        // Results list
        List<List<Integer>> results = new ArrayList<>();
        // Define a stack for the data
        Stack<Data> stack = new Stack<>();
        stack.add(new Data(nums, 0));

        while (!stack.empty()) {
            // Delete the last element from the stack
            Data value = stack.pop();
            // If the index is equals to the last index available of the list, we continue...
            if (value.index >= value.nums.size() - 1) {
                results.add(value.nums);
                continue;
            }

            // Iterate over the nums starting from the saved index
            for (int i = value.index; i < nums.size(); i++) {
                Collections.swap(value.nums, value.index, i);
                stack.add(new Data(new ArrayList<>(value.nums), value.index + 1));
                Collections.swap(value.nums, value.index, i);
            }
        }

        // Return the results
        return results;
    }
}
