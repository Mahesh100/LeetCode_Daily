class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        if (A.length != B.length) return -1;
        int[] A1 = new int[6];
        int[] B1 = new int[6];
        for (int i = 0; i < A.length; i ++) {
            A1[A[i] - 1] ++;
            B1[B[i] - 1] ++;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A1.length; i ++) {
            if (A1[i] != 0) {
                if (A1[i] + B1[i] < A.length) continue;
                boolean flag = true;
                int sum = A1[i];
                int count = 0;
                for (int x = 0; x < B.length; x ++) {
                    if ((B[x] - 1) == i) {
                        if (B[x] == A[x]) { }
                        else {
                            ++ count;
                            ++ sum;
                        }
                    }
                }
                if (sum == A.length && count < min) min = count;
            }
        }
        for (int i = 0; i < B1.length; i ++) {
            if (B1[i] != 0) {
                if (A1[i] + B1[i] < B.length) continue;
                boolean flag = true;
                int sum = B1[i];
                int count = 0;
                for (int x = 0; x < A.length; x ++) {
                    if ((A[x] - 1) == i) {
                        if (B[x] == A[x]) { }
                        else {
                            ++ count;
                            ++ sum;
                        }
                    }
                }
                if (sum == B.length && count < min) min = count;
            }
        }
        if (min == Integer.MAX_VALUE) return  -1;
        return min;
    }
}