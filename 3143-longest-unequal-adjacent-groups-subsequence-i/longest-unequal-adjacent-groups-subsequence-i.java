import java.util.*;

class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        List<String> dp0 = new ArrayList<>(); // Subsequence ending with group 0
        List<String> dp1 = new ArrayList<>(); // Subsequence ending with group 1

        for (int i = 0; i < n; i++) {
            if (groups[i] == 0) {
                // Try to extend from subsequence ending in group 1
                List<String> newDp0 = new ArrayList<>(dp1);
                newDp0.add(words[i]);
                if (newDp0.size() > dp0.size()) {
                    dp0 = newDp0;
                }
            } else {
                // Try to extend from subsequence ending in group 0
                List<String> newDp1 = new ArrayList<>(dp0);
                newDp1.add(words[i]);
                if (newDp1.size() > dp1.size()) {
                    dp1 = newDp1;
                }
            }
        }

        return dp0.size() > dp1.size() ? dp0 : dp1;
    }

    // Optional: Main method for quick testing
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] words1 = {"e", "a", "b"};
        int[] groups1 = {0, 0, 1};
        System.out.println(solution.getLongestSubsequence(words1, groups1)); // Output: [e, b] or [a, b]

        String[] words2 = {"a", "b", "c", "d"};
        int[] groups2 = {1, 0, 1, 1};
        System.out.println(solution.getLongestSubsequence(words2, groups2)); // Output: [a, b, c] or [a, b, d]
    }
}
