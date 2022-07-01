class Solution {
    public int brokenCalc(int startValue, int target) {
        

        HashMap<Integer, Integer> map = new HashMap();
         
          for(int i=0; i<nums.length; i++){
              map.put(nums[i],i);
          }
        
        for(int i=0; i<nums.length;i++){
            int num =nums[i];
            int rem = terget-num;
            if(map.containsKey(rem)){
                int index = map.get(rem);
                return new int[]{i, index};
            }
        }
        return new int[]{};
        
    }
}
