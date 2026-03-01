package leetcode.easy;

import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("{()[]{}}"));
    }

    public static boolean isValid(String s) {
        Map<Character, Character> hash = Map.of('(', ')', '[', ']', '{', '}');
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.add(ch);
                continue;
            }

            if (stack.empty()) {
                return false;
            }

            char value = stack.pop();
            if (hash.get(value) != ch) {
                return false;
            }
        }

        return stack.empty();
    }
}
