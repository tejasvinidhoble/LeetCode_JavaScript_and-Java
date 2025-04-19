class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int low = lowerBound(nums, i + 1, n - 1, lower - nums[i]);
            int high = upperBound(nums, i + 1, n - 1, upper - nums[i]);
            count += (high - low + 1);
        }

        return count;
    }

    private int lowerBound(int[] nums, int left, int right, int target) {
        int ans = right + 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private int upperBound(int[] nums, int left, int right, int target) {
        int ans = left - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans; 
    }
}