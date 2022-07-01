class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] mins = new int[amount + 1];
        for (int i = 1; i <= amount; i ++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j ++) {
                if (i - coins[j] >= 0 && mins[i - coins[j]] != Integer.MAX_VALUE) {
                    min = Math.min(min, mins[i - coins[j]] + 1);
                }   
            }
            mins[i] = min;
        }
        if (mins[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return mins[amount];
    }
}