package leetcode.fast_slow_pointers;

import java.util.Arrays;

public class RemoveDuplicatesArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 2, 3, 4, 5, 5, 6}; // [1, 2, 3, 4, 5, 6, _, _, _, _]
        System.out.println(modify(nums));
        System.out.println(Arrays.toString(nums));
    }

    public static int modify(int[] nums) {
        /*
        * Fast and Slow pointers approach
        * */
        // Start the slow pointer at 1 because the element at the index
        // 0 is never moving. Keeps track of the index to modify
        int slow = 1;
        // Iterate through the array
        for (int i = 1; i < nums.length; i++) {
            // Compare the value at fast with the element before slow because
            // slow represents the index to modify and the element before
            // represents the last unique element
            if (nums[i] != nums[slow - 1]) {
                swap(nums, slow, i);
                slow++;
            }
        }

        return slow;
    }

    public static void swap(int[] nums, int i, int j) {
        // Swap element from i to j and vice versa
        RemoveElementArray.swap(nums, j, i);
    }
}
