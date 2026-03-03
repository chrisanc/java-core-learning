package leetcode.two_pointers;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        // Define an array of integers
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        // Apply the threeSum and display the returning values
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        /*
        * Takes an array of integers and return all the triplets which summed == 0
        * */
        // Define a hash to implement a TwoSum variation
        Map<Integer, Integer> hash = new HashMap<>();
        Map<String, Integer> hasher = new HashMap<>();
        // List of results
        List<List<Integer>> results = new ArrayList<>();

        // Iterate the array length - 2 (because they're triplets)
        for (int i = 0; i < nums.length - 1; i++) {
            // Get a fixedValue
            int fixedValue = nums[i];
            // Clear the hash
            hash.clear();
            // Define a pointer next to the current one
            for (int j = i + 1; j < nums.length; j++) {
                if (hash.containsKey(nums[j])) {
                    List<Integer> temp = List.of(fixedValue, nums[hash.get(nums[j])], nums[j]);
                    int[] minMax = getMinMax(temp);
                    if (hasher.getOrDefault(minMax[0] + "" + minMax[1], -1)  < 0) {
                        results.add(temp);
                        hasher.put(minMax[0] + "" + minMax[1], 1);
                    }
                } else {
                    hash.put(-fixedValue-nums[j], j);
                }
            }
        }

        return results;
    }

    public static int[] getMinMax(List<Integer> nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (Integer value : nums) {
            if (value < min) {
                min = value;
            }
            if (value > max) {
                max = value;
            }
        }

        return new int[]{min, max};
    }
}
