class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length() != s3.length()) return false;
        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();
        char[] a3 = s3.toCharArray();
        int[][] dp = new int[a1.length+1][a2.length+1];
        
        return helper(a1, a2,a3,0,0,0,dp);
    }
    boolean helper(char[] a1, char[] a2, char[] a3, int i1, int i2, int i3, int[][] dp) {
        if(i1==a1.length && i2==a2.length && i3==a3.length) return true;
        
        if(dp[i1][i2]!=0) return false;
        
        if(i1<a1.length && a1[i1]==a3[i3] ) {
            if(helper(a1, a2, a3, i1+1, i2, i3+1,dp)) return true;
           
        }
        if(i2<a2.length && a2[i2]==a3[i3]){
            if(helper(a1, a2, a3, i1, i2+1, i3+1, dp)) return true;
        }
        dp[i1][i2]=1;
        
        return false;
    }
}