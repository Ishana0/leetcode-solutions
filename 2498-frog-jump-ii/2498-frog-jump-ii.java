class Solution {
    public int maxJump(int[] stones) {
        int answer = stones[1] - stones[0];

        for(int i = 2; i < stones.length; i++) {
            int jump = stones[i] - stones[i - 2];
            answer = Math.max(answer, jump);
        }

        return answer;
    }
}