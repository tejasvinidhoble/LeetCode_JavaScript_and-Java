class Solution {
    public boolean divideArray(int[] nums) {
    int[] count = new int[501]; // Array to store frequency of numbers
        
        // Count frequency of each number
        for (int num : nums) {
            count[num]++;
        }

        // Check if every number appears an even number of times
        for (int freq : count) {
            if (freq % 2 != 0) {
                return false; // If any number appears an odd number of times, return false
            }
        }
        return true;    
    }
}