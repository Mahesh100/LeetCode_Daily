class Solution {
    public int numberOfArithmeticSlices(int[] A) {    //A == nums
        int[] dp = new int[A.length];
        int res =0;
        
        for(int i=2; i<A.length; i++){
            if(A[i] - A[i-1] == A[i-1]-A[i-2]){
                dp[i] = 1+dp[i-1];
                    res += dp[i];
            }
            
        }
        return res;
        
    }
}