class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int result = 0;

        // Count the frequency of each answer
        for (int answer : answers) {
            countMap.put(answer, countMap.getOrDefault(answer, 0) + 1);
        }

        // Calculate minimum rabbits for each group
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int x = entry.getKey();        // The answer given by rabbit
            int freq = entry.getValue();   // How many rabbits gave this answer
            int groupSize = x + 1;         // One rabbit + x same-color friends

            // Number of such full groups required
            int groups = (freq + groupSize - 1) / groupSize;

            // Total rabbits = groups * groupSize
            result += groups * groupSize;
        }

        return result;
    }
}
