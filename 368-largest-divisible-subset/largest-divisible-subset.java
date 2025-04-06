class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
          int n = nums.length;
        Arrays.sort(nums); // Sort the array

        int[] dp = new int[n]; // dp[i] = size of the largest subset ending at i
        int[] prev = new int[n]; // to reconstruct the subset
        Arrays.fill(dp, 1); // Every number is a subset of size 1
        Arrays.fill(prev, -1);

        int maxIndex = 0;

        // Build dp array
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        prev[i] = j;
                    }
                }
            }
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }

        // Reconstruct the subset
        List<Integer> result = new ArrayList<>();
        int k = maxIndex;
        while (k >= 0) {
            result.add(nums[k]);
            k = prev[k];
        }

        return result;
    }
}