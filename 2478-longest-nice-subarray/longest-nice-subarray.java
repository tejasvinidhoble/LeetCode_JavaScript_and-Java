class Solution {
    public int longestNiceSubarray(int[] nums) {
         int left = 0, bitMask = 0, maxLength = 0;
        
        for (int right = 0; right < nums.length; right++) {
            while ((bitMask & nums[right]) != 0) {
                bitMask ^= nums[left]; // Remove nums[left] from the bitMask
                left++;
            }
            bitMask |= nums[right]; // Add nums[right] to bitMask
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}