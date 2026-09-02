class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;

        boolean[][] dp = new boolean[n][n + 1];

        dp[0][1] = true;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                int k = stones[i] - stones[j];

                if(k <= n && dp[j][k]) {
                    if(k - 1 > 0) {
                        dp[i][k - 1] = true;
                    }

                    dp[i][k] = true;

                    if(k + 1 <= n) {
                        dp[i][k + 1] = true;
                    }
                }
            }
        }

        for(int k = 1; k <= n; k++) {
            if(dp[n - 1][k]) {
                return true;
            }
        }
        return false;
    }
}