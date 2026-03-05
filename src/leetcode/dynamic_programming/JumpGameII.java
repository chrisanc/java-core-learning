package leetcode.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class JumpGameII {
    public static void main(String[] args) {
        int[] nums = new int[]{3,3,1,2,6,0,4,4};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        return jumpGame(nums, 0, 0);
    }


    public static int jumpGame(int[] nums, int steps, int currIndex) {
        // Get the minimum value
        int minimum = Integer.MAX_VALUE;

        // Base case for the recursion returning the steps
        if (currIndex >= nums.length - 1) {
            return steps;
        }

        // Iterate to get the indexes
        for (int i = 1; i <= nums[currIndex]; i++) {
            // Find recursively the minimum steps for this index on to the end
            minimum = Math.min(minimum, jumpGame(nums, steps + 1, currIndex + i));
        }

        // Return the minimal steps found
        return minimum;
    }
}
