class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
         int n = colors.length;
        int count = 0;
        int violations = 0;

        // Check the first k-length window
        for (int i = 0; i < k - 1; i++) {
            if (colors[i] == colors[i + 1]) {
                violations++;
            }
        }

        // If first window is valid, count it
        if (violations == 0) count++;

        // Sliding window through the rest of the array
        for (int i = 1; i < n; i++) {
            int prevFirst = colors[i - 1];
            int prevSecond = colors[i];
            int prevLast = colors[(i + k - 2) % n];
            int newLast = colors[(i + k - 1) % n];

            // Remove old violation (leftmost pair)
            if (prevFirst == prevSecond) violations--;

            // Add new violation (new rightmost pair)
            if (prevLast == newLast) violations++;

            // If no violations, it's a valid alternating group
            if (violations == 0) count++;
        }

        return count;
    }
}