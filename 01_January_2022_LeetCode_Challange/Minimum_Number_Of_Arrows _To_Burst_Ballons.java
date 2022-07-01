public class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0) return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return (a[1] - b[1]);
            }
        });
        int curend = points[0][1];
        int count = 1;
        for(int[] p : points) {
            if(p[0] > curend) {
                count++;
                curend = p[1];
            }
            else continue;
        }

        return count;
    }
}
