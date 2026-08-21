class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[] dp = new int[n];

        for (int j = 0; j < n; j++) {
            dp[j] = grid[0][j];
        }

        for (int i = 1; i < n; i++) {
            int[] newDp = new int[n];

            for (int j = 0; j < n; j++) {
                int min = Integer.MAX_VALUE;

                for (int k = 0; k < n; k++) {
                    if (k != j) {
                        min = Math.min(min, dp[k]);
                    }
                }

                newDp[j] = grid[i][j] + min;
            }

            dp = newDp;
        }

        int answer = Integer.MAX_VALUE;

        for (int value : dp) {
            answer = Math.min(answer, value);
        }

        return answer;
    }
}