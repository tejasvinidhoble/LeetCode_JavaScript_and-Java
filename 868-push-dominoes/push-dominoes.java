class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char[] result = dominoes.toCharArray();
        int[] forces = new int[n];

        // Left to Right pass to apply 'R' forces
        int force = 0;
        for (int i = 0; i < n; i++) {
            if (result[i] == 'R') {
                force = n; // max force
            } else if (result[i] == 'L') {
                force = 0; // cancel force
            } else if (force > 0) {
                force--;
            }
            forces[i] += force;
        }

        // Right to Left pass to apply 'L' forces
        force = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (result[i] == 'L') {
                force = n;
            } else if (result[i] == 'R') {
                force = 0;
            } else if (force > 0) {
                force--;
            }
            forces[i] -= force;
        }

        // Construct the final result
        StringBuilder sb = new StringBuilder();
        for (int f : forces) {
            if (f > 0) {
                sb.append('R');
            } else if (f < 0) {
                sb.append('L');
            } else {
                sb.append('.');
            }
        }

        return sb.toString();
    }
}
