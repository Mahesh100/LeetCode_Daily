class Solution {
   public int subarraySum(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
 
    int count = 0;
    int sum = 0;
 
    //e.g., 1 1 2 1 1
    for(int i=0; i<nums.length; i++){
        sum += nums[i];
        int n = map.getOrDefault(sum-k, 0);
        count += n;
 
        map.put(sum, map.getOrDefault(sum,0)+1);
    }
 
    return count;
}
}
