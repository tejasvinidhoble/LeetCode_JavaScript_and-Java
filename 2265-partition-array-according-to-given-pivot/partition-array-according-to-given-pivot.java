class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
         List<Integer> less = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();

        // Step 1: Categorize elements into three lists
        for (int num : nums) {
            if (num < pivot) {
                less.add(num);
            } else if (num == pivot) {
                equal.add(num);
            } else {
                greater.add(num);
            }
        }

        // Step 2: Merge lists into result array
        int index = 0;
        for (int num : less) {
            nums[index++] = num;
        }
        for (int num : equal) {
            nums[index++] = num;
        }
        for (int num : greater) {
            nums[index++] = num;
        }

        return nums;
    }
}