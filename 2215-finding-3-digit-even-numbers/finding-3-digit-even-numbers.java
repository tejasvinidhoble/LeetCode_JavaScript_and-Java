

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> result = new TreeSet<>();
        int n = digits.length;

        // Count frequency of each digit
        int[] freq = new int[10];
        for (int d : digits) {
            freq[d]++;
        }

        // Generate all 3-digit numbers
        for (int i = 100; i <= 999; i += 2) { // only even numbers
            int a = i / 100;
            int b = (i / 10) % 10;
            int c = i % 10;

            // Check if digits a, b, c can be formed from the input digits
            int[] tempFreq = new int[10];
            tempFreq[a]++;
            tempFreq[b]++;
            tempFreq[c]++;

            boolean isValid = true;
            for (int d = 0; d < 10; d++) {
                if (tempFreq[d] > freq[d]) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                result.add(i);
            }
        }

        // Convert to array
        int[] resArr = new int[result.size()];
        int idx = 0;
        for (int num : result) {
            resArr[idx++] = num;
        }

        return resArr;
    }
}
