class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> sum = new HashMap<>();
        int s = 0;
        int longest = 0;
        sum.put(0, -1); // put 0 to the left
        for(int i = 0;i < nums.length;++i) {
            if(nums[i] == 0) {
                s += -1;
            } else {
                s += 1;
            }
            
            if(sum.containsKey(s)) {
                longest = Math.max(longest, i - sum.get(s));       
            } else {
                sum.put(s, i);
            }
        }
        
        return longest;
    }
}
