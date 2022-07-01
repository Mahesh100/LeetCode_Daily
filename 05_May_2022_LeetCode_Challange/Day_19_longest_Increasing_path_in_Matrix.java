public int longestIncreasingPath(int[][] matrix) {
    int result = 0;
    int m = matrix.length;
    int n = matrix[0].length;
 
    int[][] mem = new int[m][n];
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            int t = helper(matrix, mem, i, j);
            result = Math.max(result, t);
        }
    }
 
    return result;
}
 
private int helper(int[][] matrix, int[][] mem, int i, int j) {
    if (mem[i][j] > 0) {
        return mem[i][j];
    }
 
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
 
    for (int k = 0; k < 4; k++) {
        int x = i + dx[k];
        int y = j + dy[k];
 
        if (x >= 0 && y >= 0
                && x < matrix.length
                && y < matrix[0].length
                && matrix[x][y] > matrix[i][j]) {
            mem[i][j] = Math.max(mem[i][j], helper(matrix, mem, x, y));
        }
    }
 
    return ++mem[i][j];
}