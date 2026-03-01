package leetcode.easy;

import java.util.Arrays;

public class RemoveElementArray {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(removeElement(nums, 2));
        System.out.println(Arrays.toString(nums));
    }

    public static int removeElement(int[] nums, int val) {
        // Define a slow pointer to point to the index to swap
        // Keeps track of the last valid index
        int slow = 0;

        // Create a fast pointer to iterate over the array
        for (int fast = 0; fast < nums.length; fast++) {
            // If the value at fast is different to the value, we swap the numbers
            // (in order to swap the values)
            if (nums[fast] != val) {
                swap(nums, slow, fast);
                slow++;
            }
            // If the fast pointer is equals to the value,
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
