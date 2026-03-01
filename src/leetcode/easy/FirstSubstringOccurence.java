package leetcode.easy;

public class FirstSubstringOccurence {
    public static void main(String[] args) {
        System.out.println(strStr("leetcodx", "x"));
    }

    public static int strStr(String haystack, String needle) {
        for (int i = 0; i + needle.length() <= haystack.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }

        return -1;
    }
}
