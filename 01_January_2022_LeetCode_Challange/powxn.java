#Problem 50
 
 
 pow(x,n)

class Solution {
    public double myPow(double x, int n) {
        double ans=1;
        int k=0;
        if(x==0.0000)  return 0.0000;
        if(n==0)  return 1.0000;
        if(n<0){
            n=0-n;
            k=1;
        }
        for(int i=0;i<n;i++){
            ans=ans*x;
        }
        if(k==1){
            ans=1/ans;
        }
        return ans;
    }
}
