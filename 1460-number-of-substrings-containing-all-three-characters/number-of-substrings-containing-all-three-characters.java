class Solution {
    public int numberOfSubstrings(String s) {
        int[] count = {0, 0, 0}; // Array to track occurrences of 'a', 'b', and 'c'
        int left = 0, result = 0;

        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'a']++; // Increment character count

            // When all 'a', 'b', 'c' are present, move left pointer
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                result += s.length() - right; // Count all substrings starting from 'left'
                count[s.charAt(left) - 'a']--; // Shrink window from left
                left++;
            }
        }
        return result;
    }
}