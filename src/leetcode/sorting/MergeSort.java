package leetcode.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = new int[]{11, 10, 8, 5, 8, 2, 6, 4, 3, 0, 11, 10, 8, 5, 8, 0, 2, 6, 4, 3, 0, 11};
        nums = mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] mergeSort(int[] nums, int i, int j) {
        // If the length of the array is <= to 1, we just return the array (as it just contains one number)
        if (j - i < 1) {
            return copyOfRange(nums, i, j);
        }

        /*
        * There's no need to call copyOfRange() any other time because
        * we'll just arrange the elements from the condition on
        * */

        // Get the middle index
        int n = (j + i) / 2;
        // Recursively call the method with new indexes for the left side (inclusive)
        int[] left = mergeSort(nums, i, n);
        // Recursively call the method with new indexes for the right side (inclusive)
        int[] right = mergeSort(nums, n + 1, j);

        // Return the merged arrays
        return merge(left, right);
    }

    public static int[] copyOfRange(int[] nums, int i, int j) {
        /*
        * Return a new array from [i, j] based on an existing one (inclusive in both ranges)...
        * */
        int[] res = new int[j - i + 1];
        int index = 0;

        for (int z = i; z <= j; z++) {
            res[index] = nums[z];
            index++;
        }

        return res;
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        // Merges two different arrays by values, ensuring it's from the minimum to maximum
        // or until one's empty
        int[] nums = new int[arr1.length + arr2.length];
        // Create a index to put values on the ith position of the new array
        int index = 0;
        // Create a pointer for the first array
        int ptr1 = 0;
        // Create a pointer for the second array
        int ptr2 = 0;

        while (ptr1 < arr1.length && ptr2 < arr2.length) {
            if (arr1[ptr1] > arr2[ptr2]) {
                nums[index] = arr2[ptr2];
                ptr2++;
            } else {
                nums[index] = arr1[ptr1];
                ptr1++;
            }
            index++;
        }

        while (ptr1 < arr1.length) {
            nums[index] = arr1[ptr1];
            index++;
            ptr1++;
        }

        while (ptr2 < arr2.length) {
            nums[index] = arr2[ptr2];
            index++;
            ptr2++;
        }

        return nums;
    }
}
