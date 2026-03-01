package leetcode.easy;

import java.util.Arrays;

public class RemoveDuplicatesArray {
    public static void main(String[] args) {
        // Define the array
        int[] nums = new int[]{1, 1, 1, 1, 1, 2, 2, 3, 4, 5, 5, 6, 6, 7};
        // Should modify in-place -> [1, 2, 3, 4, 5, 6, 7, _, _, _, _, _, _, _] and return 7 (length of the values)
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        // Define a slow pointer that keeps that of the index we should modify
        int slow = 1;

        // Iterate over the array of nums starting from 1
        for (int fast = 1; fast < nums.length; fast++) {
            // If the current position is different to the slow pointer -1 (-1 because that's the last
            // unique element added)
            if (nums[fast] != nums[slow - 1]) {
                // Swapping elements
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                // Increase the slow by 1
                slow++;
            }
        }

        // Return the value of the slow pointer (as it stays on the index where unique values exists)
        return slow;
    }
}
