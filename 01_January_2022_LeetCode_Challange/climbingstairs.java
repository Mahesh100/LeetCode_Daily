
/*
#Climbing Stairs
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top? */
class Solution {
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }

        int[] ways = new int[n + 1];
        ways[0] = 1;
        ways[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            ways[i] = ways[i - 2] + ways[i - 1];
        }
        
       return ways[n];
    }

