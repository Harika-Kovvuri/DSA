class Solution {
    public boolean checkValidGrid(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] != 0) {
            return false;
        }
        int[][] ans = new int[n * n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[grid[i][j]][0] = i;
                ans[grid[i][j]][1] = j;
            }
        }

        for (int k = 0; k < n * n - 1; k++) {
            int r1 = ans[k][0];
            int c1 = ans[k][1];
            int r2 = ans[k + 1][0];
            int c2 = ans[k + 1][1];
            if (!((Math.abs(r1 - r2) == 2 && Math.abs(c1 - c2) == 1)
                    || (Math.abs(r1 - r2) == 1 && Math.abs(c1 - c2) == 2))) {
                return false;
            }
        }
        return true;
    }
}