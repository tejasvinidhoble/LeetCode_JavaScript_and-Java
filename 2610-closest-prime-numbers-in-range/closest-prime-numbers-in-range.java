class Solution {
    public int[] closestPrimes(int left, int right) {
       int LIMIT = 1000000;
        boolean[] isPrime = new boolean[LIMIT + 1];

        // Step 1: Initialize the sieve
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false; // 0 and 1 are not primes

        // Step 2: Sieve of Eratosthenes
        for (int i = 2; i * i <= LIMIT; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= LIMIT; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Step 3: Collect primes in the given range
        List<Integer> primes = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        // Step 4: Find the closest prime pair
        if (primes.size() < 2) {
            return new int[]{-1, -1}; // No valid pairs
        }

        int minGap = Integer.MAX_VALUE;
        int[] result = new int[2];

        for (int i = 0; i < primes.size() - 1; i++) {
            int gap = primes.get(i + 1) - primes.get(i);
            if (gap < minGap) {
                minGap = gap;
                result[0] = primes.get(i);
                result[1] = primes.get(i + 1);
            }
        }

        return result;  
    }
}