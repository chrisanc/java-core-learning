package leetcode.dynamic_programming;

import java.util.*;

public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println("Generate Valid Parentheses");
        System.out.println(generateParentheses(2));
    }

    public static List<String> generateParentheses(int n) {
        List<String> results = new ArrayList<>();
        generate(results, generateFirstParentheses(n).toCharArray(), 0);
        return results;
    }

    public static void generate(List<String> results, char[] s, int index) {
        if (index >= s.length) {
            results.add(new String(s));
            return;
        }

        for (int i = index; i < s.length; i++) {
            swap(s, index, i);
            generate(results, s, index + 1);
            swap(s, index, i);
        }
    }

    public static String generateFirstParentheses(int n) {
        return "(".repeat(n) + ")".repeat(n);
    }

    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
