package leetcode.fast_slow_pointers;

import java.util.Arrays;

public class RemoveElementArray {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2}; // [0, 1, 3, 0, 4, 2, 2, 2]
        System.out.println(removeElement(nums, 2));
        System.out.println(Arrays.toString(nums));
    }

    public static int removeElement(int[] nums, int val) {
        // This pointer keeps track of the last valid element in the array [slow - 1] and the current
        // value is the value to potentially modify
        int slow = 0;

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // If the value at the fast pointer isn't equal to the targeted
            // value we just do a swapping of values
            if (nums[i] != val) {
                swap(nums, slow, i);
                // Increase slow by 1
                slow++;
            }
            // If the value at the fast pointer is equals to the targeted value,
            // we just increase i
        }

        return slow;
    }

    public static void swap(int[] nums, int i, int j) {
        // Swap the numbers to put the correct value in the slow index position
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
