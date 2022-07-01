public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    helper(0, nums, result);
    return result;
}
 
private void helper(int start, int[] nums, List<List<Integer>> result){
    if(start==nums.length-1){
        ArrayList<Integer> list = new ArrayList<>();
        for(int num: nums){
            list.add(num);
        }
        result.add(list);
        return;
    }
 
    HashSet<Integer> set = new HashSet<>();
 
    for(int i=start; i<nums.length; i++){
        if(set.contains(nums[i])){
            continue;
        }
        set.add(nums[i]);
 
        swap(nums, i, start);
        helper(start+1, nums, result);
        swap(nums, i, start);
    }
}
 
private void swap(int[] nums, int i, int j){
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
