class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long[] dp = {0, Long.MIN_VALUE};
        for (int n : nums) {
            long cnt0 = dp[0] + n, cnt1 = dp[1] + n;
            int x = n ^ k;
            dp = new long[]{ Math.max(cnt0, dp[1] + x), 
                             Math.max(cnt1, dp[0] + x) };
        }
        return dp[0];
    }
}