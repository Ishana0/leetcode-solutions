class Solution {
    public long maximumSum(int[] nums, int m, int l, int r) {
        int n = nums.length;

        long[] prefix = new long[n + 1];

        for(int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        long NEG = Long.MIN_VALUE / 4;

        long[] dpPrev = new long[n + 1];

        Arrays.fill(dpPrev, 0);

        long answer = NEG;

        for(int k = 1; k <= m; k++) {
            long[] dp = new long[n + 1];

            Arrays.fill(dp, NEG);

            Deque<Integer> deque = new ArrayDeque<>();

            for(int i = n - 1; i >= 0; i--) {
                int addIndex = i + l;

                if(addIndex <= n) {
                    long currentValue = prefix[addIndex] + dpPrev[addIndex];

                    while(!deque.isEmpty()) {
                        int last = deque.peekLast();

                        long lastValue = prefix[last] + dpPrev[last];

                        if(lastValue > currentValue) {
                            break;
                        }

                        deque.pollLast();
                    }

                    deque.offerLast(addIndex);
                }

                while(!deque.isEmpty() && deque.peekFirst() > i + r) {
                    deque.pollFirst();
                }

                if(i + 1 <= n) {
                    dp[i] = dp[i + 1];
                }

                if(!deque.isEmpty()) {
                    int j = deque.peekFirst();

                    if(dpPrev[j] != NEG) {
                        long take = prefix[j] - prefix[i] + dpPrev[j];

                        dp[i] = Math.max(dp[i], take);
                    }
                }
            }

            answer = Math.max(answer, dp[0]);

            dpPrev = dp;
        }

        return answer;
    }
}