class Solution {
    public int minCapability(int[] nums, int k) {
        int low = 1, high = (int)1e9; // Search space from 1 to max possible value

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canRob(nums, k, mid)) {
                high = mid; // Try to minimize capability
            } else {
                low = mid + 1; // Increase capability
            }
        }
        return low;
    }

    private boolean canRob(int[] nums, int k, int capability) {
        int count = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= capability) { // If we can rob this house
                count++;
                i++; // Skip the adjacent house
            }
            if (count >= k) return true;
        }
        return false;
    
    }
}