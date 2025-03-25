class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        int[][] horz = new int[rectangles.length][2];
        int[][] vert = new int[rectangles.length][2];
        int idx = 0;
        for (int[] i : rectangles) {
            horz[idx][0] = i[0];
            horz[idx][1] = i[2];
            vert[idx][0] = i[1];
            vert[idx][1] = i[3];
            idx++;
        }
        
        Arrays.sort(horz, (x, y) -> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
        Arrays.sort(vert, (x, y) -> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
    
        return canCut(vert) || canCut(horz);
    }

    private boolean canCut(int[][] arr) {
        int cut = 0;
        int max = arr[0][1];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] < max) {
                max = Math.max(arr[i][1], max);
            } else {
                max = arr[i][1];
                cut++;
            }
            if (cut == 2) {
                break;
            }
        }
        return cut == 2;
    }
}