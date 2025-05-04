class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] count = new int[100];
        int result = 0;
        for (int[] d : dominoes) {
            int a = d[0], b = d[1];
            int key = Math.min(a, b) * 10 + Math.max(a, b);
            result += count[key];
            count[key]++;
        }
        return result;
    }
}
