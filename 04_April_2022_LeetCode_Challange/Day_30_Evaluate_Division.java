class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
         Map<String,Map<String, Double>> map = new HashMap<>();
         for(int i=0;i<equations.size();i++){
             List<String> list = equations.get(i);
             String a = list.get(0);
             String b = list.get(1);
             if(map.containsKey(a)==false){
                 map.put(a, new HashMap<>());
             }
             map.get(a).put(b, values[i]);
             
             if(map.containsKey(b)==false){
                 map.put(b, new HashMap<>());
             }
             map.get(b).put(a, 1/values[i]);
         }
        
         int index = 0;
         double[] res = new double[queries.size()];
         for(List<String> ele: queries){
                if(map.containsKey(ele.get(0))==false || 
                   map.containsKey(ele.get(1))==false){1
                    res[index++] = -1;
                    continue;
                }
                double temp = dfs(map, new HashSet<>(), ele.get(0), ele.get(1));     
                res[index++] = (temp==0?-1:temp);
         }
        
         return res;
    }
    
    public double dfs(Map<String, Map<String, Double>> map, Set<String> seen, 
                   String start, String end){
        
            if(start.equals(end)){
                return 1;
            }
            if(seen.contains(start)){
                return 0;
            }
            
            
            seen.add(start);
            for(String next: map.get(start).keySet()){
                  double temp = dfs(map, seen, next, end);
                  if(temp!=0){
                      return temp*map.get(start).get(next);
                  }
            }
        
            seen.remove(start);
            return 0;
        
    }
}