class Solution {
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
          String low = Long.toString(start);
        String high = Long.toString(finish);
        int n = high.length();
        low = String.format("%" + n + "s", low).replace(' ', '0'); // pad with leading 0s
        int pre_len = n - s.length(); // how much we can vary
        Long[][][] memo = new Long[n][2][2]; // i, tightLow, tightHigh

        return dfs(0, true, true, low, high, limit, s, pre_len, memo);
    }

    private long dfs(
        int i,
        boolean limit_low,
        boolean limit_high,
        String low,
        String high,
        int limit,
        String s,
        int pre_len,
        Long[][][] memo
    ) {
        if (i == low.length()) return 1;

        if (memo[i][limit_low ? 1 : 0][limit_high ? 1 : 0] != null) {
            return memo[i][limit_low ? 1 : 0][limit_high ? 1 : 0];
        }

        int lo = limit_low ? low.charAt(i) - '0' : 0;
        int hi = limit_high ? high.charAt(i) - '0' : 9;

        long res = 0;

        if (i < pre_len) {
            for (int digit = lo; digit <= Math.min(hi, limit); digit++) {
                res += dfs(
                    i + 1,
                    limit_low && digit == lo,
                    limit_high && digit == hi,
                    low,
                    high,
                    limit,
                    s,
                    pre_len,
                    memo
                );
            }
        } else {
            int x = s.charAt(i - pre_len) - '0';
            if (x >= lo && x <= Math.min(hi, limit)) {
                res = dfs(
                    i + 1,
                    limit_low && x == lo,
                    limit_high && x == hi,
                    low,
                    high,
                    limit,
                    s,
                    pre_len,
                    memo
                );
            }
        }

        memo[i][limit_low ? 1 : 0][limit_high ? 1 : 0] = res;
        return res;
        
    }
}