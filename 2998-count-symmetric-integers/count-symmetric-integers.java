class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;

        for (int i = low; i <= high; i++) {
            String s = Integer.toString(i);
            int len = s.length();

            // Only consider even digit numbers
            if (len % 2 == 0) {
                int n = len / 2;
                int sum1 = 0, sum2 = 0;

                // Sum of first half digits
                for (int j = 0; j < n; j++) {
                    sum1 += s.charAt(j) - '0';
                }

                // Sum of second half digits
                for (int j = n; j < len; j++) {
                    sum2 += s.charAt(j) - '0';
                }

                if (sum1 == sum2) {
                    count++;
                }
            }
        }

        return count;
    }
}