class Solution {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        int[][] dp = new int[2][n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = nums[i] + sum[i];
            dp[0][i + 1] = Integer.MAX_VALUE;
            dp[1][i + 1] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = i - 1; k < j; k++) {
                    dp[i % 2][j] = Math.min(dp[i % 2][j], Math.max(dp[(i - 1) % 2][k], sum[j] - sum[k]));
                }
            }
        }
        return dp[m % 2][n];
    }
}