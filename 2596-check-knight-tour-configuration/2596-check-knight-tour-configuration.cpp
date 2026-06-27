class Solution {
public:
    bool checkValidGrid(vector<vector<int>>& grid) {
        int n = grid.size();
        if (grid[0][0] != 0) {
            return false;
        }
        vector<pair<int, int>> ans(n * n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[grid[i][j]] = {i, j};
            }
        }

        for (int k = 0; k < n * n - 1; k++) {
            int r1 = ans[k].first;
            int c1 = ans[k].second;
            int r2 = ans[k + 1].first;
            int c2 = ans[k + 1].second;

            if (!((abs(r1 - r2) == 2 && abs(c1 - c2) == 1) ||
                  (abs(r1 - r2) == 1 && abs(c1 - c2) == 2))) {
                return false;
            }
        }
        return true;
    }
};