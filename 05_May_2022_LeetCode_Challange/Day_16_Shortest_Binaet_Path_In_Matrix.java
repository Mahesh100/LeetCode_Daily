class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
           int n = grid.length - 1;
           Queue<Integer> q = new ArrayDeque<Integer>();
           q.add(0);
           if (grid[0][0] == 1 || grid[n][n] == 1) return -1;
           grid[0][0] = 1;
           while (q.size() > 0) {
               int curr = q.remove(), i = curr & (1 << 7) - 1, j = curr >> 7;
               if (i == n && j == n) return grid[n][n];
               for (int a = Math.max(i-1,0); a <= Math.min(i+1,n); a++)
                   for (int b = Math.max(j-1,0); b <= Math.min(j+1,n); b++)
                       if (grid[a][b] == 0) {
                           grid[a][b] = grid[i][j] + 1;
                           q.add(a + (b << 7));
                       }
           }
           return -1;
       }
   }