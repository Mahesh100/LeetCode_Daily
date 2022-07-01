class Solution {
    private static final int MOD = 1000000007;
    private static final int MAX = 100;

    public int threeSumMulti(int[] A, int target) {
        if (A == null || A.length < 3) {
            return 0;
        }

        // Count the element frequency
        long[] count = new long[MAX + 1];
        for (int num : A) {
            count[num]++;
        }

        long rst = 0L;
        // i <= j <= k
        for (int i = 0; i <= target; i++) {
            for (int j = i; j <= target; j++) {
                int k = target - i - j;
                if (k < 0 || k > MAX || k < j) {
                    continue;
                }
                if (count[i] == 0 || count[j] == 0 || count[k] == 0) {
                    continue;
                }

                if (i == j && j == k) {
                    rst += count[i] * (count[i] - 1) * (count[i] - 2) / 6;
                } else if (i == j && j != k) {
                    rst += count[i] * (count[i] - 1) / 2 * count[k];
                } else if (i != j && j == k) {
                    rst += count[i] * count[j] * (count[j] - 1) / 2;
                } else {
                    rst += count[i] * count[j] * count[k];
                }
            }
        }

        return (int)(rst % MOD);
    }
}