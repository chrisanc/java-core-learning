package leetcode.easy;

public class FinalValAfterOps {
    public static void main(String[] args) {
        String[] nums = new String[]{"X--", "X++", "--X"};
        System.out.println(finalValueAfterOperations(nums));
    }

    public static int finalValueAfterOperations(String[] operations) {
        // Initial value
        int x = 0;
        // Iterate over the operations array
        for (String s : operations) {
            // Switch the value at index 1 (as it never changes, just binary)
            switch (s.charAt(1)) {
                case '+' -> x++;
                default -> x--;
            }
        }

        // Return the value modified
        return x;
    }
}
