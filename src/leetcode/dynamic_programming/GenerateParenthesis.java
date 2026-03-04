package leetcode.dynamic_programming;

import java.util.*;

public class GenerateParenthesis {
    static Map<String, Short> memo = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Generate Valid Parentheses");
        System.out.println(generateParenthesis(4));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        String parenthesis = generateFirstParentheses(n);
        generate(results, parenthesis.toCharArray(), 0);
        return results;
    }

    public static void generate(List<String> results, char[] s, int index) {
        // char[] -> string using the constructor of String
        String str = new String(s);
        // Base case for recursion: When the index is >= to the length of the
        // original values, we just verify that it haven't been added and add it
        if (index >= s.length) {
            // If the memo doesn't contain the current key and the parenthesis are valid
            // we add it on the results list
            if (!memo.containsKey(str) && isValidParentheses(str)){
                results.add(str);
            }
            return;
        }

        // If the memo already contains the current string, we return. (save up computations)
        // If we already got it on the memo means it have been computed before and we don't
        // need duplicated values
        if (memo.containsKey(str)) {
            return;
        }

        // Recursive algorithm to find the permutations
        for (int i = index; i < s.length; i++) {
            // Backtrack
            swap(s, index, i);
            generate(results, s, index + 1);
            swap(s, index, i);
        }

        // Put the current key in the memo if it's not
        memo.putIfAbsent(str, (short) 1);
    }

    public static String generateFirstParentheses(int n) {
        return "(".repeat(n) + ")".repeat(n);
    }

    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean isValidParentheses(String parentheses) {
        Stack<Character> stack = new Stack<>();
        for (char c : parentheses.toCharArray()) {
            if (c == '(') {
                stack.add(c);
                continue;
            }

            if (stack.empty()) return false;
            stack.pop();
        }

        return stack.empty();
    }
}
