class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int minOperations = k; // Maximum possible W's in a window of size k
        int whiteCount = 0;

        // Count W's in the first window of size k
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                whiteCount++;
            }
        }
        minOperations = whiteCount;

        // Sliding window
        for (int i = k; i < n; i++) {
            if (blocks.charAt(i - k) == 'W') {
                whiteCount--; // Remove leftmost element of the previous window
            }
            if (blocks.charAt(i) == 'W') {
                whiteCount++; // Add rightmost element of the new window
            }
            minOperations = Math.min(minOperations, whiteCount);
        }

        return minOperations;
    }
}