class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> lastIndexMap = new HashMap<>();

        // Step 1: Store the last occurrence index of each character
        for (int i = 0; i < s.length(); i++) {
            lastIndexMap.put(s.charAt(i), i);
        }

        // Step 2: Traverse the string to find partitions
        int start = 0;
        int maxEnd = 0;

        for (int i = 0; i < s.length(); i++) {
            maxEnd = Math.max(maxEnd, lastIndexMap.get(s.charAt(i)));
            if (i == maxEnd) {
                result.add(i - start + 1);
                start = i + 1;
            }
        }

        return result;
   
    }
}