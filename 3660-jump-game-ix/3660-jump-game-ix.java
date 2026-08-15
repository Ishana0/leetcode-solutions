class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;

        int[] ans = new int[n];

        int[] prefixMax = new int[n];

        prefixMax[0] = nums[0];

        for(int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
        }
        
        int suffixMin = Integer.MAX_VALUE;
        
        for (int i = n - 1; i >= 0; i--) {
            if(prefixMax[i] > suffixMin) {
                ans[i] = ans[i + 1];
                } else {
                    ans[i] = prefixMax[i];
                }

        suffixMin = Math.min(suffixMin, nums[i]);
    }
    
    return ans;
    }
}