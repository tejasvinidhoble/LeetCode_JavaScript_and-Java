class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
         int m = grid.length, n = grid[0].length;
        int k = queries.length;
        int[] answer = new int[k];

        // Store original indices of queries
        int[][] queryWithIndex = new int[k][2];
        for (int i = 0; i < k; i++) {
            queryWithIndex[i][0] = queries[i];
            queryWithIndex[i][1] = i;
        }
        Arrays.sort(queryWithIndex, Comparator.comparingInt(a -> a[0])); // Sort by query value

        // Directions for moving in 4 directions (up, down, left, right)
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        // Min Heap to explore smallest values first
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        boolean[][] visited = new boolean[m][n];

        pq.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;

        int count = 0; // Total points collected
        int lastQueryResult = 0;

        for (int[] q : queryWithIndex) {
            int queryVal = q[0];
            int index = q[1];

            // Expand the grid until we reach a cell >= queryVal
            while (!pq.isEmpty() && pq.peek()[0] < queryVal) {
                int[] cell = pq.poll();
                int val = cell[0], r = cell[1], c = cell[2];

                count++; // Since it's our first time visiting this cell, we gain a point

                // Explore neighbors
                for (int d = 0; d < 4; d++) {
                    int nr = r + dx[d], nc = c + dy[d];

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                        pq.offer(new int[]{grid[nr][nc], nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }

            // Store the result for this query
            answer[index] = count;
        }

        return answer;
    }
}