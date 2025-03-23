class Solution {
    public int countPaths(int n, int[][] roads) {
          List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Populate graph with roads
        for (int[] road : roads) {
            int u = road[0], v = road[1], time = road[2];
            graph.get(u).add(new int[]{v, time});
            graph.get(v).add(new int[]{u, time});
        }
        
        // Dijkstra's Algorithm
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        long[] shortestTime = new long[n];
        int[] ways = new int[n];

      int MOD = 1_000_000_007; 

        Arrays.fill(shortestTime, Long.MAX_VALUE);
        shortestTime[0] = 0;
        ways[0] = 1;
        pq.offer(new long[]{0, 0}); // {time, node}
        
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long time = curr[0];
            int node = (int) curr[1];
            
            if (time > shortestTime[node]) continue;
            
            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                long newTime = time + neighbor[1];
                
                if (newTime < shortestTime[nextNode]) {
                    shortestTime[nextNode] = newTime;
                    ways[nextNode] = ways[node];
                    pq.offer(new long[]{newTime, nextNode});
                } else if (newTime == shortestTime[nextNode]) {
                    ways[nextNode] = (ways[nextNode] + ways[node]) % MOD;
                }
            }
        }
        
        return ways[n - 1];
    }
}