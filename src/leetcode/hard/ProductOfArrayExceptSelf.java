package leetcode.hard;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(arr)));
    }

    public static int[] productExceptSelf(int[] nums) {
        // Create a prefix array
        int[] pre = new int[nums.length];
        // Create a suffix array
        int[] suff = new int[nums.length];
        // End the suffix array with a 1
        suff[nums.length - 1] = 1;
        // Start the prefix array with a 1
        pre[0] = 1;

        // Iterate over the nums to fill up the array with products
        for (int i = 1; i < nums.length; i++) {
            pre[i] = nums[i - 1] * pre[i - 1];
        }

        for(int i = nums.length - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = pre[i] * suff[i];
        }

        return nums;
    }
}
