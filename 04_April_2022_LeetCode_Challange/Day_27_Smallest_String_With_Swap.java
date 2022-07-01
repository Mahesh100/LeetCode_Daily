class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        int n = s.length();

        for(int i = 0; i < pairs.size(); i ++){
            int u = pairs.get(i).get(0);
            int v = pairs.get(i).get(1);
            if(!graph.containsKey(u)) graph.put(u, new ArrayList<>());
            if(!graph.containsKey(v)) graph.put(v, new ArrayList<>());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        char[] ans = new char[n];
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(visited[i]) continue;
            visited[i] = true;
            List<Integer> components = new ArrayList<>();
            List<Character> chars = new ArrayList<>();
            dfs(graph, s, visited, components, chars, i);
            Collections.sort(components);
            Collections.sort(chars);
            for(int j = 0; j < components.size(); j++){
                ans[components.get(j)] = chars.get(j);
            }
        }
        return String.valueOf(ans);
    }

    private void dfs(HashMap<Integer, ArrayList<Integer>> graph, String s, boolean[] visited , List<Integer> components, List<Character> chars, int curr){
        visited[curr] = true;
        components.add(curr);
        chars.add(s.charAt(curr));
        if(!graph.containsKey(curr)) return;
        for(Integer k:  graph.get(curr)){
            if(visited[k]) continue;
            dfs(graph, s, visited, components, chars, k);
        }
    }
}