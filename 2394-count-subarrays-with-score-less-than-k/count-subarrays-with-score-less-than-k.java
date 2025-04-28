public class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long ans = 0;
        long sum = 0;
        int start = 0;

        for (int end = 0; end < n; end++) {
            sum += nums[end];

            while (start <= end && sum * (end - start + 1) >= k) {
                sum -= nums[start];
                start++;
            }

            ans += (end - start + 1);
        }

        return ans;
    }
}
