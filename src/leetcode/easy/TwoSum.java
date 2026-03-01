package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 9, 0, 4, 5, 9};
        System.out.println(Arrays.toString(twoSum(arr, 18)));
    }

    public static int[] twoSum(int[] nums, int target) {
        /*
        * params: int[] nums is the array of numbers to search in
        * returns int[], which is an array with two elements, the indexes of the numbers
        * */
        // Declare a hashmap to save up the values
        /*
        * A hashmap is just a structure that hashes the key (no matter the size) to an integer
        * that servers as an index for an array of buckets or as a memory address
        * */
        // With the new keyword, we allocate memory to the variable
        Map<Integer, Integer> hash = new HashMap<>();

        // Iterate over the array of numbers to find the
        for (int i = 0; i < nums.length; i++) {
            // We verify if the current value isn't within the hash
            if (!hash.containsKey(nums[i])) {
                // Set up the residual of the target with the index
                hash.put(target - nums[i], i);
            } else {
                // Return a new array with the two values which addition is equal to the target
                // hash.get(value) gets the index of the another value
                return new int[]{hash.get(nums[i]), i};
            }
        }

        // O(n) time complexity and O(1) space complexity
        // If no coincidence was found, we return an empty array
        return new int[]{};
    }
}