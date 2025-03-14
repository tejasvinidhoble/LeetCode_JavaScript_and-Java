class Solution {
    public int maximumCandies(int[] candies, long k) {
         int low = 1, high = Integer.MIN_VALUE;

        // Find the maximum candy in a single pile
        for (int candy : candies) {
            high = Math.max(high, candy);
        }

        int result = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canDistribute(candies, k, mid)) {
                result = mid; // Store the possible answer
                low = mid + 1; // Try for a bigger value
            } else {
                high = mid - 1; // Try for a smaller value
            }
        }

        return result;
    }

    private boolean canDistribute(int[] candies, long k, int mid) {
        if (mid == 0) return false; // Avoid division by zero
        
        long count = 0; // Total children that can be served
        for (int candy : candies) {
            count += candy / mid; // Count how many children can be served
            if (count >= k) return true; // If we can serve k children, return true early
        }
        return count >= k;
    }
}