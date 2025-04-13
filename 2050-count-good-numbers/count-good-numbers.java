class Solution {
    static final int MOD = 1_000_000_007;
    public int countGoodNumbers(long n) {
        long evenPositions = (n + 1) / 2;
        long oddPositions = n / 2;

        long evenChoices = modPow(5, evenPositions, MOD); // even index digits
        long oddChoices = modPow(4, oddPositions, MOD);   // odd index digits

        return (int) ((evenChoices * oddChoices) % MOD);
    }

    // Fast exponentiation method (modular exponentiation)
    private long modPow(long base, long exp, int mod) {
        long result = 1;
        base = base % mod;

        while (exp > 0) {
            if ((exp & 1) == 1) { // if exp is odd
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1; // exp = exp / 2
        }

        return result;
    }
}