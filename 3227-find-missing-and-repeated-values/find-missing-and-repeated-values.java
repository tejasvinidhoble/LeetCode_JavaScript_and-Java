class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int size = n * n;
        boolean[] seen = new boolean[size + 1];
        int repeating = -1, missing = -1;
        
        // Traverse the grid and find the repeating number
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = grid[i][j];
                if (seen[num]) {
                    repeating = num;
                }
                seen[num] = true;
            }
        }
        
        // Find the missing number
        for (int i = 1; i <= size; i++) {
            if (!seen[i]) {
                missing = i;
                break;
            }
        }
        
        return new int[]{repeating, missing};
    }
}