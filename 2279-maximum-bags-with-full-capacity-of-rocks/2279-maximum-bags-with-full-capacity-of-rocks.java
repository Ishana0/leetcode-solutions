class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;

        for(int i = 0; i < n; i++) {
            capacity[i] = capacity[i] - rocks[i];
        }

        Arrays.sort(capacity);

        int answer = 0;

        for(int i = 0; i < n; i++) {
            if(additionalRocks >= capacity[i]) {
                additionalRocks -= capacity[i];
                answer++;
            } else {
                break;
            }
        }

        return answer;
    }
}