class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int lo = 1;
        int hi = 1000000000;
         
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
             
            if (canFinish(mid, piles, H)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
         
        if (canFinish(lo, piles, H)) {
            return lo;
        } else {
            return hi;
        }
    }
     
    private boolean canFinish(int K, int[] piles, int H) {
        int time = 0;
        for (int cBananas : piles) {
            time += (cBananas - 1) / K + 1;
        }
         
        return time <= H;
    }
}