// Using Binary Index Tree/Fenwick Tree


class NumArray {
    
    int[] btree;
    int[] arr;
    

    public NumArray(int[] nums) {
        
        btree=new int[nums.length+1];
        arr=nums;
        
        for(int i=0; i<nums.length; i++){
            add(i+1, nums[i]);
        }
        
    }
    
    public void add(int i, int val) {
        for(int j=i; j<btree.length; j=j+(j&(-j)) ){
            btree[j] +=val;
        }
        
    }
    
    void update(int i, int val){
        add(i+1, val-arr[i]);
        arr[i]=val;
    }
    
    public int sumRange(int i, int j) {
        return sumHelper(j+1)-sumHelper(i);
        
    }
    
    public int sumHelper(int i){
        int sum=0;
        for(int j=i; j>=1; j=j-(j&(-j))){
            sum +=btree[j];
        }
        
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */