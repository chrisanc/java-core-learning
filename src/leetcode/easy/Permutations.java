package leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(1, 2, 3));
        List<List<Integer>> results = new ArrayList<>();
        permutate(nums, results, 0);
        System.out.println(results);
    }

    public static void permutate(List<Integer> nums, List<List<Integer>> results, int index) {
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
}
