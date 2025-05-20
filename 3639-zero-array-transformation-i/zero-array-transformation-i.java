class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] coverage = new int[n + 1];  // Difference array for query coverage

        // Build coverage using difference array approach
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            coverage[l]++;
            if (r + 1 < n) coverage[r + 1]--;
        }

        // Prefix sum to get the number of queries covering each index
        for (int i = 1; i < n; i++) {
            coverage[i] += coverage[i - 1];
        }

        // Check if each nums[i] can be decremented by coverage[i]
        for (int i = 0; i < n; i++) {
            if (nums[i] > coverage[i]) {
                return false;
            }
        }

        return true;
    }
}
