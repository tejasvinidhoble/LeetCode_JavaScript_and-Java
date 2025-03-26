class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> values = new ArrayList<>();
        int m = grid.length, n = grid[0].length;

        // Flatten the grid and check divisibility condition
        int base = grid[0][0];
        for (int[] row : grid) {
            for (int num : row) {
                if ((num - base) % x != 0) {
                    return -1; // Not possible to make all elements equal
                }
                values.add(num);
            }
        }

        // Sort the values to find the median
        Collections.sort(values);
        int median = values.get(values.size() / 2);

        // Calculate minimum operations
        int operations = 0;
        for (int num : values) {
            operations += Math.abs(num - median) / x;
        }

        return operations;
    }
}