class Solution {
    public int minimumIndex(List<Integer> nums) {
          int candidate = -1, count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        // Step 2: Count occurrences of the dominant element
        int totalCount = 0;
        for (int num : nums) {
            if (num == candidate) {
                totalCount++;
            }
        }

        // Step 3: Check if candidate is actually the dominant element
        if (totalCount * 2 <= nums.size()) {
            return -1; // No dominant element (should not happen per problem constraints)
        }

        // Step 4: Find the minimum valid split index
        int leftCount = 0; // Count of dominant element in the left part
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) == candidate) {
                leftCount++;
            }

            int leftSize = i + 1;
            int rightSize = nums.size() - leftSize;
            int rightCount = totalCount - leftCount; // Count of dominant element in right subarray

            // Check if both left and right subarrays have the dominant element
            if (leftCount * 2 > leftSize && rightCount * 2 > rightSize) {
                return i;
            }
        }

        return -1;
    }
}