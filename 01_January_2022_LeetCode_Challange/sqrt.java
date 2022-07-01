

/* #Problem 69

Sqrt(x)

*/

class Solution {
    public int mySqrt(int x) {
        int start = 1;
        int end = x;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (middle == x / middle) {
                return middle;
            } else if (middle > x / middle) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return end;
    }
}