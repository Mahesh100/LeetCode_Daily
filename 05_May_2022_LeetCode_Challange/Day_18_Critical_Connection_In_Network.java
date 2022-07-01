class Solution {
    int index = 0;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (List<Integer> connection : connections) {
            graph[connection.get(0)].add(connection.get(1));
            graph[connection.get(1)].add(connection.get(0));
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        int[] dfn = new int[n], low = new int[n];
        // use dfn to track if visited (dfn[i] == -1)
        Arrays.fill(dfn, -1);
        for (int i = 0; i < n; i++) {
            if (dfn[i] == -1) {
                tarjan(i, graph, dfn, low, ans, i);
            }
        }
        return ans;
    }
    
    private void tarjan(int u, List<Integer>[] graph, int[] dfn, int[] low, List<List<Integer>> ans, int preU) {
        // discover u
        dfn[u] = low[u] = ++index;
        for (int v : graph[u]) {
            // if v is the father node of u then skip it
            if (v == preU) continue;
            if (dfn[v] == -1) {
                // if not discovered
                tarjan(v, graph, dfn, low, ans, u);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > dfn[u]) {
                    // if there is no path for v to reach back to previous vertices of u, then u - v is critical
                    ans.add(Arrays.asList(u, v));
                }
            } else {
                // if v has been discovered and not parent of u, update low[u]
                // cannot use low[v] because u is not subtree of v
                low[u] = Math.min(low[u], dfn[v]);
            }
        }
    }
}