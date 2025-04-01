class Solution {
    public long mostPoints(int[][] questions) {
      int n = questions.length;
        long[] dp = new long[n + 1]; // Using long to avoid overflow

        for (int i = n - 1; i >= 0; i--) {
            int points = questions[i][0];
            int brainpower = questions[i][1];
            int next = i + brainpower + 1;

            // Option 1: Solve the current question
            long solve = points + (next < n ? dp[next] : 0);
            
            // Option 2: Skip the current question
            long skip = dp[i + 1];

            // Store the best choice
            dp[i] = Math.max(solve, skip);
        }
        
        return dp[0];  
    }
}