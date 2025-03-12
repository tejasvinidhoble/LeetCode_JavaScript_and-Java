class Solution {
    public int maximumCount(int[] nums) {
             int negCount = findFirstNonNegativeIndex(nums);
        int posCount = nums.length - findFirstPositiveIndex(nums);
        return Math.max(negCount, posCount);
    }

    // Finds the first index where nums[i] is >= 0 (first non-negative number)
    private static int findFirstNonNegativeIndex(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    // Finds the first index where nums[i] is > 0 (first positive number)
    private static int findFirstPositiveIndex(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}