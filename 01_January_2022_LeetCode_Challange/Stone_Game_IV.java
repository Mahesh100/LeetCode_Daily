class Solution {
    public boolean winnerSquareGame(int n) {
         Map<Integer, Boolean> record = new HashMap<>();
         return dfs(n, record);
     }
 
     private boolean dfs(int n, Map<Integer, Boolean> record) {
         if (n == 0) {
             return false;
         }
 
         if (record.containsKey(n)) {
             return record.get(n);
         }
 
         for (int i = 1; i*i <= n;i++) {
             if (!dfs(n - i * i, record)) {
                 record.put(n, true);
                 return true;
             }
         }
 
         record.put(n, false);
         return false;
     }
 }