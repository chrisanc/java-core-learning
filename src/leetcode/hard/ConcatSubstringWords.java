package leetcode.hard;

import java.util.*;

public class ConcatSubstringWords {
    public static void main(String[] args) {
        String[] words = new String[]{"ab", "po"};
        System.out.println(findSubstring("abpopoablasd", words));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<String> permutations = getPermutationsOf(words);

        List<Integer> result = new ArrayList<>();
        int step = permutations.getFirst().length();

        HashMap<String, Integer> perm = new HashMap<>();
        for (String str : permutations) {
            perm.putIfAbsent(str, 1);
        }

        for (int i = 0; i <= s.length() - step; i++) {
            String substr = s.substring(i, i + step);
            if (perm.getOrDefault(substr, -1) != -1) {
                result.add(i);
            }
        }

        return result;
    }

    public static List<String> getPermutationsOf(String[] words) {
        // Necessary data structures
        List<String> results = new ArrayList<>();
        Stack<Data> stack = new Stack<>();

        // Add initial 'Data' to the stack
        stack.add(new Data(words, 0));

        while (!stack.empty()) {
            Data value = stack.pop();
            if (value.index >= words.length - 1) {
                results.add(String.join("", value.words));
                continue;
            }

            for (int i = value.index; i < words.length; i++) {
                swap(value.words, value.index, i);
                stack.add(new Data(Arrays.copyOfRange(value.words, 0, value.words.length), value.index + 1));
                swap(value.words, value.index, i);
            }
        }

        return results;
    }

    public static <T> void swap(T[] nums, int i, int j) {
        T temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    static class Data {
        String[] words;
        int index;

        public Data(String[] words, int index) {
            this.words = words;
            this.index = index;
        }
    }
}
