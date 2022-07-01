class Solution {
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        Stack<Integer> s = new Stack<Integer>();
        int[] vis = new int[len];
        for (int i = 0; i < len; i++) {
            if (vis[i] > 0) continue;
            vis[i] = 1;
            s.push(i);
            while (s.size() > 0) {
                int curr = s.pop();
                int[] edges = graph[curr];
                for (int next:edges)
                    if (vis[next] == 0) {
                        vis[next] = vis[curr] ^ 3;
                        s.push(next);
                    } else if (vis[curr] == vis[next]) return false;
            }
        }
        return true;
    }
}