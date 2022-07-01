class Solution {
    public int maxDistToClosest(int[] seats) {
        int last = -1;
        int len = seats.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (seats[i] == 1) {
                res = last < 0 ? i : Math.max(res, (i - last) / 2);
                last = i;
            }
        }
        res = Math.max(res, len - last - 1);
        return res;
    }
}