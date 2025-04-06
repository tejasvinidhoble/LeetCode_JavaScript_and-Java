class Solution {
    public int subsetXORSum(int[] nums) {
        
      return helper(nums, 0, 0);
    }

    // Recursive helper function
    private static int helper(int[] nums, int index, int currentXOR) {
        if (index == nums.length) {
            return currentXOR;
        }

        // Include current number
        int withElement = helper(nums, index + 1, currentXOR ^ nums[index]);

        // Exclude current number
        int withoutElement = helper(nums, index + 1, currentXOR);

        return withElement + withoutElement;
}
}