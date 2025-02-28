class Solution {
    int helper(int[] nums) {
        // ------ DP ------
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for(int i = 2; i <= n; i++ ) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[n];
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return nums[0];
        }
        // choose 0th house
        int first = helper(Arrays.copyOfRange(nums, 0 , n - 1));
        //skip 0th house -> means you can choose last house
        int second = helper(Arrays.copyOfRange(nums, 1, n));

        return Math.max(first, second);
    }
}