class Solution {
    private static final int MOD = 1000000007;
    
    public int kInversePairs(int n, int k) {
        int[][] opt = new int[Math.max(4, n + 1)][Math.max(4, k + 1)];
        if(n < 1 || k < 0) {
            throw new IllegalArgumentException();
        }
        opt[0][0] = 0;
        for(int j = 1;j <= k;++j) {
            opt[0][j] = 0;
        }
        for(int i = 1;i <= n;++i) {
            opt[i][0] = 1;
        }
        
        for(int i = 1;i <= n;++i) {
            int s = opt[i - 1][0];
            for(int j = 1;j <= k;++j) {
                s += opt[i - 1][j];
                if(j - i >= 0) s -= opt[i - 1][j - i];
                if(s < 0) s += MOD;
                s %= MOD;
                opt[i][j] = s;
            }
        }
        
        return opt[n][k];        
    }
}