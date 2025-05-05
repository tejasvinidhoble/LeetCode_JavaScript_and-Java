class Solution {
    final long mod = 1000000007;
    Long[][] dp;

    public int numTilings(int n) {
        dp = new Long[n + 1][2];  // dp[i][0] = not possible, dp[i][1] = possible
        return (int) dominoes(0, n, false);
    }

    private long dominoes(int i, int n, boolean possible) {
        if (i == n) return possible ? 0 : 1;
        if (i > n) return 0;

        int p = possible ? 1 : 0;
        if (dp[i][p] != null) return dp[i][p];

        long res;
        if (possible) {
            res = (dominoes(i + 1, n, false) + dominoes(i + 1, n, true)) % mod;
        } else {
            res = (dominoes(i + 1, n, false)
                 + dominoes(i + 2, n, false)
                 + 2 * dominoes(i + 2, n, true)) % mod;
        }

        return dp[i][p] = res;
    }
}
