
class Solution {
    static final int MOD = 1_000_000_007;

    int m, n;
    int[][] grid;
    int[][][] memo;

    // dir = 0 means moving right
    // dir = 1 means moving down
    int solve(int i, int j, int dir) {

        if (i >= m || j >= n) {
            return -1;
        }

        if (memo[i][j][dir] != -2) {
            return memo[i][j][dir];
        }

        // Empty cell: robot stops reflecting
        if (grid[i][j] == 0) {
            return memo[i][j][dir] = i * n + j;
        }

        // Mirror: reflect immediately
        if (dir == 0) {
            return memo[i][j][dir] =
                solve(i + 1, j, 1);
        } else {
            return memo[i][j][dir] =
                solve(i, j + 1, 0);
        }
    }

    public int uniquePaths(int[][] grid) {

        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        memo = new int[m][n][2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j][0] = -2;
                memo[i][j][1] = -2;
            }
        }

        long[][] dp = new long[m][n];

        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1 || dp[i][j] == 0) {
                    continue;
                }

                long ways = dp[i][j];

                // Try moving right
                int right = solve(i, j + 1, 0);

                if (right != -1) {
                    int x = right / n;
                    int y = right % n;

                    dp[x][y] = (dp[x][y] + ways) % MOD;
                }

                // Try moving down
                int down = solve(i + 1, j, 1);

                if (down != -1) {
                    int x = down / n;
                    int y = down % n;

                    dp[x][y] = (dp[x][y] + ways) % MOD;
                }
            }
        }

        return (int) dp[m - 1][n - 1];
    }
}
