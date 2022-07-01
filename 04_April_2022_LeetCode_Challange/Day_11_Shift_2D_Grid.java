class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length, mod = m * n;
        k = k % mod;
        Integer[][] newGrid = new Integer[m][n];
        for (int i = 0 ; i < mod; i++) {
            int pre = (i - k + mod) % mod;
            newGrid[i / n][i % n] = grid[pre / n][pre % n];
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            ans.add(Arrays.asList(newGrid[i]));
        }
        return ans;
    }
}